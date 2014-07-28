/*
 * What is the first term in the Fibonacci sequence to contain 1000 digits?
 * 
 */
import java.math.*;
class ProjectEuler25{
	public static void main(String[] args){
		int n = 2;
		BigInteger p1 = BigInteger.valueOf(1);
		BigInteger p2 = BigInteger.valueOf(1);		
		while(true){
			n += 1;
			BigInteger p3 = p1.add(p2);
			if(p3.toString().length() >= 1000)
				break;
			p1 = p2;
			p2 = p3;	
		}
		System.out.println(n);
	}
}
