/**
 * @param {number[]} temperatures
 * @return {number[]}
 */
const dailyTemperatures = function(temperatures) {
    const stack = [];
    let answer = [];
    for (let i = 0; i < temperatures.length; i++) {
        while (stack.length && temperatures[stack[stack.length - 1]] < temperatures[i]) {
            const prevDay = stack.pop();
            answer[prevDay] = i - prevDay;
        }
        stack.push(i);
    }
    return answer;
};

console.log(dailyTemperatures([73,74,75,71,69,72,76,73]));