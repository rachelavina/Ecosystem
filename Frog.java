/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author 628972
 */
public class Frog extends Animal {
    private int size;
    private Color color;
    private ImageIcon ii;
    private Image img;
    
    public Frog(int size) {
        super();
        this.size = size;
        this.color = new Color(255, 0, 100, 100);
        this.ii = new ImageIcon(getClass().getResource("/Images/frog(2).png"));
        this.img = ii.getImage();
        super.setPopulation(10);
        super.setChainPosition(3);
        super.setVx(3);
        super.setVy(3);
        //super.setX(130);
        //super.setY(130);
        //x = (int) Math.random() * 100;
        //y = (int) Math.random() * 100;
        //x = (int) Math.random() * 700;
        //y = (int) Math.random() * 700;
        
    }
    
    public Frog() {
        this(50);
    }
    
    @Override
    public void draw(Graphics g) {
        //g.fillOval(x, y, size, size);
        //g.setColor(Color.RED);
        g.drawImage(img, x, y, size, size, null);
    }
    
    /*@Override
    public void eaten() {
        die();
    }*/

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
  
}