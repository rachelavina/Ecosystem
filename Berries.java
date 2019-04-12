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
public class Berries extends Plant {
    private int size;
    private Color color;
    private ImageIcon ii;
    private Image img;
    
    public Berries(int size)  {
        super();
        this.size = size;
        this.color = new Color(255, 0, 100, 100);
        this.ii = new ImageIcon(getClass().getResource("/Images/berries.png"));
        this.img = ii.getImage();
        super.setPopulation(10);
        super.setVx(30);
        super.setVy(30);
        super.setTasty(true);
        //super.setPoisonous(true);
        super.setSunNeeded(3);
        //super.setX((int) Math.random() * 60);
        //super.setY((int) Math.random() * 60);
    }
    
    public Berries()  {
       this(40);
    }
    
    
    public void draw(Graphics g) {
        //g.fillOval(x, y, size, size);
        //g.setColor(Color.RED);
        g.drawImage(img, x, y, size, size, null);
    }
    
    @Override
    public void eaten() {
        die();
    }
}