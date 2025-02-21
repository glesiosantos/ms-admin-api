package br.com.ohgestor.msadmin.api.services.impl;

import br.com.ohgestor.msadmin.api.config.AsaasConfig;
import br.com.ohgestor.msadmin.api.domains.Cliente;
import br.com.ohgestor.msadmin.api.domains.Pedido;
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
    public String gerarCobrancaPixAsaas(Pedido pedido) throws Exception {
        String customerId = null;
        String asaasCustomer = buscarClienteAsaas(pedido.getCliente()).getBody();
        JsonNode jsonNode = mapper.readTree(asaasCustomer);

        if(jsonNode.get("totalCount").asInt() > 0 && !jsonNode.get("data").isEmpty() ) {
            customerId = jsonNode.get("data").get(0).get("id").toString();
            System.out.println("*** *** Customer id"+ customerId);
        } else {
            String criarAsaasCliente = cadastrarClienteAsaas(pedido.getCliente()).getBody();
            JsonNode node = mapper.readTree(criarAsaasCliente);
            System.out.println(node.get("id").toString());
            customerId = node.get("id").toString();
        }

        return "";
    }
}
