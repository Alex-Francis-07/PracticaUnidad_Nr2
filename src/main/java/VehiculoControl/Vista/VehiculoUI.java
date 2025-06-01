package VehiculoControl.Vista;

import VehiculoControl.Controlador.ServicioVehiculo;
import VehiculoControl.Modelo.*;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * @author AlexSigcho, Yandri Piscocama, Julian Vega, Sebastian Orellana
 */


// Clase que muestra el menú en consola y permite interactuar con el usuario
public class VehiculoUI {
    public static void main(String[] args) {
        ServicioVehiculo servicioVehiculo = new ServicioVehiculo();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Gestión de Registro De Vehículos ===");
            System.out.println("Autores:Julian Vega // Yandri Piscocama // Alex Sigcho // Sebastian Orellana");
            System.out.println("=============================");
            System.out.println("1. Registrar vehículo");
            System.out.println("2. Registrar viaje");
            System.out.println("3. Actualizar mantenimiento");
            System.out.println("4. Listar vehículos");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (opcion) {
                    case 1:
                        System.out.print("Tipo (moto/camioneta/camion): ");
                        String tipoVehiculo = scanner.nextLine();
                        System.out.print("Placa: ");
                        String placa = scanner.nextLine();
                        System.out.print("Capacidad carga: ");
                        double capacidad = scanner.nextDouble();
                        System.out.print("Consumo (L/km): ");
                        double consumo = scanner.nextDouble();
                        System.out.print("Costo mantenimiento: ");
                        double mantenimiento = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Fecha último mantenimiento (YYYY-MM-DD): ");
                        LocalDate fecha = LocalDate.parse(scanner.nextLine());

                        if (tipoVehiculo.equalsIgnoreCase("moto")) {
                            System.out.print("Cilindrada: ");
                            int cilindrada = scanner.nextInt();
                            servicioVehiculo.registrarVehiculo(new Moto(placa, capacidad, consumo, mantenimiento, fecha, cilindrada));
                        } else if (tipoVehiculo.equalsIgnoreCase("camioneta")) {
                            System.out.print("¿Tracción 4x4? (true/false): ");
                            boolean traccion = scanner.nextBoolean();
                            servicioVehiculo.registrarVehiculo(new Camioneta(placa, capacidad, consumo, mantenimiento, fecha, traccion));
                        } else if (tipoVehiculo.equalsIgnoreCase("camion")) {
                            System.out.print("Número de ejes: ");
                            int ejes = scanner.nextInt();
                            servicioVehiculo.registrarVehiculo(new Camion(placa, capacidad, consumo, mantenimiento, fecha, ejes));
                        }
                        break;
                    case 2:
                        System.out.print("Placa del vehículo: ");
                        String placaViaje = scanner.nextLine();
                        System.out.print("Distancia recorrida (km): ");
                        double distancia = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Fecha del viaje (YYYY-MM-DD): ");
                        LocalDate fechaViaje = LocalDate.parse(scanner.nextLine());
                        servicioVehiculo.registrarViaje(placaViaje, new Viaje(distancia, fechaViaje));
                        servicioVehiculo.mostrarVehiculosConEstado();
                        break;
                    case 3:
                        System.out.print("Placa: ");
                        String placaMant = scanner.nextLine();
                        System.out.print("Nueva fecha mantenimiento (YYYY-MM-DD): ");
                        LocalDate fechaMant = LocalDate.parse(scanner.nextLine());
                        servicioVehiculo.actualizarMantenimiento(placaMant, fechaMant);
                        break;
                    case 4:
                        servicioVehiculo.mostrarVehiculosConEstado();
                        break;
                    case 5:
                        System.out.println("Saliendo...");
                        return;
                    default:
                        System.out.println("Opción inválida.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine();
            }
        }
    }
}