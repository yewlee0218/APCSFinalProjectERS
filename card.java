import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.util.ArrayList;

/**
 * Write a description of class card here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class card extends Actor
{
    private int suit;
    private int rank;
    private GreenfootImage card;
    /**
     * Act - do whatever the card wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    public card(int rank, int suit){
        this.rank = rank;
        this.suit = suit;
        card = new GreenfootImage(convertRank(rank) + "_of_" + convertSuit(suit) + ".png");
    }
    private String convertRank(int rank){
        String s = "";
        if (rank < 10){
            rank++;
            s = Integer.toString(rank);
        }
        else if (rank == 10){
            s = "jack";
        }
        else if (rank == 11){
            s = "queen";
        }
        else if (rank == 12){
            s = "king";
        }
        else{
            s = "ace";
        }
        return s;
    }
    private String convertSuit(int suit){
        String s = "";
        if (suit == 0){
            s = "clubs";
        }
        else if (suit == 1){
            s = "diamonds";
        }
        else if (suit == 2){
            s = "hearts";
        }
        else{
            s = "spades";
        }
        return s;
    }
    public int getRank(){
        return rank;
    }
    public int getSuit(){
        return suit;
    }
    public void drawACard(){
        setImage(card);
    }
}
