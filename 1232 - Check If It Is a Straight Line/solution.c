
#include <stdbool.h>

bool checkStraightLine(int** coordinates, int coordinatesSize, int* coordinatesColSize){
    float denominator;
    denominator = (float)(coordinates[0][0] - coordinates[1][0]);

    if (denominator == 0) {
        const int baseX = coordinates[0][0];
        for (int i = 2; i < coordinatesSize; ++i) {
            if (baseX != coordinates[i][0]) {
                return false;
            }
        }

        return true;
    }


    const float slope = (float)(coordinates[0][1] - coordinates[1][1]) / denominator;
    const int baseX = coordinates[0][0];
    const int baseY = coordinates[0][1];

    for (int i = 2; i < coordinatesSize; ++i) {
        denominator = (float)(coordinates[i][0] - baseX);
        if ((float)((coordinates[i][1] - baseY) / denominator) != slope) {
            return false;
        }
    }

    return true;
}