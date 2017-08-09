
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SelectionSort extends GenericSort {

    public SelectionSort(String path) {
        super(path);
    }
    
    public SelectionSort(int [] vet) {
        super(vet);
    }
    
    public void selectionSort(int[] v){
        int i, j, min;      
        for (i = 0; i < v.length-1; i++){    
            min = i;
            
        for (j = i+1; j < v.length; j++)
            if (v[j] > v[min])
            min = j;        
             troca(i,v, min);
        } 
    }

    private void troca(int i,int v[], int min) {       
        int aux  = v[min];
            v[min] = v[i];
            v[i]  = aux;
    }       

    @Override
    public void sortArray() {   
        long start, finish;
        
        start = System.currentTimeMillis();
        selectionSort(vet);
        finish = System.currentTimeMillis();
        System.out.println("Selection Sort: " + (finish - start) + " ms");
        
        try {
            writer("test/saida"+vet.length+"_selection.out", vet);
        } catch (IOException ex) {
            Logger.getLogger(SelectionSort.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
}
