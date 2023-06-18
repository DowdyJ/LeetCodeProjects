const { clearInterval } = require("timers");


let id = -1;

/**
 * @param {Function} fn
 * @param {Array} args
 * @param {number} t
 * @return {Function}
 */
var cancellable = function(fn, args, t) {
    fn(...args);
    id = setInterval(() => {fn(...args);}, t);
    return () => {clearInterval(id);}
};
