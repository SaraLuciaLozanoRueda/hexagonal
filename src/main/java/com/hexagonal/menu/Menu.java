package com.hexagonal.menu;

import java.util.Scanner;

/*import com.hexagonal.Ciudad.adapters.in.CiudadConsoleAdapter;
import com.hexagonal.Ciudad.adapters.out.CiudadMySQLRepository;
import com.hexagonal.Ciudad.application.CiudadService;*/
import com.hexagonal.Pais.adapters.in.PaisConsoleAdapter; 
import com.hexagonal.Pais.adapters.out.PaisMySQLRepository;
import com.hexagonal.Pais.application.PaisService;
import com.hexagonal.utility.Validaciones;

public class Menu {
    public static void menu() {
        Scanner sc = new Scanner(System.in);
        Validaciones vali = new Validaciones();
 
        
        for (int i = 0; i < 15; i++) {
            System.out.println();
        }

        while (true) {
            int opcion = vali.ValiINT("1. PAISES\n2. CIUDADES\n");
            switch (opcion) {
                case 1:
                    PaisMySQLRepository paisMySQLRepository = new PaisMySQLRepository(
                            "jdbc:mysql://localhost:3306/liga_hexagonal", "campus2023", "campus2023");
                    PaisService paisService = new PaisService(paisMySQLRepository);
                    PaisConsoleAdapter paisConsoleAdapter = new PaisConsoleAdapter(paisService);
                    paisConsoleAdapter.start();
                    break;

                case 2:
                    /*CiudadMySQLRepository ciudadMySQLRepository = new CiudadMySQLRepository(
                            "jdbc:mysql://localhost:3306/liga_hexagonal", "campus2023", "campus2023");
                    CiudadService ciudadService = new CiudadService(ciudadMySQLRepository, null);
                    CiudadConsoleAdapter ciudadConsoleAdapter = new CiudadConsoleAdapter(ciudadService);
                    ciudadConsoleAdapter.star();*/
                    break;
                default:
                sc.close();
                    break;
            }
        }

    }
}
