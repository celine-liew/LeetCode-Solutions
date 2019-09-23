// ascending order array
// [0,1,2,3,4,5,6,7] -> [4,5,6,7,0,1,2]
// if found return index, else -1

module.exports = findMin = (nums) => {
    return recursiveFindMin(0, nums.length-1, nums);
};

const recursiveFindMin = (start, end, array) => {
    if (end - start === 0) {
        return array[start];
    }

    if (array[start] < array[end]) {
        return array[start];
    }

    const mid = start + Math.floor((end - start)/2);
    // if (array[mid-1] > array[mid]) {
    //     return array[mid];
    // } else if (array[mid] > array[mid+1]) {
    //     return array[mid+1]
    // } else 
    if (array[mid] >= array[start]) {
        return recursiveFindMin(mid + 1, end, array);
    } else {
        return recursiveFindMin(0, mid - 1, array);
    }   
};



/* using while method: */

var findMin = function(nums) {
    /* question - is it continous numbers? duplicates? non-numbers inside array?
    
    first way: 
check that 0th < last element? if it is then 0th is the smallest. 
go down the list one by one and if there is element smaller than it, that smaller element is the smallest.
    
    binary search approach -> check the xth element against first and last elements.  */
    
    
    let min = Number.NEGATIVE_INFINITY
    let len = nums.length
    let start = 0, end = len; 
    const first = nums[0], last = nums[len-1]  // 4, 2
      
    if (first < last)
      return nums[start]
    
    
    while (start < end) {
      console.log(start,end)
      let mid = start + Math.floor((end - start) / 2)  // mid = 3
      let check = nums[mid]
      
        
      if (check <= first && check <= last) {
        if (check < nums[mid-1]) {
          return check;
        }
        end = mid
      }
      else { 
        start = mid;
      } 
    }
    // console.log("here?" + start)
    return check;
};

// console.log(findMin([4,0,1,2,3]))
// console.log(findMin([3,4,0,1,2]))
// console.log(findMin([3,4,5,1,2]))
// console.log(findMin([1,2,3,4,5]))
console.log(findMin([1,2,3,4,5,0]))
console.log(findMin([1,2,3,4,5,-1,0]))
    
    
