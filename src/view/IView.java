
    package view;

    import modell.Tabla;


    public interface IView {
          void displayBoard(Tabla board);
        void displayEmptyRowsAndColumns(int emptyRows, int emptyColumns);
    }
