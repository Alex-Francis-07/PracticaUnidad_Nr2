package VehiculoControl.Modelo;
/**
 * Julian Vega, Alex Sigcho, Yandry Piscocama, Sebastián orellana
 */


import java.time.LocalDate;

// Clase que representa un viaje realizado por un vehículo
public class Viaje {
    private double distanciaRecorrida;
    private LocalDate fechaViaje;

    public Viaje(double distanciaRecorrida, LocalDate fechaViaje) {
        if (distanciaRecorrida < 0) throw new IllegalArgumentException("Distancia no puede ser negativa");
        this.distanciaRecorrida = distanciaRecorrida;
        this.fechaViaje = fechaViaje;
    }

    public double getDistanciaRecorrida() {
        return distanciaRecorrida;
    }

    public LocalDate getFechaViaje() {
        return fechaViaje;
    }
}