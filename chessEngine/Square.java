public class Square {
    private int row, col;
    private Piece piece;

    public Square(int row, int col, Piece piece) {
        this.row = row;
        this.col = col;
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public int getRow(){
        return this.row;
    }

    public int getCol(){
        return this.col;
    }
}
