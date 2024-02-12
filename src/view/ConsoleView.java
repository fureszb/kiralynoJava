package view;

import modell.Tabla;

public class ConsoleView implements IView {

    @Override
    public void displayBoard(Tabla board) {
        char[][] boardState = board.getTabla();
        for (char[] row : boardState) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    @Override
    public void displayEmptyRowsAndColumns(int emptyRows, int emptyColumns) {
        System.out.println("Üres sorok: " + emptyRows);
        System.out.println("Üres oszlopok: " + emptyColumns);
    }
}
