package com.ddc.algorithm.astarsearch;

import java.util.ArrayList;
import java.util.List;

public class AStarSearch {

    // A*算法

    public static class Grid {
        public int x;
        public int y;
        public int g; // 从起点到当前节点的实际代价
        public int h; // 从当前节点到目标节点的估计代价, 不考虑障碍物
        public int f; // f = g + h
        public Grid parent; // 父节点

        public Grid(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void initGrid(Grid parent, Grid end) {
            this.parent = parent;
            if (parent != null) {
                this.g = parent.g + 1; // 假设每一步代价为1
            } else {
                this.g = 1;
            }
            this.h = Math.abs(end.x - this.x) + Math.abs(end.y - this.y); // 曼哈顿距离
            this.f = this.g + this.h;
        }
    }

    // 0表示可以走, 1表示障碍物
    public static final int[][] MAZE = {
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0}
    };


    public static Grid aStarSearch(Grid start, Grid end) {
        List<Grid> openList = new ArrayList<>();
        List<Grid> closeList = new ArrayList<>();

        start.initGrid(null, end);
        openList.add(start);

        while (!openList.isEmpty()) {
            Grid current = findMinGrid(openList);
            if (current.x == end.x && current.y == end.y) {
                return current; // 找到路径，返回终点节点
            }

            openList.remove(current);
            closeList.add(current);

            List<Grid> neighbors = findNeighbors(current, openList, closeList);
            for (Grid neighbor : neighbors) {
                if (!containGrid(openList, neighbor.x, neighbor.y)) {
                    openList.add(neighbor);
                    neighbor.initGrid(current, end);
                }
                for (Grid openGrid : openList) {
                    if (openGrid.x == end.x && openGrid.y == end.y) {
                        return openGrid; // 找到路径，返回终点节点
                    }
                }
            }
        }

        return null; // 无路径
    }

    private static Grid findMinGrid(List<Grid> openList) {
        Grid minGrid = openList.get(0);
        for (Grid grid : openList) {
            if (grid.f < minGrid.f) {
                minGrid = grid;
            } else if (grid.f == minGrid.f && grid.g < minGrid.g) {
                minGrid = grid;
            }
        }
        return minGrid;
    }

    private static List<Grid> findNeighbors(Grid grid, List<Grid> openList, List<Grid> closeList) {
        List<Grid> neighbors = new ArrayList<>();
        int x = grid.x;
        int y = grid.y;

        // 上
        if (isValid(x - 1, y, openList, closeList)) {
            Grid up = new Grid(x - 1, y);
            neighbors.add(up);
        }
        // 下
        if (isValid(x + 1, y, openList, closeList)) {
            Grid down = new Grid(x + 1, y);
            neighbors.add(down);
        }
        // 左
        if (isValid(x, y - 1, openList, closeList)) {
            Grid left = new Grid(x, y - 1);
            neighbors.add(left);
        }
        // 右
        if (isValid(x, y + 1, openList, closeList)) {
            Grid right = new Grid(x, y + 1);
            neighbors.add(right);
        }
        return neighbors;
    }


    private static boolean isValid(int x, int y, List<Grid> openList, List<Grid> closeList) {
        if (x < 0 || x >= MAZE.length || y < 0 || y >= MAZE[0].length) {
            return false;
        }

        if (MAZE[x][y] == 1) {
            return false;
        }
        if (containGrid(openList, x, y)) {
            return false;
        }
        if (containGrid(closeList, x, y)) {
            return false;
        }
        return true;
    }

    private static boolean containGrid(List<Grid> list, int x, int y) {
        for (Grid grid : list) {
            if (grid.x == x && grid.y == y) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Grid start = new Grid(2, 1);
        Grid end = new Grid(2, 5);
        Grid result = aStarSearch(start, end);
        if (result != null) {
            List<Grid> path = new ArrayList<>();
            while (result != null) {
                path.add(result);
                result = result.parent;
            }
            for (int i = path.size() - 1; i >= 0; i--) {
                Grid grid = path.get(i);
                System.out.println("(" + grid.x + "," + grid.y + ")");
            }

            for (int i = 0; i < MAZE.length; i++) {
                for (int j = 0; j < MAZE[0].length; j++) {
                    if (containGrid(path, i, j)) {
                        System.out.print(" * ");
                    } else if (MAZE[i][j] == 1) {
                        System.out.print(" | ");
                    } else {
                        System.out.print(" . ");
                    }
                }
                System.out.println();
            }
        } else {
            System.out.println("无路径");
        }
    }
}
