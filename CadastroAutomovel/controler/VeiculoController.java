package controler;

import modell.*;
import modell.excecao.*;
import java.util.*;

public class VeiculoController {
    private List<Veiculo> veiculos = new ArrayList<>();

    public void adicionarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    public List<Veiculo> listarVeiculos() {
        return veiculos;
    }

    public void atualizarVeiculo(String placa, Veiculo novo) throws VeiculoNaoEncontradoException {
        Veiculo antigo = buscarPorPlaca(placa);
        veiculos.set(veiculos.indexOf(antigo), novo);
    }

    public void removerVeiculo(String placa) throws VeiculoNaoEncontradoException {
        Veiculo veiculo = buscarPorPlaca(placa);
        veiculos.remove(veiculo);
    }

    public Veiculo buscarPorPlaca(String placa) throws VeiculoNaoEncontradoException {
        for (Veiculo v : veiculos) {
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                return v;
            }
        }
        throw new VeiculoNaoEncontradoException("Veículo com placa " + placa + " não encontrado.");
    }
}
