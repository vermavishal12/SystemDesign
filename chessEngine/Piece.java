public abstract class Piece {
    
    protected boolean isWhite;

    public Piece(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public boolean isWhite() {
        return isWhite;
    }
    
    public abstract boolean isValidMove(Move move, Board board);
}
