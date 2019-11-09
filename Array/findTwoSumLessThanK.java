/* Pair with largest sum which is less than K in the array
Given an array arr of size N and an integer K. The task is to find the pair of intergers such that their sum is maximum and but less than K

Examples:

Input : arr = {30, 20, 50} , K = 70
Output : 30, 20
30 + 20 = 50 which is maximum possible usm which is less than K

Input : arr = {5, 20, 110, 100, 10}, K = 85
Output : 20, 10
*/

import java.util.Arrays; 
  
class GFG  
{ 
  
// Function to find pair with largest  
// sum which is less than K in the array 
static void Max_Sum(int arr[], int n, int k) 
{ 
    // sort first
    Arrays.sort(arr);
    int breakpoint = n;
    for (int i=0; i<n; i++){
        if (arr[i] >= k){
            breakpoint = i;
            break;
        }
    }
    
    int right = breakpoint - 1;
    int left = 0;
    while (left < right && left >= 0){
        while (arr[0] + arr[right] >= k){
            right--;
        }
        left = right-1;
        while (arr[left] + arr[right] >= k){
            left--;
        }
        break;
    }
    
     System.out.print( "ans: " + arr[left] + " " + arr[right]); 
} 
  
// Driver code 
public static void main (String[] args)  
{ 
    /* ans: 10.20 */
    // int []arr = {5, 20, 110, 100, 10};  
    // int k = 85; 
    /* ans: 10.20 */
    int []arr = {5, 20, 40, 3000, -10};  
    int k = 46; 

    /* ans: 20,30 */
    // int []arr = {30, 20, 50};  
    // int k = 70; 
    int n = arr.length; 
      
    // Function call 
    Max_Sum(arr, n, k); 
} 
}  
  
// This code is contributed by anuj_67.. 
