package com.hugolini.hexagonal.adapters.in.controller;

import com.hugolini.hexagonal.adapters.in.mapper.ClienteAdapterInMapper;
import com.hugolini.hexagonal.adapters.in.request.ClienteAdapterInRequest;
import com.hugolini.hexagonal.adapters.in.response.ClienteAdapterInResponse;
import com.hugolini.hexagonal.application.core.domain.ClienteDomain;
import com.hugolini.hexagonal.application.ports.in.AtualizarClienteInPort;
import com.hugolini.hexagonal.application.ports.in.BuscarClientePorIdInPort;
import com.hugolini.hexagonal.application.ports.in.DeletarClientePorIdPort;
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
    private AtualizarClienteInPort atualizarClienteInPort;

    @Autowired
    private DeletarClientePorIdPort deletarClientePorIdInPort;

    @Autowired
    private ClienteAdapterInMapper clienteAdapterInMapper;

    @PostMapping
    public ResponseEntity<Void> registrarCliente(@Valid @RequestBody ClienteAdapterInRequest clienteAdapterInRequest) {
        var clienteDomain = clienteAdapterInMapper.toDomain(clienteAdapterInRequest);
        registrarClienteInPort.registrarCliente(clienteDomain, clienteAdapterInRequest.getCep());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteAdapterInResponse> buscarPorId(@PathVariable String id) {
        var cliente = buscarClientePorIdInPort.buscarPorId(id);
        var clienteResponse = clienteAdapterInMapper.toResponse(cliente);
        return ResponseEntity.ok().body(clienteResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarCliente(@PathVariable String id, @Valid @RequestBody ClienteAdapterInRequest clienteAdapterInRequest) {
        ClienteDomain clienteDomain = clienteAdapterInMapper.toDomain(clienteAdapterInRequest);
        clienteDomain.setId(id);
        atualizarClienteInPort.atualizarCliente(clienteDomain, clienteAdapterInRequest.getCep());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable final String id) {
        buscarClientePorIdInPort.buscarPorId(id);
        deletarClientePorIdInPort.deletarClientePorId(id);
        return ResponseEntity.noContent().build();
    }
}
