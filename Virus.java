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
public class Virus extends Infection{
    private int size;
    private Color color;
    private ImageIcon ii;
    private Image img;
    
    public Virus(int size)  {
        super();
        this.size = size;
        this.color = new Color(255, 0, 100, 100);
        this.ii = new ImageIcon(getClass().getResource("/Images/virus(2).png"));
        this.img = ii.getImage();
        super.setPopulation(10);
        super.setVx(5);
        super.setVy(5);
    }
    
    public Virus()  {
        this(25);
    }
    
    
    public void draw(Graphics g) {
        //g.fillOval(x, y, size, size);
        //g.setColor(Color.ORANGE);
        g.drawImage(img, x, y, size, size, null);
    }
}

