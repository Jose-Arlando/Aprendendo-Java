public abstract class Personagem{
    String nome;
    int vida;

    void Mago(String nome){
        this.nome = nome;
    }

    abstract void mostrarStatus();

    void resultado(){
        if (vida <= 0){
            System.out.println(nome+" foi derrotado!");
        } else {
            System.out.println(nome+" sobreviveu com "+vida+" de vida");
        }
    }
}
