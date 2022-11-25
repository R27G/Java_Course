import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CatFiles {

	static Scanner inUser = new Scanner(System.in);//User Input Reader
	static final String filename = "outputFile";
	
	static List<String> fileInput(int numFiles){//Takes name of file and put them in a list of Strings.
		List<String> listFile = new ArrayList<String>();
		for(int  i= 1; i <= numFiles; i++ ) {
			System.out.println("Insert the name of file number "+i+".");
			String str = inUser.nextLine();
			listFile.add(str+".txt");
		}
		return listFile;
	}
	//Prende una lista di nomi di file e ne concatena il contenuto
	static String catInputFiles(List<String> files) {
		String res = "";
		try {
			for(String s : files) {
				Scanner inFile = new Scanner(new FileReader(s));
				while(inFile.hasNext()) {
					res += inFile.nextLine();
				}
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return res;
	}
	//Write the concatenated string to a file called outputFile.

	static boolean catFileWriter(String content) { 		
		try {
			PrintWriter outputFile = new PrintWriter(filename+".txt");
			outputFile.print(content);
			outputFile.close();
			return true;
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	public static void main(String[] args) {
		/*
		 * APP
		 * 
		 */
		while(true) {
			System.out.println("Insert a number: (Or quit)");
			String str = inUser.nextLine();
			if(str.equals("quit")) {
				System.out.println("Program ended");
				break;
			}else {
				List<String> listFile = fileInput(Integer.parseInt(str));
				System.out.println("Files to concatenate: \n"+listFile);
				String concatenateString = catInputFiles(listFile);
				System.out.println("Hai concatenato la stringa : \n"+concatenateString);
				if(catFileWriter(concatenateString) == true)
					System.out.println("Operazione conclusa con successo");
			}
		}
	}

}
