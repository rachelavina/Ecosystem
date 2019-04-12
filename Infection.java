/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulation;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author 628972
 */
public abstract class Infection extends Organism{
    private boolean hasDna;
    
    public void infect(boolean sick)   {
        sick = true;
    }
    @Override
     public void update(){
        move();
    }
}
