import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FirstStage extends World
{
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public FirstStage()
    {    
        super(600, 400, 1); 
        
        Pesawat player1 = new Pesawat();
        this.addObject(player1, 30, 200);
        player1.setName("player1");
        
        Pesawat player2 = new Pesawat();
        player2.setRotation(180);
        player2.setName("player2");
        this.addObject(player2, 570, 200);
        
        Pesawat player3 = new Pesawat();
        player3.setRotation(270);
        player3.setName("player3");
        this.addObject(player3, 300, 370);
        
        Pesawat player4 = new Pesawat();
        player4.setRotation(90);
        player4.setName("player4");
        this.addObject(player4, 300, 30);
    }
}