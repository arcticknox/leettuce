/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number[]}
 */
const topKFrequent = function(nums, k) {
    const map = new Map();
    nums.forEach((num) => map.set(num, (map.get(num) || 0) + 1));
    let result = [];
    const arr = [...map.entries()].sort((a,b) => b[1] - a[1]);
    for (let i = 0; i < k; i++) {
        result.push(arr[i][0]);
    }
    return result;
};

console.log(topKFrequent([1,1,1,2,2,3], 2));