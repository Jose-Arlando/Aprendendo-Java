public class Conta_corrente extends Conta{
    double limite = 500;
    


    void depositar(double valor){
        this.saldo += valor;
        System.out.println("valor depositado em conta corrente: R$"+valor+" saldo atual: "+saldo);
    }

    void sacar(double valor){
        if(saldo >= valor){
            saldo -= valor;
            System.out.println("Valor sacado da conta corrente: R$"+valor+" saldo atual: R$"+saldo);
        } else if(saldo < valor && saldo + limite >= valor){
            saldo -= valor;
            System.out.println("Foi utilizado o limite. Saldo atual: R$"+saldo);
        } else {
            System.out.println("Saldo insuficiente para saque. Saldo atual: R$"+saldo);
        }
    }

    public boolean transferir(double valor, Conta destino){
        if(saldo >= valor){
            this.saldo -= valor;
            destino.depositar(valor);
            
            
            return true;
        } else {
            return false;
        }
    }

    double getsaldo(){
        return saldo;
    }
}