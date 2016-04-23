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
		HashTable<String, Integer> table = new HashTable<>();
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

				System.out.println(">>Enter a symbol consisting of 1-6 char: ");
				String s = read.readLine();charVal = s.toCharArray();				
				int iterations = s.length();int total = 0;int exp = s.length()-1;																		
				for(int i = 0; i<iterations; i++){					
					int currentMapNumber = (char)charVal[i]-64;
					total += currentMapNumber * Math.pow(32,exp--);
				}
				table.tableInsert(s,total%3);
				break;

			case 2:
				System.out.println(">>Enter a symbol to delete: ");
				String s1 = read.readLine();
				boolean deleted = table.tableDelete(s1);
				if(deleted){
					System.out.println("Item " + s1 + " successfully deleted.");	
				}
				else{
					System.out.println("Item " + s1 + " was NOT found.");	
				}
				break;

			case 3:
				System.out.println("Retrieve and display a value in table: " );
				String s2 = read.readLine();
				Integer val = table.tableRetrieve(s2);
				if(val!=null){
					System.out.println("The hash value for this symbol is: " + val);
				}
				else{
					System.out.println("Does not exist.");
				}
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
