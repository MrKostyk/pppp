import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Darth extends JPanel {
    private final BaseAnimation standAnimation;
    private BaseAnimation currentAnimation;

    Darth(){
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(-65,-9,27,59));
        points.add(new Point(-40,-9,27,59));
        standAnimation = new BaseAnimation(points,true);

        currentAnimation = standAnimation;
        currentAnimation.start();

    }


    @Override
    public int getWidth() {
        return 27;//105
    }

    @Override
    public int getHeight() {
        return 59;//75
    }


    public void saltoAnim(){
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(-65,-9,27,59));
        points.add(new Point(-29,-9,27,59));
        BaseAnimation saltoAnimation = new BaseAnimation(points);
       saltoAnimation.start();
       currentAnimation = saltoAnimation;
    }



    public void standAnimation(){
        currentAnimation = standAnimation;
    }



    @Override
    protected void paintComponent(Graphics g) {//10

        BufferedImage image;
        try {
            image = ImageIO.read(new File("res/img_2.png"));
            setSize(currentAnimation.getW(),currentAnimation.getH());
            g.drawImage(image, currentAnimation.getX(), currentAnimation.getY(),null);
        } catch (IOException e) {
            e.printStackTrace();
        }



    }


    class BaseAnimation extends Thread {

        private int x;
        private int y;
        private int w;
        private int h;


        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getW() {
            return w;
        }

        public int getH() {
            return h;
        }
        private boolean isAllitime;
        private final ArrayList<Point> points;

        public BaseAnimation(ArrayList<Point> points) {
            this.points = points;
        }

        public BaseAnimation(  ArrayList<Point> points, boolean isAllitime) {
            this.points = points;
            this.isAllitime = isAllitime;
        }

        @Override
        public void run() {
            int i = 0;
            while (true){
                if(i == points.size()){
                    i = 0;
                    if (!isAllitime){
                        standAnimation();
                        return;
                    }
                }
                x = points.get(i).x();
                y = points.get(i).y();
                h = points.get(i).h();
                w =  points.get(i).w();
                try {
                    Thread.sleep(1000/8);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                repaint();
                i++;

            }
        }
    }
}
