package com.hugolini.hexagonal.adapters.out.client;

import com.hugolini.hexagonal.adapters.out.client.response.EnderecoAdapterOutResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "BuscarEnderecoPorCepClient",
        url = "${hugolini.cliente-endereco-.url}"
)
public interface BuscarEnderecoPorCepClient {

    @GetMapping("/{cep}")
    EnderecoAdapterOutResponse buscarEnderecoPorCep(@PathVariable("cep") String cep);

}
