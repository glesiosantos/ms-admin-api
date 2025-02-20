package br.com.ohgestor.msadmin.api.services.impl;

import br.com.ohgestor.msadmin.api.config.AsaasConfig;
import br.com.ohgestor.msadmin.api.domains.Cliente;
import br.com.ohgestor.msadmin.api.domains.Pedido;
import br.com.ohgestor.msadmin.api.services.AsaasClientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AsaasClientServiceImpl implements AsaasClientService {

    private final RestTemplate restTemplate = new RestTemplateBuilder().build();

    private final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private AsaasConfig asaasConfig;

    @Override
    public ResponseEntity<String> cadastrarClienteAsaas(Cliente cliente) {

        String request = "{"
                + "\"name\":\"" + cliente.getRazaoSocial() + "\","
                + "\"cpfCnpj\":\"" + cliente.getCpfOuCnpj() + "\","
                +"}";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("access_token", asaasConfig.getAccessToken());

        HttpEntity<String> entity = new HttpEntity<>(request, headers);
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

        if(asaasCustomer == null) {
            System.out.println("Vazio, cadastrar");
            cadastrarClienteAsaas(pedido.getCliente());
        }
        customerId = mapper.readTree(asaasCustomer).get(0).get("id").toString();

        return "";
    }
}
