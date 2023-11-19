#include <stdio.h>
#include <stdlib.h>

struct Node {
    
    int data;
    struct Node* left;
    struct Node* right;
    
};

struct Node* createNode(int data) {
    
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));

    newNode->data = data;
    newNode->left = NULL;
    newNode->right = NULL;

    return newNode;
}

struct Node* createTree() {

    struct Node* root = createNode(2);

    root->right = createNode(7);
    root->right->left = createNode(1);
    root->right->right = createNode(3);
    root->right->left->left = createNode(5);

    return root;
}

int sumOfElements(struct Node* root) {
    
    if(root == NULL) {
        return 0;
    }

    int sum = root -> data + sumOfElements(root -> left) + sumOfElements(root -> right);

    return sum;
}

int main() {

    struct Node* root = createTree();

    printf("Sum of elements: %d\n", sumOfElements(root));
    printf("\n");

    return 0;
}
