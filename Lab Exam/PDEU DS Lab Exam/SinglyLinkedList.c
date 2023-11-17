#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node *next;
};

struct Node* createNode(int data) {

    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = data;
    newNode->next = NULL;

    return newNode;
}

struct Node* directCreateLinkedList(struct Node* head, int* length) {

    printf("- - - - Enter -1 to stop - - - -\n");

    int data;
    struct Node* newNode;

    while(1) {

        printf("Enter data: ");
        scanf("%d", &data);
        
        if(data == -1) {
            break;
        }

        newNode = createNode(data);

        if(head == NULL) {
            head = newNode;
            (*length)++;
        } 
        
        else {
            
            struct Node* temp = head;
            
            while(temp->next != NULL) {
                temp = temp->next;
            }

            temp->next = newNode;

            (*length)++;
        }
    }

    return head;
}

void printLinkedList(struct Node* head) {

    struct Node* temp = head;

    while(temp != NULL) {
        printf("%d ", temp->data);
        temp = temp->next;
    }

    printf("\n");
}

struct Node* insertAtPosition(struct Node* head, int data, int position, int* length) {

    struct Node* newNode = createNode(data);

    struct Node* currPtr = head;

    if(position == 0) {
        newNode->next = head;
        head = newNode;
        
        (*length)++;

        return head;
    }

    else if (position > *length) {
        
        printf("Invalid position. Returning old list.\n");
        return head;

    }

    for(int i = 0; i < position - 1; i++) {
        currPtr = currPtr->next;
    }

    newNode->next = currPtr->next;
    currPtr->next = newNode;

    (*length)++;

    return head;

}

struct Node* insertBeforeData(struct Node* head, int data, int beforeData, int* length) {

    struct Node* newNode = createNode(data);

    struct Node* currPtr = head;
    struct Node* prevPtr = NULL;

    if(head -> data == beforeData) {

        newNode->next = head;
        head = newNode;

        (*length)++;

        return head;
    }

    while(currPtr -> data != beforeData && currPtr != NULL) {

        prevPtr = currPtr;
        currPtr = currPtr->next;

    }

    if(currPtr == NULL) {
        printf("Data not found. Returning old list.\n");
        return head;
    }

    prevPtr->next = newNode;
    newNode->next = currPtr;

    (*length)++;

    return head;
}

struct Node* insertAfterData(struct Node* head, int data, int afterData, int* length) {

    struct Node* newNode = createNode(data);

    struct Node* currPtr = head;

    while(currPtr->data != afterData && currPtr != NULL) {
        currPtr = currPtr->next;
    }

    if(currPtr == NULL) {
        printf("Data not found. Returning old list.\n");
        return head;
    }

    newNode->next = currPtr->next;
    currPtr->next = newNode;

    (*length)++;

    return head;
}

struct Node* deleteAtPosition(struct Node* head, int position, int* length) {

    struct Node* currPtr = head;
    struct Node* prevPtr = NULL;
    
    if(position == 0) {

        head = head -> next;
        free(currPtr);

        (*length)--;

        return head;
    }

    else if (position >= *length) {
            
        printf("Invalid position. Returning old list.\n");
        return head;

    }

    for(int i = 0; i < position; i++) {

        prevPtr = currPtr;
        currPtr = currPtr->next;

    }

    prevPtr->next = currPtr->next;
    free(currPtr);

    (*length)--;

    return head;
}

struct Node* deleteAfterData(struct Node* head, int afterData, int* length) {

    struct Node* currPtr = head;
    struct Node* prevPtr = currPtr;

    while(prevPtr->data != afterData && currPtr != NULL) {

        prevPtr = currPtr;
        currPtr = currPtr->next;

    }

    if(currPtr == NULL && prevPtr->data != afterData) {
        printf("Data not found. Returning old list.\n");
        return head;
    }

    else if (currPtr == NULL && prevPtr->data == afterData) {
        printf("No data after %d. Returning old list.\n", afterData);
        return head;
    }

