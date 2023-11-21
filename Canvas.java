import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Canvas extends JFrame implements KeyListener {



    private int hp = 50;
    private final Darth darth  = new Darth();
    private final mon mon1  = new mon();
    Canvas(){
        setSize(700,500);
        setLayout(null);
        addKeyListener(this);
        setVisible(true);

        int x = 50;
        int y = 50;
        darth.setBounds(x, y,darth.getWidth(),darth.getHeight());
        add(darth);
        mon1.setBounds(300,300,200,200);
        add(mon1);

    }



    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {

            case KeyEvent.VK_LEFT -> {
            }
            case KeyEvent.VK_SPACE -> {
                darth.saltoAnim();
                hp -= 10;
            }
            case KeyEvent.VK_ESCAPE -> {
                EndGameWindow endGameWindow = new EndGameWindow(hp);
                add(endGameWindow);
            }

            case KeyEvent.VK_C -> {
                mon1.attackAnim();
                mon1.ter1();
            }
            case KeyEvent.VK_Z -> {
                mon1.saltoAnim();
                mon1.ter2();
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        System.out.println("keyReleased = "+keyEvent.getKeyChar());
    }
}
