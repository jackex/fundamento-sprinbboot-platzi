package com.fundamentosplatzi.springboot.fundamentos.bean;

import org.springframework.stereotype.Component;

public class MyBeanWithPropertiesImplement implements MyBeanWithProperties {

    public String nombre;
    public String apellido;

    public MyBeanWithPropertiesImplement(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Override
    public String function() {
        return this.nombre + " - " + this.apellido;
    }
}
