public class Player {
    String id;
    String name;
    int rating;
    boolean isWhite;

    public Player(String name, int rating, boolean isWhite) {
        this.name = name;
        this.rating = rating;
        this.isWhite = isWhite;
    }

    public boolean isWhite(){
        return this.isWhite;
    }

    public String getName(){
        return this.name;
    }
}
