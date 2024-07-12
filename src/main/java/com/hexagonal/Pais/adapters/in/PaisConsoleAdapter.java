package com.hexagonal.Pais.adapters.in;

import java.util.Optional;
import java.util.Scanner;

import com.hexagonal.Pais.application.PaisService;
import com.hexagonal.Pais.domain.models.Pais;
import com.hexagonal.menu.Menu;

public class PaisConsoleAdapter {
    private final PaisService paisService;

    public PaisConsoleAdapter(PaisService paisService) {
        this.paisService = paisService;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println(
                    "1. Crear Pais\n2. Actualizar Pais\n3. Buscar Pais por ID\n4. Eliminar Pais\n5. Listar todos los paises\n6. Salir\n\nIngresa tu eleccion");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Ingrese el nombre del pais: ");
                    String createName = sc.next();

                    Pais newPais = new Pais(createName);
                    paisService.createPais(newPais);
                    break;

                case 2:
                    System.out.println("Ingrese ID a actualizar: ");
                    int updateId = sc.nextInt();

                    System.out.println("\nIngrese el nuevo nombre: ");
                    String updateName = sc.next();

                    Pais updatePais = new Pais(updateId, updateName);
                    paisService.updatePais(updatePais);
                    break;

                case 3:
                    System.out.println("Ingrese el ID del pais a buscar: ");
                    int findId = sc.nextInt();

                    Optional<Pais> pais = paisService.getPaisById(findId);
                    pais.ifPresentOrElse(
                            p -> System.out.println("ID: " + p.getId_pais() + ", Nombre: " + p.getNombre_pais()),
                            () -> System.out.println("Pais no encontrado"));
                    break;

                case 4:
                    System.out.println("Ingrese el Id del pais a borrar: ");
                    int deleteId = sc.nextInt();

                    paisService.deletePais(deleteId);
                    break;

                case 5:
                    paisService.getAllPaises().forEach(p -> {
                        System.out.println("ID: " + p.getId_pais() + ", Nombre: " + p.getNombre_pais());
                    });
                    break;

                case 6:
                System.out.println("Volviendo al menu principal");
                Menu.menu();
                    break;

                default:
                    System.out.println("Opcion invalida, Intentelo de nuevo.");
            }
        }
    }
}
