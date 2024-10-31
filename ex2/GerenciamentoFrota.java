package ex2;

import java.util.ArrayList;
import java.util.List;

public class GerenciamentoFrota {
    public static void main(String[] args) {
        List<Veiculo> frota = new ArrayList<>();

        frota.add(new Carro("ABC-1234", "Toyota", "Corolla", 2020));
        frota.add(new Caminhao("DEF-5678", "Volvo", "FH16", 2018));
        frota.add(new Onibus("GHI-9012", "Mercedes", "Sprinter", 2019));

        for (Veiculo veiculo : frota) {
            veiculo.exibirDetalhes();
            System.out.println("---------------------------");
        }
    }
}
