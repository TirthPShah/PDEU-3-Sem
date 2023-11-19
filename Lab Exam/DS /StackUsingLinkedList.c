#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <limits.h>

struct Node {
    int data;
    struct Node* prev;
};

struct Stack {
    struct Node* top;
};

struct Node* createNode(int data) {

    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode -> data = data;
    newNode -> prev = NULL;

    return newNode;

}

void createStack(struct Stack* stack) {
    stack -> top = NULL;
}

bool isEmpty(struct Stack* stack) {
    return (stack -> top == NULL);
}

void push(struct Stack* stack, int data) {

    struct Node* newNode = createNode(data);
    
    newNode -> prev = stack -> top;
    stack -> top = newNode;

}

int peek(struct Stack* stack) {
    return ((stack -> top) -> data);
}

int pop(struct Stack* stack) {

    if(isEmpty(stack)) {
        printf("Stack is Empty. Stack Underflow.");
        return INT_MIN;
    }

    struct Node* temp = stack -> top;

    int data = temp -> data;
    stack -> top = temp -> prev;
    free(temp);

    return data;
}

void printStack(struct Stack* stack) {

    if(isEmpty(stack)) {
        printf("Stack is Empty. Stack Underflow.");
        return;
    }

    struct Node* curr = stack -> top;

    while(curr != NULL) {

        printf("%d ", curr -> data);
        curr = curr -> prev;

    }

    printf("\n");
}

int main() {

    struct Stack myStack;
    createStack(&myStack);

    push(&myStack, 10);
    push(&myStack, 20);

    printf("%d ", peek(&myStack));

    pop(&myStack);

    printf("\n");

    printf("%d ", peek(&myStack));

    printf("\n");

    push(&myStack, 30);
    push(&myStack, 40);

    printStack(&myStack);

    return 0;
}