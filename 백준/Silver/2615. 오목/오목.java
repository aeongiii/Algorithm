import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 1}; 
    static int[] dy = {0, 1, 1, 1};
    static int result;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        map = new int[19][19];
        visited = new boolean[19][19];

        for (int i = 0; i < 19; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (map[i][j] != 0) {
                    for (int dir = 0; dir < 4; dir++) {
                        flag = false;
                        dfs(new Node(i, j, map[i][j]), 1, dir);

                        if (!flag) {
                            int nx = i - dx[dir];
                            int ny = j - dy[dir];
                            int color = map[i][j];

                            if (nx >= 0 && nx < 19 && ny >= 0 && ny < 19) {
                                if (map[nx][ny] == color) { 
                                    result = 0;
                                }
                            }

                            if (result != 0) {
                                System.out.println(result);
                                System.out.println((i + 1) + " " + (j + 1));
                                return;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(result);
    }

    static void dfs(Node node, int cnt, int direction) {
        if (cnt == 5) {
            int nx = node.x + dx[direction];
            int ny = node.y + dy[direction];
            int color = node.color;

            if (nx < 0 || nx >= 19 || ny < 0 || ny >= 19) {
                result = node.color;
                return;
            }


            if (map[nx][ny] != color) {
                result = node.color;
                return;
            }
        }

        int nx = node.x + dx[direction];
        int ny = node.y + dy[direction];
        int color = node.color;
        if (nx < 0 || nx >= 19 || ny < 0 || ny >= 19) return;
        if (map[nx][ny] != color) return;
        if (visited[nx][ny]) return;

        visited[nx][ny] = true;
        dfs(new Node(nx, ny, color), cnt + 1, direction);
        if (!flag) {
            visited[nx][ny] = false;
        }
    }
}

class Node {
    int x;
    int y;
    int color;

    Node (int x, int y, int color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }
}