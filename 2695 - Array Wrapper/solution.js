/**
 * @param {number[]} nums
 */
var ArrayWrapper = function(nums) {
    this.nums = nums;
};

ArrayWrapper.prototype.valueOf = function() {
    if (this.nums.length == 0)
        return 0;

    return this.nums.reduce((accumulator, curVal) => accumulator += curVal);
}

ArrayWrapper.prototype.toString = function() {
    return "["+ this.nums.join() + "]";
}