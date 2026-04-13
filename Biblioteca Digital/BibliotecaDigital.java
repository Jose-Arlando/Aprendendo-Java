import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
public class BibliotecaDigital {
    public static void main(String[] args){

        ArrayList <Socio> lista = new ArrayList<>();
        ArrayList <Livros> listalivros = new ArrayList<>();
        ArrayList <Ordem> listaordem = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        Random aleatorio = new Random();

        int menu;
        do{
            System.out.println("===========================");
            System.out.println("BEM VINDO A NOSSA BIBLOTECA!");
            System.out.println("1-CADASTRAR NOVO SÓCIO");
            System.out.println("2-CADASTRAR LIVRO");
            System.out.println("3-EMPRESTAR LIVRO");
            System.out.println("4-DEVOLVER LIVRO");
            System.out.println("5-LISTAR SÓCIOS E LIVROS");
            System.out.println("6-SAIR");
            menu = sc.nextInt();
            sc.nextLine();
            System.out.println("===========================");

            switch (menu){
                case 1:
                    Socio socio = new Socio();
                    System.out.println(">> CADASTRAR SÓCIO");
                    System.out.println("QUAL O NOME? ");
                    String nome = sc.nextLine();

                    System.out.println("QUAL O CPF? ");
                    String cpf = sc.nextLine();

                    int cartao = aleatorio.nextInt(100);
                    System.out.println("SEU NÚMERO DE CARTÃO DE ACESSO SERÁ: "+cartao);

                    socio.cadastrar(nome, cpf, cartao);
                    lista.add(socio);
                    socio.mostrarcadastro();   
                    break;          
                case 2:
                    Livros l = new Livros();
                    System.out.println(">> CADASTRAR LIVRO");
                    System.out.println("QUAL O TÍTULO: ");
                    String novotitulo = sc.nextLine();
                    l.titulo = novotitulo;

                    System.out.print("AUTOR: ");
                    String novoautor = sc.nextLine();
                    l.autor = novoautor;

                    System.out.print("CÓDIGO: ");
                    String novocodigo = sc.nextLine();
                    l.codigo = novocodigo;

                    System.out.print("PÁGINAS: ");
                    int novopag = sc.nextInt();
                    sc.nextLine();
                    l.pag = novopag;
                    l.emprestado = false;

                    listalivros.add(l);
                    break;
                case 3: 
                    System.out.println(">> EMPRESTAR LIVRO");
                    System.out.println("QUAL O NÚMERO DO SEU CARTÃO DE ACESSO? ");
                    int cartaobusca = sc.nextInt();
                    sc.nextLine();
                    boolean cartaoencontrado = false;
                    for (Socio s: lista){
                        if(cartaobusca == s.mostrarcartao()){
                            
                            cartaoencontrado = true;
                            System.out.println("SÓCIO ENCONTRADO.");
                            System.out.println("QUAL LIVRO DESEJA? ");
                            String livrobusca = sc.nextLine();
                            boolean encontrado = false;

                            for (Livros x: listalivros){
                                if (livrobusca.equals(x.titulo)){
                                    encontrado = true;
                                    if(!x.emprestado){
                                        Ordem o = new Ordem();
                                        o.devedor = s.mostrarnome();
                                        o.cartaodevedor = s.mostrarcartao();
                                        o.livroemprestado = x.titulo;

                                        listaordem.add(o);
                                        System.out.println("VOCÊ EMPRESTOU!");
                                        x.emprestar();
                                    } else {
                                        for (Ordem o: listaordem){
                                            if(livrobusca.equals(o.livroemprestado)){
                                                System.out.println("O LIVRO:"+o.livroemprestado+" FOI EMPRESTADO PELO SOCIO: "+o.devedor+". ESPERE ELE DEVOLVER!");
                                            }
                                        }
                                        
                                    }
                                }
                            } if (!encontrado){
                            System.out.println("LIVRO NÃO ENCONTRADO");
                            }
                            
                        }
                    }
                    if (!cartaoencontrado){
                        System.out.println("CARTÃO DE ACESSO INCORRETO");
                    }
                    break;
                case 4:
                    l = new Livros();
                    System.out.println(">> DEVOLVER LIVRO");
                    boolean encontrado = false;
                    System.out.println("QUAL O NÚMERO DO SEU CARTÃO DE ACESSO? ");
                    cartaobusca = sc.nextInt();
                    sc.nextLine();
                    System.out.println("QUAL O NOME DO LIVRO: ");
                    String livrobusca = sc.nextLine();
                    encontrado = listaordem.removeIf(o->cartaobusca==o.cartaodevedor && livrobusca.equals(o.livroemprestado));
                    if(encontrado){
                        System.out.println("DEVOLVIDO COM SUCESSO");
                        l.devolver();
                    } else {
                        System.out.println("NÃO FOI POSSÍVEL");
                    }
                    break;
                case 5:
                    System.out.println(">> LISTAR SÓCIOS E LIVROS");
                    System.out.println("--------------------------");
                    System.out.println("SÓCIOS");
                    System.out.println("");
                    for (Socio s: lista){
                        s.mostrar();
                        System.out.println("---------------------------");
                    }
                    
                    System.out.println("LIVROS");
                    System.out.println("");
                    for (Livros x: listalivros){
                        x.mostrar();
                        System.out.println("---------------------------");
                }
            }                
        } while ( menu != 6);
        sc.close();
    }
}
class Livros{
    String titulo;
    String autor;
    String codigo;
    int pag;
    boolean emprestado;

    void emprestar(){
        emprestado = true;
    }

    void devolver(){
        emprestado = false;
    }
    void mostrar(){
        System.out.println("TITULO: "+titulo);
        System.out.println("AUTOR: "+autor);
        System.out.println("CODIGO: "+codigo);
        System.out.println("EMPRESTADO: "+emprestado);
    }

}
class Socio{
    private String nome;
    private String cpf;
    private int cartao;

    void cadastrar(String nome, String cpf, int cartao){
        this.nome = nome;
        this.cpf = cpf;
        this.cartao = cartao;
    }
    void mostrarcadastro(){
        System.out.println("CADASTRADO COM SUCESSO!");
        System.out.println("------------------");
        System.out.println("NOME: "+nome);
        System.out.println("CPF: "+cpf);
        System.out.println("CARTAO: "+cartao );
        System.out.println("------------------");
    }
    void mostrar(){
        System.out.println("NOME: "+nome);
    }
    public String mostrarnome(){
        return nome;
    }
    public int mostrarcartao(){
        return cartao;
    }
}
class Ordem{
    String devedor;
    String livroemprestado;
    int cartaodevedor;
}