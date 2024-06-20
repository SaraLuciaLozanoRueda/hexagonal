package com.hexagonal.menu;

import java.util.Scanner;

import com.hexagonal.Ciudad.adapters.in.CiudadConsoleAdapter;
import com.hexagonal.Ciudad.adapters.out.CiudadMySQLRepository;
import com.hexagonal.Ciudad.application.CiudadService;
import com.hexagonal.Pais.adapters.in.PaisConsoleAdapter;
import com.hexagonal.Pais.adapters.out.PaisMySQLRepository;
import com.hexagonal.Pais.application.PaisService;

public class Menu {
    public static void menu() {
        Scanner sc = new Scanner(System.in);
        
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }

        System.out.println(
                "BIENVENIDOS A LA LIGA BETPLAY\nPreparate para nuestras nuevas actualizaciones y disfruta de ellas");

        while (true) {
            System.out.println("1. PAISES\n2. CIUDADES\n3.REGIONES\n\nIngresa tu eleccion");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    PaisMySQLRepository paisMySQLRepository = new PaisMySQLRepository(
                            "jdbc:mysql://localhost:3306/liga_hexagonal", "campus2023", "campus2023");
                    PaisService paisService = new PaisService(paisMySQLRepository);
                    PaisConsoleAdapter paisConsoleAdapter = new PaisConsoleAdapter(paisService);
                    paisConsoleAdapter.start();
                    break;

                case 2:
                    CiudadMySQLRepository ciudadMySQLRepository = new CiudadMySQLRepository(
                            "jdbc:mysql://localhost:3306/liga_hexagonal", "campus2023", "campus2023");
                    CiudadService ciudadService = new CiudadService(ciudadMySQLRepository);
                    CiudadConsoleAdapter ciudadConsoleAdapter = new CiudadConsoleAdapter(ciudadService);
                    ciudadConsoleAdapter.star();
                    break;
                default:
                sc.close();
                    break;
            }
        }

    }
}
