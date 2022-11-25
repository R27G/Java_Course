import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class App {
	
	static Scanner in = new Scanner(System.in);
	static final String outputfilename = "output";
    public static void main( String[] args ) {
    	System.out.println("Inserisci file di input(senza estensione) ed una parola chiave");
    	String inputFilename = in.next();
    	String keyword = in.next();
    	
    	System.out.println("Filename: "+inputFilename+"\nKeyword: "+keyword);
    	/*
    	 * usare scanner.hasnext per leggere linea per linea oppure bufferedReader(readLine).
    	 */
    	try {
        	in = new Scanner(new FileReader(inputFilename+".txt"));
    		PrintWriter outputFile = new PrintWriter(outputfilename+".txt");
        	while(in.hasNext()) {
            	String res = in.nextLine();
            	if(res.contains(keyword)) {
            		outputFile.print(res);
            	}
        	}
        	outputFile.close();
        	in.close();
    	}catch(IOException e) {
    		e.printStackTrace();
    	}
    }
}
