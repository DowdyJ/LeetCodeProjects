/**
 * @param {Function} fn
 * @param {Array} args
 * @param {number} t
 * @return {Function}
 */
let id = -1;
var cancellable = function(fn, args, t) {
    id = setTimeout(() => {fn(...args);}, t);
    return () => {clearInterval(id);}
};