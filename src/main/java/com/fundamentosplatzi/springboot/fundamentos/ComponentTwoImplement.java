package com.fundamentosplatzi.springboot.fundamentos;

import com.fundamentosplatzi.springboot.fundamentos.component.ComponentDependency;
import org.springframework.stereotype.Component;

@Component
public class ComponentTwoImplement implements ComponentDependency {


    @Override
    public void hablar() {
        System.out.println("Hola mundo soy el segundo mensaje");
    }
}
