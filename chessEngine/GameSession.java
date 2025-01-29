import java.util.Scanner;

public class GameSession {
    private Game game;

    
    
        public static void main(String[] args) {
            System.out.println("Hello, World");
            Scanner scanner = new Scanner(System.in);
            System.out.println("-------------------ChessGameStart--------------");
            Player playerWhite = new Player("white one", 1100, true);
            Player playerBlack = new Player("Black Player" , 1200, false);
            Game newGame = new Game(playerWhite, playerBlack);
            for(int i = 0 ; i < 2 ; i++) {
                System.out.println("Current Turn: " + newGame.getCurrPlayer().getName());
                System.out.println("Enter move (fromRow fromCol toRow toCol): ");

                int fromRow = scanner.nextInt();
                int fromCol = scanner.nextInt();
                int toRow = scanner.nextInt();
                int toCol = scanner.nextInt();

                Square from = newGame.getBoard().getSquare(fromRow, fromCol);
                Square to = newGame.getBoard().getSquare(toRow, toCol);
                Move move = new Move(from, to, newGame.getCurrPlayer(), to.getPiece());

                if (!newGame.makeMove(move)) {
                    System.out.println("Invalid move, try again.");
                }
            }
    }

    public void start() {

    }
    public void start1() {
        Scanner scanner = new Scanner(System.in);
        while (game.getGameState() == GameState.ONGOING) {
            System.out.println("Current Turn: " + game.getCurrPlayer().getName());
            System.out.println("Enter move (fromRow fromCol toRow toCol): ");
            int fromRow = scanner.nextInt();
            int fromCol = scanner.nextInt();
            int toRow = scanner.nextInt();
            int toCol = scanner.nextInt();
            
            Square from = game.getBoard().getSquare(fromRow, fromCol);
            Square to = game.getBoard().getSquare(toRow, toCol);
            Move move = new Move(from, to, game.getCurrPlayer(), to.getPiece());
            
            if (!game.makeMove(move)) {
                System.out.println("Invalid move, try again.");
            }
        }
        System.out.println("Game Over!");
        scanner.close();
    }
}
