import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    public static final int GAME_MODE_HVSAI = 0;
    public static final  int GAME_MODE_HMVSHM = 1;

    public GamePanel(){
        setBackground(Color.lightGray);
        setOpaque(true);

    }


    public void startGame(int gameMode, int fieldSize, int winLength){
        System.out.printf(" Game mode is: %d%n Field size : %d%n Win Length : %d%n", gameMode,fieldSize,winLength);
        GridLayout gridLayout = new GridLayout(fieldSize, fieldSize);


    }
}
