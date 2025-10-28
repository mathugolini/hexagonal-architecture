package com.hugolini.hexagonal.adapters.out.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "clientes")
public class ClienteAdapterOutEntity {

    @Id
    private String id;
    private String nome;
    private EnderecoAdapterOutEntity endereco;
    private String cpf;
    private Boolean cpfValido;
}
