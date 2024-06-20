package com.hexagonal.Ciudad.adapters.in;

import java.util.Optional;
import java.util.Scanner;

import com.hexagonal.Ciudad.application.CiudadService;
import com.hexagonal.Ciudad.domain.models.Ciudad;

public class CiudadConsoleAdapter {
    private final CiudadService ciudadService;

    public CiudadConsoleAdapter(CiudadService ciudadService) {
        this.ciudadService = ciudadService;
    }

    public void star() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println(
                    "1. Crear Ciudad\n2. Actualizar Ciudad\n3. Buscar Ciudad por ID\n4. Eliminar Ciudad\n5. Listar todos los Ciudades\n6. Salir\n\nIngresa tu eleccion");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Ingrese el nombre de la Ciudad");
                    String nombreC = sc.next();

                    Ciudad newCiudad = new Ciudad(nombreC);
                    ciudadService.createCiudad(newCiudad);
                    break;

                case 2:
                    System.out.println("Ingrese el ID de la Ciudad a actualizar");
                    int updateId = sc.nextInt();// ACTUALIZAR EL ID

                    System.out.println("Ingrese el nuevo nombre de la Ciudad");
                    String updateName = sc.next();// ACTUALIZAR EL NOMBRE

                    System.out.println("Ingresa el nuevo id de region");
                    int updateIR = sc.nextInt();//ACTUALIZAR ID DE LA REGION

                    Ciudad upCi = new Ciudad(updateId,updateName,updateIR);
                    ciudadService.updateCiudad(upCi);
                    break;

                case 3:
                    System.out.println("Ingrese el id de la Ciudad a buscar: ");
                    int buIdC = sc.nextInt();// BUSCAR ID DE LA Ciudad

                    Optional<Ciudad> ciudad = ciudadService.getCiudadById(buIdC);
                    ciudad.ifPresentOrElse(
                            c -> System.out.println("ID: " + c.getId_ciudad() + ", Nombre: " + c.getNombre_ciudad()+ ", ID de region " + c.getId_region()),
                            () -> System.out.println("Ciudad no encontrada"));
                    break;

                case 4:
                System.out.println("Ingrese el id de la Ciudad a eliminar: ");
                int boIdC = sc.nextInt();//BORRAR CIUDAD POR ID

                ciudadService.deleteCiudad(boIdC);
                    break;

                case 5:
                    ciudadService.getAllCiudades().forEach(c -> {
                        System.out.println("ID: " + c.getId_ciudad() + ", Nombre: " + c.getNombre_ciudad() + ", Id-Region: "+ c.getId_region());
                    });
                    break;
                
                case 6:
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        }
    }
}
