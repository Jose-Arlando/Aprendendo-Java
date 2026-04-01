public class Guerreiro extends Personagem{
    Guerreiro(String nome){
        this.nome = nome;
        this.vida = 10;
    }

    @Override
    void mostrarStatus(){
        System.out.println("Nome do guerreiro: " + nome);
        System.out.println("Vida: " + vida);
    }    
}
