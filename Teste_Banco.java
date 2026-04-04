import java.util.ArrayList;
import java.util.Scanner;

public class Teste_Banco {
    public static void main(String[] args){

        int opcao;
        Scanner sc = new Scanner(System.in);
        ArrayList <Cliente> listaclientes = new ArrayList<>();
        ArrayList <Historico_transaçao> historico_transaçoes = new ArrayList<>();


        do{
            System.out.println("Bem-vindo ao Banco feito em Java!");
            System.out.println("-----------------------------");
            System.out.println("1. Adicionar cliente");
            System.out.println("2. Depositar");
            System.out.println("3. Sacar");
            System.out.println("4. Transferir");
            System.out.println("5. Ver Saldo");
            System.out.println("6. Ver Histórico de transações");
            System.out.println("0. Sair");
            opcao = sc.nextInt();
            sc.nextLine();

            if(opcao == 1){
                System.out.println(">> Adicionar Cliente!");
                System.out.println("-----------------------------");
                System.out.println("Digite o nome do cliente:");
                String nome = sc.nextLine();
                System.out.println("Digite CPF do cliente:");
                String cpf = sc.nextLine();
                Cliente cliente = new Cliente(nome, cpf);
                listaclientes.add(cliente);
                cliente.mostrar();
                System.out.println("-----------------------------");
            } else if (opcao == 2){
                System.out.println(">> Depositar!");
                System.out.println("-----------------------------");
                System.out.println("Digite CPF do cliente: ");
                String cpfbusca = sc.nextLine();
                boolean encontrado = false;
                for( Cliente c: listaclientes){ 
                    if(c.getcpf().equals(cpfbusca)){
                        encontrado = true;
                        System.out.println("1. Depositar em conta poupança");
                        System.out.println("2. Depositar em conta corrente");
                        int escolha = sc.nextInt();
                        sc.nextLine();
                        if(escolha == 1){
                            System.out.print("Digite o valor que deseja depositar: \nR$");
                            double valordepositar = sc.nextDouble();
                            sc.nextLine();
                            c.Conta_poupança.depositar(valordepositar);
                        } else if (escolha == 2){
                            System.out.print("Digite o valor que deseja depositar: \nR$");
                            double valordepositar = sc.nextDouble();
                            sc.nextLine();
                            c.Conta_corrente.depositar(valordepositar);
                        }
                    }
                } if(!encontrado) 
                    System.out.println("Cliente não encontrado. ");
            } else if (opcao == 3){
                System.out.println(">> Sacar!");
                System.out.println("-----------------------------");
                System.out.println("Digite CPF do cliente: ");
                String cpfbusca = sc.nextLine();
                boolean encontrado = false;
                for (Cliente c: listaclientes){
                    if(c.getcpf().equals(cpfbusca)){
                        encontrado = true;
                        System.out.println("1. Sacar da conta poupança");
                        System.out.println("2. Sacar da conta corrente");
                        int escolha = sc.nextInt();
                        sc.nextLine();
                        if (escolha == 1){
                            System.out.println("Digite o valor que deseja sacar: \nR$");
                            double valorsaque = sc.nextDouble();
                            sc.nextLine();
                            c.Conta_poupança.sacar(valorsaque);
                        } else if (escolha == 2){
                            System.out.println("Digite o valor que deseja sacar: \nR$");
                            double valorsaque = sc.nextDouble();
                            sc.nextLine();
                            c.Conta_corrente.sacar(valorsaque); 
                        }
                    }
                } if (!encontrado)
                    System.out.println("CLiente não encontrado.");
            } else if(opcao == 4){
                System.out.println(">> Transferir!");
                System.out.println("-----------------------------");
                System.out.println("Digite CPF do cliente de origem:");
                String cpfbuscaorigem = sc.nextLine();
                boolean encontradoorigem = false;
                for(Cliente c: listaclientes){
                    if(c.getcpf().equals(cpfbuscaorigem)){
                        encontradoorigem = true;
                        System.out.println("Digite CPF do cliente de destino: ");
                        String cpfbuscadestino = sc.nextLine();
                        boolean encontradodestino = false;
                        for(Cliente d: listaclientes){
                            if(d.getcpf().equals(cpfbuscadestino)){
                                encontradodestino = true;
                                System.out.println("Digite o valor que deseja transferir: \nR$");
                                double valortransferir = sc.nextDouble();
                                sc.nextLine();
                                boolean transferido = c.Conta_corrente.transferir(valortransferir, d.Conta_corrente);
                                if(transferido){
                                    Historico_transaçao t = new Historico_transaçao(c.getnome(), d.getnome(), valortransferir);
                                    historico_transaçoes.add(t);
                                    System.out.println("Valor transferido da conta corrente: R$"+valortransferir+ " saldo atual: R$"+c.Conta_corrente.getsaldo());

                                } else {
                                    System.out.println("Transferência não realizada. Verifique o saldo e tente novamente.");
                                }
                            }
                        } if (!encontradodestino)
                            System.out.println("Cliente de destino não encontrado.");
                    }
                } if (!encontradoorigem)
                    System.out.println("Cliente de origem não encontrado.");
            } else if (opcao == 5){
                System.out.println(">> Ver saldo!");
                System.out.println("-----------------------------");
                System.out.println("Digite CPF do cliente: ");
                String cpfbusca = sc.nextLine();
                boolean encontrado = false;
                for(Cliente c: listaclientes){
                    if (c.getcpf().equals(cpfbusca)){
                        encontrado = true;
                        c.mostrar();
                    }
                } if (!encontrado){
                    System.out.println("Cliente não encontrado.");
                }
            } else if (opcao == 6){
                System.out.println(">> Ver histórico de transações!");
                System.out.println("-----------------------------");
                System.out.println("Digite CPF do cliente: ");
                String cpfbusca = sc.nextLine();
                boolean encontrado = false;
                for(Cliente c: listaclientes){
                    if(c.getcpf().equals(cpfbusca)){
                        for(Historico_transaçao t: historico_transaçoes){
                            System.out.println("Origem: " + t.origem + " Destino: " + t.destino + " Valor: R$" + t.valor);
                        }
                    }
                }
            }
        } while (opcao != 0); 

        for(Cliente c: listaclientes){
            c.mostrar();
        }
        sc.close();
    }   
}
