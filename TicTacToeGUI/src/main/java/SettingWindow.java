import javafx.scene.control.RadioButton;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingWindow extends JFrame {

    private static final int WINDOW_HEIGHT = 350;
    private static final int WINDOW_WIDTH = 270;
    private static final int MIN_WIN_LENGTH = 3;
    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 10;
    private static final String FIELD_SIZE_PREFIX = "Размер поля: ";
    private static final String WIN_LENGTH_PREFIX = "Длина победы в символах: ";

    private MainWindow xoWindow;
    private JRadioButton hmVSai;
    private JRadioButton hmVShm;
    private JSlider slideWinLen;
    private JSlider slideFieldSize;


    public SettingWindow(MainWindow window){
        setSize(WINDOW_HEIGHT, WINDOW_WIDTH);
        this.xoWindow = window;
        Rectangle gameWindowBounds = xoWindow.getBounds();
        int posX = (int) gameWindowBounds.getCenterX() - WINDOW_WIDTH / 2;
        int posY = (int) gameWindowBounds.getCenterY() - WINDOW_HEIGHT / 2;
        setResizable(false);
        setLocation(posX, posY);
        setTitle("Создать игру");
        setLayout(new GridLayout(8, 1));
        setButton();
        addGameControls();



}

    private void setButton(){
        hmVSai = new JRadioButton("human vs AI");
        hmVShm = new JRadioButton("human vs human");
        JLabel label = new JLabel("Выбери режим");
        add(label);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(hmVSai);
        buttonGroup.add(hmVShm);
        hmVShm.setSelected(true);
        add(hmVSai);
        add(hmVShm);

        JButton buttonStart = new JButton("Создать новую игру");
        buttonStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                classStartGame();
            }
        });
        add(buttonStart);
    }

    public void addGameControls(){
        final JLabel label = new JLabel(FIELD_SIZE_PREFIX + MIN_FIELD_SIZE);
        final JLabel label1 = new JLabel(WIN_LENGTH_PREFIX + MIN_WIN_LENGTH);
        slideFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        slideWinLen = new JSlider(MIN_WIN_LENGTH, MIN_FIELD_SIZE, MIN_FIELD_SIZE);

        slideFieldSize.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int currentValue = slideFieldSize.getValue();
                label.setText(FIELD_SIZE_PREFIX + currentValue);
                slideWinLen.setMaximum(currentValue);
            }
        });

        slideWinLen.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                label1.setText(WIN_LENGTH_PREFIX + slideWinLen.getValue());
            }
        });

        add(label);
        add(slideFieldSize);
        add(label1);
        add(slideWinLen);



    }

    private void classStartGame(){
        int gameMode;
        if (hmVShm.isSelected()){
            gameMode = GamePanel.GAME_MODE_HMVSHM;
        }
        else if (hmVSai.isSelected())
        {
            gameMode = GamePanel.GAME_MODE_HVSAI;
        }
        else {
            throw new RuntimeException("Данный режим игры не поддерживается");
        }

        int fieldSize = slideFieldSize.getValue();
        int winLength = slideWinLen.getValue();
        xoWindow.startGame(gameMode, fieldSize, winLength);
        setVisible(false);
    }
}
