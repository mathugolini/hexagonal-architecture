package com.hugolini.hexagonal.config;

import com.hugolini.hexagonal.adapters.out.service.DeletarClientePorIdAdapterOutService;
import com.hugolini.hexagonal.application.core.usecase.service.BuscarClientePorIdUseCaseService;
import com.hugolini.hexagonal.application.core.usecase.service.DeletarClientePorIdUseCaseService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeletarClientePorIdConfig {

    @Bean
    public DeletarClientePorIdUseCaseService deletarClientePorIdUseCase(
            BuscarClientePorIdUseCaseService buscarClientePorIdUseCaseService,
            DeletarClientePorIdAdapterOutService deletarClientePorIdAdapterOutService) {
        return new DeletarClientePorIdUseCaseService(buscarClientePorIdUseCaseService, deletarClientePorIdAdapterOutService);
    }
}
