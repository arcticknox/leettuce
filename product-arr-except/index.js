/**
 * @param {number[]} nums
 * @return {number[]}
 */
const productExceptSelf = (nums) => {
   let leftProduct = 1;
   let rightProduct = 1;
   let result = [];

   for (let i = nums.length - 1; i >= 0; i--) {
    result[i] = rightProduct;
    console.log(result);
    rightProduct *= nums[i];
   }
   
   for (let j = 0; j < nums.length; j++) {
    result[j] *= leftProduct;
    leftProduct *= nums[j];
   }
   return result;
};

console.log(productExceptSelf([1,2,3,4]));