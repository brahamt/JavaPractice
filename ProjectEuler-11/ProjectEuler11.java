/*
 * What is the greatest product of four adjacent numbers in the same 
 * direction (up, down, left, right, or diagonally) in the 20×20 grid?
 * grid in file, "problem.txt"
 * 
 * Naive solution, loop over each number in the grid from index (0,0). 
 * For each number compute it's product with the next three 
 * to the right, vertically down, diaganol to the left and diagonal to 
 * the right. Maintain the largest value seen, while looping.
 */

import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
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
	
	public static int getProd(int[][] grid, int[] i, int[] j){
		//given the grid, and two arrays each for the two i,j indexes of
		// points in the grid, return product of those points, as long 
		// as they lie within the grid bounds.
		int prod = 1;
		for(int pt = 0; pt <4; pt++){
			if(i[pt] >= 0 && i[pt] < 20 && j[pt] >= 0 && j[pt] < 20)
				prod *= grid[i[pt]][j[pt]];
		}
		return prod;
	}
	public static int[] highestProd(int[][] grid, int i, int j){
		//Given the grid and an i,j index into the grid, return the
		// largest product(horizontal vertical or diagonal)for it.
		List<Integer> prodlist = new ArrayList<Integer>();
		//horizontal
		prodlist.add(getProd(grid, new int[] {i,i+1,i+2,i+3},new int[] {j,j,j,j}));
		//vertical
		prodlist.add(getProd(grid, new int[] {i,i,i,i}, new int[] {j,j+1,j+2,j+3}));
		//right diagonal
		prodlist.add(getProd(grid, new int[] {i,i+1,i+2,i+3}, new int[] {j,j+1,j+2,j+3}));
		//left diagonal
		prodlist.add(getProd(grid, new int[] {i,i-1,i-2,i-3}, new int[] {j,j+1,j+2,j+3}));
		
		int m = Collections.max(prodlist);	
		return new int[] {m, prodlist.indexOf(m)};
		
	}
	public static void main(String args[]){
		int[][] grid = readGrid();
		for(int i=0; i< 20; i++)
			System.out.println(Arrays.toString(grid[i]));	
		int prod = 0;
		int prodx = 0;
		int prody = 0;
		int orientation = 0;
		for(int i = 0; i<20; i++){			
			for(int j = 0; j<20; j++){
				int[] val = highestProd(grid, i,j);
				if(val[0] > prod){
					prod = val[0];

				}
			}
		}
		
		System.out.println("largest product: " +prod);

	}
	
}
