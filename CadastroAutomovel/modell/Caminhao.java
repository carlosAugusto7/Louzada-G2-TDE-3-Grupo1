package modell;

public class Caminhao extends Veiculo {
    private int eixos;

    public Caminhao(String placa, String marca, String modelo, int eixos) {
        super(placa, marca, modelo);
        this.eixos = eixos;
    }

    public void exibirDetalhes() {
        System.out.println("Caminhão - Placa: " + placa + ", Marca: " + marca + ", Modelo: " + modelo + ", Eixos: " + eixos + ", IPVA: R$" + calcularIPVA());
    }

    public double calcularIPVA() {
        return 2000.0;
    }
}

