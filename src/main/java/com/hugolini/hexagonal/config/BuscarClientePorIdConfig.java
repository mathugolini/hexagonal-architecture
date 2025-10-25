package com.hugolini.hexagonal.config;

import com.hugolini.hexagonal.adapters.out.BuscarClientePorIdAdapterOut;
import com.hugolini.hexagonal.application.core.domain.ClienteDomain;
import com.hugolini.hexagonal.application.core.usecase.BuscarClientePorIdUseCase;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuscarClientePorIdConfig {

    public BuscarClientePorIdUseCase buscarClientePorIdUseCase(BuscarClientePorIdAdapterOut buscarClientePorIdAdapterOut) {
        return new BuscarClientePorIdUseCase(buscarClientePorIdAdapterOut);
    }
}