    prevPtr->next = currPtr->next;
    free(currPtr);

    (*length)--;

    return head;
}

struct Node* deleteBeforeData(struct Node* head, int beforeData, int* length) {

    if(head -> data == beforeData) {
        printf("No data before %d. Returning old list.\n", beforeData);
        return head;
    }

    else if (head -> next -> data == beforeData)
    {
        head = head -> next;

        (*length)--;

        return head;
    }
    

    struct Node* currPtr = head;
    struct Node* prevPtr;
    struct Node* prevToPrevPtr;

    while(currPtr->data != beforeData && currPtr != NULL) {

        prevToPrevPtr = prevPtr;
        prevPtr = currPtr;
        currPtr = currPtr->next;

    }

    if(currPtr == NULL) {
        printf("Data not found. Returning old list.\n");
        return head;
    }

    else if (prevToPrevPtr == NULL) {
        printf("No data before %d. Returning old list.\n", beforeData);
        return head;
    }

    prevToPrevPtr->next = currPtr;

    free(prevPtr);

    (*length)--;

    return head;
}

struct Node* sortLinkedList(struct Node* head) {

    struct Node* currPtr = head;
    struct Node* nextPtr = currPtr->next;

    int temp;

    while(currPtr != NULL) {

        nextPtr = currPtr->next;

        while(nextPtr != NULL) {

            if(currPtr->data > nextPtr->data) {

                temp = currPtr->data;
                currPtr->data = nextPtr->data;
                nextPtr->data = temp;

            }

            nextPtr = nextPtr->next;

        }

        currPtr = currPtr->next;

    }

    return head;
}

struct Node* recursiveReverseLinkedList(struct Node* head) {

    if(head == NULL || head->next == NULL) {
        return head;
    }

    struct Node* rest = recursiveReverseLinkedList(head->next);

    head->next->next = head;
    head->next = NULL;

    return rest;
}

struct Node* reverseLinkedList(struct Node* head) {

    struct Node* prev = NULL;
    struct Node* curr = head;
    struct Node* forw;

    if(head == NULL || head -> next == NULL) {
        return head;
    }

    while (curr != NULL) {

        forw = curr -> next;
        curr -> next = prev;
        prev = curr;
        curr = forw;

    }

    return prev;
}

int main() {

    struct Node* head = NULL;

    int length = 0;

    printf("- - - - Creating List - - - -\n");
    head = directCreateLinkedList(head, &length);

    printf("- - - - Generated List - - - -\n");
    printLinkedList(head);
    printf("Length: %d\n", length);

    printf("- - - - Inserting 20 at last position - - - -\n");
    head = insertAtPosition(head, 20, length, &length);

    printLinkedList(head);
    printf("Length: %d\n", length);

    printf("- - - - Inserting 30 before 20 - - - -\n");
    head = insertBeforeData(head, 30, 20, &length);

    printLinkedList(head);
    printf("Length: %d\n", length);

    printf("- - - - Inserting 40 after 30 - - - -\n");
    head = insertAfterData(head, 40, 30, &length);

    printLinkedList(head);
    printf("Length: %d\n", length);

    printf("- - - - Deleting last element - - - -\n");
    head = deleteAtPosition(head, length-1, &length);

    printLinkedList(head);
    printf("Length: %d\n", length);

    printf("- - - - Deleting after 40 - - - -\n");
    head = deleteAfterData(head, 40, &length);

    printLinkedList(head);
    printf("Length: %d\n", length);

    printf("- - - - Deleting before 4 - - - -\n");
    head = deleteBeforeData(head, 4, &length);

    printLinkedList(head);
    printf("Length: %d\n", length);

    printf("- - - - Sorting List - - - -\n");

    head = sortLinkedList(head);

    printLinkedList(head);
    printf("Length: %d\n", length);

    printf("- - - - Reversing List - - - -\n");

    struct Node* rev = reverseLinkedList(head);

    printLinkedList(rev);

    return 0;
}