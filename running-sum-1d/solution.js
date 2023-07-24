const runningSum = (nums) => {
    let sums = [];
    const final = nums.map((item, index) => {
        if (index === 0) {
            sums.push(item);
            return item;
        }
        console.log(item, sums[index - 1])
        const sum = item + sums[index - 1];
        console.log(sum);
        sums.push(sum);
        return sum;
    })
    return final;
}

console.log(runningSum([1,2,3,4]));