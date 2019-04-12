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
public class Bacteria extends Infection{
    private int size;
    private boolean antibiotic;
    private Color color;
    private ImageIcon ii;
    private Image img;
    
    public Bacteria(int size)  {
        super();
        this.size = size;
         this.color = new Color(255, 0, 100, 100);
        this.ii = new ImageIcon(getClass().getResource("/Images/bacteria2.png"));
        this.img = ii.getImage();
        super.setPopulation(10);
        super.setVx(3);
        super.setVy(3);
    }
    
    public Bacteria()  {
        this(25);
    }
    
    //@Override
    public void draw(Graphics g) {
        //g.fillOval(x, y, size, size);
        //g.setColor(Color.PINK);
        g.drawImage(img, x, y, size, size, null);
    }
}
