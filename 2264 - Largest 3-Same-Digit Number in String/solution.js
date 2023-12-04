/**
 * @param {string} num
 * @return {string}
 */
var largestGoodInteger = function(num) {
    
    const valsToCheck = ["999", "888", "777", "666", "555", "444", "333", "222", "111", "000"]

    for (const val of valsToCheck) {
        if (num.includes(val)) {
            return val;
        }
    }

    return "";
};
