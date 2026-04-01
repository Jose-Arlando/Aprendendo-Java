import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

class RPG{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        Random n = new Random();
        ArrayList <Personagem> listaPersonagens = new ArrayList<>();
        int op;

        System.out.println("Bem-vindo ao RPG!\nEscolha entre o mago Gandalf e o guerreiro Maximus para iniciarmos!");
        Mago mago = new Mago("Gandalf");
        Guerreiro guerreiro = new Guerreiro("Maximus");

        listaPersonagens.add(mago);
        listaPersonagens.add(guerreiro);

        do{
            
            System.out.println("----------------------");
            System.out.println("1 - INICIAR RODADA.");
            System.out.println("0 - FINALIZAR.");
            op = sc.nextInt();
            sc.nextLine();
            
            if(op == 1){
                for (Personagem p : listaPersonagens){
                    if(p.vida > 0){
                        System.out.println("----------------------");
                        System.out.println("Vez de: "+p.nome);
                        System.out.println("Deseja atacar? (1-sim/2-não)");
                        int escolha = sc.nextInt();
                        sc.nextLine();
                        if(escolha == 1){
                            System.out.println("Quem você deseja atacar? ");
                            String personagem_busca = sc.nextLine();
                            if(personagem_busca.equalsIgnoreCase(p.nome)){
                                System.out.println("Você não pode atacar a si mesmo!");
                                continue;
                            } else {
                                System.out.println("----------------------");
                                for(Personagem personagem: listaPersonagens){
                                    if(personagem.nome.equalsIgnoreCase(personagem_busca)){
                                        int dano = n.nextInt(1,10);
                                        int defesa = n.nextInt(0,5);
                                        System.out.println("Dano: "+dano+" / Defesa: "+defesa);
                                        if (dano > defesa){
                                            System.out.println("Ataque bem-sucedido!");
                                            personagem.vida -= (dano - defesa);
                                            if (personagem.vida <= 0){
                                                personagem.resultado();
                                                break;
                                            }
                                        } else {
                                            System.out.println("Ataque falhou! O defensor bloqueou o ataque.");
                                        }
                                        personagem.resultado();
                                    }
                                }
                            
                            }
                        } 

                    }else {
                        System.out.println(p.nome+" está fora de combate");
                    }
                }
            }
        } while (op != 0);
    System.out.println("Jogo finalizado.");
    sc.close();
    }
}