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
    public int timer = 10;
    public String textshowing = "Slap Invalid";
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
    public ArrayList getPlayerCard(){
        return playerCard;
    }
    public ArrayList getComputerCard(){
        return computerCard;
    }
    public void setPlayersTurn(boolean value){
        playersturn = value;
    }
    public void placeCardDown(ArrayList<card> list){
        card drawnCard = list.remove(0);
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
    public void slapWin(ArrayList<card> list){
        for (int i = 0; i < cardInPile.size(); i++){
            list.add(cardInPile.get(i));
        }
        cardInPile.clear();
    }
    public void slapLose(ArrayList<card> list){
        cardInPile.add(0, list.remove(list.size()-1));
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
                return true;
                //if (cardInPile.get(cardInPile.size() - 1).getSuit() == cardInPile.get(cardInPile.size()-3).getSuit()){
                   // return true;
                //}
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
    public boolean isSpecial(){
        if (cardInPile.get(cardInPile.size() - 1).getRank() >= 10){
            return true;
        }
        return false;
    }
    public boolean ifSpecialCard(ArrayList<card> list){
        int count = 0;
        if (cardInPile.get(cardInPile.size() - 1).getRank() == 10){ // jack
            count = 1;
        }
        else if (cardInPile.get(cardInPile.size() - 1).getRank() == 11){ // queen
            count = 2;
        }
        else if (cardInPile.get(cardInPile.size() - 1).getRank() == 12){ // king
            count = 3;
        }
        else if (cardInPile.get(cardInPile.size() - 1).getRank() == 13){ // ace
            count = 4;
        }
        while (count > 0){
            placeCardDown(list);
            count--;
            if (isSpecial()){
                return true;
            }
        }
        return false;
    }
}
