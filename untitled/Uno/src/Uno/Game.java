package Uno;

import javax.swing.*;
import java.awt.*;
import java.util.*;



public class Game {
    private int currentPlayer;
    private String[] playerIds;

    private UnoDeck deck;
    private ArrayList<ArrayList<UnoCard>> playerHands;
    private ArrayList<UnoCard> stockpile;
    private UnoCard.Color validColor;
    private UnoCard.Value validValue;

    boolean gameDirection;

    public Game(String []pids){
        this.deck = new UnoDeck();
        deck.shuffle();

        this.playerIds = pids;
        this.currentPlayer = 0;
        this.gameDirection = false;

        this.playerHands = new ArrayList<ArrayList<UnoCard>>();

        for(int i=0; i<pids.length; i++){
            ArrayList<UnoCard> playerHand = new ArrayList<UnoCard>(Arrays.asList(deck.drawCard(7)));
            playerHands.add(playerHand);
        }
    }

    public void start(Game game){
        UnoCard card = deck.drawCard();
        validColor = card.getColor();
        validValue = card.getValue();

        if(card.getValue() == UnoCard.Value.Wild_Four || card.getValue() == UnoCard.Value.DrawTwo){
            start(game);
        }
        if(card.getValue() == UnoCard.Value.Skip){
            JLabel message = new JLabel(playerIds[currentPlayer] + "was skipped!");
            message.setFont(new Font("Arial", 1, 48));
            JOptionPane.showMessageDialog(null, message);

            if(gameDirection == false){
                currentPlayer = (currentPlayer + 1) % playerIds.length;
            }
            if(gameDirection == true){
                currentPlayer = (currentPlayer - 1) % playerIds.length;
                if(currentPlayer == -1){
                    currentPlayer = playerIds.length - 1;
                }
            }
        }
        if(card.getValue() == UnoCard.Value.Reverse){
            JLabel message = new JLabel("Direction has changed!");
            message.setFont(new Font("Arial", 1, 48));
            JOptionPane.showMessageDialog(null, message);

            gameDirection ^= true;
            currentPlayer = (currentPlayer - 1) % playerIds.length;
        }
        stockpile.add(card);
    }

    public UnoCard getTopCard(){
        return new UnoCard(validColor, validValue);
    }

    public ImageIcon getTopCardIcon(){
        return new ImageIcon(validColor + "-" + validValue + ".png");
    }

    public String getCurrentPlayer(){
        return playerIds[currentPlayer];
    }

    public String getPreviousPlayer(int i){
        int index = (currentPlayer - i) % playerIds.length;
        return playerIds[index];
    }

    public String[] getPlayers(){
        return this.playerIds;
    }

    public ArrayList<UnoCard> getPlayerHand(String pid){
        return playerHands.get(Arrays.asList(playerIds).indexOf(pid));
    }

    public int getPlayerHandSize(String pid){
        return getPlayerHand(pid).size();
    }

    public boolean hasEmptyHand(String pid){
        if(getPlayerHandSize(pid) == 0){
            return true;
        }
        return false;
    }

    public boolean isGameOver(){
        for(String player: this.playerIds){
            if(hasEmptyHand(player)){
                return true;
            }
        }
        return false;
    }

    public boolean validCardPlay(UnoCard card){
        return card.getColor() == validColor || card.getValue() == validValue;
    }

    public void checkPlayerTurn(String pid) throws InvalidPlayerTurnException{
        if(playerIds[currentPlayer] != pid){
            String message = "its not this player turn"
            throw new InvalidPlayerTurnException(message, pid);
        }
    }

    public void submitDraws(String pid) throws InvalidPlayerTurnException{
        checkPlayerTurn(pid);

        if(deck.isEmpty()){
            this.deck.replaceDeckWith(stockpile);
            deck.shuffle();
        }
        getPlayerHand(pid).add(deck.drawCard());
        if(!gameDirection){
            currentPlayer = (currentPlayer + 1) % playerIds.length;
        }
        else {
            currentPlayer = (currentPlayer - 1) % playerIds.length;
            if(currentPlayer == -1){
                currentPlayer = playerIds.length - 1;
            }
        }
    }

    public void setCardColor(UnoCard.Color color) {
        this.validColor = color;
    }

