import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class mon extends JPanel {

    int x =-81;
    int y =-530;

    int t;


    mon(){
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point());
        points.add(new Point());
        BaseAnimation standAnimation = new BaseAnimation(points, true);

        standAnimation.start();
    }


    @Override
    public int getWidth() {
        return 300;//105
    }

    @Override
    public int getHeight() {
        return 300;
    }


    public void saltoAnim(){
        y =-530 ;
        if(x<-1251){
            x=-81 ;}
        x=x-260 ;
    }

    public void attackAnim(){



        y=-267 ;
        x=x-260 ;
        if(x<-1251){
            x=-81 ;
        }
    }




    public void ter2(){
        t=2;


    }
    public void ter1(){

        t=1;

    }

    public void standAnimation(){
        y =-530 ;
        if(x<-1251){
            x=-81 ;}
        x=x-260 ;

    }





    @Override
    protected void paintComponent(Graphics g) {//10

        BufferedImage image ;
        try {
            image = ImageIO.read(new File("res/img.png"));
            setSize(289,265);
            g.drawImage(image, x, y,null);

            System.out.println("paintComponent");
        } catch (IOException e) {
            e.printStackTrace();
        }



    }


    class BaseAnimation extends Thread {


        private final boolean isAllitime;
        private final ArrayList<Point> points;



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
