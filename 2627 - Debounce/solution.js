/**
 * @param {Function} fn
 * @param {number} t milliseconds
 * @return {Function}
 */
let waiting = false;
let id = -1;

var debounce = function(fn, t) {
    return function(...args) {
        if (id != -1)
            clearTimeout(id);

        id = setTimeout(() => {
            id = -1;
            fn(...args);
        }, t);
    }
};