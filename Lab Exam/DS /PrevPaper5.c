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

    struct edge edges[] = {{1, 2}, {1, 3}, {3, 2}, {3, 4}, {4, 3}};

    edgeCount = sizeof(edges) / sizeof(edges[0]);

    vertexCount = 4;

    struct graph* graph = createGraph(edges, edgeCount, vertexCount);

    printf("\n\n- - - - Check whether there is an edge or not (Give -1 to stop) - - - -\n\n");

    while(1) {

        printf("Edge: ");
        scanf("%d", &start);

        if(start < 0) {
            break;
        }

        scanf("%d", &end);

        if(end < 0) {
            break;
        }

        if(graph->matrix[start][end] == 1) {
            printf("Yes\n\n");
        }

        else {
            printf("No\n\n");
        }

    }

    return 0;
}