import Controller.ScoreboardMenuController;
import Model.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ScoreBoardTest {
    @Test
    public void showScoreBoardTest(){
        Player playerOne = new Player("abdol","abdol1","abdoli");
        Player playerTwo = new Player("ahmad","ahmad1","123Ahmad");
        Player playerTree = new Player("esmal","esmali","A124smal");
        new ScoreboardMenuController().showScoreboard();
    }
}
