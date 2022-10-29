import java.util.Scanner;

public class heap3 {
    private static int tam;
    private static int[] vetor;

    static Scanner leitor = new Scanner(System.in);

    public static void main(String[] args) {

        String linha;

        linha = leitor.nextLine();

        String splitLinha[] = linha.split(" ");
        int arr[] = new int[splitLinha.length];

        for(int i = 0; i < splitLinha.length; i++){
            arr[i] = Integer.parseInt(splitLinha[i]);
        }

        System.out.print("Estado inicial:");
        printArray(arr);
        
        
        heapsort(arr);

    }

    public static void printArray(int arr[]){
        
        for(int i=0; i<arr.length; i++){
            if(i<arr.length-1){
                System.out.printf(" %d |", arr[i]);
            }
            else{
                System.out.printf(" %d", arr[i]);
            }
        }
    }
    
    public static void heapsort(int[] array) {
        vetor = array;          
        tam = vetor.length - 1; 
        

        constroiHeap();
        
        for (int i = tam; i > 0; i--) {
            troca(0, tam);      
            tam -= 1;           
            maxHeapifica(0);  
        }
    }
    
    private static void constroiHeap() {
        
        int meio;

        if(vetor.length%2==0){
            meio = (int) tam/2;
        }
        else{
            meio = (int) (tam/2);
            meio--;
        }
        
        for (int i = meio ; i >= 0; i--) {
            maxHeapifica(i);
            System.out.print("\nEstado Atual:");
            printArray(vetor);
        }

        System.out.print("\nResultado Final:");
        printArray(vetor);

    }
    

    private static void troca(int i, int j) {
        int aux;
        aux = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = aux;
    }
    
    
    private static void maxHeapifica(int pai) {

        int maior = pai,            
            esquerda = 2 * pai + 1, 
            direita = 2 * pai + 2;  
        
        if (esquerda <= tam && vetor[esquerda] > vetor[maior])
            maior = esquerda;
        
        if (direita <= tam && vetor[direita] > vetor[maior])
            maior = direita;
        
        if (maior != pai) {
            troca(pai, maior);      
            maxHeapifica(maior);    
        }

    }
    
}
