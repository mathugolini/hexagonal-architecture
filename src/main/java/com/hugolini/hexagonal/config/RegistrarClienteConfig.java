package com.hugolini.hexagonal.config;

import com.hugolini.hexagonal.adapters.out.service.BuscarEnderecoPorCepAdapterOutService;
import com.hugolini.hexagonal.adapters.out.service.RegistrarClienteAdapterOutService;
import com.hugolini.hexagonal.application.core.usecase.service.RegistrarClienteUseCaseService;
import com.hugolini.hexagonal.application.ports.out.EnviarCpfParaValidacaoOutPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RegistrarClienteConfig {

    @Bean
    public RegistrarClienteUseCaseService registrarClienteUseCase(
        BuscarEnderecoPorCepAdapterOutService buscarEnderecoPorCepAdapterOutService,
        RegistrarClienteAdapterOutService registrarClienteAdapterOutService,
        EnviarCpfParaValidacaoOutPort enviarCpfParaValidacaoOutPort) {

        return new RegistrarClienteUseCaseService(buscarEnderecoPorCepAdapterOutService, registrarClienteAdapterOutService, enviarCpfParaValidacaoOutPort);
    }
}