    public void submitPlayerCard(String pid, UnoCard card, UnoCard.Color declaredColor) throws InvalidColorSubmissionException, InvalidPlayerTurnException, InvalidValueSubmissionException{
        checkPlayerTurn(pid);
        ArrayList<UnoCard> pHand = getPlayerHand(pid);
        if(!validCardPlay(card)){
            if(card.getColor() == UnoCard.Color.Wild){
                validColor = card.getColor();
                validValue = card.getValue();
            }

            if(card.getColor() != validColor){
                JLabel message = new JLabel("Invalid player move, expected" + validColor);
                message.setFont(new Font("Arial", 1, 48));
                JOptionPane.showMessageDialog(null, message);
                throw new InvalidColorSubmissionException(message.toString(), validColor, card.getColor());
            }

            if(card.getValue() != validValue){
                JLabel message = new JLabel("Invalid player move, expected" + validValue);
                message.setFont(new Font("Arial", 1, 48));
                JOptionPane.showMessageDialog(null, message);
                throw new InvalidValueSubmissionException(message.toString(), validValue, card.getValue());
            }

        }
        pHand.remove(card);
        if(hasEmptyHand(pid)){
            JLabel message = new JLabel("Thank you for playing." pid + "had won!");
            message.setFont(new Font("Arial", 1, 48));
            JOptionPane.showMessageDialog(null, message);
            System.exit(0);
        }
        validColor = card.getColor();
        validValue = card.getValue();
        stockpile.add(card);
        if(gameDirection){
            currentPlayer = (currentPlayer - 1) % playerIds.length;
            if(currentPlayer == -1){
                currentPlayer = playerIds.length - 1;
            }
        }
        if(!gameDirection){
            currentPlayer = (currentPlayer + 1) % playerIds.length;
        }
        if(card.getColor() == UnoCard.Color.Wild){
            validColor = declaredColor;
        }
        if(card.getValue() == UnoCard.Value.DrawTwo){
            for(int i=0; i<2; i++) {
                getPlayerHand(playerIds[currentPlayer]).add(deck.drawCard());
            }
            JLabel message = new JLabel(playerIds[currentPlayer] + "drew 2 cards");
            message.setFont(new Font("Arial", 1, 48));
            JOptionPane.showMessageDialog(null, message);
        }
        if(card.getValue() == UnoCard.Value.Wild_Four){
            for(int i=0; i<4; i++) {
                getPlayerHand(playerIds[currentPlayer]).add(deck.drawCard());
            }
            JLabel message = new JLabel(playerIds[currentPlayer] + "drew 4 cards");
            message.setFont(new Font("Arial", 1, 48));
            JOptionPane.showMessageDialog(null, message);
        }
        if(card.getValue() == UnoCard.Value.Skip){
            JLabel message = new JLabel(playerIds[currentPlayer] + "was skipped");
            message.setFont(new Font("Arial", 1, 48));
            JOptionPane.showMessageDialog(null, message);
            if(gameDirection){
                currentPlayer = (currentPlayer - 1) % playerIds.length;
                if(currentPlayer == -1){
                    currentPlayer = playerIds.length - 1;
                }
            }
            if(!gameDirection){
                currentPlayer = (currentPlayer + 1) % playerIds.length;
            }
        }
        if(card.getValue() == UnoCard.Value.Reverse){
            JLabel message = new JLabel(playerIds[currentPlayer] + "changed game direction");
            message.setFont(new Font("Arial", 1, 48));
            JOptionPane.showMessageDialog(null, message);
            gameDirection ^= true;
            if(gameDirection){
                currentPlayer = (currentPlayer - 2) % playerIds.length;
                if(currentPlayer == -1){
                    currentPlayer = playerIds.length - 1;
                }
                if(currentPlayer == -2){
                    currentPlayer = playerIds.length - 2;
                }
            }
            if(!gameDirection){
                currentPlayer = (currentPlayer + 2) % playerIds.length;
            }
        }
    }
}

class InvalidPlayerTurnException extends Exception{
    private String playerId;
    public InvalidPlayerTurnException(String message, String pid){
        super(message);
        this.playerId = pid;
    }

    public String getPid(){
        return this.playerId;
    }
}

class InvalidColorSubmissionException extends Exception{
    private UnoCard.Color expected;
    private UnoCard.Color actucal;

    public InvalidColorSubmissionException(String message, UnoCard.Color expected, UnoCard.Color actual){
        super(message);
        this.expected = expected;
        this.actucal = actual;
    }
}

class InvalidValueSubmissionException extends Exception{
    private UnoCard.Value expected;
    private UnoCard.Value actucal;

    public InvalidValueSubmissionException(String message, UnoCard.Value expected, UnoCard.Value actucal){
        super(message);
        this.expected = expected;
        this.actucal = actucal;
    }
}


