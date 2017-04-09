package eg.edu.alexu.csd.datastructure.maze.cs70;

import java.io.File;
import java.util.Scanner;

import eg.edu.alexu.csd.datastructure.maze.IMazeSolver;
import eg.edu.alexu.csd.datastructure.queue.cs70.MyQueue;
import eg.edu.alexu.csd.datastructure.stack.cs70.MyStack;

/**
 * The Class MazeSolver.
 */
public class MazeSolver implements IMazeSolver {

  /** The sc. */
  Scanner sc;

  /** The x0. */
  final int x0 = 0;

  /** The x1. */
  final int x1 = 1;

  /** The nx1. */
  final int nx1 = -1;

  /** The start row. */
  private int startRow;

  /** The start col. */
  private int startCol;

  /** The exit. */
  private boolean exit = false;

  /** The visited. */
  private boolean[][] visited;

  /** The stack. */
  MyStack stack = new MyStack();

  /** The queue. */
  MyQueue queue = new MyQueue();

  /**
   * Read the maze file, and solve it using Breadth First Search.
   *
   * @param maze
   *          maze file
   * @return the coordinates of the found path from point 'S' to point
   *          'E' inclusive, or null if no
   *         path found. coordinates indexes are zero based.
   */
  @Override
  public int[][] solveBFS(final File maze) {
    String[] problem = isValid(maze);
    visited = new boolean[problem.length][problem[x0].length()];
    queue.enqueue(new int[] {startRow, startCol});
    boolean exitbfs = false;
    while (!queue.isEmpty()) {
      int[] tmp = (int[]) queue.dequeue();
      if (!visited[tmp[x0]][tmp[x1]]) {
        stack.push(tmp);
        visited[tmp[x0]][tmp[x1]] = true;
      } else {
        continue;
      }
      if (problem[tmp[x0]].charAt(tmp[x1]) == 'E') {
        exitbfs = true;
        break;
      }
      if (tmp[x0] > x0) {
        if (!visited[tmp[x0] - x1][tmp[x1]]
            && problem[tmp[x0] - x1].charAt(tmp[x1]) != '#') {
          queue.enqueue(new int[] {tmp[x0] - x1, tmp[x1]});
        }
      }
      if (tmp[x1] + x1 < problem[x0].length()) {
        if (!visited[tmp[x0]][tmp[x1] + x1]
            && problem[tmp[x0]].charAt(tmp[x1] + 1) != '#') {
          queue.enqueue(new int[] {tmp[x0], tmp[x1] + x1});
        }
      }
      if (tmp[x0] + x1 < problem.length) {
        if (!visited[tmp[x0] + x1][tmp[x1]]
            && problem[tmp[x0] + x1].charAt(tmp[x1]) != '#') {
          queue.enqueue(new int[] {tmp[x0] + x1, tmp[x1]});
        }
      }
      if (tmp[x1] > 0) {
        if (!visited[tmp[x0]][tmp[x1] - x1]
            && problem[tmp[x0]].charAt(tmp[x1] - x1) != '#') {
          queue.enqueue(new int[] {tmp[x0], tmp[x1] - x1});
        }
      }
    }
    if (!exitbfs) {
      return null;
    }
    MyStack stack2 = new MyStack();
    stack2.push(stack.pop());
    while (!stack.isEmpty()) {
      int[] tmp = (int[]) stack.pop();
      int[] tmp2 = (int[]) stack2.peek();
      if ((abs(tmp[x0] - tmp2[x0]) == 1 && tmp[x1] == tmp2[x1])
          || (abs(tmp[x1] - tmp2[x1]) == x1 && tmp[x0] == tmp2[x0])) {
        stack2.push(tmp);
      }
    }
    int[][] path = new int[stack2.size()][2];
    int counter = x0;
    while (!stack2.isEmpty()) {
      path[counter] = (int[]) stack2.pop();
      counter++;
    }
    return path;
  }

  /**
   * Abs.
   *
   * @param input the input.
   * @return the int.
   */
  private int abs(final int input) {
    // TODO Auto-generated method stub
    if (input < 0) {
      return input * nx1;
    }
    return input;
  }

