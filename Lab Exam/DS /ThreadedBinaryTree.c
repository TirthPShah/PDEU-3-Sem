#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

struct Node {
    int info;
    struct Node* left;
    struct Node* right;
    bool leftThread;
    bool rightThread;
};

struct Node* insert(struct Node* root, int ikey) {

    struct Node* ptr = root;
    struct Node* par = NULL;

    while( ptr != NULL) {

        if(ikey == (ptr -> info)) {
            printf("Duplicate Key !\n");
            return root;
        }

        par = ptr;

        if(ikey < ptr -> info) {

            if(ptr -> leftThread == false) {
                ptr = ptr -> left;
            }

            else {
                break;
            }
        }

        else {

            if(ptr -> rightThread == false) {
                ptr = ptr -> right;
            }

            else {
                break;
            }
        }
    }

    struct Node* tmp = (struct Node*)malloc(sizeof(struct Node));
    tmp -> info = ikey;
    tmp -> leftThread = true;
    tmp -> rightThread = true;

    if(par == NULL) {
        root = tmp;
        tmp -> left = NULL;
        tmp -> right = NULL;
    }

    else if(ikey < (par -> info)) {

        tmp -> left = par -> left;
        tmp -> right = par;
        par -> leftThread = false;
        par -> left = tmp;
    }

    else {

        tmp -> left = par;
        tmp -> right = par -> right;
        par -> rightThread = false;
        par -> right = tmp;
    }

    return root;
}

struct Node* inOrderSuccessor(struct Node* ptr) {

    if(ptr -> rightThread == true) {
        return ptr -> right;
    }

    ptr = ptr -> right;

    while(ptr -> leftThread == false) {
        ptr = ptr -> left;
    }

    return ptr;
}

void inOrder(struct Node* root) {

    if(root == NULL) {
        printf("Tree is empty !\n");
        return ;
    }

    struct Node* ptr = root;

    while(ptr -> leftThread == false) {
        ptr = ptr -> left;
    }

    while(ptr != NULL) {

        printf("%d ", ptr -> info);
        ptr = inOrderSuccessor(ptr);
    }
}

int main() {
    
    struct Node* root = NULL;

    printf("- - - - Inserting Data, Give -1 to stop - - - -\n");

    while(1) {
        printf("Enter Data: ");

        int data;
        scanf("%d", &data);

        if(data == -1) {
            break;
        }

        root = insert(root, data);
    }

    inOrder(root);
    printf("\n");

    return 0;

}