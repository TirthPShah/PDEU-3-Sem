#include <stdio.h>
#include <stdlib.h>

#define MAX_SIZE 100

struct Stack {
    int array[MAX_SIZE];
    int top;
};

void initializeStack(struct Stack* stack) {
    stack->top = -1;
}

int isEmpty(struct Stack* stack) {
    return stack->top == -1;
}

int isFull(struct Stack* stack) {
    return stack->top == MAX_SIZE - 1;
}

void push(struct Stack* stack, int data) {
    if (isFull(stack)) {
        printf("Stack Overflow\n");
        return;
    }
    stack->array[++stack->top] = data;
}

int pop(struct Stack* stack) {
    if (isEmpty(stack)) {
        printf("Stack Underflow\n");
        exit(EXIT_FAILURE);
    }
    return stack->array[stack->top--];
}

int peek(struct Stack* stack) {
    if (isEmpty(stack)) {
        printf("Stack is empty\n");
        exit(EXIT_FAILURE);
    }
    return stack->array[stack->top];
}

void printStack(struct Stack* stack) {
    if (isEmpty(stack)) {
        printf("Stack is empty\n");
        return;
    }
    for (int i = 0; i <= stack->top; ++i) {
        printf("%d ", stack->array[i]);
    }
    printf("\n");
}

void deleteMiddleElement(struct Stack* stack) {
    
    int size = stack->top + 1;
    int middle = size / 2;

    for (int i = middle; i < stack -> top; i++) {
        stack -> array[i] = stack -> array[i + 1];
    }

    stack -> top--;
}

int main() {
    struct Stack myStack;
    initializeStack(&myStack);

    push(&myStack, 1);
    push(&myStack, 2);
    push(&myStack, 3);
    push(&myStack, 4);
    push(&myStack, 5);

    printf("Original Stack: ");
    printStack(&myStack);

    deleteMiddleElement(&myStack);

    printf("Stack after deleting middle element: ");
    printStack(&myStack);

    return 0;
}
