package com.finxera.assignment;

import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        int maze[][] = {
                { 0, 1, 0, 0, 0, 0, 0 },
                { 0, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 1, 0, 0, 0, 0 },
                { 0, 1, 0, 0, 0, 0, 0 },
                { 0, 1, 0, 1, 0, 1, 0 },
                { 0, 1, 0, 1, 0, 1, 0 },
                { 0, 0, 0, 1, 0, 1, 0 }
        };
        final var start = new Coordinate(0, 0);
        final var goal = new Coordinate(maze.length-1, maze[0].length-1);

        final List<Coordinate> output = new PathFinder(maze).find(start, goal, new Stack<>());
        if (Objects.nonNull(output))
            System.out.println("Path to reach from Start to Goal :: " + output);
        else
            System.out.println("There is no path to reach Goal from Source");
    }
}
