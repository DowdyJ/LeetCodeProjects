import assert from "assert";

function containsNearbyDuplicate(nums: number[], k: number): boolean {
    if (k === 0)
        return false;

    let numberWindow : number[] = [];
    let duplicatesInRange : Set<number> = new Set<number>();

    for (let i = 0; i < k; i++) {
        if (nums[i] == null)
            break;

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
        
        duplicatesInRange.delete(numberWindow.shift() as number);
        numberWindow.push(nums[i]);
    }

    return false;
};



assert(containsNearbyDuplicate([1,2,3,1], 3));
assert(containsNearbyDuplicate([1,0,1,1], 1));
assert(!containsNearbyDuplicate([1,2,3,1,2,3], 2));