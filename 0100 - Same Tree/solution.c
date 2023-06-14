#include <stdbool.h>
#include <stdlib.h>

struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
};

extern inline bool isMatchingDFS(struct TreeNode* restrict left, struct TreeNode* restrict right) {
    
    if (left == NULL && right == NULL) {
        return true;
    } 
    else if (left == NULL || right == NULL || left->val != right->val) {
        return false;
    }

    return isMatchingDFS(left->left, right->left) && isMatchingDFS(left->right, right->right);
}


bool isSameTree(struct TreeNode* p, struct TreeNode* q) {
    return isMatchingDFS(p, q);
}

int main() {
    return 0;
}
