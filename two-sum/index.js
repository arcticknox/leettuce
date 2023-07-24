/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 * target = x + current;
 * x = target - current;
 * Create a hashmap { Current: index }
 * Iterate through the array and check the map has x
 * If x is in the map, return the index of x and the current index
 */

const twoSum = (nums, target) => {
	const sumMap = new Map();
	for (let i = 0; i < nums.length; i++) {
		const x = target - nums[i];
		if (sumMap.has(x)) {
			return [sumMap.get(x), i];
		}
		sumMap.set(nums[i], i);
	}
};

const findSum = (nums, target) => {
	nums.sort((a, b) => a - b);
	let i = 0;
	let j = nums.length - 1;
	const result = [];

	while (i !== j) {
		let sum = nums[i] + nums[j];

		if (sum < target) {
			i++;
		} else if (sum > target) {
			j--;
		} else {
			result.push(nums[i]);
			result.push(nums[j]);
			return result;
		}

	} 
	return false;
}

// console.log(twoSum([2, 7, 11, 15], 9));
console.log(findSum([2, 7, 11, 15], 9));
