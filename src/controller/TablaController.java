package controller;


import modell.Tabla;
import view.IView;

public class TablaController implements IController {
    private Tabla board;
    private IView view;

    public TablaController(IView view, Tabla board) {
        this.view = view;
        this.board = board;
    }

    @Override
    public void startGame() {
        board.Elhelyez(8); // Place 8 queens
        displayBoard();
    }

    @Override
    public void displayBoard() {
        view.displayBoard(board);
        int emptyRows = board.ÜresSorokSzáma();
        int emptyColumns = board.ÜresOszlopokSzáma();
        view.displayEmptyRowsAndColumns(emptyRows, emptyColumns);
    }
}
