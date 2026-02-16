import java.util.Scanner;
public class Condicao {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("qual sua idade: ");
        int idade = sc.nextInt();
        System.out.println(idade);
        
        if(idade < 18){
            System.out.println("menor de idade");
        }else if(idade == 18){
            System.out.println("Completou 18 agora");
        }else{
            System.out.println("maior de idade");
        }
    }
}
