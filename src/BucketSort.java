import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {

    private int numBuckets = 0;
    public int getNumBuckets() {
        return numBuckets;
    }
    public void setNumBuckets(int numBuckets) {
        this.numBuckets = numBuckets;
    }
    BucketSort(ArrayList<Integer> vet) {
        int n = vet.size();

        // Encontrar o valor máximo no vetor para determinar o número de baldes
        int max = Integer.MIN_VALUE;
        for (int num : vet) {
            if (num > max) {
                max = num;
            }
        }

        setNumBuckets(NumBuckets(n, max));
        // criaando os baldes
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>(numBuckets);
        for (int i = 0; i < numBuckets; i++) {
            buckets.add(new ArrayList<>());
        }

        // distribui os elementos nos baldes
        for (int i = 0; i < n; i++) {
            int num = vet.get(i);
            int bucketIndex = (int) ((num * 1.0 / (max + 1)) * (numBuckets - 1));
            buckets.get(bucketIndex).add(num);
        }

        // ordenar cada balde individualmente
        for (int i = 0; i < numBuckets; i++) {
            Collections.sort(buckets.get(i));
        }

        // Junta os baldes de volta no vetor original
        int index = 0;
        for (ArrayList<Integer> bucket : buckets) {
            for (int num : bucket) {
                vet.set(index, num);
                index++;
            }
        }
    }
    //determinar a quantidade de baldes
    private int NumBuckets(int quant, int maior) {
        int numBuckets = Math.max((int) Math.sqrt(quant), 1);
        numBuckets = Math.min(numBuckets, maior);
        return numBuckets;
    }
}
