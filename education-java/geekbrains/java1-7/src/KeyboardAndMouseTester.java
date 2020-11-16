// 1. Создать класс KeyboardAndMouseTester. Данный класс должен иметь два поля с информацией (JLabel) и одно пустое поле (JPanel).
// 2. Первое поле должно отображать информацию в формате Number pressed: [n], где вместо n указывается текущая нажатая цифра на клавиатуре. Нажатия всех остальных клавиш (в том числе цифр с модификаторами Ctrl, Shift и Alt) не должны учитываться.
// 3. Второе поле должно отображать информацию в формате Mouse clicked: [X: x; Y: y], где вместо x и y указываются координаты клика мыши по пустому полю.
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KeyboardAndMouseTester {
    public static void main(String[] args) {
        JFrame mainWindow = new JFrame();
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setTitle("Keyboard And Mouse Tester");
        mainWindow.setBounds(100, 100, 700, 500);
        mainWindow.setResizable(false);

        JPanel panelToLabel = new JPanel();
        panelToLabel.setPreferredSize(new Dimension(700, 50));
        panelToLabel.setLayout(new GridLayout(0, 2, 0, 0));
        mainWindow.add(panelToLabel, BorderLayout.NORTH);

        JLabel leftLabel = new JLabel();
        leftLabel.setText(" Number pressed: [ ]");
        leftLabel.setPreferredSize(new Dimension(340, 50));
        leftLabel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        panelToLabel.add(leftLabel);


        JLabel rightLabel = new JLabel();
        rightLabel.setText(" Mouse clicked: [X: 0; Y: 0]");
        rightLabel.setPreferredSize(new Dimension(340, 50));
        rightLabel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        panelToLabel.add(rightLabel);

        JPanel areaForClick = new JPanel();
        mainWindow.add(areaForClick, BorderLayout.CENTER);

        areaForClick.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                rightLabel.setText(" Mouse clicked: [X: "+ e.getX() +"; Y: "+ e.getY() +"]");
            }
        });
        mainWindow.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (Character.isDigit(e.getKeyChar()) && !e.isAltDown() && !e.isShiftDown() && !e.isControlDown()) {
                    leftLabel.setText(" Number pressed: [" + e.getKeyChar() + "]");
                }
            }
        });
        mainWindow.setVisible(true);
    }
}
