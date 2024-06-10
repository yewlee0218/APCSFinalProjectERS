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
    private int beginning = 1;
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
                        w.slapWin(w.getPlayerCard(), "No Special Card");
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
                if (w.cardInPile.size() > 0){
                    if (beginning == 1){
                        boolean checkSpecial = w.ifSpecialCard(w.getPlayerCard());
                        beginning = 0; 
                        w.placeCardDown(w.getPlayerCard());
                        if ((w.cardInPile.get(w.cardInPile.size()-2).getRank()) >= 10 && w.isSpecial() == false){
                            w.specialCardCount--; 
                            if (w.specialCardCount > 0){
                                w.showText("Must place " + (w.specialCardCount) + "\nmore cards.", 500, 150);
                                w.setPlayersTurn(true);
                            }
                            else{
                                computersTurn(w);
                            }
                        }
                        else {
                            computersTurn(w);
                        }
                    }
                    else {
                        w.placeCardDown(w.getPlayerCard());
                        if (w.isSpecial() == true){
                            computersTurn(w);
                            w.showText("", 500, 150);
                        }
                        else if (w.specialCardCount > 0){
                            w.specialCardCount--;
                            w.setPlayersTurn(true);
                            w.showText("Must place " + w.specialCardCount + "\nmore cards.", 500, 150);
                        }
                        else{
                            w.slapWin(w.getComputerCard(), "No Special Card");
                            computersTurn(w);
                        }
                    }
                }
                //very start of the game:
                else{
                    w.placeCardDown(w.getPlayerCard());
                    w.setPlayersTurn(false);
                }
            }
        }      
    }
    public void computersTurn(MyWorld world){
        world.setPlayersTurn(false);
        beginning = 1;
    }
}
