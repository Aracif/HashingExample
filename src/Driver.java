import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Driver {
	//Ascii values A-Z==65-90
	//Pseudocode-if ascii val >=65 <=90 subtract 64, this will map 1-26 to letters
	//A-Z
	public static void main(String[] args) throws IOException{
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		HashTable<Integer, String> table = new HashTable<>();
		char[] charVal = new char[6];
		
		while(true){
			int selection = Integer.parseInt(read.readLine());
			System.out.println("\t1. Insert a symbol in the symbol table");
			System.out.println("\t2. Delete a symbol from the symbol table");
			System.out.println("\t3. Retrieve and display the value of a symbol in the symbol table");
			System.out.println("\t4. Display the hash index of a symbol");
			System.out.println("\t5. Exit program");
			System.out.println(">>Make a selection: " + selection);
			
			switch(selection){
			
			case 1:		
					
					System.out.println(">>Enter the a symbol consisting of 1-6 char: ");
					String s = read.readLine();charVal = s.toCharArray();				
					int iterations = s.length();int total = 0;int exp = s.length()-1;
					
														
					for(int i = 0; i<iterations; i++){
						System.out.println(charVal[i]);
						int currentMapNumber = (char)charVal[i]-64;
						System.out.println("Current number: " + currentMapNumber);
						System.out.println("Current exp: " + i);
						total += currentMapNumber * Math.pow(32,exp--);
					}
					System.out.println("Total: " + total);
					System.out.println("Hash value: " + total%3);
					table.tableInsert(total%3, s);
					break;
					
			case 2:
					System.out.println(">>Enter a symbol to delete: ");
					String s1 = read.readLine();
					break;
					
			case 3:
					System.out.println("Retrieve and display a value in table: " );
					String s2 = read.readLine();
					break;
			case 4:
					System.out.println("Enter a symbol to return its hash index: ");
					String s3 = read.readLine();
					break;
			
			case 5:
					System.out.println("Goodbye");
					System.exit(0);
					break;
			
			}
			
		}
			
			

 


	}

}
