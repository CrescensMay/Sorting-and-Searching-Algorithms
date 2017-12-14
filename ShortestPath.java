package design.classes;

public class ShortestPath {

    private static final int vertices = 7;
    private static final int infinite = Integer.MAX_VALUE;

    private int minDistance(int[] distance, boolean[] sptSet){// creating a shortest path tree set
        int min = infinite;
        int min_index = -1;

        for (int vertex = 0; vertex < vertices; vertex++){
            if(!sptSet[vertex] && distance[vertex] <= min){
               min = distance[vertex];
               min_index = vertex;
            }
        }
        return min_index;
    }

    private void displayPath(int[] parent, int j){
        if (parent[j] == -1){
            return;
        }
        displayPath(parent, parent[j]);
        System.out.print("\t" + j);
    }

    private void display(int[] distance, int n, int[] parent){
        char vertex = 'A';
        System.out.println("\n Vertex \t Distance\t\tPath");
        System.out.println("------------------------------------");
        for (int i = 0; i < vertices; i++){
            System.out.printf("\n A -> %c \t\t %d\t\t\t0 ", vertex++, distance[i]);
            displayPath(parent, i);
        }
    }

    //Algorithm Here
    private void dijkstra(int[][] graph){
        int[] distance = new int[vertices];//maintient spd de la src a i
        boolean[] sptSet =  new boolean[vertices];//vrai si le vertex est inclu
        int[] parent = new int[vertices];
        //remettre tout inf
        for (int i = 0; i < vertices; i++){
            parent[0] = -1;
            distance[i] = infinite;
            sptSet[i] = false;
        }
        distance[0] = 0;//placer la source a l'origine de lui meme tjrs 0

        for (int count = 0; count < vertices; count++){
            int u = minDistance(distance, sptSet);//choisir la dist min de la list des vertices,u tjrs src au debut
            sptSet[u] = true;//marquer le choisi comme processed
            char vertex = 'A';
            for (int v = 0; v < vertices; v++){//update dist de v
                if (!sptSet[v] && graph[u][v] != 0 &&
                        distance[u] != infinite &&
                        distance[u] + graph[u][v] < distance[v]){
                    parent[v] = u;
                    distance[v] = distance[u] + graph[u][v];
                }
//                System.out.println();
//                System.out.print("\t\tCHECKING INDEX: " + v + " ('" + vertex++ + "')\n");
//                display(distance, vertices, parent);
            }

        }
        display(distance, vertices, parent);

    }

    public static void main(String[] args) {
        int[][] graph = new int[][]{
                //     A  B  C  D  E  F  G
                /*A*/ {0, 4, 3, 0, 7, 0, 0},
                /*B*/ {4, 0, 6, 5, 0, 0, 0},
                /*C*/ {3, 6, 0, 11, 8, 0, 0},
                /*D*/ {0, 5, 11, 0, 2, 2, 10},
                /*E*/ {7, 0, 8, 2, 0, 0, 5},
                /*F*/ {0, 0, 0, 2, 0, 0, 3},
                /*G*/ {0, 0, 0, 10, 5, 3, 0}

        };
        ShortestPath shortestPath = new ShortestPath();
        long startTime = System.currentTimeMillis();
        System.out.println("\n\t\t\tWELCOME TO DIJKSTRA ALGORITHM");

        shortestPath.dijkstra(graph);

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        double totalTimeInSeconds = totalTime / 1000.0;

        System.out.println("\n\n\t\t\t\t\t\t\t LEGEND\n");
        System.out.println("\t\t\t\t\t\t\t 0 == A");
        System.out.println("\t\t\t\t\t\t\t 1 == B");
        System.out.println("\t\t\t\t\t\t\t 2 == C");
        System.out.println("\t\t\t\t\t\t\t 3 == D");
        System.out.println("\t\t\t\t\t\t\t 4 == E");
        System.out.println("\t\t\t\t\t\t\t 5 == F");
        System.out.println("\t\t\t\t\t\t\t 6 == G");
        System.out.println("\nTotal time: " + totalTimeInSeconds +"s");

    }

}
