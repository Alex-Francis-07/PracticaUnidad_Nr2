package VehiculoControl.Modelo;

import java.time.LocalDate;

/**
 * @author AlexSigcho, Yandri Piscocama, Julian Vega, Sebastian Orellana
 */

// Clase para camionetas, hereda de Vehiculo
public class Camioneta extends Vehiculo {
    private boolean traccion4x4;

    public Camioneta(String placa, double capacidad, double consumo, double mantenimiento, LocalDate fecha, boolean traccion4x4) {
        super(placa, capacidad, consumo, mantenimiento, fecha);
        this.traccion4x4 = traccion4x4;
    }

    @Override
    public String toString() {
        return "Camioneta [Placa=" + placa + ", Tracción 4x4=" + traccion4x4 + ", Estado=" + estado + "]";
    }
}
