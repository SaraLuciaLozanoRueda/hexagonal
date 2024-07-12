package com.hexagonal.Ciudad.adapters.in;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.hexagonal.Ciudad.application.CiudadService;
import com.hexagonal.Ciudad.domain.models.Ciudad;
import com.hexagonal.Region.domain.models.Region;
import com.hexagonal.menu.Menu;
import com.hexagonal.utility.Validaciones;

public class CiudadConsoleAdapter {
    private final CiudadService ciudadService;

    public CiudadConsoleAdapter(CiudadService ciudadService) {
        this.ciudadService = ciudadService;
    }

    public void star() {
        Scanner sc = new Scanner(System.in);
        Validaciones vali = new Validaciones();

        while (true) {
            int choice = vali.ValiINT("1. Crear Ciudad\n2. Actualizar Ciudad\n3. Buscar Ciudad por ID\n4. Eliminar Ciudad\n5. Listar todos los Ciudades\n6. Salir\n\nIngresa tu eleccion")

            switch (choice) {
                case 1:
                    String nombreC = vali.ValiString("Ingrese el nombre de la Ciudad");

                    List<Region>regiones = ciudadService.allRegiones();

                    for(Region re : regiones){
                        System.out.println("ID de la region: " + re.getId_region() + "\nNombre de la region: " + re.getNombre_region() + "\nID del pais: " + re.getId_pais());
                    }

                    System.out.println();
                    int IDregion = vali.ValiINT("Ingrese el id de la region relacionado a la ciudad");

                    Optional<Region>encuentraRegion = ciudadService.findRegion(IDregion);
                    if(encuentraRegion.isPresent()){
                    Ciudad newCiudad = new Ciudad(nombreC,IDregion);
                    ciudadService.createCiudad(newCiudad);
                    }else{
                        System.out.println("La region con ID " + IDregion + ", no existe");
                    }
                    
                    break;

                case 2:
                    System.out.println();
                    int updateId = vali.ValiINT("Ingrese el ID de la Ciudad a actualizar");// ACTUALIZAR EL ID

                    System.out.println();
                    String updateName = vali.ValiString("Ingrese el nuevo nombre de la Ciudad");// ACTUALIZAR EL NOMBRE

                    System.out.println();
                    int updateIR = vali.ValiINT("Ingresa el nuevo id de region");//ACTUALIZAR ID DE LA REGION

                    Ciudad upCi = new Ciudad(updateId,updateName,updateIR);
                    ciudadService.updateCiudad(upCi);
                    break;

                case 3:
                    System.out.println();
                    int buIdC = vali.ValiINT("Ingrese el id de la Ciudad a buscar: ");// BUSCAR ID DE LA Ciudad

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
                    System.out.println("Volviendo al menu principal");
                    Menu.menu();
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        }
    }
}
