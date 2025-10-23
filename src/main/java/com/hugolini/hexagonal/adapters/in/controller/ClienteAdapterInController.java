package com.hugolini.hexagonal.adapters.in.controller;

import com.hugolini.hexagonal.adapters.in.controller.mapper.ClienteAdapterInControllerMapper;
import com.hugolini.hexagonal.adapters.in.controller.request.ClienteAdapterInControllerRequest;
import com.hugolini.hexagonal.adapters.in.controller.response.ClienteAdapterInResponse;
import com.hugolini.hexagonal.application.ports.in.BuscarClientePorIdInPort;
import com.hugolini.hexagonal.application.ports.in.RegistrarClienteInPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteAdapterInController {

    @Autowired
    private RegistrarClienteInPort registrarClienteInPort;

    @Autowired
    private BuscarClientePorIdInPort buscarClientePorIdInPort;

    @Autowired
    private ClienteAdapterInControllerMapper clienteAdapterInControllerMapper;

    @PostMapping
    public ResponseEntity<Void> registrarCliente(@Valid @RequestBody ClienteAdapterInControllerRequest clienteAdapterInControllerRequest) {
        var clienteDomain = clienteAdapterInControllerMapper.toDomain(clienteAdapterInControllerRequest);
        registrarClienteInPort.registrarCliente(clienteDomain, clienteAdapterInControllerRequest.getCep());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteAdapterInResponse> buscarPorId(@PathVariable String id) {
        var cliente = buscarClientePorIdInPort.buscarPorId(id);
        var clienteResponse = clienteAdapterInControllerMapper.toResponse(cliente);
        return ResponseEntity.ok().body(clienteResponse);
    }
}
