package com.fundamentosplatzi.springboot.fundamentos.bean;

public class OperacionMatematicaImplement implements OperacionMatematica{

    private OperacionTrigonometrica operacionTrigonometrica;

    public OperacionMatematicaImplement(OperacionTrigonometrica operacionTrigonometrica){
        this.operacionTrigonometrica = operacionTrigonometrica;
    }

    @Override
    public void realizarOperacion(int number) {
        System.out.println("El numero digitado fue: " + number + " y su  exponente es: " + Math.pow(number, 2));
        this.operacionTrigonometrica.areaFigura(number);
    }
}
