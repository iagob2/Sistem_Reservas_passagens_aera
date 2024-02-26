
package Sistema; 
import java.util.Scanner;
 
public class Teste {
    public static void main(String[] args) {
    	
    	System.out.println("Azul Airlines");
    	
        // Criando um objeto da classe Voo
     //   Voo iago = new Voo("abc566", 0, 1, 40);
 
        // Realizando algumas reservas
      //  iago.realizarReserva();
       // iago.realizarReserva();
     //   iago.realizarReserva();
 
        // Exibindo a quantidade de assentos disponíveis
     //   System.out.println("Quantidade de assentos disponíveis: " + iago.quantidadeAssentos());
 
        // Calculando e exibindo o valor do pagamento
     //  System.out.println("Valor do pagamento: " + iago.realizarPagamento(1));
 
        // Imprimindo a passagem
      //  iago.imprimirPassagem(1);
        
       // Scanner origin = new Scanner(System.in);
        
    	
    	// Criando um objeto da classe Voo
        Scanner scanner = new Scanner(System.in);
        
        // Solicitando a entrada do número do voo
        System.out.print("Digite o número do voo: ");
        String numeroVoo = scanner.nextLine();
        
        // Solicitando a entrada para origem
        System.out.println("Escolha a origem:");
        System.out.println("1. Santos");
        System.out.println("2. Cubatão");
        System.out.println("3. São Vicente");
        System.out.print("Digite o número da origem: ");
        int origem = scanner.nextInt() - 1; // Subtrai 1 para corresponder ao índice do ArrayList
        
        // Solicitando a entrada para destino
        System.out.println("Escolha o destino:");
        System.out.println("1. São Paulo");
        System.out.println("2. Rio de Janeiro");
        System.out.println("3. Praia Grande");
        System.out.print("Digite o número do destino: ");
        int destino = scanner.nextInt() - 1; // Subtrai 1 para corresponder ao índice do ArrayList
        
        // Solicitando a entrada para número de assentos disponíveis
        System.out.print("Digite o número de assentos disponíveis: ");
        int numAssentosDisp = scanner.nextInt();
        
        Voo novoVoo = new Voo(numeroVoo, origem, destino, numAssentosDisp);
        
        // Realizando algumas reservas
      //  novoVoo.realizarReserva();
       // novoVoo.realizarReserva();
      //  novoVoo.realizarReserva();
        
        // Exibindo a quantidade de assentos disponíveis
        System.out.println("Quantidade de assentos disponíveis: " + novoVoo.quantidadeAssentos());
        
        // Calculando e exibindo o valor do pagamento
        System.out.println("Valor do pagamento: " + novoVoo.realizarPagamento(1));
        
        // Imprimindo a passagem
        novoVoo.imprimirPassagem(1);
        
        // Fechando o scanner
        scanner.close();
        
        
        
    }
}
 