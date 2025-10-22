package com.hugolini.hexagonal.adapters.in.controller;

import com.hugolini.hexagonal.adapters.in.controller.mapper.ClienteAdapterInControllerMapper;
import com.hugolini.hexagonal.adapters.in.controller.request.ClienteAdapterInControllerRequest;
import com.hugolini.hexagonal.application.ports.in.RegistrarClienteInPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteAdapterInController {

    @Autowired
    private RegistrarClienteInPort registrarClienteInPort;

    @Autowired
    private ClienteAdapterInControllerMapper clienteAdapterInControllerMapper;

    @PostMapping
    public ResponseEntity<Void> registrarCliente(@Valid @RequestBody ClienteAdapterInControllerRequest clienteAdapterInControllerRequest) {
        var clienteDomain = clienteAdapterInControllerMapper.toDomain(clienteAdapterInControllerRequest);
        registrarClienteInPort.registrarCliente(clienteDomain, clienteAdapterInControllerRequest.getCep());
        return ResponseEntity.ok().build();
    }
}
