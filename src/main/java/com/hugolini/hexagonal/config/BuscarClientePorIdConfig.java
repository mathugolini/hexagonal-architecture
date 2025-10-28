package com.hugolini.hexagonal.config;

import com.hugolini.hexagonal.adapters.out.service.BuscarClientePorIdAdapterOutService;
import com.hugolini.hexagonal.application.core.usecase.service.BuscarClientePorIdUseCaseService;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuscarClientePorIdConfig {

    public BuscarClientePorIdUseCaseService buscarClientePorIdUseCase(BuscarClientePorIdAdapterOutService buscarClientePorIdAdapterOutService) {
        return new BuscarClientePorIdUseCaseService(buscarClientePorIdAdapterOutService);
    }
}
