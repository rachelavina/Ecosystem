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
public class Grasshopper extends Animal {
    private int size;
    private Color color;
    private ImageIcon ii;
    private Image img;
    
    

    public Grasshopper(int size) {
        super();
        this.size = size;
        this.color = new Color(255, 0, 100, 100);
        this.ii = new ImageIcon(getClass().getResource("/Images/grasshopper(2).png"));
        this.img = ii.getImage();
        super.setPopulation(20);
        super.setChainPosition(5);
        super.setVx(3);
        super.setVy(3);

        //x = (int) Math.random() * 100;
        //y = (int) Math.random() * 100;
        
        /*
        use this to set the animals at different starting positions
        */
        //x = (int) Math.random() * 700;
        //y = (int) Math.random() * 700;
        
    }
    
    public Grasshopper() {
        this(50);
    }
    
    @Override
    public void draw(Graphics g) {
        //g.fillOval(x, y, size, size);
        //g.setColor(Color.GREEN);
        g.drawImage(img, x, y, size, size, null);
    }
    
    /*@Override
    public void eaten() {
        die();
    }*/
    
    
}