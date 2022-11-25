import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class App {
	
	static String shiftEncrypt(String content, int shift, int module) {
		String encryptedString = "";
		char tmpChar = ' ';
		for(int i = 0; i < content.length(); i++) {
			if(content.charAt(i) == ' ') {
				encryptedString += " ";
			}else {
				if(((char) content.charAt(i)) >= 'A' && ((char) content.charAt(i) - shift) < 'A' || 
						((char) content.charAt(i)) >= 'a' && ((char) content.charAt(i) - shift) < 'a') {
					tmpChar = (char)(content.charAt(i) - shift + module);
				}else {
					tmpChar = (char) (content.charAt(i) - shift);
					System.out.println("crypted letter: "+content.charAt(i)+"--> encrypted letter: "+tmpChar);
				}
				encryptedString += tmpChar;
			}
		}
		System.out.println("\nCrypted content: "+content+" --> Encrypted Content: "+encryptedString+" .");
		return encryptedString;
	}
	
	static String shiftCrypt(String content, int shift, int module) {
		String cryptedString = "";
		char tmpChar = ' ';
		for(int i = 0; i < content.length(); i++) {
			if(content.charAt(i) == ' ') {
				cryptedString += " ";
			}else {
				if(((char) content.charAt(i)) <= 'Z' && ((char) content.charAt(i) + shift) > 'Z' ||
						((char) content.charAt(i)) <= 'z' && ((char) content.charAt(i) + shift) > 'z') {
					tmpChar = (char)(content.charAt(i) + shift - module);
				}else {
					tmpChar = (char) (content.charAt(i) + shift);
					System.out.println("encrypted letter: "+content.charAt(i)+"--> crypted letter: "+tmpChar);
				}
				cryptedString += tmpChar;
			}
		}
		System.out.println("\nEncrypted content: "+content+" --> Crypted Content: "+cryptedString+" .");
		return cryptedString;
	}
	
	static void encrypting() {
		String res;
		try {
			System.out.println("Nome file da decryptare: ");
    		res = in.nextLine();
    		System.out.println("Shift da utilizzare: ");
    		int shift = in.nextInt();
    		System.out.println("Modulo da utilizzare");
    		int mod = in.nextInt();
    		System.out.println("Inserisci nome file per l'output: ");
    		in.nextLine();
    		String outputFileName = in.nextLine();
    		PrintWriter outputFile = new PrintWriter(outputFileName+".txt");
    		in = new Scanner(new FileReader(res+".txt"));
    		res = in.nextLine();
    		System.out.println("Contenuto da decryptare: "+res);
    		res = shiftEncrypt(res, shift, mod);
    		System.out.println("Contenuto decryptato: "+res);
    		outputFile.print(res);
    		outputFile.close();
    		System.out.println("Operazione conclusa.");
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	static void crypting() {
		String res;
		try {
			System.out.println("Nome file da cryptare: ");
    		res = in.nextLine();
    		System.out.println("Shift da utilizzare: ");
    		int shift = in.nextInt();
    		System.out.println("Modulo da utilizzare");
    		int mod = in.nextInt();
    		System.out.println("Inserisci nome file per l'output: ");
    		in.nextLine();
    		String outputFileName = in.nextLine();
    		PrintWriter outputFile = new PrintWriter(outputFileName+".txt");
    		in = new Scanner(new FileReader(res+".txt"));
    		res = in.nextLine();
    		System.out.println("Contenuto da cryptare: "+res);
    		res = shiftEncrypt(res, shift, mod);
    		System.out.println("Contenuto cryptato: "+res);
    		outputFile.print(res);
    		outputFile.close();
    		System.out.println("Operazione conclusa.");
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	static Scanner in = new Scanner(System.in);
	
    public static void main( String[] args ) {
    	while(true) {
        	System.out.println("Cosa vuoid fare ? [Enc/C]");
        	String res = in.nextLine();
            	if(res.equals("Enc")) {
            		encrypting();
            	}else if(res.equals("C")) {
            		crypting();
            	}
            	else if(res.equals("quit") || res.equals("Quit")){
            		System.out.println("Closing...");
            		break;
            	}else {
            		System.out.println("Something gone wrong.");
            		break;
            	}
            	in = new Scanner(System.in);
    	}
    }
}
