package VehiculoControl.Modelo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/**
 * @author AlexSigcho, Yandri Piscocama, Julian Vega, Sebastian Orellana
 */

// Clase abstracta base para cualquier tipo de vehículo
public abstract class Vehiculo {
    protected static final double PRECIO_COMBUSTIBLE = 1.5;

    protected String placa;
    protected double capacidadDeCarga;
    protected double consumoCombustible;
    protected double costoBaseMantenimiento;
    protected LocalDate fechaUltimoMantenimiento;
    protected EstadoVehiculo estado;
    protected List<Viaje> viajes;

    public Vehiculo(String placa, double capacidad, double consumo, double mantenimiento, LocalDate fechaMantenimiento) {
        this.placa = placa;
        this.capacidadDeCarga = capacidad;
        this.consumoCombustible = consumo;
        this.costoBaseMantenimiento = mantenimiento;
        this.fechaUltimoMantenimiento = fechaMantenimiento;
        this.estado = EstadoVehiculo.DISPONIBLE;
        this.viajes = new ArrayList<>();
    }

    // Cálculo del costo operativo según la fórmula dada
    public double calcularCostoOperativo(Viaje viaje) {
        return viaje.getDistanciaRecorrida() * consumoCombustible * PRECIO_COMBUSTIBLE + costoBaseMantenimiento;
    }

    public void agregarViaje(Viaje viaje) {
        viajes.add(viaje);
    }

    // Actualiza el estado del vehículo según su último mantenimiento
    public void actualizarEstado() {
        long meses = ChronoUnit.MONTHS.between(fechaUltimoMantenimiento, LocalDate.now());
        if (meses > 6) {
            estado = EstadoVehiculo.NECESITA_MANTENIMIENTO;
        }
    }

    public void actualizarMantenimiento(LocalDate fecha) {
        this.fechaUltimoMantenimiento = fecha;
        estado = EstadoVehiculo.DISPONIBLE;
    }

    public EstadoVehiculo getEstado() {
        return estado;
    }

    public String getPlaca() {
        return placa;
    }

    public abstract String toString();
}