/**
 * @param {number[]} arr
 * @return {number}
 */
var findSpecialInteger = function(arr) {
    const numberAndCount = {};

    for (const num of arr) {
        if (numberAndCount[num]) {
            numberAndCount[num] += 1;
        }
        else {
            numberAndCount[num] = 1;
        }

        if (numberAndCount[num] > (arr.length / 4)) {
            return num;
        }
    }

    return -1;
};
