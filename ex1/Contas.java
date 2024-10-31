package ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Contas {
    private static List<ContaBancaria> contas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ContaPoupanca contaPoupanca = new ContaPoupanca("Cliente 1", "001", 1000.0, 10);
        contas.add(contaPoupanca);

        ContaEspecial contaEspecial = new ContaEspecial("Cliente 2", "002", 500.0, 300.0);
        contas.add(contaEspecial);

        System.out.println(
                "Escolha uma operacao:\n1 - Sacar\n2 - Depositar\n3 - Mostrar Saldo com Rendimento\n4 - Mostrar Dados das Contas");
        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                System.out.print("Informe o número da conta para saque: ");
                String numeroContaSaque = scanner.next();
                System.out.print("Informe o valor do saque: ");
                double valorSaque = scanner.nextDouble();
                realizarSaque(numeroContaSaque, valorSaque);
                break;

            case 2:
                System.out.print("Informe o número da conta para depósito: ");
                String numeroContaDeposito = scanner.next();
                System.out.print("Informe o valor do depósito: ");
                double valorDeposito = scanner.nextDouble();
                realizarDeposito(numeroContaDeposito, valorDeposito);
                break;

            case 3:
                System.out.print("Informe a taxa de rendimento (%): ");
                double taxaRendimento = scanner.nextDouble();
                calcularRendimentoContas(taxaRendimento);
                break;

            case 4:
                mostrarDadosContas();
                break;

            default:
                System.out.println("Opção inválida.");
                break;
        }

        scanner.close();
    }

    public static void realizarSaque(String numeroConta, double valor) {
        for (ContaBancaria conta : contas) {
            if (conta.getNumeroConta().equals(numeroConta)) {
                conta.sacar(valor);
                return;
            }
        }
        System.out.println("Conta não encontrada.");
    }

    public static void realizarDeposito(String numeroConta, double valor) {
        for (ContaBancaria conta : contas) {
            if (conta.getNumeroConta().equals(numeroConta)) {
                conta.depositar(valor);
                return;
            }
        }
        System.out.println("Conta não encontrada.");
    }

    public static void calcularRendimentoContas(double taxaRendimento) {
        for (ContaBancaria conta : contas) {
            if (conta instanceof ContaPoupanca) {
                ((ContaPoupanca) conta).calcularNovoSaldo(taxaRendimento);
            }
        }
    }

    public static void mostrarDadosContas() {
        for (ContaBancaria conta : contas) {
            System.out.println("Cliente: " + conta.getCliente());
            System.out.println("Número da Conta: " + conta.getNumeroConta());
            System.out.println("Saldo: R$" + conta.getSaldo());
            if (conta instanceof ContaPoupanca) {
                System.out.println("Tipo: Conta Poupança");
            } else if (conta instanceof ContaEspecial) {
                System.out.println("Tipo: Conta Especial");
            }
            System.out.println("---------------------------");
        }
    }
}
