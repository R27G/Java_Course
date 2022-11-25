import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class App {
	
	static Scanner in = new Scanner(System.in);
	
    public static void main( String[] args ) {
    	System.out.println("Inserisci file di input(senza estensione) ed una parola chiave");
    	String filename = in.next();
    	String keyword = in.next();
    	
    	System.out.println("Filename: "+filename+"\nKeyword: "+keyword);
    	try {
        	in = new Scanner(new FileReader(filename+".txt"));
        	String res = in.nextLine();
        	/*
        	 * usare scanner.hasnext per leggere linea per linea oppure bufferedReader(readLine).
        	 */
        	in.close();
    	}catch(IOException e) {
    		e.printStackTrace();
    	}

    	
    }
}
