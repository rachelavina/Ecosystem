/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author jword
 */
public class Ecosystem extends JPanel {

    private Timer timer;
    private ArrayList<Bacteria> bacterias;
    private ArrayList<Virus> viruses;
    private ArrayList<Plant> plants;
    private ArrayList<Grasshopper> grasshoppers;
    private ArrayList<Rat> rats;
    private ArrayList<Frog> frogs;
    private ArrayList<Snake> snakes;
    private ArrayList<Eagle> eagles;
        
    public Ecosystem() {
        super();
        setSize(1200, 960);
        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduleTask(), 1000, 1000/24);
       
        
      grasshoppers = new ArrayList<>();
      rats = new ArrayList<>();
      frogs = new ArrayList<>();
      snakes = new ArrayList<>();
      eagles = new ArrayList<>();
      bacterias = new ArrayList<>();
      viruses = new ArrayList<>();
      plants = new ArrayList<>();
        for (int i = 0; i < 10; i++) {

            if (i % 5 == 0) {
                grasshoppers.add(new Grasshopper());
                bacterias.add(new Bacteria());
            }
            if (i % 5 == 1) {
                rats.add(new Rat());
                viruses.add(new Virus());
            }
            if (i % 5 == 2) {
                frogs.add(new Frog());
                bacterias.add(new Bacteria());
            }
            if (i % 5 == 3) {
                snakes.add(new Snake());
                viruses.add(new Virus());
            }
            if (i % 5 == 4) {
                eagles.add(new Eagle());
            }
        }  
        
        for (int i = 0; i < 30; i++) {
            if (i % 5 == 1) {
                plants.add(new Berries());
            }
            if (i % 5 == 2) {
                plants.add(new Grass());  
            }
            if (i % 5 == 3) {
                plants.add(new Grain());  
            }
        }
        
