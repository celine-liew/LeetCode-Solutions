/*
Given a array A consisting of N integers and an integer K,
return the largest contiguous subarray from all the contiguous subarrays of length K.
We defined that subarray A is greater than subarray B if the first non-matching element in both arrays has a greater value in A than in B.
For example,A=[1,2,4,3],B=[1,2,3,5].
A is greater than B because A[2]>B[2].

Example
Example 1:

Input:
[1,4,3,2,5]
4
Output:
[4,3,2,5]
Explanation:
there are two subarrays of size 4:
[1,4,3,2]and [4,3,2,5].
So the largest subarray is [4,3,2,5].
Example 2:

Input:
[7,1,2,7,9,2,3,1,2,5]
4
Output:
[9,2,3,1]
*/

function largestSubarray(arr, k){
  const arrLen = arr.length;
  let container = [];
  
  for (let i = 0; i < arrLen - k + 1; i++){
    let temp = [];
    for (let j = i; j < i + k; j++){
      temp.push(arr[j]);
    }
    container.push(temp);
  }
  
  console.log(container)
  container=container.sort();
  console.log(container)
  
  return container[container.length - 1];
}

let arr = [ 1, 9, 2, 7, 9, 3] , k = 2;
console.log(largestSubarray(arr, k));
