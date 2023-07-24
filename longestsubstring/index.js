/**
 * @param {string} s
 * @return {number}
 */
const lengthOfLongestSubstring = (s) => {
    let set = new Set();
    let left = 0;
    let max = 0;

    for (let i = 0; i < s.length; i++) {
        // Check if already exists, clear set if yes
        while (set.has(s[i])) {
            set.delete(s[left]);
            left++;
        }
        set.add(s[i]);
        max = Math.max(max, i - left + 1);
    }
    return max;
};