import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
 
class MyPanel extends JPanel {
        private Ball ball;
        int panelWidth = 500;
        int panelHeight = 500;
        int diameter = 300;
        int yDraw = diameter;

        int ballSize = 20;
        int x = 0;
        int y=0;
        int rr=0;
        int gg=0;
        int bb=0;
        Random rand = new Random(); 

        int counterPrzyprostokatna = diameter/2;
        
        int counterPrzyprostokatnaSwitch = -1;
        int przeciwprostokatna = (diameter/2)*(diameter/2);
        int przyprostokatnaOne;
        int przyprostokatnaTwo;
        
        int reduction = 10;
        int rangeMax = diameter;
        int rangeMin = 0;
        int positionY=-100;
 
        public MyPanel () {        	
                ball = new Ball();
                setPreferredSize(new Dimension(400, 400));
        }
        int i =0;
        public void dzialaj() throws InterruptedException {

          while (i <= rangeMax) {
            

            panelWidth=getWidth();
            panelHeight=getHeight();    
            x=i;
            przyprostokatnaOne= counterPrzyprostokatna*counterPrzyprostokatna;
            przyprostokatnaTwo=(int) Math.sqrt(przeciwprostokatna-przyprostokatnaOne);
            y=diameter+przyprostokatnaTwo;
            if(counterPrzyprostokatna==0)
            {
              counterPrzyprostokatnaSwitch=1;
              counterPrzyprostokatna=0;
            }
            Thread.sleep(15);
            repaint();
            System.out.println(yDraw);
            i++;
            counterPrzyprostokatna=counterPrzyprostokatna+counterPrzyprostokatnaSwitch;
            
            if(i==rangeMax+1)
            {
              counterPrzyprostokatnaSwitch=-1;
              rangeMin=rangeMin+reduction;
              rr= rand.nextInt(255); 
              gg=rand.nextInt(255); 
              // i=i-1;
              // counterPrzyprostokatna=counterPrzyprostokatna-1;
              while(i>=rangeMin)
              {
                if(counterPrzyprostokatna==0)
                {
                  counterPrzyprostokatnaSwitch=1;
                  counterPrzyprostokatna=0;
                } 
                i=i-1;
                x=i;
                counterPrzyprostokatna=counterPrzyprostokatna+counterPrzyprostokatnaSwitch;
                przyprostokatnaOne= counterPrzyprostokatna*counterPrzyprostokatna;
                przyprostokatnaTwo=(int) Math.sqrt(przeciwprostokatna-przyprostokatnaOne);
                y=diameter+przyprostokatnaTwo;    
                repaint();
                Thread.sleep(15);
                }
                counterPrzyprostokatnaSwitch = -1;
                i++;
                counterPrzyprostokatna--;
                rangeMax=rangeMax-reduction;
                rr= rand.nextInt(255); 
                gg=rand.nextInt(255); 
            }  
          }
        repaint();
        }
        public void paintComponent (Graphics g) {
        		super.paintComponent(g);
                Graphics2D g2 = (Graphics2D)g;
                g2.setColor(new Color(rr, gg, 116));
                g2.fill(new Ellipse2D.Double((x+((panelWidth-diameter)/2))-ballSize/2,y-(ballSize/2) +positionY, ballSize, ballSize));
                g2.setColor(new Color(0, 0, 0));
                g2.drawLine(panelWidth/2, yDraw+positionY, x+((panelWidth-diameter)/2), y+positionY);
        }
 
}