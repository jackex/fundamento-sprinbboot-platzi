package com.fundamentosplatzi.springboot.fundamentos.bean;

import org.apache.juli.logging.LogFactory;
import org.apache.juli.logging.Log;

public class OperacionMatematicaImplement implements OperacionMatematica{

    private Log LOGGER = LogFactory.getLog(OperacionMatematicaImplement.class);

    private OperacionTrigonometrica operacionTrigonometrica;

    public OperacionMatematicaImplement(OperacionTrigonometrica operacionTrigonometrica){
        this.operacionTrigonometrica = operacionTrigonometrica;
    }

    @Override
    public void realizarOperacion(int number) {
        this.LOGGER.info("Hemos ingresado al metodo realizarOperacion...!!!");
        this.LOGGER.debug("El numero enviado como parametro a la dependenia Trigonometrica es: "+ number);
        System.out.println("El numero digitado fue: " + number + " y su  exponente es: " + Math.pow(number, 2));
        this.operacionTrigonometrica.areaFigura(number);
    }
}
