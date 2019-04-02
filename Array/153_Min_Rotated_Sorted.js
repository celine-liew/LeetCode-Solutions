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