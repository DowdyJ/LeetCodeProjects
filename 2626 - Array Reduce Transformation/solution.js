/**
 * @param {number[]} nums
 * @param {Function} fn
 * @param {number} init
 * @return {number}
 */
var reduce = function(nums, fn, init) {
    let accumulatedVal = init

    for (const num of nums) {
        accumulatedVal = fn(accumulatedVal, num);
    }

    return accumulatedVal;
};