#include <stdbool.h>
#include <stdlib.h>

struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
};

bool areIdentical(struct TreeNode *restrict const left, struct TreeNode *restrict const right)
{
    if (left == NULL && right == NULL)
        return true;
    else if (left == NULL || right == NULL || left->val != right->val)
        return false;

    return areIdentical(left->left, right->right) && areIdentical(left->right, right->left);
}

bool isSymmetric(struct TreeNode *root)
{
    struct TreeNode *left = root->left;
    struct TreeNode *right = root->right;

    return areIdentical(left, right);
}
