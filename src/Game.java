import java.util.ArrayDeque;

public class Game {
    private Grid grid;

    public Game(Grid grid) {
        if (!grid.isGridFilled()) {
            throw new IllegalStateException("Error! Fill the grid.");
        }
        this.grid = grid;
    }

    public int play(int inputRowY, int inputColX, int numberN) {
        char[][] grid = this.grid.getGrid();

        if (!isInBounds(inputRowY, inputColX, grid)) {
            throw new IllegalArgumentException("coordinate doesnt exist");
        }

        ArrayDeque<int[]> redDeque = new ArrayDeque<>();
        ArrayDeque<int[]> greenDeque = new ArrayDeque<>();

        int counterGeneration = 0;

        for (int i = 0; i <= numberN; i++) {

            if (grid[inputRowY][inputColX] == '1') {
                counterGeneration++;
            }

            for (int r = 0; r < grid.length; r++) {
                for (int c = 0; c < grid[r].length; c++) {
                    int greenNeighbours = getGreenNeighbours(grid, r, c);

                    if (grid[r][c] == '1') {
                        if (greenNeighbours != 2 && greenNeighbours != 3 && greenNeighbours != 6) {
                            redDeque.push(new int[]{r, c});
                        }
                    } else {
                        if (greenNeighbours == 3 || greenNeighbours == 6) {
                            greenDeque.push(new int[]{r, c});
                        }
                    }
                }
            }
            while (!redDeque.isEmpty()) {
                int[] currentCell = redDeque.pop();
                grid[currentCell[0]][currentCell[1]] = '0';
            }
            while (!greenDeque.isEmpty()) {
                int[] currentCell = greenDeque.pop();
                grid[currentCell[0]][currentCell[1]] = '1';
            }
        }
        return counterGeneration;
    }

    private static int getGreenNeighbours(char[][] matrix, int row, int col) {
        int greenNeighboursCount = 0;
        for (int r = row - 1; r < row + 2; r++) {
            for (int c = col - 1; c < col + 2; c++) {
                if (isInBounds(r, c, matrix) && !(row == r && col == c) && matrix[r][c] == '1') {
                    greenNeighboursCount++;
                }
            }
        }
        return greenNeighboursCount;
    }

    private static boolean isInBounds(int r, int c, char[][] matrix) {
        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length;
    }

}
