/**
 * @param {number[]} height
 * @return {number}
 */
const trap = (height) => {
    if (height == null || height.length == 0) return 0;
    let i = 0, j = height.length - 1;
    let leftMax = 0, rightMax = 0, result = 0;

    while (i < j) {
        console.log(i, j);
        leftMax = Math.max(leftMax, height[i]);
        rightMax = Math.max(rightMax, height[j]);
        console.log(leftMax, rightMax);
        result += leftMax - height[i];
        result += rightMax - height[j];
        height[i] < height[j] ? i++ : j--;
    }
    return result;
};

console.log(trap([0,1,0,2,1,0,1,3,2,1,2,1]));