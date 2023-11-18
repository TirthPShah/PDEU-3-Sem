void iterativePostOrder(struct Node* root) {

//     struct Node* curr = root;
//     struct Node* parStack[50];
//     int top = -1;
//     struct Node* lastVisited = NULL;

//     while (curr != NULL || top != -1) {

//         while (curr != NULL) {
//             parStack[++top] = curr;
//             curr = curr->left;
//         }

//         struct Node* temp = parStack[top]->right;

//         if (temp == NULL || temp == lastVisited) {
//             curr = parStack[top--];
//             printf("%d ", curr->data);
//             lastVisited = curr;
//         } else {
//             curr = temp;
//         }
//     }
// }