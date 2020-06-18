import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {

    private static final int SIZE_X = 640;
    private static final int SIZE_Y = 400;
    private static final int LOCATION_X = 300;
    private static final int LOCATION_Y = 400;
    JButton newGameButton;
    SettingWindow settingWindow;
    JButton exitGame;
    GamePanel gamePanel;

    public MainWindow(){
        setSize(SIZE_X, SIZE_Y);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(LOCATION_X, LOCATION_Y);
        setResizable(false);
        setTitle("TicTacToe");

        newGameButton = newGame();
        exitGame = exitGameButton();

        settingWindow = new SettingWindow(this);

        JPanel jPanel = new JPanel(new GridLayout(1,2));
        jPanel.add(newGameButton);
        jPanel.add(exitGame);

        add(jPanel, BorderLayout.SOUTH);

        this.gamePanel = new GamePanel();

        add(gamePanel, BorderLayout.CENTER);



        setVisible(true);
    }

    private JButton newGame(){
        JButton game = new JButton("new game");
        game.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                settingWindow.setVisible(true);
            }
        });
        return game;
    }
    private JButton exitGameButton() {
        JButton exitThisGame = new JButton("exit");
        exitThisGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        return exitThisGame;
    }

    public void startGame(int gameMode, int fieldSize, int winLength){
        this.gamePanel.startGame(gameMode, fieldSize, winLength);
    }

}
