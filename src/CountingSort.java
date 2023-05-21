import java.util.ArrayList;

public class CountingSort {
    CountingSort(ArrayList<Integer> vet) {
        int n = vet.size();
        if (n <= 1) {
            return;
        }
    
        int max = Integer.MIN_VALUE;
        for (int num : vet) {
            if (num > max) {
                max = num;
            }
        }

        int[] count = new int[max + 1];
        for (int i = 0; i <= max; i++) {
            count[i] = 0;
        }
 
        for (int i = 0; i < n; i++) {
            count[vet.get(i)]++;
        }

        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        // Construindo vetor ordenado
        ArrayList<Integer> vetor = new ArrayList<>(n);
        for (int i = n - 1; i >= 0; i--) {
            vetor.add(0); 
        }
        for (int i = n - 1; i >= 0; i--) {
            int num = vet.get(i);
            int index = count[num] - 1;
            vetor.set(index, num);
            count[num]--;
        }

        
        for (int i = 0; i < n; i++) {
            vet.set(i, vetor.get(i));
        }
    }
}
