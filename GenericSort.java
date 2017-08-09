import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class GenericSort implements SortingInterface {
    int [] vet ;
    long tempoExecucao;
    String path;

    //Primeiro Construtor
    public GenericSort(String path) {   
        this.path = path;  
        
        //Ler arquivo
        try {
            reader(path);
        } catch (IOException ex) {
            Logger.getLogger(GenericSort.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
    
    //Segundo Construtor de cópia
     public GenericSort(int [] v){
         this.vet = v.clone();
    }
     
    //Ler o arquivo
    public void reader(String path) throws FileNotFoundException, IOException{
        
        BufferedReader in = new BufferedReader(new FileReader(path));   
        String line = in.readLine();
        this.vet = new int [Integer.parseInt(line)];
        line = in.readLine();
        String [] vetString = line.split(" ");
        
        for (int i = 0; i < vet.length; i++){
           vet[i] = Integer.parseInt(vetString[i]);   
        }
        in.close();
    
    }
    
    //Escrever no arquivo
    public void writer(String path, int [] vet) throws IOException{
        
        BufferedWriter out = new BufferedWriter(new FileWriter(path));
        for (int i = 0; i < vet. length; i++) {
            out.write("" + vet[i]);
            if (i != vet.length - 1)
                out.write(" ");
	}
        out.newLine();
        out.flush();
	out.close();
    }
 
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < vet.length; i++) {
            stringBuilder.append(vet[i]);
            if (i < vet.length-1) {
                stringBuilder.append(" ");
            }
        }
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
   
}


