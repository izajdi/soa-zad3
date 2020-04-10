package Uno;

import javax.swing.*;
import java.util.*;

public class UnoDeck {
    private UnoCard []cards;
    private int cardsInDeck;
    public UnoDeck(){
        cards = new UnoCard[108];
    }
    public void reset(){
        UnoCard.Color []colors = UnoCard.Color.values();
        UnoCard.Value []values = UnoCard.Value.values();
        cardsInDeck =0;
        for(int i=0; i<colors.length -1; i++){
            UnoCard.Color color = colors[i];
            cards[cardsInDeck++] = new UnoCard(color, UnoCard.Value.getValue(0));
            for(int j=1; j<values.length-2; j++){
                cards[cardsInDeck++] = new UnoCard(color, values[j]);
                cards[cardsInDeck++] = new UnoCard(color, values[j]);
            }
            UnoCard.Value []wildVaules = new UnoCard.Value[]{UnoCard.Value.Wild, UnoCard.Value.Wild_Four};
            for(int x=0; x<2; x++){
                cards[cardsInDeck++] = new UnoCard(UnoCard.Color.Wild, wildVaules[x]);
            }
        }
    }

    public void replaceDeckWith(ArrayList<UnoCard> newDeck){
        this.cards = newDeck.toArray(new UnoCard[newDeck.size()]);
        this.cardsInDeck = cards.length;
    }

    public boolean isEmpty(){
        return cardsInDeck == 0;
    }

    public void printDeck(){
        for(int i=0; i< cards.length; i++){
            System.out.println(cards[i].toString());
        }
    }

    public void shuffle() {
        Random random = new Random();
        for(int i=0; i<cards.length; i++){
            int randomInt = i + random.nextInt(cards.length - i);
            UnoCard randomCard = cards[randomInt];
            cards[randomInt] = cards[i];
            cards[i] = randomCard;
        }
    }
    public UnoCard drawCard() throws IllegalArgumentException{
        if(isEmpty()){
            throw new IllegalArgumentException("Deck is empty");
        }
        return cards[--cardsInDeck];
    }

    public ImageIcon drawCardImage() throws IllegalArgumentException{
        if(isEmpty()){
            throw new IllegalArgumentException("Deck is empty");
        }
        ImageIcon ii = new ImageIcon(cards[--cardsInDeck].toString() + ".png");
        return ii;

    }

    public UnoCard[] drawCard(int n) throws IllegalArgumentException{
        if(isEmpty()){
            throw new IllegalArgumentException("Deck is empty");
        }
        if(n > cardsInDeck){
            throw new IllegalArgumentException("There is not enough cards in the deck");
        }
        UnoCard []result = new UnoCard[n];
        for(int i=0; i<n; i++){
            result[i] = cards[--cardsInDeck];
        }
        return result;
    }


    public static void main(String []args){
        UnoDeck deck = new UnoDeck();
        deck.reset();
        deck.shuffle();
        deck.printDeck();
    }

}
