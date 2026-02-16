import java.util.Scanner;
public class CalculadoraComSwitch {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("n1: ");
        int n1 = sc.nextInt();
        System.out.print("n2: ");
        int n2 = sc.nextInt();
        sc.nextLine();
        System.out.print("operador: ");
        String op = sc.nextLine();
        
        switch (op){
            case ("+"):
                int r = n1 + n2;
                System.out.println(n1+ "+" +n2+ "=" + r);
                break;
            case ("-"):
                r = n1 - n2;
                System.out.println(n1+ "-" +n2+ "=" + r);
                break;
            case ("*"):
                r = n1 * n2;
                System.out.println(n1+ "x" +n2+ "=" + r);
                break;
            case ("/"):
                if (n2 == 0){
                    System.out.println(n1+ "+" +n2+ "=" + 0);
                } else {
                    r = n1 / n2;
                    System.out.println(n1+ "+" +n2+ "=" + r);
                }
                break;
        }
    }
}