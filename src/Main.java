import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Enter the grid size");
        Scanner scanner = new Scanner(System.in);
        String sizeAnswer = scanner.nextLine();
        String[] size = sizeAnswer.split(", ");

        int xCol = Integer.parseInt(size[0]);
        int yRow = Integer.parseInt(size[1]);

        try {

            Grid grid = new Grid(yRow, xCol);

            String[] inputRows = new String[yRow];
            System.out.println("Please write " + yRow + " series with length " + xCol + ":");
            for (int i = 0; i < yRow; i++) {
                System.out.println("Serie " + (i + 1) + ":");
                String inputRow = scanner.nextLine();
                inputRows[i] = inputRow;
            }

            grid.fillGrid(inputRows);

            Game game = new Game(grid);
            System.out.println("Enter 'X-Column, Y-Row, N-NumberOfGen':");
            String inputGameAnswer = scanner.nextLine();
            String[] inputGame = inputGameAnswer.split(", ");
            int xCoordinateCol = Integer.parseInt(inputGame[0]);
            int yCoordinateRow = Integer.parseInt(inputGame[1]);
            int nGeneration = Integer.parseInt(inputGame[2]);

            int resultGame = game.play(yCoordinateRow, xCoordinateCol, nGeneration);
            System.out.println("Number of generation: " + resultGame);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}