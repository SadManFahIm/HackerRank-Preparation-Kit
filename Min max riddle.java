import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.Stack;
import java.util.TreeMap;

public class Solution { 
  public static void main(String[] args) throws IOException { 
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    
    for(int i=0; i<arr.length; i++){
       arr[i] = sc.nextInt();
    }
    
    int[] result = riddle(arr);
    
    for(int i=0; i<result.length; i++){
       if(i != 0){
         System.out.print(" ");
       }
       System.out.print(result[i]);
    }
    sc.close();
  }
  

  static int[] riddle(int[] arr) {
    int[] lefts = leftWinSize(arr);
    int[] rights = rightWinSize(arr);

    SortedMap<Integer, Integer> numberToWinSize = new TreeMap<>(Collections.reverseOrder());
    
    
    for(int i=0; i<arr.length; i++){
     
      numberToWinSize.put(
        arr[i],
        Math.max(numberToWinSize.getOrDefault(arr[i], -1),lefts[i] + rights[i] + 1));
    }
    
    Iterator<Integer> iter = numberToWinSize.keySet().iterator();
    int number = iter.next();
    int[] result = new int[arr.length];
    
    for(int i=0; i<result.length; i++){
    
      while(numberToWinSize.get(number) <= i){
        number = iter.next();
      }
      result[i] = number;
    }
    return result;
  }
  
 
  static int[] leftWinSize(int[] arr){
    int[] lefts = new int[arr.length];
    Stack<Integer> indices = new Stack<>();
    
    for(int i=0; i<arr.length; i++){
      while(!indices.isEmpty() && arr[i] <= arr[indices.peek()]){
        indices.pop();
      }
      lefts[i] = i - (indices.isEmpty() ? 0 : indices.peek() + 1);
      indices.push(i);
    }
    
    return lefts;
  }
  
  
  static int[] rightWinSize(int[] arr){
    int[] rights = new int[arr.length];
    Stack<Integer> indices = new Stack<>();
    
    for(int i=arr.length-1; i>=0; i--){
      while(!indices.isEmpty() && arr[i] <= arr[indices.peek()]){
        indices.pop();
      }
      
      rights[i] = (indices.isEmpty() ? arr.length : indices.peek()) - i - 1;
      indices.push(i);
    }
    return rights;
  }
}