package ex1;

public class ContaEspecial extends ContaBancaria {
    private double limite;

    public ContaEspecial(String cliente, String numeroConta, double saldo, double limite) {
        super(cliente, numeroConta, saldo);
        this.limite = limite;
    }

    public double getLimite() {
        return limite;
    }

    @Override
    public void sacar(double valor) {
        if (valor > 0 && saldo + limite >= valor) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso.");
        } else {
            System.out.println("Limite insuficiente para saque.");
        }
    }
}
