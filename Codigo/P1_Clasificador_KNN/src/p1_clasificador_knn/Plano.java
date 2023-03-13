/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1_clasificador_knn;

/**
 *
 * @author anton
 */
import javax.swing.JPanel;
import java.awt.*;

public class Plano{

    private JPanel pnl;
    private int w, h;

    //Constructor
    public Plano(JPanel pnl){
        this.pnl = pnl;
        w = pnl.getWidth();
        h = pnl.getHeight();
    }

    //Metodos
    public void dibujarCartesiano(){
        Graphics2D g = (Graphics2D) pnl.getGraphics();
        g.setFont(new Font( "sans-serif", 0, 12 ));
        g.setColor(new Color(230,230,230));

        for(int i=60 ; i<=w ; i+=60){
            g.drawLine(i, 3, i, h-4);
        }

        for(int i=10 ; i<h ; i+=60){
            g.drawLine(3, i, w-4, i);
        }

        g.setColor(Color.BLACK);

        g.drawLine(60, 0, 60, h);
        g.drawLine(0, h/2, w, h/2); 

        int  cont = 0;

        for(int i=60 ; i<=w ; i+=60){
            g.drawString(String.valueOf(cont), i-18,h-15);
            cont+=10;
        }
        cont = 4;

        for(int i=10 ; i<h ; i+=60){
            g.drawString(String.valueOf(cont), 7,i-2);
            cont--;
        }
        g.setColor(Color.WHITE);
        g.fillRect(w-109,7, 100,100);

        g.setColor(new Color(149,188,17));
        g.fillOval(w-99, 17, 12, 12);

        g.setColor(new Color(250,121,4));
        g.fillOval(w-99, 34, 12, 12);

        g.setColor(new Color(11,152,208));
        g.fillOval(w-99, 51, 12, 12);

        g.setColor(new Color(12,66,100));
        g.fillOval(w-99, 68, 12, 12);

        g.setColor(new Color(255,222,23));
        g.fillOval(w-99, 85, 12, 12);

        g.setColor(Color.BLACK);
        g.drawRect(w-109,7, 100,100);

        for(int i=1 ; i<=5 ; i++){
            String c = i + " Estrellas";
            g.drawString(c, w-80,i*17+10);
        }
    }

    public void dibujarPunto(float x, float y, String color){
        Graphics2D g = (Graphics2D) pnl.getGraphics();

        switch(color){
            case "1":
                g.setColor(new Color(149,188,17));
                break;
            case "2":
                g.setColor(new Color(250,121,4));
                break;
            case "3":
                g.setColor(new Color(11,152,208));
                break;
            case "4":
                g.setColor(new Color(12,66,100));
                break;
            case "5":
                g.setColor(new Color(255,222,23));
                break;
            default:
                break;
        }
        int xDigital, yDigital;

        xDigital = 60 + (int)(Math.round(x*6));
        yDigital = h/2 - (int)(Math.round(y*60));

        g.fillOval(xDigital-3, yDigital-3, 6, 6); 
    }
}	
