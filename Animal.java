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
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author 628972
 */
public abstract class Animal extends Organism{
    private int chainPosition;
    private String gender;
    private boolean isEndangered;
    private double animalSize;
    private boolean poisonous;


    
    //getters and setters
    public int getChainPosition() {
        return chainPosition;
    }

    public void setChainPosition(int chainPosition) {
        this.chainPosition = chainPosition;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isIsEndangered() {
        return isEndangered;
    }

    public void setIsEndangered(boolean isEndangered) {
        this.isEndangered = isEndangered;
    }

    public double getAnimalSize() {
        return animalSize;
    }

    public void setAnimalSize(double animalSize) {
        this.animalSize = animalSize;
    }

    public boolean isPoisonous() {
        return poisonous;
    }

    public void setPoisonous(boolean poisonous) {
        this.poisonous = poisonous;
    }
    
    //methods
    
    
    public void getSick()   {
        
    }
    public void fight() {
        
    }
    public void grow()  {
        
    }
    public void collide()   {
        fight();
    }
    @Override
     public void update(){
        move();
    }
}
