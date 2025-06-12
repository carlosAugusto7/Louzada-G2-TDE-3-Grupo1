package view;

import modell.Veiculo;
import modell.Carro;
import modell.Moto;
import modell.Caminhao;
import modell.excecao.*;
import controler.VeiculoController;
import java.util.*;

public class Principal {
    private static VeiculoController controller = new VeiculoController();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean executando = true;

        while (executando) {
            System.out.println("\n1. Cadastrar Veículo");
            System.out.println("2. Listar Veículos");
            System.out.println("3. Atualizar Veículo");
            System.out.println("4. Remover Veículo");
            System.out.println("5. Sair");
            System.out.print("Escolha: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> cadastrar();
                case 2 -> listar();
                case 3 -> atualizar();
                case 4 -> remover();
                case 5 -> executando = false;
                default -> System.out.println("Opção inválida.");
            }
        }
    }

    private static void cadastrar() {
        System.out.println("\nTipo (1-Carro, 2-Moto, 3-Caminhão): ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Placa: ");
        String placa = scanner.nextLine();
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();

        try {
            switch (tipo) {
                case 1 -> {
                    System.out.print("Portas: ");
                    int portas = scanner.nextInt();
                    controller.adicionarVeiculo(new Carro(placa, marca, modelo, portas));
                }
                case 2 -> {
                    System.out.print("Cilindradas: ");
                    int cilindradas = scanner.nextInt();
                    controller.adicionarVeiculo(new Moto(placa, marca, modelo, cilindradas));
                }
                case 3 -> {
                    System.out.print("Eixos: ");
                    int eixos = scanner.nextInt();
                    controller.adicionarVeiculo(new Caminhao(placa, marca, modelo, eixos));
                }
                default -> throw new EntradaInvalidaException("Tipo inválido.");
            }
        } catch (EntradaInvalidaException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void listar() {
        System.out.println("\n--- Veículos Cadastrados ---");
        for (Veiculo v : controller.listarVeiculos()) {
            v.exibirDetalhes();
        }
    } 

    private static void atualizar() {
        System.out.print("Placa do veículo a atualizar: ");
        String placa = scanner.nextLine();

        try {
            Veiculo antigo = controller.buscarPorPlaca(placa);
            System.out.println("Novo cadastro para substituição:");
            cadastrar();
            Veiculo novo = controller.listarVeiculos().get(controller.listarVeiculos().size() - 1);
            controller.removerVeiculo(novo.getPlaca());
            controller.atualizarVeiculo(placa, novo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void remover() {
        System.out.print("Placa do veículo a remover: ");
        String placa = scanner.nextLine();

        try {
            controller.removerVeiculo(placa);
            System.out.println("Removido com sucesso.");
        } catch (VeiculoNaoEncontradoException e) {
            System.out.println(e.getMessage());
        }
    }
}
