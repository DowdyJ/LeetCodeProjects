

function containsDuplicate(nums: number[]): boolean {
    let seenNumbers : Set<number> = new Set<number>();

    for (const num of nums) {
        if (seenNumbers.has(num))
            return true;
        else 
            seenNumbers.add(num);
    }

    return false;
};