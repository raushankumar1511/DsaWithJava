package Graphs.Implementation;

public class usingMatrix {
    public static void main(String[] args) {
        int n = 3;
        int m =3; // like triangle

        int[][] adj = new int[n+1][n+1];

        //1--2
        adj[1][2] =1;
        adj[2][1] =1;

        //1--3
        adj[1][3] =1;
        adj[3][1] =1;

        //2--3
        adj[2][3] =1;
        adj[3][2] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(adj[i][j] ==1){
                    System.out.println(i + " " + j);
                }

            }

        }



    }
}
