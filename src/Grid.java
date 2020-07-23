
public class Grid {

    private char[][] grid;
    private int rowY;
    private int columnX;
    private boolean isGridFilled;

    public Grid(int rowY, int columnX) {
        setRow(rowY);
        setColumn(columnX);
        this.grid = new char[rowY][];
        this.isGridFilled = false;
    }

    public char[][] getGrid() {
        return this.grid;
    }

    private void setRow(int rowY) {
        if (rowY <= 0 || rowY > 999) {
            throw new IllegalArgumentException("Y must be in the range 1-1000");
        }
        this.rowY = rowY;
    }


    private void setColumn(int columnX) {
        if (columnX <= 0 || columnX > this.rowY) {
            throw new IllegalArgumentException("X must be in the range 1-1000 and must be <= Y");
        }
        this.columnX = columnX;
    }

    public boolean isGridFilled() {
        return this.isGridFilled;
    }

    public void fillGrid(String[] inputRows) {
        if (inputRows.length != this.rowY) {
            throw new IllegalArgumentException("Rows bust be equal to " + this.rowY);
        }
        for (int i = 0; i < inputRows.length; i++) {
            if (inputRows[i].length() != this.columnX) {
                throw new IllegalArgumentException("Length of the serie number " + (i + 1) + " must be " + this.columnX);
            }
            if (!inputRows[i].matches("[0-1]+")) {
                throw new IllegalArgumentException("The input data must contain only 0 and 1");
            }
            grid[i] = inputRows[i].toCharArray();
        }
        this.isGridFilled = true;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (char[] chars : this.grid) {
            result.append(String.valueOf(chars));
            result.append(System.lineSeparator());
        }
        return result.toString();
    }
}
