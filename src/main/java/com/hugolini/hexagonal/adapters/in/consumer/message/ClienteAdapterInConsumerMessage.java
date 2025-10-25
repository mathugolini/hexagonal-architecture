package com.hugolini.hexagonal.adapters.in.consumer.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteAdapterInConsumerMessage {

    private String id;
    private String nome;
    private String cep;
    private String cpf;
    private Boolean cpfValido;
}
