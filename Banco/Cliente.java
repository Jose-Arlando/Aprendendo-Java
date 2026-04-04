import java.util.ArrayList;
class Cliente{

    private String nome;
    private String cpf;
    Conta Conta_poupança;
    Conta Conta_corrente;

    public Cliente(){}
    
    public Cliente(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
        Conta_poupança = new Conta_poupança();
        Conta_corrente = new Conta_corrente();

    }
    //métodos
    String getnome(){ 
        return nome;
    }

    String getcpf(){
        return cpf;
    }

    void mostrar(){
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Tipo de conta: " + Conta_poupança.getClass().getSimpleName());
        System.out.println("Saldo: R$" + Conta_poupança.getsaldo());
        System.out.println("Tipo de conta: " + Conta_corrente.getClass().getSimpleName());
        System.out.println("Saldo: R$"+Conta_corrente.getsaldo());
        System.out.println("-----------------------------");
    }
}