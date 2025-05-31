package VehiculoControl.Modelo;

import java.time.LocalDate;

// Clase para motos, hereda de Vehiculo
public class Moto extends Vehiculo {
    private int cilindrada;

    public Moto(String placa, double capacidad, double consumo, double mantenimiento, LocalDate fecha, int cilindrada) {
        super(placa, capacidad, consumo, mantenimiento, fecha);
        this.cilindrada = cilindrada;
    }

    @Override
    public String toString() {
        return "Moto [Placa=" + placa + ", Cilindrada=" + cilindrada + ", Estado=" + estado + "]";
    }
}
