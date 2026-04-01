public class Mago extends Personagem{
    Mago(String nome){
        this.nome = nome;
        this.vida = 10;
    }

    @Override
    void mostrarStatus(){
        System.out.println("Nome do mago: " + nome);
        System.out.println("Vida: " + vida);
    }
}
