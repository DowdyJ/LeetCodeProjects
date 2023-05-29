function trap(heightMap: number[]): number {

    let currentInspectLevel : number = 0;
    let currentXLeftBound : number = 0;
    let currentXRightBound : number = 0;

    let waterBlocks : number = 0;

    let maxIndex = getMaxHeightIndex(heightMap);

    return waterBlocks;
};

function getMaxHeightIndex(heightArray : number[]) {
    let maxIndex : number = -1;

    for (let i = 0; i < heightArray.length; ++i) {
        if (heightArray[i] > heightArray[maxIndex])
            maxIndex = i;
    }

    return maxIndex;
}


console.log(`The answer is ${trap([1, 2, 3, 4, 3, 2, 1])}`);