int findNonMinOrMax(int* nums, int numsSize){
    if (numsSize < 3)
        return -1;

    int a = nums[0];
    int b = nums[1];
    int c = nums[2];

    if (a > b) {
        if (b > c)
            return b;
        else if (c > a)
            return a;
        else
            return c;
    }
    else {
        if (a > c)
            return a;
        else if (c > b)
            return b;
        else
            return c;
    }
}