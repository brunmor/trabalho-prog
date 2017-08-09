public class Principal {
    
    public static void main (String [] args) {
        
        String path = args[0];

        GenericSort c1 = new BubbleSort(path);
        c1.sortArray();
        
        GenericSort c2 = new InsertionSort(path);
        c2.sortArray();
        
        GenericSort c3 = new SelectionSort(path);
        c3.sortArray();
        
        GenericSort c4 = new MergeSort(path);
        c4.sortArray();
        
        GenericSort c5 = new QuickSort(path);
        c5.sortArray();
        
        GenericSort c6 = new HeapSort(path);
        c6.sortArray();

        GenericSort c7 = new CountingSort(path);
        c7.sortArray();
    } 
}
    
    
    

