import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HeapSort extends GenericSort  {

    public HeapSort(String path) {
        super(path);
    }
    
    public HeapSort(int [] vet) {
        super(vet);
    }

    public void heapSort(int[] vet){
        HeapMaximo h = new HeapMaximo(vet);
        h.construirHeap();
        
        for (int i = vet.length-1; i > 0; i--){
            h.trocaElementos(0, i);
            h.decNumElementos();
            h.descer(0);     
        }
    }
    
    @Override
    public void sortArray() {
        long start, finish;
        
        //Calcula tempo de execucao
        start = System.currentTimeMillis();
        heapSort(vet);
        finish = System.currentTimeMillis();
        System.out.println("Heap Sort: " + (finish - start) + " ms");
        
        //Grava em arquivo
        try {
            writer("test/saida"+vet.length+"_heap.out", vet);
        } catch (IOException ex) {
            Logger.getLogger(HeapSort.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
}
    
    
    
    


         
