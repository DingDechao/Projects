package org.example.hkex;

public class Maze {

    //迷宫问题，给定一个二维数组表示迷宫，0表示通路，1表示墙壁，找到从起点到终点的最短路径路径，用递归实现
    public static void main(String[] args) {
        int[][] maze = {
                {0, 1, 0, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 1, 0}
        };
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int startX = 0;
        int startY = 0;
        int endX = 4;
        int endY = 4;
        int pathLength = findShortestPath(maze, visited, startX, startY, endX, endY, 0);
        System.out.println("最短路径长度: " + pathLength);
    }

    public static int findShortestPath(int[][] maze, boolean[][] visited, int x, int y, int endX, int endY, int pathLength) {
        if (x < 0 || x >= maze.length || y < 0 || y >= maze[0].length || maze[x][y] == 1 || visited[x][y]) {
            return Integer.MAX_VALUE;
        }
        if (x == endX && y == endY) {
            return pathLength;
        }
        visited[x][y] = true;
        int up = findShortestPath(maze, visited, x - 1, y, endX, endY, pathLength + 1);
        int down = findShortestPath(maze, visited, x + 1, y, endX, endY, pathLength + 1);
        int left = findShortestPath(maze, visited, x, y - 1, endX, endY, pathLength + 1);
        int right = findShortestPath(maze, visited, x, y + 1, endX, endY, pathLength + 1);
        visited[x][y] = false;
        return Math.min(Math.min(up, down), Math.min(left, right));
    }
}
