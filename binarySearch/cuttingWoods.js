/* Given an int array wood representing the length of n pieces of wood and an int k. 
It is required to cut these pieces of wood such that more or equal to k pieces of the same length len are cut. 
What is the longest len you can get?
*/

function get_pieces(nums, length){
  
  return nums.reduce( (acc, val) =>{ 
    return acc + Math.floor(val/length);
  } , 0);
}


function binary(nums, k){
  let l =0,
      r = Math.max(...nums),
      best = 0;
  
  while (l <= r){
    let mid = Math.floor((l+r)/2)
    if (mid == 0) return 0;
    
    let pieces = get_pieces(nums, mid)
    
    if (pieces < k){
      r = mid -1;
    } else {
      if (pieces == k){
        best = Math.max(best, mid);
      }
        l = mid+1;
    }
  }
  return best;
}

console.log(binary([5, 9, 7], 3))
console.log(binary([5, 9, 7], 4))
console.log(binary([1, 2, 3], 7))
