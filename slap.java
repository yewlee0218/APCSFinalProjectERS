import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class slap here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class slap extends Actor
{
    private int timer = 100;
    /**
     * Act - do whatever the slap wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {   
        MyWorld w = (MyWorld)getWorld();
        boolean turn = w.isPlayersTurn();
        if (turn == false){
            if (timer > 0){
                w.showText("Waiting...", 100, 100);
                timer--;
            }
            else{
                w.showText("", 100, 100);
                if ((w.cardInPile.size() > 0) && (w.isSpecial())){
                    boolean check = w.ifSpecialCard(w.getComputerCard());
                    if (!check){
                        w.slapWin(w.getPlayerCard());
                    }
                }
                else{
                    w.placeCardDown(w.getComputerCard());
                }
                w.setPlayersTurn(true);
                timer = 100;
            }
        }
        else {
            if (Greenfoot.mousePressed(this)){
                if ((w.cardInPile.size() > 0) && (w.isSpecial())){
                    boolean check = w.ifSpecialCard(w.getPlayerCard());
                    if (!check){
                        w.slapWin(w.getComputerCard());
                    }
                    //w.setPlayersTurn(false);
                }
                else{
                    w.placeCardDown(w.getPlayerCard());
                    //w.specialCardCount--;
                    //if (w.ifSpecialCard(w.getPlayerCard()) == false){
                        //w.setPlayersTurn(true);
                    //}
                    //else{
                        //w.setPlayersTurn(false);
                    //}
                }
                w.setPlayersTurn(false); //i wanted to comment this out
            }
        }      
    }
}