        /*
        Grasshoppers, rats, frogs, snakes, and eagles all live in one ecosystem.
        Animals only eat the animal below them, otherwise they bounce off of other animals.
        A virus or bacteria kills an animal, but only a virus dies with its host.
        Species can reproduce, but if they go over the carrying capacity, then natural selection causes some to die.
        Plants grow in the beginning, but are only eaten if they taste good.
        */
        
    }
    
    
    
            
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        for(Grasshopper grasshopper : grasshoppers) {
            grasshopper.draw(g);   
        }
        
        for(Rat rat : rats)   {
            rat.draw(g);
        }
        
        for(Frog frog : frogs)   {
            frog.draw(g);  
        }
        
        for(Snake snake : snakes)   {
            snake.draw(g);           
        }
        
        for(Eagle eagle : eagles)   {
            eagle.draw(g);
        }
        
        for (Bacteria bacteria : bacterias) {
            bacteria.draw(g);
        }
        
        for (Virus virus: viruses)  {
            virus.draw(g);
        }
        
        for (Plant plant : plants) {
            plant.draw(g);
        }
        
    }
    
    
    
    private class ScheduleTask extends TimerTask {
    
        @Override
        public void run() {
            

            for (Grasshopper g : grasshoppers)   {
                
                g.wallCollisions();
                g.update();
            }
            for (Rat r : rats)   {
                r.wallCollisions();
                r.update();
            }
            for (Frog f : frogs)  {
                f.wallCollisions();
                f.update();
            }
            for (Snake s : snakes)  {
                s.wallCollisions();
                s.update();
            }
            for (Eagle e : eagles)  {
                e.wallCollisions();
                e.update();
            }
            
            for (Bacteria b : bacterias)    {
                b.wallCollisions();
                b.update();
            }
            
            for (Virus v : viruses) {
                v.wallCollisions();
                v.update();
            }
            for (Plant p : plants) {
                p.setVx(0);
                p.setVy(0);
            }

  
            
            for (Grasshopper g : grasshoppers) {
                for (Rat r : rats)  {
                    animalEncounter(g,r);
                }
            }
            for (Grasshopper g : grasshoppers) {
                for (Frog f : frogs)  {
                    animalBounce(g,f);
                }
            }
            for (Grasshopper g : grasshoppers) {
                for (Snake s : snakes)  {
                    animalBounce(g,s);
                }
            }
            for (Grasshopper g : grasshoppers) {
                for (Eagle e : eagles)  {
                    animalBounce(g,e);
                }
            }
            for (Rat r : rats)  {
                for (Frog f : frogs)    {
                    animalEncounter(r,f);
                }
            }
            for (Rat r : rats)  {
                for (Snake s : snakes)    {
                    animalBounce(r,s);
                }
            }
            for (Rat r : rats)  {
                for (Eagle e : eagles)    {
                    animalBounce(r,e);
                }
            }
            for (Frog f : frogs)  {
                for (Snake s : snakes)    {
                    animalEncounter(f,s);
                }
            }
            for (Frog f : frogs)  {
                for (Eagle e : eagles)    {
                    animalBounce(f,e);
                }
            }
            for (Snake s : snakes)  {
                for (Eagle e : eagles)    {
                    animalEncounter(s,e);
                }
            }

            
            // this is one group versus itself
            for (int i = 0; i < grasshoppers.size(); i++) {
              for (int j = i + 1; j < grasshoppers.size(); j++)    {
              grasshopperReproduce(grasshoppers.get(i), grasshoppers.get(j));
              if (grasshoppers.size() > 20) {
                      grasshoppers.remove(j);
                  }
            }
            }
            
            for (int i = 0; i < rats.size(); i++) {
              for (int j = i + 1; j < rats.size(); j++)    {
              ratReproduce(rats.get(i), rats.get(j));
              if (rats.size() > 15) {
                      rats.remove(j);
                  }
            }
            }
            
            for (int i = 0; i < frogs.size(); i++) {
              for (int j = i + 1; j < frogs.size(); j++)    {
              frogReproduce(frogs.get(i), frogs.get(j));
                  if (frogs.size() > 10) {
                      frogs.remove(j);
                  }
            }
            }
            
            for (int i = 0; i < snakes.size(); i++) {
              for (int j = i + 1; j < snakes.size(); j++)    {
              snakeReproduce(snakes.get(i), snakes.get(j));
              if (snakes.size() > 5) {
                      snakes.remove(j);
                  }
            }
            }
            
            for (int i = 0; i < eagles.size(); i++) {
              for (int j = i + 1; j < eagles.size(); j++)    {
              eagleReproduce(eagles.get(i), eagles.get(j));
              if (eagles.size() > 3) {
                      eagles.remove(j);
                  }
            }
            }
            
            for (int i = 0; i < bacterias.size(); i++)  {
                for (int j = i + 1; j < bacterias.size(); j++) {
                bacteriaReproduce(bacterias.get(i), bacterias.get(j)); 
                if (bacterias.size() > 10) {
                      bacterias.remove(j);
                  }
            }
            }
            
            for (int i = 0; i < viruses.size(); i++)  {
                for (int j = i + 1; j < viruses.size(); j++) {
                virusReproduce(viruses.get(i), viruses.get(j));
                if (viruses.size() > 10) {
                      viruses.remove(j);
                  }
            }
            }
           
           
            for (Grasshopper g : grasshoppers) {
                for (Virus v : viruses) {
                    spreadVirus(v, g);
                }
            }
           for (Grasshopper g : grasshoppers) {
                for (Bacteria b : bacterias) {
                    spreadBacteria(b, g);
                }
            }
            for (Rat r : rats) {
                for (Virus v : viruses) {
                    spreadVirus(v, r);
                }
            }
            for (Rat r : rats) {
                for (Bacteria b : bacterias) {
                    spreadBacteria(b, r);
                }
            }
            for (Frog f : frogs) {
                for (Virus v : viruses) {
                    spreadVirus(v, f);
                }
            }
            for (Frog f : frogs) {
                for (Bacteria b : bacterias) {
                    spreadBacteria(b, f);
                }
            }
            for (Snake s : snakes) {
                for (Virus v : viruses) {
                    spreadVirus(v, s);
                }
            }
            for (Snake s : snakes) {
                for (Bacteria b : bacterias) {
                    spreadBacteria(b, s);
                }
            }
            for (Eagle e : eagles) {
                for (Virus v : viruses) {
                    spreadVirus(v, e);
                }
            }
            for (Eagle e : eagles) {
                for (Bacteria b : bacterias) {
                    spreadBacteria(b, e);
                }
            }
           
            
            for (Grasshopper g : grasshoppers) {
                for (Plant p : plants) {
                    eatPlant(p, g);
                }
            }
            
            for (Rat r : rats) {
                for (Plant p : plants) {
                    eatPlant(p, r);
                }
            }
            
            for (Frog f : frogs) {
                for (Plant p : plants) {
                    eatPlant(p, f);
                }
            }
            
            for (Snake s : snakes) {
                for (Plant p : plants) {
                    eatPlant(p, s);
                }
            }
            
            
            for (Eagle e : eagles) {
                for (Plant p : plants) {
                    eatPlant(p, e);
                }
            }
            
            repaint();
        }
    }
    
    
    
    
    public void animalEncounter(Animal obj1, Animal obj2) {
    if(obj1.getX() + 50 > obj2.getX() && obj1.getX() < obj2.getX() + 50 && obj1.getY() + 50 > obj2.getY() && obj1.getY() < obj2.getY() + 50)    {
        if (obj1.getChainPosition() == 1 + obj2.getChainPosition()) {
            obj1.die();
            obj1.setVx(0);
            obj1.setVy(0);
            
        }
        if(obj1.getChainPosition() + 1 == obj2.getChainPosition())  {
            obj2.die();
            obj2.setVx(0);
            obj2.setVy(0);
            
        }
        }
    }
    
     
    private void animalBounce(Animal a1, Animal a2) {
        if(a1.getX() + 50 > a2.getX() && a1.getX() < a2.getX() + 50 && a1.getY() + 50 > a2.getY() && a1.getY() < a2.getY() + 50)    {
            
            /*
            makes the characters bounce off of one another
            could be used for the same species
            or from the beginning to make them spread out more
            */
            int tempVx = a1.getVx();
            int tempVy = a1.getVy();
            a1.setVx(a2.getVx());
            a1.setVy(a2.getVy());
            a2.setVx(tempVx);
            a2.setVy(tempVy);
            a1.move();
            a2.move();
            

        }
    }
    
    
        private void eatPlant(Plant p, Animal a) {
            if (a.getX() + 50 > p.getX() && a.getX() < p.getX() + 40 && a.getY() + 50 > p.getY() && a.getY() < p.getY() + 40) {
                if (p.decideEdible() == true) {
                p.eaten();
                    if (p.isPoisonous() == true) {
                        a.die();
                    }
        }
            }
            
        }
        
    
            
        private void grasshopperReproduce(Grasshopper a1, Grasshopper a2)  {
             if(a1.getX() + 15 >= a2.getX() && a1.getX() < a2.getX() + 15 && a1.getY() + 15 >= a2.getY() && a1.getY() < a2.getY() + 15)    {
                 grasshoppers.add(new Grasshopper());
                 
                 
                 
                }
        }
        private void ratReproduce(Rat a1, Rat a2)  {
             if(a1.getX() + 15 > a2.getX() && a1.getX() < a2.getX() + 15 && a1.getY() + 15 > a2.getY() && a1.getY() < a2.getY() + 15)    {
                 rats.add(new Rat());
                
                 
                }     
            }
        private void frogReproduce(Frog a1, Frog a2)  {
             if(a1.getX() + 15 > a2.getX() && a1.getX() < a2.getX() + 15 && a1.getY() + 15 > a2.getY() && a1.getY() < a2.getY() + 15)    {
                 frogs.add(new Frog());
                
                 
                 
                }     
            }
        private void snakeReproduce(Snake a1, Snake a2)  {
             if(a1.getX() + 15 > a2.getX() && a1.getX() < a2.getX() + 15 && a1.getY() + 15 > a2.getY() && a1.getY() < a2.getY() + 15)    {
                 snakes.add(new Snake());
                
                
                
                }     
            }
        private void eagleReproduce(Eagle a1, Eagle a2)  {
             if(a1.getX() + 15 > a2.getX() && a1.getX() < a2.getX() + 15 && a1.getY() + 15 > a2.getY() && a1.getY() < a2.getY() + 15)    {
                 eagles.add(new Eagle());
                 
                }     
            }
        private void bacteriaReproduce(Bacteria a1, Bacteria a2)  {
             if(a1.getX() + 10 > a2.getX() && a1.getX() < a2.getX() + 10 && a1.getY() + 10 > a2.getY() && a1.getY() < a2.getY() + 10)    {
                 bacterias.add(new Bacteria());
                 
               
                 
                }     
            }
         private void virusReproduce(Virus a1, Virus a2)  {
             if(a1.getX() + 10 > a2.getX() && a1.getX() < a2.getX() + 10 && a1.getY() + 10 > a2.getY() && a1.getY() < a2.getY() + 10)    {
                 viruses.add(new Virus());
                 
                 
                }     
            }
        
        private void dieOff(Organism o, int num, ArrayList thing)   {
            if (num > o.getPopulation()) {
                for (int i = 0; i < num; i++) {
                    if (i >= o.getPopulation()) {
                        //thing.remove(i);
                        
                        
                    
                    }
                }
            }
        }
        
        private void spreadVirus(Virus v, Animal a)    {
            if (a.getX() + 50 > v.getX() && a.getX() < v.getX() + 25 && a.getY() + 50 > v.getY() && a.getY() < v.getY() + 25) {
                a.die();
                v.die();
            }
        }
        private void spreadBacteria(Bacteria b, Animal a)    {
            if (a.getX() + 50 > b.getX() && a.getX() < b.getX() + 25 && a.getY() + 50 > b.getY() && a.getY() < b.getY() + 25) {
                a.die();
            }
        }
        
        private void regrowGrain()   {
            plants.add(new Grain());
        }
        
        private void regrowBerries()   {
            plants.add(new Berries());
        }
        
        private void regrowGrass()   {
            plants.add(new Grass());
        }
        }