import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MergeSort extends GenericSort  {

    public MergeSort(String path) {
        super(path);  
    }
    
    public MergeSort(int [] vet) {
        super(vet);    
    }
    
    private void merge(int p, int q, int r, int v[]){
        int i, j, k;
        int [] w = new int [v.length];
        
        i = p; j = q; k = 0;

        while (i < q && j < r){
        if (v[i] > v[j]) {
            w[k] = v[i];
            i++;
            
            }
        else{
            w[k] = v[j]; j++;
            }
        
            k++;
        }

        while (i < q){
            w[k] = v[i];
            i++;
            k++;
        }
        
        while (j < r){
            w[k] = v[j]; j++;
            k++;
        }
        
        for (i = p; i < r; i++)
             v[i] = w[i-p];
    }
    
    public void mergeSort(int p, int r, int v[]){
       
        if (p < r-1) {
        int q = (p + r) / 2;
        
        mergeSort(p, q, v);
        mergeSort(q, r, v);
        merge(p, q, r, v);
        
        }
    }

    @Override
    public void sortArray() {     
         
         //Calcula tempo de execucao
        long start = System.currentTimeMillis();
        mergeSort(0, vet.length, vet);
        long finish = System.currentTimeMillis();  
        System.out.println("Merge Sort: " + (finish - start) + " ms");
        
        //escreve no arquivo
        try {
            writer("test/saida"+vet.length+"_merge.out", vet);
        } catch (IOException ex) {
            Logger.getLogger(MergeSort.class.getName()).log(Level.SEVERE, null, ex);
            
        }
     
    }
    
}    

