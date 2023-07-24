/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
 const isIsomorphic = function(s, t) {
   if (s.length !== t.length) return false;
   let isoMapStoT = new Map();
   let isoMapTtoS = new Map();
   for(let i = 0; i < s.length; i++) {
    console.log(isoMapStoT.get(s[i]), t[i]);
        if (!isoMapStoT.has(s[i]) && !isoMapTtoS.has(t[i])) {
            isoMapStoT.set(s[i], t[i]);
            isoMapTtoS.set(t[i], s[i]);
        }
        else if (isoMapStoT.get(s[i]) !== t[i] || isoMapTtoS.get(t[i] !== s[i])) return false;
       
   }
   return true;
};

console.log(isIsomorphic('badc', 'baba'));