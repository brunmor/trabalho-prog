import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QuickSort extends GenericSort {

    public QuickSort(String path) {
        super(path);
    }
    
    public QuickSort(int [] vet) {
        super(vet);
    } 
     
    public void quickSort(int p, int r, int[] v){
        int q;
        if (p < r){
        q = partition(p, r, v);
        quickSort(p, q - 1, v);
        quickSort(q + 1, r, v);        
        }
    }
    
    private int partition(int p, int r, int [] v){
        int x = v[r];
        int i = p-1;
        for (int j = p ; j <= r-1 ; j++) {
            if (v[j] >= x){
            i = i + 1;
            trocar(i, j);
            }
        }
            trocar(i + 1, r);        
            return i + 1;    
    }
    
    private void trocar( int i, int j) {    
             int aux  = vet[i];
             vet[i] = vet[j];
             vet[j]  = aux;
    }

    @Override
    public void sortArray() {
        long start, finish;
        
        start = System.currentTimeMillis();
        quickSort(0,vet.length - 1, vet);
        finish = System.currentTimeMillis();
        System.out.println("Quick Sort: " + (finish - start) + " ms");
        
        try {
            writer("test/saida"+vet.length+"_quick.out", vet);
        } catch (IOException ex) {
            Logger.getLogger(QuickSort.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }
}
