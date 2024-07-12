package com.hexagonal.utility;

import java.util.Scanner;


public class Validaciones {
    Scanner sc = new Scanner(System.in);

    public int ValiINT(String mensaje){
        int valor;
        while(true){
            System.out.println(mensaje);
            try {
                valor = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Debes ingresar un numero valido");
            }
        }return valor;
    }


    public String ValiString(String mensaje){
        String caracter;
        while(true){
            System.out.println(mensaje);
            try {
                caracter = sc.nextLine().trim();
                if(caracter.isEmpty()){
                    throw new IllegalArgumentException("Este campo es obligatorio");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    

}
