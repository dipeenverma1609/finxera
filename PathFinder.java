package com.finxera.assignment;

import java.util.Objects;
import java.util.Stack;

public class PathFinder {

    private final int rows;
    private final int cols;
    private final int[][] maze;
    private final boolean [][]visited;

    public PathFinder (final int[][] maze) {
        this.maze = maze;
        this.rows = maze.length;
        this.cols = maze[0].length;
        this.visited = new boolean[this.rows][this.cols];
    }

    public Stack<Coordinate> find(final Coordinate curr, final Coordinate goal, final Stack<Coordinate> path) {
        final int x = curr.getX();
        final int y = curr.getY();
        //System.out.println("Current path => "+ path);
        //System.out.println("Current node => "+ curr);
        if (goal.getX() == x && goal.getY() == y) {
            return path;
        }
        this.visited[curr.getX()][curr.getY()] = true;
        path.push(curr);

        if (canMoveTo(x + 1, y)) {
            final Coordinate next = new Coordinate(curr.getX() + 1, curr.getY());
            final var response = find(next, goal, path);
            if (Objects.nonNull(response)) {
                return path;
            }
        }
        if (canMoveTo(x, y + 1)) {
            final Coordinate next = new Coordinate(curr.getX(), curr.getY() + 1);
            final var response = find(next, goal, path);
            if (Objects.nonNull(response)) {
                return path;
            }
        }
        if (canMoveTo(x - 1, y)) {
            final Coordinate next = new Coordinate(curr.getX() - 1, curr.getY());
            final var response = find(next, goal, path);
            if (Objects.nonNull(response)) {
                return path;
            }
        }
        if (canMoveTo(x, y - 1)) {
            final Coordinate next = new Coordinate(curr.getX(), curr.getY() - 1);
            final var response = find(next, goal, path);
            if (Objects.nonNull(response)) {
                return path;
            }
        }

        visited[x][y] = false;
        path.pop();
        //System.out.println("Backtracking from node => "+ curr);
        return null;
    }

    private boolean canMoveTo(final int row, final int col) {
        //System.out.println("Checking for ("+row+","+col+")");
        return isValid(row, col) && this.maze[row][col] == 0 && !this.visited[row][col];
    }
    private boolean isValid(final int row, final int col) {
        return (row >= 0) && (row < this.rows) && (col >= 0) && (col < this.cols);
    }
}
