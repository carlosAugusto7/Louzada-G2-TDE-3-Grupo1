package modell;

public class Carro extends Veiculo {
    private int portas;

    public Carro(String placa, String marca, String modelo, int portas) {
        super(placa, marca, modelo);
        this.portas = portas;
    }

    public void exibirDetalhes() {
        System.out.println("Carro - Placa: " + placa + ", Marca: " + marca + ", Modelo: " + modelo + ", Portas: " + portas + ", IPVA: R$" + calcularIPVA());
    }

    public double calcularIPVA() {
        return 1000.0;
    }
}

