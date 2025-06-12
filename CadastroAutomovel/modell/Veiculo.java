package modell;

public abstract class Veiculo implements Exibivel {
    protected String placa;
    protected String marca;
    protected String modelo;

    public Veiculo(String placa, String marca, String modelo) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public abstract double calcularIPVA();
}
