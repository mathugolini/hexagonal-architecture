package com.hugolini.hexagonal.adapters.out.client.response;

import lombok.Data;

@Data
public class EnderecoAdapterOutResponse {

    private String rua;
    private String cidade;
    private String estado;
}
