import java.util.ArrayList;
import java.util.List;

enum GameState {
    ONGOING, CHECKMATE, STALEMATE, DRAW, RESIGNATION
}


enum GameResult {
    WHITE_WIN, BLACK_WIN, DRAW
}

public class Game {
    private Player playerWhite;
    private Player playerBlack;

    private Board board;
    private Player currPlayer;

    private GameState state;
    private GameResult result;
    private List<Move> moveHistory;

    public Game(Player playerWhite, Player blackPlayer) {
        this.playerBlack = playerBlack;
        this.playerWhite = playerWhite;
        this.currPlayer = playerWhite;
        this.board = new Board();
        this.state = GameState.ONGOING;
        this.moveHistory = new ArrayList<>();
    }

    public GameState getGameState(){
        return this.state;
    }

    public Player getCurrPlayer() {
        return this.currPlayer;
    }

    public Board getBoard() {
        return this.board;
    }

    public boolean makeMove(Move move) {
        if(this.state != GameState.ONGOING){
            System.out.println("Game is over now");
            return false;
        }

        if(!move.getPlayer().equals(currPlayer)) {
            System.out.println("This is not your turn");
        }

        if(!board.isValidMove(move)) {
            
            return false;
        }
        board.updateMove(move);
        moveHistory.add(move);
        if(board.isCheckmate(currPlayer)) {
            state = GameState.CHECKMATE;
            System.out.println(currPlayer.getName() + " wins by checkmate!");
        }else if(board.isStalemate(currPlayer)) {
            state = GameState.STALEMATE;
            System.out.println(currPlayer.getName() + " wins by stalemate!");
        } else {
            // need to switch the currPlayer
            currPlayer = (currPlayer.equals(playerBlack)) ? playerWhite : playerBlack;
        }
        return true;
    }
    public boolean isCheckmate() { 
        // add the logic to check whether the current player is already checkmate or not.
        return false;
    }
    public boolean isStalemate() {
        // add the logic if the current player is stalemate.
        
        return false;
    }

    public void endGame(GameResult result) {
        this.result = result;
    }
}
