#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

struct graph {
    struct vertex* point[100];
};

struct vertex {
    int end;
    struct vertex* next;
};

struct edge {
    int end, start;
};

struct graph* createGraph(struct edge edges[], int n, int numVertices) {

    struct graph* graph = (struct graph*)malloc(sizeof(struct graph));

    for (int i = 0; i <= numVertices; i++) {
        graph->point[i] = NULL;
    }

    for (int i = 0; i < n; i++) {
        int start = edges[i].start;
        int end = edges[i].end;

        struct vertex* v = (struct vertex*)malloc(sizeof(struct vertex));

        v->end = end;
        v->next = graph->point[start];
        graph->point[start] = v;
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

    printf("\nAdjacency List:\n\n");

    bool hasEdges;

    for (int i = 0; i <= vertexCount; i++) {

        struct vertex* ptr = graph->point[i];

        hasEdges = (ptr != NULL);

        while (ptr != NULL) {
            printf("%d -> %d \t", i, ptr->end);
            ptr = ptr->next;
        }

        if(hasEdges) {
            printf("\n");
        }
    }

    free(edges);

    return 0;
}