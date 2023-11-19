#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

struct graph {
    int matrix[100][100];
};

struct edge {
    int start, end;
};

struct graph* createGraph(struct edge edges[], int n, int numVertices) {

    struct graph* graph = (struct graph*)malloc(sizeof(struct graph));

    for (int i = 0; i <= numVertices; i++) {
        for (int j = 0; j <= numVertices; j++) {
            graph->matrix[i][j] = 0;
        }
    }

    for (int i = 0; i < n; i++) {
        int start = edges[i].start;
        int end = edges[i].end;

        graph->matrix[start][end] = 1;
    }

    return graph;
}

int main() {

    int start, end;
    int edgeCount = 0;
    int vertexCount = 0;

    struct edge* edges = NULL;

    printf("\n\n- - - - Enter edges (start and end vertex), and use a negative number to stop - - - -\n\n");

    edges = (struct edge*)malloc(sizeof(struct edge));

    while (1) {

        printf("Edge %d: ", edgeCount + 1);
        scanf("%d", &start);

        if (start < 0) {
            break;
        }

        else if (start > vertexCount) {
            vertexCount = start;
        }

        scanf("%d", &end);

        if (end < 0) {
            break;
        }

        else if (end > vertexCount) {
            vertexCount = end;
        }

        edges = (struct edge*)realloc(edges, (edgeCount + 1) * sizeof(struct edge));

        edges[edgeCount].start = start;
        edges[edgeCount].end = end;

        edgeCount++;
    }

    struct graph* graph = createGraph(edges, edgeCount, vertexCount);

    printf("\n\n- - - - Adjacency Matrix - - - -\n\n");

    for(int i = 0; i <= vertexCount; i++) {
        for(int j = 0; j <= vertexCount; j++) {
            printf("%d ", graph->matrix[i][j]);
        }
        printf("\n");
    }

    printf("\n\n- - - - Printing Edges - - - -\n\n");

    bool flag = false;

    for(int i = 0; i <= vertexCount; i++) {

        for(int j = 0; j <= vertexCount; j++) {
            if(graph->matrix[i][j] == 1) {
                printf("%d -> %d\t", i, j);
                flag = true;
            }
        }

        if(flag == true) {
            printf("\n");
            flag = false;
        }
    }

    return 0;
}