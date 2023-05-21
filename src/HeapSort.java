import java.util.ArrayList;

public class HeapSort {
  
    HeapSort(ArrayList<Integer> vet) {
        int n = vet.size();

        // Construir o heap máximo
        for (int i = n / 2 - 1; i >= 0; i--) {
            heap(vet, n, i);
        }

        // Extrair elementos do heap um por um
        for (int i = n - 1; i > 0; i--) {
            
            swap(vet, 0, i);
            heap(vet, i, 0);
        }
    }

    private static void heap(ArrayList<Integer> vet, int n, int i) {
        int maior = i; //maior elemento
        int esq = 2 * i + 1;
        int dir = 2 * i + 2; 

        if (esq < n && vet.get(esq) > vet.get(maior)) {
            maior = esq;
        }

        if (dir < n && vet.get(dir) > vet.get(maior)) {
            maior = dir;
        }
        if (maior != i) {
            swap(vet, i, maior);
            //Recursivo
            heap(vet, n, maior);
        }
    }

    //troca
    private static void swap(ArrayList<Integer> vet, int i, int j) {
        int aux = vet.get(i);
        vet.set(i, vet.get(j));
        vet.set(j, aux);
    }
}
