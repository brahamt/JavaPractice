
/*
 * Eulers algorithm for GCD.
 * Assumes input two positive integers
 */
class gcd{
	
	public static int gcd(int v1, int v2){
		// Returns gcd of the two arguments
		// Recursivly calls self with smaller cases 
		// until a result is obtained
		if(v1%v2 == 0)
			return v2;
		else
			return gcd(v2, v1-v2);
	}
	
	public static void main(String args[]){
		int v1 = Integer.parseInt(args[0]);
		int v2 = Integer.parseInt(args[1]);
		if(v2 > v1){
			int temp = v2;
			v2 = v1;
			v1 = temp;
		}	
		
		System.out.println(gcd(v1,v2));		
	}
}
