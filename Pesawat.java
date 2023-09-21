import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Pesawat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pesawat extends Actor
{
    /**
     * Act - do whatever the Pesawat wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    
    
    String name;
    
    private int kecepatan = 3;
    
    public Pesawat(){
        GreenfootImage img = this.getImage();
        img.scale(20, 20);
        this.setImage(img);
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void act()
    {   
        System.out.println(" -->" + this.getRotation());
        
        int xPos = this.getX();
        int yPos = this.getY();
        
        System.out.print("pesawat " + this.name + " x:" + xPos + " y:" + yPos);
        System.out.println(" -->Menabrak objek " + this.isTouching(Pesawat.class));
        
        move(kecepatan);
        
        if (isAtEdge()) {
            turn(180);
        }
        
        if (this.isTouching(Pesawat.class)) {
            for (Pesawat other : getIntersectingObjects(Pesawat.class)) {
                if (other != this && this.getName().startsWith("player") && other.getName().startsWith("player")) {
                    if (this.getName().equals("player1") && other.getName().equals("player2")) {
                        Skull skull1 = new Skull();
                        getWorld().addObject(skull1, getX(), getY());
                        getWorld().removeObject(this);
                        
                        Skull skull2 = new Skull();
                        getWorld().addObject(skull2, other.getX(), other.getY());
                        getWorld().removeObject(other);
                    }
                }
            }
        }
        
        if (this.getName().equals("player1") || this.getName().equals("player2")) {
            checkDistance(0); 
        } else if (this.getName().equals("player3") || this.getName().equals("player4")) {
            checkDistance(100); 
        }
    }
    
    private void checkDistance(int minDistance) {
        for (Pesawat other : getWorld().getObjects(Pesawat.class)) {
            if (other != this && getDistance(other) < minDistance) {
                turn(180);
            }
        }
    }
    
    private double getDistance(Pesawat other) {
        int x1 = getX();
        int y1 = getY();
        int x2 = other.getX();
        int y2 = other.getY();
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    } 
}