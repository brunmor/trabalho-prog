import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BubbleSort extends GenericSort {  

    public BubbleSort(String path) {
        super(path);
    }
    
    public BubbleSort(int [] vet) {
        super(vet);
    }

    public void bubble( int []v){
        for (int i = v.length-1; i > 0; i--){
            for (int j = 0; j < i; j++)  
                if (v[j] < v[j+1])
                    troca(v, j, j+1);
            }
    }
     
    private void troca(int [] v, int i, int j){
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    } 
    
    @Override
    public void sortArray() {
        long start, finish;
        
        start = System.currentTimeMillis();
        bubble(vet);
        finish = System.currentTimeMillis();
        System.out.println("Bubble Sort: " + (finish - start) + " ms");
        
        try {
            writer("test/saida"+vet.length+"_bubble.out", vet);
        } catch (IOException ex) {
            Logger.getLogger(BubbleSort.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
    
   
}

         
         
         
     


  

