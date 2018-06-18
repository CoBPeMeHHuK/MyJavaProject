package Tanks;

import javax.swing.*;
import javax.swing.plaf.PanelUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class Panel extends JPanel implements ActionListener {

    public static boolean presskeyUp1;
    public static boolean presskeyDown1;
    public static boolean presskeyLeft1;
    public static boolean presskeyRight1;

    public static boolean presskeyUp2;
    public static boolean presskeyDown2;
    public static boolean presskeyLeft2;
    public static boolean presskeyRight2;

    public static int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    public static int HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;

    public static enum STATES{MENUE,PLAY}
    public static STATES state = STATES.PLAY;

    private BufferedImage image;
    private Graphics2D g;


    Timer mainTimer = new Timer(30,this);

    Back back = new Back();
    PlayerTank tank1 = new PlayerTank();
    PlayerTank tank2 = new PlayerTank();

    public Panel() {
        super();
        setFocusable(true);
        requestFocus();
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        g = (Graphics2D) image.getGraphics();

        addKeyListener(new Listener());

        mainTimer.start();
        System.out.println("Timer START");

        tank1.setImg(new ImageIcon("image/pl1.png").getImage());

        tank2.setImg(new ImageIcon("image/pl1.png").getImage());
    }

    public void actionPerformed(ActionEvent e) {
        if(state.equals(STATES.MENUE)){
            //System.out.println("MENUE");

        }
        if(state.equals(STATES.PLAY)){
            //System.out.println("PLAY  ");
            gameUpdate();
            gameRender();
            gameDraw();

        }
    }

    private void gameUpdate() {

//        tank1.up = presskeyUp1;
//        tank1.down = presskeyDown1;
//        tank1.left = presskeyLeft1;
//        tank1.right = presskeyRight1;
        tank1.setControl(presskeyUp1,presskeyDown1,presskeyLeft1,presskeyRight1);
        tank1.update();

        tank2.setControl(presskeyUp2,presskeyDown2,presskeyLeft2,presskeyRight2);
        tank2.update();



    }

    private void gameRender() {
        back.draw(g);
        tank1.draw(g);
        tank2.draw(g);

        Image imge = new ImageIcon("image/krisha.jpg").getImage();
        g.drawImage(imge,10,10,null);


    }

    private void gameDraw() {
        Graphics g2 = this.getGraphics();
        g2.drawImage(image ,0,0,null);
        g2.dispose();
    }
}
