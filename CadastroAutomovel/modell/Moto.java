package modell;

public class Moto extends Veiculo {
    private int cilindradas;

    public Moto(String placa, String marca, String modelo, int cilindradas) {
        super(placa, marca, modelo);
        this.cilindradas = cilindradas;
    }

    public void exibirDetalhes() {
        System.out.println("Moto - Placa: " + placa + ", Marca: " + marca + ", Modelo: " + modelo + ", Cilindradas: " + cilindradas + ", IPVA: R$" + calcularIPVA());
    }

    public double calcularIPVA() {
        return 500.0;
    }
}
