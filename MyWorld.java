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
    public boolean playersturn = true;
    public boolean hasSlapped = false;
    private int timer = 100; 
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
        initializeDeck();
        distributeCards();
        
    }
    public boolean isPlayersTurn(){
        return playersturn;
    }
    public void setPlayersTurn(boolean value){
        playersturn = value;
    }
    public void placeCardDownPlayer(){
        card drawnCard = playerCard.remove(0);
        cardInPile.add(drawnCard);
        addObject(drawnCard, 247, 182);
        drawnCard.drawACard();
    } 
    public void placeCardDownComputer(){
        card drawnCard = computerCard.remove(0);
        cardInPile.add(drawnCard);
        addObject(drawnCard, 247, 182);
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
    public void slapWin(){
        if (isPlayersTurn()){
            for (int i = 0; i < cardInPile.size(); i++){
                playerCard.add(cardInPile.get(i));
            }   
        }
        else{
            for (int i = 0; i < cardInPile.size(); i++){
                computerCard.add(cardInPile.get(i));
            }  
        }
        cardInPile.clear();
    }
    public void slapLose(){
        if (isPlayersTurn()){
            cardInPile.add(0, playerCard.remove(playerCard.size() - 1));
        }
        else{
            cardInPile.add(0, computerCard.remove(computerCard.size()-1));
        }
        if (timer > 0){
            showText("Slap Invalid", 500, 150);
            timer--;
        }
        else{
            showText("", 100, 100);
            timer = 100;
        }
    }
    public boolean marriage(){
        if (cardInPile.size() > 1){
            if (cardInPile.get(cardInPile.size() - 1).getRank() == 11){
                if (cardInPile.get(cardInPile.size() - 2).getRank() == 12){
                    return true;
                }
            }
            else if (cardInPile.get(cardInPile.size()-1).getRank() == 12){
                if (cardInPile.get(cardInPile.size() - 2).getRank() == 11){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean divorce(){
        if (cardInPile.size() > 2){
            if (cardInPile.get(cardInPile.size() - 1).getRank() == 11){
                if (cardInPile.get(cardInPile.size() - 3).getRank() == 12){
                    return true;
                }
            }
            else if (cardInPile.get(cardInPile.size() - 1).getRank() == 12){
                if (cardInPile.get(cardInPile.size() - 3).getRank() == 11){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean sandwich(){
        if (cardInPile.size() > 2){
            if (cardInPile.get(cardInPile.size() - 1).getRank() == cardInPile.get(cardInPile.size()- 3).getRank()){
                if (cardInPile.get(cardInPile.size() - 1).getSuit() == cardInPile.get(cardInPile.size()-3).getSuit()){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean couple(){
        if (cardInPile.size() > 1){
             if (cardInPile.get(cardInPile.size()-1).getRank() == cardInPile.get(cardInPile.size() - 2).getRank()){
                if (cardInPile.get(cardInPile.size() - 1).getSuit() == cardInPile.get(cardInPile.size() - 2).getSuit()){
                    return true;
                }
            }
        }
        return false;
    }
    private void prepare()
    {
        card card = new card(5, 2);
        addObject(card,247,182);
        computer computer = new computer();
        addObject(computer,267,38);
        player player = new player();
        addObject(player,262,337);
        slap slap = new slap();
        addObject(slap,371,345);
    }
    
}
