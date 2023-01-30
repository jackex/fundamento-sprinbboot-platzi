package com.fundamentosplatzi.springboot.fundamentos.configuration;

import com.fundamentosplatzi.springboot.fundamentos.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MiConfiguracionDeBeans {

    @Bean
    public MiPrimerBean operacionMiPrimerBean(){  //EL TIPO DE RETORNO DEL METODO DEBE SER EL MISMO DE LA INTERFAZ O DEPENDENCIA
        return new MiSegundoBeanImplement();
    }

    @Bean
    public OperacionTrigonometrica operacionTrigonometrica(){
        return new OperacionTrigonometricaImplement();
    }

    @Bean
    public OperacionMatematica operacionMatematica(OperacionTrigonometrica operacionTrigonometrica){
        return new OperacionMatematicaImplement(operacionTrigonometrica);
    }
}
