/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
const isAnagram = function (s, t) {
    if (s.length !== t.length) return false;
    const counts = new Map();
    for (let i = 0; i < s.length; i++) {
        counts.set(s[i], (counts.get(s[i]) || 0) + 1);
    }
    for (let j = 0; j < t.length; j++) {
        let count = counts.get(t[j]);
        if (count === undefined || count === 0) return false;
        counts.set(t[j], count - 1);
    }
    return true;
};