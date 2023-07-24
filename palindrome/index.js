/**
 * @param {string} s
 * @return {boolean}
 */
const isPalindrome = (s) => {
    let input = s.toLowerCase().replace(/[^a-z0-9]/gi, "");
    let left = 0; right = input.length - 1;
    while (left < right) {
        if (input[left] !== input[right]) {
            return false;
        }
        left++; right--;
    }
    return true;
};