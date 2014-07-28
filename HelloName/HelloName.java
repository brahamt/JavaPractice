/*
 * Try out three methods for console input.
 * Scanner is the recommended way, system.console returns null if input
 * is not console. Bufferedreader is the most flexible way.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
class HelloName{
	
	public static void main(String args[]){
		// Using Scanner
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your name: ");
		String name = sc.nextLine();
		
		// Using console.in
		System.out.println("Enter your language of choice: ");
		String lang = System.console().readLine();
		
		// Using BufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter your IDE of choice: ");
		String ide = "Geany";
		try{
			ide = br.readLine();		
		}
		catch(IOException e){}
		
		System.out.println("Hello "+name+", enjoy doing "+lang+" on "+ide);
	}
}
