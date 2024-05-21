import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NineOfSpades here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NineOfSpades extends card
{
    public NineOfSpades(int x, int y){
        super(x,y);
        GreenfootImage image = getImage();
        image.scale(image.getWidth() / 500 * 60, image.getHeight()/726 * 80);
        setImage(image);
    }
    /**
     * Act - do whatever the NineOfSpades wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
