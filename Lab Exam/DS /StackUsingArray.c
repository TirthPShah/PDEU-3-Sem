#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <limits.h>

struct Stack {
    int capacity;
    int* array;
    int top;
};

struct Stack* createStack(int capacity) {

    struct Stack* stack = (struct Stack*)malloc(sizeof(struct Stack));

    stack -> capacity = capacity;
    stack -> top = -1;
    
    stack -> array = (int*)malloc(sizeof(capacity * sizeof(int)));

    return stack;
}

bool isFull(struct Stack* stack) {
    return stack -> top == stack -> capacity - 1;
}

bool isEmpty(struct Stack* stack) {
    return stack -> top == -1;
}

void push(struct Stack* stack, int data) {

    if(isFull(stack)) {
        printf("Stack Overflow\n");
        return;
    }

    stack -> array [++stack -> top] = data;
    printf("%d pushed to stack\n", data);

}

int pop(struct Stack* stack) {
    
    if(isEmpty(stack)) {
    
        printf("Stack Underflow\n");
        return INT_MIN;
    }

    return (stack -> array [stack -> top--]);
}

int peek (struct Stack* stack) {

    if(isEmpty(stack)) {
        printf("Stack Underflow\n");
        return INT_MIN;
    }

    return (stack -> array [stack -> top]);
}

void printStack(struct Stack* stack) {

    if(isEmpty(stack)) {
        printf("Stack Underflow\n");
        return;
    }

    for(int i = stack -> top; i >= 0; i--) {
        printf("%d ", stack -> array [i]);
    }

    printf("\n");
}

int main() {

    struct Stack* stack = createStack(100);

    push(stack, 10);
    push(stack, 20);
    push(stack, 30);

    printStack(stack);

    printf("%d popped from stack\n", pop(stack));

    printStack(stack);

    printf("%d peeked from stack\n", peek(stack));

    printStack(stack);

    push(stack, 40);
    push(stack, 50);

    printStack(stack);

    return 0;
}