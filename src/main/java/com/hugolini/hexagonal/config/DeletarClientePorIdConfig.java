package com.hugolini.hexagonal.config;

import com.hugolini.hexagonal.adapters.out.DeletarClientePorIdAdapterOut;
import com.hugolini.hexagonal.application.core.usecase.BuscarClientePorIdUseCase;
import com.hugolini.hexagonal.application.core.usecase.DeletarClientePorIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeletarClientePorIdConfig {

    @Bean
    public DeletarClientePorIdUseCase deletarClientePorIdUseCase(
            BuscarClientePorIdUseCase buscarClientePorIdUseCase,
            DeletarClientePorIdAdapterOut deletarClientePorIdAdapterOut) {
        return new DeletarClientePorIdUseCase(buscarClientePorIdUseCase, deletarClientePorIdAdapterOut);
    }
}
