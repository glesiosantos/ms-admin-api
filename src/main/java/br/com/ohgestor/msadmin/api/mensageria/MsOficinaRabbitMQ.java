package br.com.ohgestor.msadmin.api.mensageria;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class MsOficinaRabbitMQ {

    @Value("${rabbitmq-exchange.oficina-exchange}")
    private String exchangeName;

    @Bean
    public Queue criarFilaAddNovasOficinaMsOficinas() {
        return QueueBuilder.durable("rabbitmq-queue-criar-oficina").build();
    }

    @Bean
    public FanoutExchange criarFanoutExchangeAddOficina(){
        return ExchangeBuilder.fanoutExchange(exchangeName).build();
    }

    @Bean
    public Binding criarBindingParaCadastroDeOficinaMsOficina() {
        return BindingBuilder.bind(criarFilaAddNovasOficinaMsOficinas()).to(criarFanoutExchangeAddOficina());
    }
}
