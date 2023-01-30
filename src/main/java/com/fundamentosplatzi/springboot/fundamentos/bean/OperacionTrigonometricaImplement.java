package com.fundamentosplatzi.springboot.fundamentos.bean;

public class OperacionTrigonometricaImplement implements OperacionTrigonometrica{

    @Override
    public void areaFigura(int number) {
        System.out.println("El area de cuadrado es: " + Math.pow(number, 2));
    }
}
