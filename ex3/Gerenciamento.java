package ex3;

import java.util.Scanner;

public class Gerenciamento {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selecione o tipo de acomodação:");
        System.out.println("1 - Quarto Simples");
        System.out.println("2 - Quarto Duplo");
        System.out.println("3 - Suíte");
        int tipo = scanner.nextInt();

        System.out.print("Digite a quantidade de dias: ");
        int dias = scanner.nextInt();

        System.out.print("Digite a quantidade de pessoas: ");
        int numPessoas = scanner.nextInt();

        Acomodacao acomodacao;

        switch (tipo) {
            case 1:
                acomodacao = new QuartoSimples();
                break;
            case 2:
                acomodacao = new QuartoDuplo();
                break;
            case 3:
                acomodacao = new Suite();
                break;
            default:
                System.out.println("Opção inválida.");
                scanner.close();
                return;
        }

        acomodacao.exibirDetalhes(dias, numPessoas);
        scanner.close();
    }
}
