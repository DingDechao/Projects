package com.ddc.algorithm.maze;

public class MazeBasic {
    // 给定2个参数, N, M 生成 N行M列的迷宫
    // 给定两个点,一个起点(startX,startY),一个终点(endX, endY),求出从起点到终点的最短路径
    public static void main(String[] args) {
        int N = 5;
        int M = 5;
        int startX = 0;
        int startY = 0;
        int endX = 4;
        int endY = 4;

        // 生成迷宫
        int[][] maze = new int[N][M];
        int[][] visited = new int[N][M];

        System.out.println("Finding shortest path from (" + startX + "," + startY + ") to (" + endX + "," + endY + "):");
        System.out.println("最短路径是:" + findShortestPath(maze, visited, startX, startY, endX, endY, 0));
        System.out.println("最短路径是:" + findShortestPathDP(maze, startX, startY, endX, endY));
    }

    //递归实现
    public static int findShortestPath(int[][] maze, int[][] visited, int x, int y, int endX, int endY, int pathLength) {
        // 边界条件
        if (x < 0 || x >= maze.length || y < 0 || y >= maze[0].length || visited[x][y] == 1) {
            return Integer.MAX_VALUE;
        }
        // 到达终点
        if (x == endX && y == endY) {
            return pathLength;
        }

        // 标记为已访问
        visited[x][y] = 1;

        // 四个方向移动
        int up = findShortestPath(maze, visited, x - 1, y, endX, endY, pathLength + 1);
        int down = findShortestPath(maze, visited, x + 1, y, endX, endY, pathLength + 1);
        int left = findShortestPath(maze, visited, x, y - 1, endX, endY, pathLength + 1);
        int right = findShortestPath(maze, visited, x, y + 1, endX, endY, pathLength + 1);

        // 回溯，标记为未访问
        visited[x][y] = 0;

        // 返回最短路径长度
        return Math.min(Math.min(up, down), Math.min(left, right));

    }

    // 动态规划版本
    public static int findShortestPathDP(int[][] maze, int startX, int startY, int endX, int endY) {
        int N = maze.length;
        int M = maze[0].length;
        int[][] dp = new int[N][M];

        // 初始化dp数组
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[startX][startY] = 0;

        // 填充dp数组
        for (int i = startX; i <= endX; i++) {
            for (int j = startY; j <= endY; j++) {
                if (i > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                }
                if (j > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                }
            }
        }
        return dp[endX][endY];
    }

//    public static int findShortestPathBFS(int[][] maze, int startX, int startY, int endX, int endY) {
//        if (maze == null || maze.length == 0) return -1;
//        int N = maze.length, M = maze[0].length;
//        // 边界和障碍检查
//        if (startX < 0 || startX >= N || startY < 0 || startY >= M ||
//                endX < 0 || endX >= N || endY < 0 || endY >= M) {
//            return -1;
//        }
//        if (maze[startX][startY] == 1 || maze[endX][endY] == 1) return -1;
//        if (startX == endX && startY == endY) return 0;
//
//        boolean[][] visited = new boolean[N][M];
//        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
//        java.util.Queue<int[]> q = new java.util.LinkedList<>();
//        q.offer(new int[]{startX, startY, 0});
//        visited[startX][startY] = true;
//
//        while (!q.isEmpty()) {
//            int[] cur = q.poll();
//            int x = cur[0], y = cur[1], dist = cur[2];
//            for (int[] d : dirs) {
//                int nx = x + d[0], ny = y + d[1];
//                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
//                if (visited[nx][ny] || maze[nx][ny] == 1) continue;
//                if (nx == endX && ny == endY) return dist + 1;
//                visited[nx][ny] = true;
//                q.offer(new int[]{nx, ny, dist + 1});
//            }
//        }
//
//    }

}
