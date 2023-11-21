import javax.swing.*;
import java.awt.*;

public class EndGameWindow extends JFrame {

    public EndGameWindow(int hp) throws HeadlessException {
        setSize(500,500);
        setLayout(new FlowLayout());
        JTextField hpTxt = new JTextField("hp = ");
        JTextField hpPoint = new JTextField(String.valueOf(hp));
        add(hpTxt);
        add(hpPoint);
        setVisible(true);
    }
}
