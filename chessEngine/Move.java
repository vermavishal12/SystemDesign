public class Move {
    private Square from;
    private Square to;
    private Player player;
    private Piece pieceCaptured;

    public Move (Square from, Square to, Player player, Piece pieceCaptured) {
        this.from = from;
        this.to = to;
        this.player = player;
        this.pieceCaptured = to.getPiece();
    }

    public Square getFromSquare() {
        return from;
    }

    public Square getToSquare() {
        return to;
    }

    public Player getPlayer(){
        return player;
    }
}
