package com.hugolini.hexagonal.config;

import com.hugolini.hexagonal.adapters.out.BuscarEnderecoPorCepAdapterOut;
import com.hugolini.hexagonal.adapters.out.RegistrarClienteAdapterOut;
import com.hugolini.hexagonal.application.core.usecase.RegistrarClienteUseCase;
import com.hugolini.hexagonal.application.ports.out.EnviarCpfParaValidacaoOutPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RegistrarClienteConfig {

    @Bean
    public RegistrarClienteUseCase registrarClienteUseCase(
        BuscarEnderecoPorCepAdapterOut buscarEnderecoPorCepAdapterOut,
        RegistrarClienteAdapterOut registrarClienteAdapterOut,
        EnviarCpfParaValidacaoOutPort enviarCpfParaValidacaoOutPort) {

        return new RegistrarClienteUseCase(buscarEnderecoPorCepAdapterOut, registrarClienteAdapterOut, enviarCpfParaValidacaoOutPort);
    }
}
