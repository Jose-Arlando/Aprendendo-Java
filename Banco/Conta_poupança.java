public class Conta_poupança extends Conta{

    boolean transferido = false;
    
    void depositar(double valor){
        saldo +=valor;
        System.out.println("valor depositado em conta poupança: R$"+valor+" saldo atual: "+saldo);
    }

    void sacar(double valor){
        if(saldo >= valor){
            saldo -= valor;
            System.out.println("Valor sacado da conta poupança: R$"+valor+" saldo atual: R$"+saldo);
        } else {
            System.out.println("Saldo insuficiente para saque. Saldo atual: R$"+saldo);
        }
    }
    
    public boolean transferir(double valor, Conta destino){
        if(saldo >= valor){
            this.saldo -= valor;
            destino.depositar(valor);
            System.out.println("Valor transferido da conta corrente: R$"+valor+" saldo atual: R$"+saldo);
            return true;
        } else {
            System.out.println("Saldo insuficiente para transferir. Saldo atual: R$"+saldo);
            return false;
        }
    }

    double getsaldo(){
        return saldo;
    }
    
    String gettitular(){
        return titular;
    }
}