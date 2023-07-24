/**
 * @param {number[]} arr
 * @return {number[][]}
 */
const threeSum = function(arr) {
    const triples = [];
    const nums = arr.sort((a,b) => a - b);
    for (let i = 0; i < nums.length; i++) {
        let left = i + 1;
        let right = nums.length - 1;

        while (left < right) {
            const sum = nums[i] + nums[left] + nums[right];
            if (sum === 0) {
                triples.push([nums[i], nums[left], nums[right]]);
            } else if (sum < 0) {
                left++;
            } else if (sum > 0) {
                right--;
            }
        }
    }
    return triples;
};


console.log(threeSum([-1,0,1,2,-1,-4]));