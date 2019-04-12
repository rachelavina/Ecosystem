/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulation;

/**
 *
 * @author 628972
 */
public abstract class Plant extends Organism {
    private boolean heterozygous;
    private boolean winter;
    private boolean tasty;
    private double plantSize;
    private boolean poisonous;
    private int sunNeeded;
    private double nutrients;
    private boolean isEdible;
    

    
        public boolean decideEdible()  {
            if (tasty == true) {
                isEdible = true;
            }
            return isEdible;
        }
    
    public void setIsEdible(boolean isEdible) {
        this.isEdible = isEdible;
    }

    public boolean isHeterozygous() {
        return heterozygous;
    }

    public void setHeterozygous(boolean heterozygous) {
        this.heterozygous = heterozygous;
    }

    public boolean isWinter() {
        return winter;
    }

    public void setWinter(boolean winter) {
        this.winter = winter;
    }

    public boolean isTasty() {
        return tasty;
    }

    public void setTasty(boolean tasty) {
        this.tasty = tasty;
    }

    public double getPlantSize() {
        return plantSize;
    }

    public void setPlantSize(double plantSize) {
        this.plantSize = plantSize;
    }

    public boolean isPoisonous() {
        return poisonous;
    }

    public void setPoisonous(boolean poisonous) {
        this.poisonous = poisonous;
    }

    public int getSunNeeded() {
        return sunNeeded;
    }

    public void setSunNeeded(int sunNeeded) {
        this.sunNeeded = sunNeeded;
    }

    public double getNutrients() {
        return nutrients;
    }

    public void setNutrients(double nutrients) {
        this.nutrients = nutrients;
    }

    public void grow()  {
        
    }
    public void absorbNutrients()    {
        
    }
    public void overGrow()  {
        
    }
    @Override
     public void update(){
        vx = 0;
        vy = 0;
    }
}
