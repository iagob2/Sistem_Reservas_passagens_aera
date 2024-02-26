package Sistema;
 
import java.util.ArrayList;
 
public class Voo {
 
    private String numeroVoo;
    private String origem;
    private String destino;
    private int numAssentosDisp;
    
    // Inicialização do ArrayList no construtor
    private ArrayList<String> listaDeDestino;
    private ArrayList<String> listaDeOrigem;
 
    // Construtor da classe
    public Voo(String numVoo, int orig, int dest, int numDisp) {
        this.numeroVoo = numVoo;
        
        // Inicialização das listas dentro do construtor
        listaDeDestino = new ArrayList<>();
        listaDeDestino.add("São Paulo");
        listaDeDestino.add("Rio de Janeiro");
        listaDeDestino.add("Praia Grande");
        
        listaDeOrigem = new ArrayList<>();
        listaDeOrigem.add("Santos");
        listaDeOrigem.add("Cubatão");
        listaDeOrigem.add("São Vicente");
        
        // Acessando a origem a partir do ArrayList
        if (orig >= 0 && orig < listaDeOrigem.size()) {
            this.origem = listaDeOrigem.get(orig);
        } else {
            this.origem = "Origem Inválida";
        }
        
        // Acessando o destino a partir do ArrayList
        if (dest >= 0 && dest < listaDeDestino.size()) {
            this.destino = listaDeDestino.get(dest);
        } else {
            this.destino = "Destino Inválido";
        }
        
        this.numAssentosDisp = numDisp;
    }
    
// Métodos getters e setters
    public String getNumeroVoo() {
        return numeroVoo;
    }
 
    public String getDestino() {
        return destino;
    }
 
    public int getAssentosDisponiveis() {
        return numAssentosDisp;
    }
 
 
    // Método para exibir informações do voo
    public void info() {
        System.out.println("Número do Voo: " + this.numeroVoo);
        System.out.println("Origem: " + this.origem);
        System.out.println("Destino: " + this.destino);
        System.out.println("Número de assentos disponíveis: " + this.numAssentosDisp);
    }
 
    // Método para realizar uma reserva
    public void realizarReserva() {
        if (this.numAssentosDisp > 0) {
            this.numAssentosDisp--;
            System.out.println("Sua reserva foi realizada.");
        } else {
            System.out.println("Desculpe, não há assentos disponíveis.");
        }
    }
 
    // Método para obter a quantidade de assentos disponíveis
    public int quantidadeAssentos() {
        return this.numAssentosDisp;
    }
 
    // Método para calcular o valor do pagamento
    public double realizarPagamento(int op) {
        double valor = 0;
        
        // Adicionei equals() para comparar strings
        if (this.destino.equals("Rio de Janeiro")) {
            valor += 100;
        }
        
        if (op == 1) {
            valor += 1000;
        } else {
            valor += 2000;
        }
        
        return valor;
    }
 
    // Método para imprimir a passagem
    public void imprimirPassagem(int opcao) {
        System.out.println("Número do Voo: " + this.numeroVoo);
        System.out.println("Origem: " + this.origem);
        System.out.println("Destino: " + this.destino);
        
        // Mostrando o valor do voo com a opção escolhida pelo usuário
        System.out.println("Valor do voo: " + realizarPagamento(opcao));
    }
}