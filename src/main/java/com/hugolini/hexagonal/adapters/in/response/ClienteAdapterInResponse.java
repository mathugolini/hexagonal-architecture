package com.hugolini.hexagonal.adapters.in.response;

import com.hugolini.hexagonal.application.core.domain.EnderecoDomain;
import lombok.Data;

@Data
public class ClienteAdapterInResponse {

    private String nome;
    private EnderecoDomain endereco;
    private String cpf;
    private Boolean cpfValido;
}
