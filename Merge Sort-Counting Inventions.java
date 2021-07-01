import java.io.*;

import java.util.*;

import java.text.*;

import java.math.*;

import java.util.regex.*;

 
public class Solution
{
  
 
public static long countInversions (int[]arr, int[]work_arr)
  {
    
long swaps = 0;
    
for (int width = 1; width < arr.length; width *= 2)
      {
	
for (int i = 0; i < arr.length; i += 2 * width)
	  {
	    
swaps +=
	      merge (arr, i, Math.min (i + width, arr.length),
		     Math.min (i + 2 * width, arr.length), work_arr);
	  
} 
copyArray (work_arr, arr);
      
} 
return swaps;
  
}
  
 
public static long merge (int[]arr, int lo, int mid, int hi,
			       int[]work_arr)
  {
    
int i = lo;
    
int j = mid;
    
long swaps = 0;
    
for (int k = lo; k < hi; k++)
      {
	
if (i < mid && (j >= hi || arr[i] <= arr[j]))
	  {
	    
work_arr[k] = arr[i];
	    
i++;
	    
swaps += j - mid;
	  
}
	
	else
	  {
	    
work_arr[k] = arr[j];
	    
j++;
	  
}
      
}
    
return swaps;
  
}
  
 
public static void copyArray (int[]work_arr, int[]arr)
  {
    
for (int i = 0; i < work_arr.length; i++)
      {
	
arr[i] = work_arr[i];
  
} 
} 
 
public static void main (String[]args)
  {
    
Scanner in = new Scanner (System.in);
    
int t = in.nextInt ();
    
long t0 = System.currentTimeMillis ();
    
for (int a0 = 0; a0 < t; a0++)
      {
	
int n = in.nextInt ();
	
int arr[] = new int[n];
	
int work_arr[] = new int[n];
	
for (int arr_i = 0; arr_i < n; arr_i++)
	  {
	    
arr[arr_i] = in.nextInt ();
	    
work_arr[arr_i] = 0;
	  
} 
System.out.println (countInversions (arr, work_arr));
    
} 
if (args.length > 0 && args[0].equals ("timed"))
      {
	
long t1 = System.currentTimeMillis ();
	
System.out.println ((t1 - t0) / 1000.0 + " seconds");
      
}

} 
 
 
}
