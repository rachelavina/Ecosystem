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
public class Grass extends Plant {
    private int size;
    private Color color;
    private ImageIcon ii;
    private Image img;
    
    public Grass(int size)  {
        super();
        this.size = size;
        this.color = new Color(255, 0, 100, 100);
        this.ii = new ImageIcon(getClass().getResource("/Images/grass(3).png"));
        this.img = ii.getImage();
        super.setPopulation(10);
        super.setVx(30);
        super.setVy(30);
        super.setHeterozygous(true);
        super.setSunNeeded(5);
        super.setTasty(false);
        //super.setX((int) Math.random() * 60);
        //super.setY((int) Math.random() * 60);
    }
    
    public Grass()  {
       this(40);
    }
    
    
    public void draw(Graphics g) {
        //g.fillOval(x, y, size, size);
        //g.setColor(Color.blue);
        g.drawImage(img, x, y, size, size, null);
    }
    
    @Override
    public void eaten() {
        die();
    }
}