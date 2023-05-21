import java.util.ArrayList;
import java.util.Random;

public class QuickSort {
  
    public QuickSort(ArrayList<Integer> vet, int pivo) {
        quickSort(vet, 0, vet.size()-1, pivo);
    }
  
    private void quickSort(ArrayList<Integer> vet, int l, int r, int pivo) {
        int index = 0;
        if (pivo == 1) {
            index = particao(vet, l, r, Medio(vet, l, r));
        }
        else if (pivo == 2) {
            index = particao(vet, l, r, Aleatorio(l, r));
        }
        if (l < index - 1) {
            quickSort(vet, l, index - 1, pivo);
        }
        if (index < r) {
            quickSort(vet, index, r, pivo);
        }
    }
  
    private int particao(ArrayList<Integer> vet, int l, int r, int pivo) {
        while (l <= r) {
            while (vet.get(l) < pivo) {
                l++;
            }
            while (vet.get(r) > pivo) {
                r--;
            }
            if (l <= r) {
                swap(vet, l, r);
                l++;
                r--;
            }
        }
        return l;
    }
  
    private int Medio(ArrayList<Integer> vet, int l, int r) {
        int meio = l + (r - l) / 2;
        int a = vet.get(l);
        int b = vet.get(meio);
        int c = vet.get(r);
        return Math.max(Math.min(a, b), Math.min(Math.max(a, b), c));
    }
  
    private int Aleatorio(int l, int r) {
        Random rand = new Random();
        return rand.nextInt(r - l + 1) + l;
    }
  
    private void swap(ArrayList<Integer> vet, int i, int j) {
        int aux = vet.get(i);
        vet.set(i, vet.get(j));
        vet.set(j, aux);
    }
}
