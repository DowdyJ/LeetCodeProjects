#include <stdio.h>
#include <math.h>
#include <stdlib.h>


char getBucket(char index) {
    return index / 32;
}

char getBit(char index) {
    return index % 32;
}

void setKey(unsigned int* hashSet, char cityIndex) {
    hashSet[getBucket(cityIndex)] |= (unsigned int)pow(2, getBit(cityIndex));
}

unsigned int containsKey(unsigned int* hashSet, char cityIndex) {
    return hashSet[getBucket(cityIndex)] & (unsigned int)pow(2, getBit(cityIndex));
}

void DFS(char cityIndex, int** isConnected, int* set, int isConnectedLength) {
    if (containsKey(set, cityIndex)) {
        return;
    }

    setKey(set, cityIndex);

    for (char i = 0; i < isConnectedLength; ++i) {
        if (isConnected[cityIndex][i])
            DFS(i, isConnected, set, isConnectedLength);
    }

    return;
}


int findCircleNum(int** isConnected, int isConnectedSize, int* isConnectedColSize){
    unsigned int* set = calloc(((isConnectedSize / 32) + 1), sizeof(unsigned int));
    int result = 0;

    for (char i = 0; i < isConnectedSize; ++i) {
        if (!containsKey(set, i)) {
            ++result;
        }

        DFS(i, isConnected, set, isConnectedSize);
    }
    
    return result;
}



int main() {

}

