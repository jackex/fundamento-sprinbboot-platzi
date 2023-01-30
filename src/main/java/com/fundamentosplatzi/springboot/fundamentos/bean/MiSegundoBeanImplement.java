package com.fundamentosplatzi.springboot.fundamentos.bean;

public class MiSegundoBeanImplement implements MiPrimerBean{
    @Override
    public void print() {
        System.out.println("ESTE ES UN MENSAJE DESDE MI SEGUNDO BEAN OHHH YESS!!!!");
    }
}
