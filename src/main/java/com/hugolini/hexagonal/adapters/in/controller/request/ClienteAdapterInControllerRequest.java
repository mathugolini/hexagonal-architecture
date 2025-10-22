package com.hugolini.hexagonal.adapters.in.controller.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ClienteAdapterInControllerRequest {

    @NotBlank
    private String nome;

    @NotBlank
    private String cpf;

    @NotBlank
    private String cep;
}
