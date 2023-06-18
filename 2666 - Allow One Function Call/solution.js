/**
 * @param {Function} fn
 * @return {Function}
 */

var once = function(fn) {
    let ran = false;
    return function(...args){
        if (ran)
            return undefined;
        ran = true;
        
        return fn(...args);
    }
};
