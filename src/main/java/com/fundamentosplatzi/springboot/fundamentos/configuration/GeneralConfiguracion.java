package com.fundamentosplatzi.springboot.fundamentos.configuration;

import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithPropertiesImplement;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeneralConfiguracion {

    @Value("${value.name}")
    public String nombre;

    @Value("${value.lastname}")
    public String apellido;

    @Value("${value.random}")
    public String random;

    @Bean
    public MyBeanWithProperties function(){
        return new MyBeanWithPropertiesImplement(nombre, apellido);
    }
}
