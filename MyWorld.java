import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public ArrayList<card> deck;
    public ArrayList<card> cardInPile = new ArrayList<>();
    public ArrayList<card> computerCard = new ArrayList<>();
    public ArrayList<card> playerCard = new ArrayList<>();
    public int cardNumInPile = 0;
    public boolean playersturn = true;
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
        initializeDeck();
        distributeCards();
        
    }
    public void placeCardDownPlayer(){
        card drawnCard = playerCard.remove(0);
        cardInPile.add(drawnCard);
        cardNumInPile++;
        drawnCard.drawACard();
    }
    public void placeCardDownComputer(){
        card drawnCard = computerCard.remove(0);
        cardInPile.add(drawnCard);
        cardNumInPile++;
        drawnCard.drawACard();
    }
    private void initializeDeck(){
        deck = new ArrayList<>();
        for (int suit = 0; suit <= 3; suit++){
            for (int rank = 1; rank <= 13; rank++){
                deck.add(new card(rank, suit));
            }
        }
    }
    private void distributeCards(){
        for (int i = 0; i < 26; i++){
            int random = (int)(Math.random() * deck.size());
            playerCard.add(deck.remove(random));
        }
        for (int j = 0; j < 26; j++){
            int random2 = (int)(Math.random() * deck.size());
            computerCard.add(deck.remove(random2));
        }
    }
    
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        card card = new card(5, 2);
        addObject(card,247,182);
        computer computer = new computer();
        addObject(computer,267,38);
        player player = new player();
        addObject(player,262,337);
        slap slap = new slap();
        addObject(slap,377,344);
    }
}
