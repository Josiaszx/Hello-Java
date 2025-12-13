package poo.polimorfismo;

public class Moto extends Vehiculo {
    private boolean tieneSidecar;

    public Moto(String marca, String modelo, boolean tieneSidecar) {
        super(marca, modelo);
        this.tieneSidecar = tieneSidecar;
    }

    @Override
    public void acelerar() {
        System.out.println("La moto " + marca + " " + modelo + " acelera rápidamente");
    }
}
