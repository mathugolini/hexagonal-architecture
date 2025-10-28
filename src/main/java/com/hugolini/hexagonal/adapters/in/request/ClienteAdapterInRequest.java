package com.hugolini.hexagonal.adapters.in.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ClienteAdapterInRequest {

    @NotBlank
    private String nome;

    @NotBlank
    private String cpf;

    @NotBlank
    private String cep;
}
