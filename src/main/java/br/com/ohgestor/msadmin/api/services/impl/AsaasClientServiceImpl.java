package br.com.ohgestor.msadmin.api.services.impl;

import br.com.ohgestor.msadmin.api.config.AsaasConfig;
import br.com.ohgestor.msadmin.api.domains.Cliente;
import br.com.ohgestor.msadmin.api.domains.Pedido;
import br.com.ohgestor.msadmin.api.domains.Usuario;
import br.com.ohgestor.msadmin.api.enuns.Plano;
import br.com.ohgestor.msadmin.api.enuns.SituacaoPedido;
import br.com.ohgestor.msadmin.api.services.AsaasClientService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Service
public class AsaasClientServiceImpl implements AsaasClientService {

    private final RestTemplate restTemplate = new RestTemplateBuilder().build();

    private final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private AsaasConfig asaasConfig;

    @Override
    public ResponseEntity<String> cadastrarClienteAsaas(Cliente cliente) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("access_token", asaasConfig.getAccessToken());

        Map<String, Object> asaasCliente = new HashMap<>();
        asaasCliente.put("name", cliente.getRazaoSocial());
        asaasCliente.put("cpfCnpj", cliente.getCpfOuCnpj());
        asaasCliente.put("company", cliente.getNomeFantasia());
        asaasCliente.put("mobilePhone", cliente.getContatos().stream().findFirst());

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(asaasCliente, headers);
        return restTemplate.exchange(asaasConfig.getBaseUrl()+"/customers", HttpMethod.POST, entity, String.class);
    }

    @Override
    public ResponseEntity<String> buscarClienteAsaas(Cliente cliente) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("access_token", asaasConfig.getAccessToken());

        HttpEntity<String> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(asaasConfig.getBaseUrl()+"/customers?cpfCnpj="+cliente.getCpfOuCnpj(), HttpMethod.GET, entity, String.class);
    }

    @Override
    public String gerarCobrancaPixAsaas(Cliente cliente) throws Exception {

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("access_token", asaasConfig.getAccessToken());

        String customerId = null;
        String asaasCustomer = buscarClienteAsaas(cliente).getBody();
        JsonNode jsonNode = mapper.readTree(asaasCustomer);

        if(jsonNode.get("totalCount").asInt() > 0 && !jsonNode.get("data").isEmpty() ) {
            customerId = jsonNode.get("data").get(0).get("id").asText();
        } else {
            String criarAsaasCliente = cadastrarClienteAsaas(cliente).getBody();
            JsonNode node = mapper.readTree(criarAsaasCliente);
            customerId = node.get("id").asText();
        }

        Map<String, Object> asaasPagamento = new HashMap<>();
        asaasPagamento.put("customer", customerId);
        asaasPagamento.put("billingType", "PIX");
        asaasPagamento.put("value", cliente.getPlano().getValor());

        if (cliente.isPeriodoDeTeste()) {
            asaasPagamento.put("dueDate", LocalDate.now().plusDays(cliente.getTotalDiasTeste() + 1).toString());
        } else {
            asaasPagamento.put("dueDate", LocalDate.now().plusDays(1).toString());
        }

        asaasPagamento.put("description","Referente a pagamento de licença de uso Auto Revise");

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(asaasPagamento, headers);
        var cobranca = restTemplate.exchange(asaasConfig.getBaseUrl()+"/payments", HttpMethod.POST, entity, String.class).getBody();
        return mapper.readTree(cobranca).get("id").asText();
    }

    @Override
    public Pedido carregarCobrancasPixComQrCode(Cliente cliente, Usuario usuario, SituacaoPedido situacao, Plano plano) throws Exception{

        String idCobrancaAsaas = gerarCobrancaPixAsaas(cliente);

        String path = String.format("/payments/%s/pixQrCode",idCobrancaAsaas);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("access_token", asaasConfig.getAccessToken());

        HttpEntity<String> entity = new HttpEntity<>(headers);
        var cobranca = restTemplate.exchange(asaasConfig.getBaseUrl()+path, HttpMethod.GET, entity, String.class).getBody();
        JsonNode jsonNode = mapper.readTree(cobranca);

        return Pedido.builder()
                .plano(plano)
                .situacao(situacao)
                .cliente(cliente)
                .usuarioVenda(usuario)
                .qrCode(jsonNode.get("encodedImage").asText())
                .chaveCompartilhamento(jsonNode.get("payload").asText())
                .dataExpiracaoPagamento(jsonNode.get("expirationDate").asText())
                .codigoAsaasCobranca(idCobrancaAsaas)
                .build();
    }

    @Override
    public String carregarStatusDoPagamentoAsaas(String idCobranca) throws Exception {

        String path = String.format("/payments/%s/status",idCobranca);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("access_token", asaasConfig.getAccessToken());

        HttpEntity<String> entity = new HttpEntity<>(headers);
        var cobranca = restTemplate.exchange(asaasConfig.getBaseUrl()+path, HttpMethod.GET, entity, String.class).getBody();
        JsonNode jsonNode = mapper.readTree(cobranca);
        return jsonNode.get("status").asText();
    }
}
