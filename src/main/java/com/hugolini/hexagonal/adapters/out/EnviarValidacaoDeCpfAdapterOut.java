package com.hugolini.hexagonal.adapters.out;

import com.hugolini.hexagonal.application.ports.out.EnviarCpfParaValidacaoOutPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class EnviarValidacaoDeCpfAdapterOut implements EnviarCpfParaValidacaoOutPort {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void enviarCpf(String cpf) {
        kafkaTemplate.send("validar-cpf-topic", cpf);
    }
}
