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
    public boolean slapValid = true;
    public boolean playersturn = true;
    public boolean hasSlapped = false;
    public int timer = 100;
    public String textshowing = "Slap Invalid";
    public int specialCardCount = 0; 
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
        slapValid = true;
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
        showText("Slap Invalid", 500, 150);
        Greenfoot.delay(100);
        showText("", 500, 150);
     }
    public boolean marriage(){
        if (cardInPile.size() > 1){
            if (ifQueenAndKing(cardInPile.get(cardInPile.size() - 1), cardInPile.get(cardInPile.size() - 2))){
                return true;
            }
        }
        return false;
    }
    public boolean divorce(){
        if (cardInPile.size() > 2){
            if (ifQueenAndKing(cardInPile.get(cardInPile.size() - 1), cardInPile.get(cardInPile.size() - 3))){
                return true;
            }
        }
        return false;
    }
    public boolean ifQueenAndKing(card a, card b){
        if ((a.getRank() == 11 || a.getRank() == 12) && (b.getRank() == 11 || b.getRank() == 12)){
            return true;
        }
        return false;
    }
    public boolean sandwich(){
        if (cardInPile.size() > 2){
            if (sameCard(cardInPile.get(cardInPile.size() - 1), cardInPile.get(cardInPile.size() - 3))){
                return true;
            }
        }
        return false;
    }
    public boolean couple(){
        if (cardInPile.size() > 1){
            if (sameCard(cardInPile.get(cardInPile.size() - 1), cardInPile.get(cardInPile.size() - 2))){
                return true;
            }
        }
        return false;
    }
    public boolean sameCard(card a, card b){
        if (a.getRank() == b.getRank()){
            return true;
        }
        return false;
    }
    public boolean redTen(){
        card top = cardInPile.get(cardInPile.size() - 1);
        if ((top.getRank() == 9) && (top.getSuit() == 1 || top.getSuit() == 2)){
            return true;
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
        if (cardInPile.get(cardInPile.size() - 1).getRank() == 10){ // jack
            specialCardCount = 1;
        }
        else if (cardInPile.get(cardInPile.size() - 1).getRank() == 11){ // queen
            specialCardCount = 2;
        }
        else if (cardInPile.get(cardInPile.size() - 1).getRank() == 12){ // king
            specialCardCount = 3;
        }
        else if (cardInPile.get(cardInPile.size() - 1).getRank() == 13){ // ace
            specialCardCount = 4;
        }
        while (specialCardCount > 0){
            if (!isPlayersTurn()){
                placeCardDown(list);
                Greenfoot.delay(50);
                specialCardCount--;
            }
            else{
                showText("Must place" + specialCardCount + "\nmore cards.", 500, 150);
                Greenfoot.delay(100);
                showText("", 500, 150);
            }
            if (isSpecial()){
                return true;
            }
        }
        return false;
    }
}
