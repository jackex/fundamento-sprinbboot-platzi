package com.fundamentosplatzi.springboot.fundamentos.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentImplement implements ComponentDependency{
    @Override
    public void hablar() {
        System.out.println("Hola mundo soy el primer mensaje");
    }
}
