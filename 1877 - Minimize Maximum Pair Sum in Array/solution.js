/**
 * @param {number[]} nums
 * @return {number}
 */
var minPairSum = function(nums) {
    nums.sort((a,b) => a - b);
    let sums = []
    for (let i = 0; i < nums.length/2; ++i) {
        sums[i] = nums[i] + nums[nums.length - 1 - i];
    }

    return Math.max(...sums);
};

var minPairSumAlt = function(nums) {
    nums.sort((a,b) => a - b);
    let a = nums.slice(0, nums.length/2);
    let b = nums.slice(nums.length/2).reverse();
    a = a.map((val, idx) => val + b[idx]);
    return Math.max(...a);
};


console.log(minPairSum([9,2,10,1,10,4,8,9,7,6,8,10,8,6,5,4,3,4,2,10]));