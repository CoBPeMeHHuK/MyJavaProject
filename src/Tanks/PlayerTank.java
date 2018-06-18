package Tanks;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class PlayerTank {


    private int speed;

    private double x;
    private double y;
    private double angl;


    // public static boolean up;
    public static boolean up;
    public static boolean down;
    public static boolean left;
    public static boolean right;


    //Image img = new ImageIcon("C:\\Tests\\fon.jpg").getImage();
    Image img = new ImageIcon("image/pl1.png").getImage();

    public PlayerTank(){
        up    = false;
        down  = false;
        left  = false;
        right = false;

        speed = 3;
        x=500;
        y=100;

        angl = 0;
        //System.out.println(angl);
    }

    public void update() {

        double gradus = Math.toDegrees(angl);
        if (gradus > 360) angl = 0;
        if (gradus < 0) angl = 6.20;


        if (up){

//            y = y-speed * Math.acos(gradus);
//            x = x+speed * Math.asin(gradus);

//            x = x+speed * Math.asin(angl);
//            y = y-speed * Math.acos(angl);
            //x = x+speed * Math.asin(angl);

            System.out.println("------------------------------------------------");
            System.out.println("Gradus = "+gradus);
            System.out.println("gradus = "+gradus);
            System.out.println("Y = "+y);
            System.out.println("X = "+x);
            //System.out.println("REZ = "+(speed * Math.asin(angl)));
            //System.out.println(Math.toRadians(gradus));
            //System.out.println(Math.asin(angl));
            //System.out.println(Math.acos(angl));

//
            if (gradus>23 && gradus<67)   {x = x-speed; y = y+speed;}
            if (gradus>68 && gradus<112)  x = x-speed;
            if (gradus>113 && gradus<157) {x = x-speed; y = y-speed;}
            if (gradus>158 && gradus<202) y = y-speed;
            if (gradus>203 && gradus<247) {x = x+speed; y = y-speed;}
            if (gradus>248 && gradus<292) x = x+speed;
            if (gradus>293 && gradus<337) {x = x+speed; y = y+speed;}
            if (gradus>338 && gradus<361||gradus>0 && gradus<22) y = y+speed;
//            if (gradus>0 && gradus<22)    {x = x-speed; y = y+speed;}


            //x = x-speed;

            //y = y+speed;
            //angl = angl + 0.01;

        }
        if (down){

            if (gradus>45 && gradus<135)  x = x+speed-2;
            if (gradus>136 && gradus<225) y = y+speed-2;
            if (gradus>226 && gradus<315) x = x-speed+2;
            if (gradus>316 && gradus<405||gradus>0 && gradus<45) y = y-speed+2;

        }

        if (left){
            angl = angl - 0.05;
          //  System.out.println(angl);
           // System.out.println("УГОЛ = " + Math.toDegrees(angl));
           // System.out.println("УГОЛ = " + Math.toDegrees(angl));
        }
        if (right){
            angl = angl + 0.05;
           // System.out.println(angl);
           // System.out.println("УГОЛ = " + Math.toDegrees(angl));
        }


    }

    public void draw(Graphics2D g){



        //Вращение
        AffineTransform origXform;
        origXform = g.getTransform();
        AffineTransform newXform = (AffineTransform)(origXform.clone());
        newXform.rotate(angl,x+23,y+60);
        g.setTransform(newXform);
        g.drawImage(img,(int)x,(int)y,null); //paint
        g.setTransform(origXform);
        //g.setBackground(Color.BLUE);
    }
    //ГЕТЕРЫ
    public double getX() {return x; }
    public double getY() {return y; }

    //СЕТЕРЫ
    public static void setControl(boolean up,boolean down, boolean left, boolean right) {
        PlayerTank.up = up;
        PlayerTank.down = down;
        PlayerTank.left = left;
        PlayerTank.right = right;
    }

    public void setImg(Image img) {
        this.img = img;
    }
}
