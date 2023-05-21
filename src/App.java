//Scarlet Hanna Damaso Ferreira


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static Scanner scan = new Scanner(System.in);
    public static Random random = new Random();

    public static void main(String args[])throws Exception{
        ArrayList<Integer> vetorGerado = new ArrayList<Integer>();
        
        int opPivo = 0;
        int opcao = 0;
        long startTimer = 0;
        long endTimer = 0;
        long duracao = 0;
        int baldes = 0;


        do {
            System.out.printf("\n\n[1] QuickSort\n" + "[2] HeapSort\n" + "[3] RadixSort\n"+ "[4] CountingSort\n"
            + "[5] BucketSort\n" + "Escolher opção: ");
            opcao = scan.nextInt();
            System.out.printf("Tamanho do vetor: ");
            int num = scan.nextInt();
            vetorGerado = gerarVetor(num);
            
            ArrayList<Integer> vetor = new ArrayList<Integer>(vetorGerado);
            switch (opcao) {
                case 1:
                    System.out.printf("[1] Pivô do meio\n" + "[2] Pivô Aleatório\n"
                    +"Escolher opção: ");
                    opPivo = scan.nextInt();
                    startTimer = System.nanoTime();
                    QuickSort quick = new QuickSort(vetor,opPivo);
                    endTimer = System.nanoTime();
                    duracao = endTimer - startTimer;
                    break;
            
                case 2:
                    startTimer = System.nanoTime();
                    HeapSort heap = new HeapSort(vetor);
                    endTimer = System.nanoTime();
                    duracao = endTimer - startTimer;
                    break;
                case 3:
                    startTimer = System.nanoTime();
                    RadixSort radix = new RadixSort(vetor);
                    endTimer = System.nanoTime();
                    duracao = endTimer - startTimer;
                    break;
                case 4:
                    startTimer = System.nanoTime();
                    CountingSort counting = new CountingSort(vetor);
                    endTimer = System.nanoTime();
                    duracao = endTimer - startTimer;
                    break;
                case 5:
                    startTimer = System.nanoTime();
                    BucketSort bucket = new BucketSort(vetor);
                    baldes = bucket.getNumBuckets();
                    endTimer = System.nanoTime();
                    duracao = endTimer - startTimer;
                    break;
            }
            imprimir(vetor,vetorGerado);
            imprimirResultado(duracao,vetor,opPivo,baldes);
            reset(vetor,startTimer,endTimer,duracao, baldes);
            System.out.printf("Encerrar Programa\n" + "[1]Sim" + " [2]Não\n"
                    + "Escolher opção: ");
            opcao = scan.nextInt();
        } while (opcao != 1);

        

    }

    public static void reset(ArrayList<Integer> vetor, long startTimer, long endTimer, long duracao, int baldes) {
        startTimer = 0;
        endTimer = 0;
        duracao = 0;
        baldes = 0;
        vetor.clear();
    }

    // método que imprime vetor
    public static void imprimir(ArrayList<Integer> vetor, ArrayList<Integer> vetGerado) {
        System.out.println("\nVetor Desordenado: ");
            for (int vet : vetGerado) {
                System.out.printf("%d ", vet);
            }
            System.out.println("\n");

        
            System.out.println("\nVetor Ordenado: ");
            for (int vet : vetor) {
                System.out.printf("%d ", vet);
            }
            System.out.println("\n");

    }

    // método para imprimir resultados
    public static void imprimirResultado(long duracao,ArrayList<Integer> vetor,int pivo, int baldes) {
        System.out.println("------------------");
        System.out.println("Tempo de execução: " + duracao / 1000000 + " milissegundos");
        if (pivo == 1) {
            System.out.println("Pivô: do meio");
        }
        else if(pivo == 2){
            System.out.println("Pivô: aleatório");
        }
        if(baldes > 0){
            System.out.println("Quantidade de baldes: "+baldes);
        }
        System.out.println("Quantidade de elementos: "+vetor.size());
        System.out.println("------------------");
    }

    // método para gerar vetor com valores em ordem decrescente, crescente ou aleatória
    public static ArrayList<Integer> gerarVetor(int quant) {
        System.out.printf("[1] Vetor Decrescente\n"+"[2] Vetor Crescente\n"+"[3] Vetor Aleatório\n"+"[4] Vetor de CEPs\n"+"Escolher opção: " );
        int num = quant;
        int opcao = scan.nextInt();
        ArrayList<Integer> vet = new ArrayList<Integer>(); // criar vetor com o tamanho passado como parâmetro
        switch (opcao) {
            case 1: //Vetor Decrescente
                int aux = num;
                for (int i = 0; i < num; i++) {
                    vet.add(aux); aux--;}
                break;
            case 2: //Vetor Crescente
                for (int i = 1; i <= num; i++) {
                    vet.add(i);
                }
                break;

            case 3: //Vetor Aleatório
                for (int i = 0; i < num; i++) {
                    int numero = random.nextInt(num*3)+1;// gerando valor
                    boolean contem = vet.contains(numero);
                    if (contem) {
                        i--;
                    } else {
                        vet.add(numero);
                    }
                }
                break;
            case 4://gerar ceps
                String pre = "66";
                for (int i = 0; i < num; i++) {
                    int n = random.nextInt(900000) + 100000; // gerando 6 dígitos
                    String cep = pre+n;
                    Integer numero =Integer.parseInt(cep);
                    boolean contem = vet.contains(numero);
                    if (contem) {
                        i--;
                    } else {
                        vet.add(numero);
                    }
                }
                break;
        } 
        return vet;
    }
}
