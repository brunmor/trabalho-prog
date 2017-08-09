import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InsertionSort extends GenericSort {

    public InsertionSort(String path) {
        super(path);
    }
    
    public InsertionSort(int [] vet) {
        super(vet);
    }
 
    public void insertionSort(int[] v){
        int i, j, x;
        
        for (i = 1; i < v.length; i++){
            x = v[i];
         for (j = i - 1; j >= 0 && v[j] < x; j--)
            v[j+1] = v[j];
            v[j+1] = x;
        }  
    } 

   @Override
    public void sortArray() {
        long start, finish;
        
        start = System.currentTimeMillis();
        insertionSort(vet);
        finish = System.currentTimeMillis();
        System.out.println("Insertion Sort: " + (finish - start) + " ms");
        
        try {
            writer("test/saida"+vet.length+"_insertion.out", vet);
        } catch (IOException ex) {
            Logger.getLogger(InsertionSort.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }
}