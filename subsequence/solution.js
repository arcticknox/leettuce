/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
 const isSubsequence = function(s, t) {
    let i = 0; let j = 0;
    while (s.length > i && t.length > j) {
        if (s[i] === t[j]) {
            i++;
        }
        j++;
    }
    if (s.length === i) return true
    return false;
};

console.log(isSubsequence('abc', 'ahbgdc'));