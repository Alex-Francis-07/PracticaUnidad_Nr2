package VehiculoControl.Modelo;

import java.time.LocalDate;

/**
 * @author AlexSigcho, Yandri Piscocama, Julian Vega, Sebastian Orellana
 */

// Clase para camiones, hereda de Vehiculo
public class Camion extends Vehiculo {
    private int numeroEjes;

    public Camion(String placa, double capacidad, double consumo, double mantenimiento, LocalDate fecha, int numeroEjes) {
        super(placa, capacidad, consumo, mantenimiento, fecha);
        this.numeroEjes = numeroEjes;
    }

    @Override
    public String toString() {
        return "Camión [Placa=" + placa + ", Ejes=" + numeroEjes + ", Estado=" + estado + "]";
    }
}