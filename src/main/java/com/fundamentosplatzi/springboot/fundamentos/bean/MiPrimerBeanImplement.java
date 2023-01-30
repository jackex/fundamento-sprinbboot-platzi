package com.fundamentosplatzi.springboot.fundamentos.bean;


public class MiPrimerBeanImplement implements MiPrimerBean{
    @Override
    public void print() {
        System.out.println("ESTE ES UN MENSAJE DESDE MI PRIMER BEAN!!! FUCK YEAHH!!");
    }
}
