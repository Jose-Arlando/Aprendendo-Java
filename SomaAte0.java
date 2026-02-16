import java.util.Scanner;
public class SomaAte0 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("0- parar de adicionar. \nQual valor: ");
        int n = sc.nextInt();
        int acm = 0;
        while(n != 0){
            acm = acm + n;
            System.out.print("0- parar de adicionar. \nQual valor: ");
            n = sc.nextInt();
        
        }
        System.out.print("soma: " +acm);
    } 
}