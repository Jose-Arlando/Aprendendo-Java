package primeiroprograma;
import java.util.Scanner;
import java.util.ArrayList;

public class Cadastro {
    public static void main (String[] args){
        ArrayList <Conta> lista = new ArrayList<>(); 
        Scanner sc = new Scanner(System.in);
        System.out.println("===== BEM VINDO AO BANCO =====");
        System.out.println("1 - Adicionar conta");
        System.out.println("2 - Consultar contas");
        System.out.println("3 - Atualizar conta");
        System.out.println("4 - Remover conta");
        System.out.println("5 - sair");
        System.out.println("O que você deseja? ");
        int op = sc.nextInt();
        sc.nextLine();

        while ( op != 5 ){
            if (op == 1){
                Conta p = new Conta();
                System.out.println("Qual o nome do usuário? ");
                p.nome = sc.nextLine();
                System.out.println("Qual o CPF do usuário? ");
                p.cpf = sc.nextLine();
                lista.add(p);
                System.out.println("===== BEM VINDO NOVAMENTE AO BANCO =====");
                System.out.println("1 - Adicionar conta");
                System.out.println("2 - Concultar contas");
                System.out.println("3 - Atualizar conta");
                System.out.println("4 - Remover conta");
                System.out.println("5 - sair");
                System.out.println("O que você deseja? ");
                op = sc.nextInt();
                sc.nextLine();

            } else if (op == 2){
                for (Conta p: lista){
                    p.mostrarcontas();
                }
                System.out.println("===== BEM VINDO NOVAMENTE AO BANCO =====");
                System.out.println("1 - Adicionar conta");
                System.out.println("2 - Concultar contas");
                System.out.println("3 - Atualizar conta");
                System.out.println("4 - Remover conta");
                System.out.println("5 - sair");
                System.out.println("O que você deseja? ");
                op = sc.nextInt();
                sc.nextLine();

            } else if (op == 3){
                System.out.println("Digite CPF da conta que deseja atualizar: ");
                String cpfmudar = sc.nextLine();
                boolean encontrado = false;
                for (Conta p: lista){
                    if (cpfmudar.equals(p.cpf)){
                            System.out.println("Qual o novo nome? ");
                            String novonome = sc.nextLine();
                            p.nome = novonome;
                            System.out.println("MUDADO COM SUCESSO!");
                            encontrado = true;
                            break;
                    }
                }
                if (encontrado == false){
                    System.out.println("CPF não encontrado");
                }          
                System.out.println("===== BEM VINDO NOVAMENTE AO BANCO =====");
                System.out.println("1 - Adicionar conta");
                System.out.println("2 - Concultar contas");
                System.out.println("3 - Atualizar conta");
                System.out.println("4 - Remover conta");
                System.out.println("5 - sair");
                System.out.println("O que você deseja? ");
                op = sc.nextInt();
                sc.nextLine();
            
            } else if (op == 4){
                System.out.println("Digite CPF da conta que deseja excluir: ");
                String cpfremover = sc.nextLine();
                boolean removido = lista.removeIf(p -> cpfremover.equals(p.cpf));
                if(removido){
                    System.out.println("REMOVIDO COM SUCESSO");
                } else {
                    System.out.println("CPF NÃO ENCONTRADO");
                }
                
                System.out.println("===== BEM VINDO NOVAMENTE AO BANCO =====");
                System.out.println("1 - Adicionar conta");
                System.out.println("2 - Concultar contas");
                System.out.println("3 - Atualizar conta");
                System.out.println("4 - Remover conta");
                System.out.println("5 - sair");
                System.out.println("O que você deseja? ");
                op = sc.nextInt();
                sc.nextLine();
            }
        }
        System.out.println("OBRIGADO POR ACESSAR NOSSO CADASTRO!");
        sc.close();
    }
}

class Conta{
    String nome;
    String cpf;

    void mostrarcontas(){
        System.out.println("===============");
        System.out.println("NOME: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("===============");
    }

}
