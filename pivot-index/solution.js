/**
 * @param {number[]} nums
 * @return {number}
 * 
 * totalSum = leftSum + rightSum + nums[i]
 * rightSum = totalSum - leftSum - nums[i]
 */
 const pivotIndex = function(nums) {
    let totalSum = 0;
    let leftSum = 0;
    nums.forEach((item) => {
        totalSum += item;
    })

    for (let i = 0; i < nums.length; i++) {
        if (leftSum === (totalSum - leftSum - nums[i])) {
           return i;
        }
        leftSum += nums[i];
    }
    return -1;
};

console.log(pivotIndex([-1,-1,-1,-1,-1,0]));