

/**
 * Chess Piece class that creates and object for each 
 * piece on the board and assigns a name and a team for
 * each of them
 * @author Ryan Walker
 * Date last modified: 6/10/18
 * project: Final project
 * Class: CIS 304.04
 */
public class ChessPieces {
    
    private String piece;
    private final String team;
    
    public ChessPieces(String p, String t){
        this.piece = p;
        this.team = t;
    }
    
    public String getName(){
        return piece;
    }
    public String getTeam(){
        return team;
    }
    
    public void isDefeated(){
        this.piece = null;
    }
    
    
    
}
