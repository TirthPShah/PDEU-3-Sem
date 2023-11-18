#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

struct Node {
    
    int data;
    struct Node* left;
    struct Node* right;
};

struct QueueNode {
    struct Node* data;
    struct QueueNode* next;
};

// Structure for a queue
struct Queue {
    struct QueueNode* front;
    struct QueueNode* rear;
};


struct Node* createNode(int data) {
    
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = data;
    newNode->left = NULL;
    newNode->right = NULL;
    
    return newNode;
}

struct QueueNode* createQueueNode(struct Node* data) {
    struct QueueNode* newNode = (struct QueueNode*)malloc(sizeof(struct QueueNode));
    newNode->data = data;
    newNode->next = NULL;
    return newNode;
}

// Function to create an empty queue
struct Queue* createQueue() {
    struct Queue* queue = (struct Queue*)malloc(sizeof(struct Queue));
    queue->front = queue->rear = NULL;
    return queue;
}

// Function to check if the queue is empty
int isEmpty(struct Queue* queue) {
    return (queue->front == NULL);
}

// Function to enqueue a tree node
void enqueue(struct Queue* queue, struct Node* data) {
    struct QueueNode* newNode = createQueueNode(data);
    if (isEmpty(queue)) {
        queue->front = queue->rear = newNode;
    } else {
        queue->rear->next = newNode;
        queue->rear = newNode;
    }
}

// Function to dequeue a tree node
struct Node* dequeue(struct Queue* queue) {
    if (isEmpty(queue)) {
        return NULL;
    } else {
        struct QueueNode* temp = queue->front;
        struct Node* data = temp->data;
        queue->front = temp->next;
        free(temp);
        return data;
    }
}

// Function to perform breadth-first traversal (BFS) on a binary search tree (BST)
void breadthFirstTraversal(struct Node* root) {
    if (root == NULL) {
        return;
    }

    // Create an empty queue
    struct Queue* queue = createQueue();

    // Enqueue the root node
    enqueue(queue, root);

    // Perform BFS
    while (!isEmpty(queue)) {
        struct Node* current = dequeue(queue);
        printf("%d ", current->data);

        // Enqueue the left child if exists
        if (current->left != NULL) {
            enqueue(queue, current->left);
        }

        // Enqueue the right child if exists
        if (current->right != NULL) {
            enqueue(queue, current->right);
        }
    }

    // Free the queue memory
    free(queue);
}

struct Node* recursiveInsert(struct Node* root, int data) {

    if(root == NULL) {
        root = createNode(data);
    }

    else if (data < root -> data) {
        root -> left = recursiveInsert(root -> left, data);
    }

    else {
        root -> right = recursiveInsert(root -> right, data);
    }

    return root;
}

void recursivePreOrder(struct Node* root) {

    if(root == NULL) {
        return ;
    }

    printf("%d ", root -> data);
    recursivePreOrder(root -> left);
    recursivePreOrder(root -> right);

}

void recursiveInOrder(struct Node* root) {

    if(root == NULL) {
        return ;
    }

    recursiveInOrder(root -> left);
    printf("%d ", root -> data);
    recursiveInOrder(root -> right);

}

void recursivePostOrder(struct Node* root) {

    if(root == NULL) {
        return ;
    }

    recursivePostOrder(root -> left);
    recursivePostOrder(root -> right);
    printf("%d ", root -> data);

}

struct Node* recursiveSearchReturningNode(struct Node* root, int data) {

    if(root == NULL || root -> data == data) {
        return root;
    }

    if(data < root -> data) {
        return recursiveSearchReturningNode(root -> left, data);
    }

    else {
        return recursiveSearchReturningNode(root -> right, data);
    }

}

bool recursiveSearch(struct Node* root, int data) {

    if(root == NULL) {
        return false;
    }

    if(root -> data == data) {
        return true;
    }

    if(data < root -> data) {
        return recursiveSearch(root -> left, data);
    }

    else {
        return recursiveSearch(root -> right, data);
    }

}

struct Node* recursiveFindMin(struct Node* root) {

    if(root == NULL || root -> left == NULL) {
        return root;
    }

    else {
        return recursiveFindMin(root -> left);
    }

}

struct Node* recursiveFindMax(struct Node* root) {

    if(root == NULL || root -> right == NULL) {
        return root;
    }

    else {
        return recursiveFindMax(root -> right);
    }

}

struct Node* recursiveDelete(struct Node* root, int data) {

