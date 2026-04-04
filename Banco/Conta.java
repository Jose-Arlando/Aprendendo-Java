abstract class Conta {
    String numero_conta;
    double saldo = 0.0;
    String titular;

    abstract void depositar(double valor);
    abstract void sacar(double valor);
    abstract public boolean transferir(double valor, Conta destino);
    abstract double getsaldo();
}
