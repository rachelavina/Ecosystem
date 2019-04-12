/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author 628972
 */


public abstract class Organism implements Food{
    //Fields
    protected int x;
    protected int y;
    protected int vx;
    protected int vy;
    protected int size;
    private int population;
    private int lifespan;
    private int years;
    private double location;
    private int survivalAbility;
    private boolean sick;
    private boolean spawn;
    private final int dx = 0;
    private final int dy = 0;





    //Constructor
    public Organism(int x, int y) {
        this.x = y;
        this.y = x;
        this.vx = vx;
        this.vy = vy;
    }

    public Organism() {
       this((int) (Math.random() * 900), (int) (Math.random() *900));
    }

    public abstract void draw(Graphics g);
    
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getVx() {
        return vx;
    }

    public void setVx(int vx) {
        this.vx = vx;
    }

    public int getVy() {
        return vy;
    }

    public void setVy(int vy) {
        this.vy = vy;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getLifespan() {
        return lifespan;
    }

    public void setLifespan(int lifespan) {
        this.lifespan = lifespan;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public double getLocation() {
        return location;
    }

    public void setLocation(double location) {
        this.location = location;
    }

    public int getSurvivalAbility() {
        return survivalAbility;
    }

    public void setSurvivalAbility(int survivalAbility) {
        this.survivalAbility = survivalAbility;
    }

    public boolean isSick() {
        return sick;
    }

    public void setSick(boolean sick) {
        this.sick = sick;
    }

    public boolean isSpawn() {
        return spawn;
    }

    public void setSpawn(boolean spawn) {
        this.spawn = spawn;
    }

    
    
    //methods
    
    public void reproduce() {
        population +=5;
    }
    
    public void die()   {
        x = -500;
        y = -500;
        vx = 0;
        vy = 0;
        
        
    }
    
    public void adapt() {
        survivalAbility++;
    }
    
    public void age()    {
        lifespan --;
    }
    
    public void overPopulate()   {
        population +=30;
    }
    
    public abstract void update();
        //move()
    
    public void move() {
        x += vx;
        y += vy;
    }
    public void wallCollisions()    {
        if(x <= 5)    {
            vx = 3;
        }
        if(x >= 1135 || x + 50 >= 1150)    {
            vx = -3;
        }
        if(y <= 5)    {
            vy = 3;
        }
        if(y >= 800 || y + 50 >= 800)    {
            vy = -3;
        }
    }
    public void spawn() {
        x = (int) (Math.random() * 1000);
        y = (int) (Math.random() * 700);
        spawn = true;
        
    }
    
    @Override
    public void eaten ()    {
        die();
    }

}
