package main;

import java.io.IOException;
import modell.Tabla;
import view.ConsoleView;

public class Kiralynok_program {

    public static void main(String[] args) {
        Tabla board = new Tabla('*');
        ConsoleView view = new ConsoleView();

        board.Elhelyez(8);
        view.displayBoard(board);
        int emptyRows = board.ÜresSorokSzáma();
        int emptyColumns = board.ÜresOszlopokSzáma();
        view.displayEmptyRowsAndColumns(emptyRows, emptyColumns);

        try {
            board.tablakAllapotanakMentese("tablak64.txt");
        } catch (IOException e) {
            System.out.println("Hiba történt a fájl írása során: " + e.getMessage());
        }

    }

}
