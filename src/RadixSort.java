import java.util.ArrayList;
import java.util.Arrays;
//import java.util.List;

public class RadixSort {

    RadixSort(ArrayList<Integer> vet) {
        // Encontra o valor máximo no vetor
        int max = Max(vet);

        //radixsort para cada dígito
        for (int exp = 1; max / exp > 0; exp *= 10) {
            CountingSort(vet, exp);
        }
    }

    private static int Max(ArrayList<Integer> vet) {
        int max = Integer.MIN_VALUE;
        for (int num : vet) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    private static void CountingSort(ArrayList<Integer> vet, int exp) {
        int n = vet.size();
        int[] count = new int[10];
        Arrays.fill(count, 0);
    
        // Contagem da ocorrência de cada dígito
        for (int i = 0; i < n; i++) {
            count[(vet.get(i) / exp) % 10]++;
        }
    
        // Calcular as posições corretas de cada dígito
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
    
        // Construir o vetor ordenado
        ArrayList<Integer> output = new ArrayList<>(Arrays.asList(new Integer[n]));
        for (int i = n - 1; i >= 0; i--) {
            int digit = (vet.get(i) / exp) % 10;
            output.set(count[digit] - 1, vet.get(i));
            count[digit]--;
        }
    
        // Copiar o vetor ordenado de volta para o vetor original
        for (int i = 0; i < n; i++) {
            vet.set(i, output.get(i));
        }
    }

}