    struct Node* temp;

    if(root == NULL) {

        printf("Element not found\n");

        return root;
    }

    if(root -> data == data) {

        if(root -> left == NULL && root -> right == NULL) {
            
            free(root);
            root = NULL;

            return root;
        }

        else if (root -> left == NULL && root -> right != NULL) {
            
            temp = root -> right;
            free(root);

            return temp;
        }

        else if (root -> left != NULL && root -> right == NULL) {

            temp = root -> left;
            free(root);

            return temp;
        }

        else {

            int minFromRight = recursiveFindMin(root -> right) -> data;                         //Alternatively, int maxFromLeft = recursiveFindMax(root -> left) -> data;

            root -> data = minFromRight;                                                        //Alternatively, root -> data = maxFromLeft;

            root -> right = recursiveDelete(root -> right, minFromRight);                       //Alternatively, root -> left = recursiveDelete(root -> left, maxFromLeft);

            return root;
        }

    }

    else if (data < root -> data) {
        root -> left = recursiveDelete(root -> left, data);
    }

    else {
        root -> right = recursiveDelete(root -> right, data);
    }

    return root;
}

bool iterativeSearch(struct Node* root, int data) {

    struct Node* temp = root;

    while(temp != NULL) {

        if(temp -> data == data) {
            return true;
        }

        else if(data < temp -> data) {
            temp = temp -> left;
        }

        else {
            temp = temp -> right;
        }

    }

    return false;

}

struct Node* iterativeInsert(struct Node* root, int data) {

    struct Node* newNode = createNode(data);
    struct Node* currPtr = root;
    struct Node* parPtr = NULL;

    while(currPtr != NULL) {

        parPtr = currPtr;

        if(data < currPtr -> data) {
            currPtr = currPtr -> left;
        }

        else { 
            currPtr = currPtr -> right;
        }

    }

    if(parPtr == NULL) {
        root = newNode;
    }

    else if(data < parPtr -> data) {
        parPtr -> left = newNode;
    }

    else {
        parPtr -> right = newNode;
    }

    return root;
}

struct Node* iterativeFindMin(struct Node* root) {

    struct Node* temp = root;

    while(temp != NULL && temp -> left != NULL) {
        temp = temp -> left;
    }

    return temp;

}

struct Node* iterativeFindMax(struct Node* root) {

    struct Node* temp = root;

    while(temp != NULL && temp -> right != NULL) {
        temp = temp -> right;
    }

    return temp;

}

void iterativeInOrder(struct Node* root) {

    struct Node* curr = root;
    struct Node* parStack[50];
    int top = -1;

    while(curr != NULL || top != -1) {

        while (curr != NULL) {
            parStack[++top] = curr;
            curr = curr -> left;
        }

        curr = parStack[top--];

        printf("%d ", curr -> data);

        curr = curr -> right;
    }
}

void iterativePreOrder(struct Node* root) {

    struct Node* curr = root;
    struct Node* parStack[50];
    int top = -1;

    while(curr != NULL || top != -1) {

        while (curr != NULL) {
            printf("%d ", curr -> data);
            parStack[++top] = curr;
            curr = curr -> left;
        }

        curr = parStack[top--];

        curr = curr -> right;
    }
}

int main() {

    struct Node* root = NULL;
    int data;

    printf("- - - - Enter -1 to stop inserting - - - -\n");

    while(1) {

        printf("Enter the data: ");
        scanf("%d", &data);

        if(data == -1) {
            break;
        }

        root = iterativeInsert(root, data);
    }

    printf("PreOrder: ");
    recursivePreOrder(root);
    printf("\n");

    printf("InOrder: ");
    recursiveInOrder(root);
    printf("\n");

    printf("PostOrder: ");
    recursivePostOrder(root);
    printf("\n");

    printf("Breadth First Traversal: ");

    breadthFirstTraversal(root);
    printf("\n");

    printf("Enter the data to search: ");
    scanf("%d", &data);

    if(recursiveSearch(root, data)) {
        printf("Found\n");
    }

    else {
        printf("Not Found\n");
    }

    printf("Enter the data to delete: ");
    scanf("%d", &data);

    root = recursiveDelete(root, data);

    printf("InOrder: ");
    iterativeInOrder(root);
    printf("\n");

    printf("PreOrder: ");
    iterativePreOrder(root);
    printf("\n");

    printf("PostOrder: ");
    recursivePostOrder(root);
    printf("\n");

    return 0;

}
