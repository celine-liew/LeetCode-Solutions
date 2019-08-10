/*
module.exports = permute = (nums) => {
    const ans = [];
    permuteHelper(nums, [], ans);
    return ans;
};

const permuteHelper = (nums, currentSeq, ans) => {
    if (nums.length === 1) {
        ans.push(currentSeq.concat(nums[0]));
        return;
    }

    for (let i = 0; i < nums.length; i++) {
        permuteHelper(nums.slice(0,i).concat(nums.slice(i+1)), currentSeq.concat(nums[i]), ans);
    }
}
*/
module.exports = permute = (nums) => {
    return permuteHelper(nums);
};

const permuteHelper = (nums) => {
    if (nums.length === 1) {
        return [nums[0]];
    }

    const answer = [];
    for (let i = 0; i < nums.length; i++) {
        const rtValues = permuteHelper(nums.slice(0,i).concat(nums.slice(i+1)));
        console.log(rtValues);
        rtValues.forEach(value => {
            answer.push([nums[i]].concat(value));
        })
    }
    return answer;
}