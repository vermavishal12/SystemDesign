public class Board {
    private Square chessBoard[][];

    public Board () {
        chessBoard = new Square[8][8];
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8 ; j++) {
                chessBoard[i][j] = new Square(i, j, null);
            }
        }
    }

    public void initializeBoard() {
        
        for(int i = 0; i < 8 ; i++) {
            Piece blackPiece = new Pawn(false);
            chessBoard[1][i].setPiece(blackPiece);
            Piece whitePiece = new Pawn(true);
            chessBoard[6][i].setPiece(whitePiece);
        }

        chessBoard[0][0].setPiece(new Rook(false));
        chessBoard[0][1].setPiece(new Knight(false));
        chessBoard[0][2].setPiece(new Bishop(false));
        chessBoard[0][3].setPiece(new Queen(false));
        chessBoard[0][4].setPiece(new King(false));
        chessBoard[0][5].setPiece(new Bishop(false));
        chessBoard[0][6].setPiece(new Knight(false));
        chessBoard[0][7].setPiece(new Rook(false));

        chessBoard[7][0].setPiece(new Rook(true));
        chessBoard[7][1].setPiece(new Knight(true));
        chessBoard[7][2].setPiece(new Bishop(true));
        chessBoard[7][3].setPiece(new King(true));
        chessBoard[7][4].setPiece(new Queen(true));
        chessBoard[7][5].setPiece(new Bishop(true));
        chessBoard[7][6].setPiece(new Knight(true));
        chessBoard[7][7].setPiece(new Rook(true));
        
    }

    public Square getSquare(int row, int col) {
        return chessBoard[row][col];
    }

    public boolean isCheckmate(Player player) {
        // Check if player is checkmated
        return false;
    }

    public boolean isStalemate(Player player) {
        // Check if player is stalemated
        return false;
    }

    public boolean isValidMove(Move move) {
        Piece piece = move.getFromSquare().getPiece();
        if(piece == null)return false;
        if(piece.isWhite() != move.getPlayer().isWhite()) {
            return false;
        }

        Square endSquare = move.getToSquare();
        if (endSquare.getPiece() != null && endSquare.getPiece().isWhite()) {
            return false;
        }

        if (piece.isValidMove(move, this)) {
            return true;
        }
            
        return false;
    }

    public void updateMove(Move move) {
        Square currSquare = move.getFromSquare();
        move.getToSquare().setPiece(currSquare.getPiece());
        move.getFromSquare().setPiece(null);
    }

}
