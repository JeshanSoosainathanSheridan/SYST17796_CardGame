package ca.sheridancollege.project;

import java.util.ArrayList;

public class Player {

    private String name;
    private ArrayList<Card> hand = new ArrayList<Card>();

    public Player(String name) {
        this.name = name;
    }

    public void Hit() {
        hand.add(GroupOfCards.getCard());
    }

    public String getPlayerName() {
        return this.name;
    }

    public String getCard(int index) {
        Card card = hand.get(index);
        String a = String.valueOf(card.getValue());
        String b = card.getSuit();
        switch (a) {
            case "1":
                a = "Ace";
                break;
            case "11":
                a = "Jack";
                break;
            case "12":
                a = "Queen";
                break;
            case "13":
                a = "King";
                break;
            default:
                break;
        }

        String cardString = a + " of " + b;

        return cardString;
    }

    public int handLength() {
        return hand.size();
    }

    public int handValue() {
        int handValue = 0;
        int cardValue;
        int numOfAces = 0;
        for (int z = 0; z < handLength(); z++) {

            cardValue = hand.get(z).getValue();

            if (cardValue == 1) {
                numOfAces++;
                cardValue = 11;
            } else if (cardValue == 11) {
                cardValue = 10;
            } else if (cardValue == 12) {
                cardValue = 10;
            } else if (cardValue == 13) {
                cardValue = 10;
            }

            handValue += cardValue;

            while (handValue > 21 && numOfAces > 0) {
                numOfAces--;
                handValue -= 10;
            }
        }

        return handValue;
    }

}
