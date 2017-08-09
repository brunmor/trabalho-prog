import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CountingSort extends GenericSort  {

    public CountingSort(String path) {
        super(path);
    }
    
    public CountingSort(int [] vet ) {
        super(vet);
    } 

    public void countingSort(int[] vet) {
        int i, j, max = -1; 
        int[] values;
        
        //Pega o maior valor para determinar o tamanho do vetor
        for (i = 0; i < vet.length; i++)
            if (Math.abs(vet[i]) > max) max = Math.abs(vet[i]);

        values = new int[max*2 + 1];

        //Ao atingir um valor, faz a mudança de tamanho máximo      
        for (i = 0; i < vet.length; i++)
            values[vet[i]+max]++;

        i = 0; j = values.length - 1;
        while (i < vet.length){
            if (values[j] > 0) {
                values[j]--;
                
                //passa ao vetor origial os valores ordenados
                vet[i] = j-max;
                i++;
            }
            else j--;
        }
    }
    
    @Override
    public void sortArray() { 
        long start, finish;
        
        start = System.currentTimeMillis();
        countingSort(vet);
        finish = System.currentTimeMillis();
        System.out.println("Counting Sort: " + (finish - start) + " ms");
        
        try {
            writer("test/saida"+vet.length+"_counting.out", vet);
        } catch (IOException ex) {
            Logger.getLogger(CountingSort.class.getName()).log(Level.SEVERE, null, ex);
         }
     
    }
     
}


