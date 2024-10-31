package ex3;

public class QuartoSimples implements Acomodacao, ServicoAdicional {
    private static final double DIARIA_FIXA = 100.0;
    private static final double CAFE_DA_MANHA = 20.0;
    private static final double LIMPEZA_EXTRA = 30.0;

    @Override
    public double calcularDiaria(int dias) {
        return DIARIA_FIXA * dias;
    }

    @Override
    public double calcularServico(int dias, int numPessoas) {
        return (CAFE_DA_MANHA * numPessoas * dias) + (LIMPEZA_EXTRA * dias);
    }

    @Override
    public void exibirDetalhes(int dias, int numPessoas) {
        double custoDiaria = calcularDiaria(dias);
        double custoServico = calcularServico(dias, numPessoas);
        double custoTotal = custoDiaria + custoServico;

        System.out.println("Quarto Simples:");
        System.out.println("Diária: R$" + DIARIA_FIXA);
        System.out.println("Custo das Diárias: R$" + custoDiaria);
        System.out.println("Custo de Serviços Adicionais: R$" + custoServico);
        System.out.println("Custo Total para " + dias + " dias: R$" + custoTotal);
    }
}
