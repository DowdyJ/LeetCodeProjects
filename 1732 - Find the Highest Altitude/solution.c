
int largestAltitude(int* gain, int gainSize){
    int maxHeight = 0;
    int curHeight = 0;

    for (int i = 0; i < gainSize; ++i) {
        curHeight += gain[i];

        if (curHeight > maxHeight)
            maxHeight = curHeight;
    }

    return maxHeight;
}
