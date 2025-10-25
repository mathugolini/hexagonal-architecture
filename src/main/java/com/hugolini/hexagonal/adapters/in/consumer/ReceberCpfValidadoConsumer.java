package com.hugolini.hexagonal.adapters.in.consumer;

import com.hugolini.hexagonal.adapters.in.consumer.mapper.ClienteMessageMapper;
import com.hugolini.hexagonal.adapters.in.consumer.message.ClienteAdapterInConsumerMessage;
import com.hugolini.hexagonal.application.ports.in.AtualizarClienteInPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceberCpfValidadoConsumer {

    @Autowired
    private AtualizarClienteInPort atualizarClienteInPort;

    @Autowired
    private ClienteMessageMapper clienteMessageMapper;

    @KafkaListener(topics = "cpf-validado-topic", groupId = "hugolini")
    public void recebeCpf(ClienteAdapterInConsumerMessage clienteAdapterInConsumerMessage) {
        var cliente = clienteMessageMapper.toDomain(clienteAdapterInConsumerMessage);
        atualizarClienteInPort.atualizarCliente(cliente, clienteAdapterInConsumerMessage.getCep());
    }
}