  /**
   * Read the maze file, and solve it using Depth First Search.
   *
   * @param maze
   *          maze file
   * @return the coordinates of the found path from point 'S' to
   *          point 'E' inclusive, or null if no
   *         path found. coordinates indexes are zero based.
   */
  @Override
  public int[][] solveDFS(final File maze) {
    // TODO Auto-generated method stub
    String[] problem = isValid(maze);
    visited = new boolean[problem.length][problem[x0].length()];
    dfs(problem, startRow, startCol);
    if (!exit) {
      return null;
    }
    int[][] path = new int[stack.size()][2];
    for (int i = stack.size() - 1; i > -1; i--) {
      path[i] = (int[]) stack.pop();
    }
    return path;
  }

  /**
   * Checks if is valid.
   *
   * @param maze the maze.
   * @return the string[].
   */
  private String[] isValid(final File maze) {
    try {
      sc = new Scanner(maze);
    } catch (Exception ex) {

      throw new RuntimeException("File not Found");
    }
    int hight = Integer.parseInt(sc.next());
    int width = Integer.parseInt(sc.next());
    String[] problem = new String[hight];
    int counter = 0;
    boolean flagStart = false;
    boolean flagExit = false;
    while (sc.hasNext()) {
      if (counter == hight) {
        throw new RuntimeException("Size is bigger");
      }
      problem[counter] = sc.next();
      if (problem[counter].contains("E")) {
        flagExit = true;
      }
      if (problem[counter].contains("S")) {
        startRow = counter;
        startCol = problem[counter].indexOf("S");
        flagStart = true;
      }
      counter++;
    }
    if (counter != hight || problem[x0].length() != width) {
      throw new RuntimeException("invalid Dimensions");
    }
    if (!flagExit || !flagStart) {
      throw new RuntimeException("No Start or no End");
    }
    sc.close();
    return problem;
  }

  /**
   * Dfs.
   *
   * @param problem the problem.
   * @param startrow the startrow.
   * @param startcol the startcol.
   */
  private void dfs(final String[] problem, final int startrow,
      final int startcol) {
    if (startrow >= problem.length || startcol >= problem[x0].length()
        || startcol < x0
        || startrow < x0) {
      return;
    }
    if (visited[startrow][startcol]) {
      return;
    }
    if (problem[startrow].charAt(startcol) == 'E') {
      stack.push(new int[] {startrow, startcol});
      visited[startrow][startcol] = true;
      exit = true;
      return;
    }
    if (problem[startrow].charAt(startcol) == '#') {
      visited[startrow][startcol] = true;
      return;
    }
    if (!exit) {
      if (!visited[startrow][startcol]) {
        visited[startrow][startcol] = true;
        stack.push(new int[] {startrow, startcol});
      }
      dfs(problem, startrow - x1, startcol);

    }
    if (!exit) {
      if (!visited[startrow][startcol]) {
        visited[startrow][startcol] = true;
        stack.push(new int[] {startrow, startcol});
      }
      dfs(problem, startrow, startcol + x1);
    }
    if (!exit) {
      if (!visited[startrow][startcol]) {
        visited[startrow][startcol] = true;
        stack.push(new int[] {startrow, startcol});
      }
      dfs(problem, startrow + x1, startcol);
    }
    if (!exit) {
      if (!visited[startrow][startcol]) {
        visited[startrow][startcol] = true;
        stack.push(new int[] {startrow, startcol});
      }
      dfs(problem, startrow, startcol - x1);
    }
    if (around(problem, startrow, startcol) && !exit) {
      stack.pop();
    }
    return;
  }

  /**
   * Around.
   *
   * @param problem the problem.
   * @param row the row.
   * @param col the col.
   * @return true, if successful
   */
  private boolean around(final String[] problem, final int row,
      final int col) {
    boolean flag1 = false;
    boolean flag2 = false;
    boolean flag3 = false;
    boolean flag4 = false;
    if (row > x0) {
      if (visited[row - x1][col]) {
        flag1 = true;
      }
    } else {
      flag1 = true;
    }
    if (col > x0) {
      if (visited[row][col - x1]) {
        flag2 = true;
      }
    } else {
      flag2 = true;
    }
    if (row + x1 < problem.length) {
      if (visited[row + x1][col]) {
        flag3 = true;
      }
    } else {
      flag3 = true;
    }
    if (col + x1 < problem[x0].length()) {
      if (visited[row][col + x1]) {
        flag4 = true;
      }
    } else {
      flag4 = true;
    }
    if (flag1 && flag2 && flag3 && flag4) {
      return true;
    }
    return false;
  }
}
