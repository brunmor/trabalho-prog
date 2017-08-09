public class HeapMaximo {
    
  private int[] h;
    private int numElementos;
    int j;

    public HeapMaximo(int maxTam){
        h = new int[maxTam];
        numElementos = 0; 
    }
    
    public HeapMaximo(int[] vet){
        h = vet;
        numElementos = vet.length;
    }
    
    public void subir(int indice){
        j = (int) (Math.ceil(indice / 2) - 1);
        if (j >= 0){
        if (h[indice] < h[j]){
        int aux = h[indice]; h[indice] = h[j]; h[j] = aux;
        subir(j);
            }
        }
    }
    
    public void descer(int indice){
        j = 2 * indice;
        
        if (j < numElementos){
            if (j < numElementos - 1){
            if (h[j + 1] < h[j]){
            j++;
                 }
            }
        if (h[indice] > h[j]){
            int aux = h[indice]; h[indice] = h[j]; h[j] = aux;         
            descer(j);
            } 
        }   
    }

    public void construirHeap(){
        int ultimo = (int) (Math.floor((double) numElementos / 2)) - 1;
        for (int i = ultimo; i >= 0; i--)
        descer(i);   
    }
    
    public void trocaElementos(int i, int j){
        int aux = h[i];
        h[i] = h[j];
        h[j] = aux;
    }
    
    public void decNumElementos(){
        numElementos--;
        }
   
}