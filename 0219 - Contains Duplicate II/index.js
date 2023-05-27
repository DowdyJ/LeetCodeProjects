"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const assert_1 = __importDefault(require("assert"));
function containsNearbyDuplicate(nums, k) {
    let numberWindow = [];
    let duplicatesInRange = new Set();
    for (let i = 0; i < k; i++) {
        numberWindow.push(nums[i]);
        if (duplicatesInRange.has(nums[i]))
            return true;
        else
            duplicatesInRange.add(nums[i]);
    }
    for (let i = k; i < nums.length; i++) {
        if (duplicatesInRange.has(nums[i]))
            return true;
        else
            duplicatesInRange.add(nums[i]);
        duplicatesInRange.delete(numberWindow.shift());
        numberWindow.push(nums[i]);
    }
    return false;
}
;
(0, assert_1.default)(containsNearbyDuplicate([1, 2, 3, 1], 3));
(0, assert_1.default)(containsNearbyDuplicate([1, 0, 1, 1], 1));
(0, assert_1.default)(!containsNearbyDuplicate([1, 2, 3, 1, 2, 3], 2));
