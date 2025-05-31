package VehiculoControl.Controlador;

import VehiculoControl.Modelo.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Clase encargada de gestionar la lógica de negocio
public class ServicioVehiculo {
    private List<Vehiculo> vehiculos;

    public ServicioVehiculo() {
        vehiculos = new ArrayList<>();
    }
    
 public void registrarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }
 
 public void registrarViaje(String placa, Viaje viaje) {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getPlaca().equals(placa)) {
                vehiculo.agregarViaje(viaje);
                double costo = vehiculo.calcularCostoOperativo(viaje);
                System.out.println("Costo operativo del viaje: " + costo);
                return;
            }
        }
        System.out.println("Vehículo no encontrado.");
    }

    public void actualizarMantenimiento(String placa, LocalDate fecha) {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getPlaca().equals(placa)) {
                vehiculo.actualizarMantenimiento(fecha);
                System.out.println("Mantenimiento actualizado.");
                return;
            }
        }
        System.out.println("Vehículo no encontrado.");
    }

    public void mostrarVehiculosConEstado() {
        for (Vehiculo vehiculo : vehiculos) {
            vehiculo.actualizarEstado();
            System.out.println(vehiculo);
        }
    }
}
