/*
 * What is the greatest product of four adjacent numbers in the same 
 * direction (up, down, left, right, or diagonally) in the 20×20 grid?
 * grid in file, "problem.txt"
 */

import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
class ProjectEuler11{
	public static int[][] readGrid(){
		int[][] grid = new int[20][20];
		Scanner s = null;
		try{			
			s = new Scanner(new File("problem.txt"));
			int Xindex = 0;
			int Yindex = 0;
			while (s.hasNextInt()){
				grid[Xindex][Yindex] = s.nextInt();
				Xindex++;
				if(Xindex > 19){
					Xindex = 0;
					Yindex++;
				}	
			}		
		}
		catch(Exception e){}
		finally{
			if(s != null){
				s.close();
			}
		}	
		return grid;
	}
	
	public static void main(String args[]){
		int[][] grid = readGrid();
		System.out.println(Arrays.deepToString(grid));	
		
	}
}
