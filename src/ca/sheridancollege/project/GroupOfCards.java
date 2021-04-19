package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class GroupOfCards {

    private static ArrayList<Card> deckOfCards = new ArrayList<Card>();

    public static void createDeck() {
        deckOfCards.clear();
        for (int x = 0; x < 4; x++) {

            for (int y = 1; y < 14; y++) {

                Card card;

                switch (x) {
                    case 0:
                        card = new Card("Hearts", y);
                        deckOfCards.add(card);
                        break;
                    case 1:
                        card = new Card("Spades", y);
                        deckOfCards.add(card);
                        break;
                    case 2:
                        card = new Card("Clubs", y);
                        deckOfCards.add(card);
                        break;
                    case 3:
                        card = new Card("Diamonds", y);
                        deckOfCards.add(card);
                        break;
                }
            }
        }
        shuffle();
        shuffle();
        shuffle();
    }

    public static Card getCard() {
        Random rand = new Random();
        int randomNum = rand.nextInt(deckOfCards.size());
        Card card = deckOfCards.get(randomNum);
        deckOfCards.remove(randomNum);
        shuffle();
        shuffle();
        shuffle();
        return card;
    }

    public static boolean shuffle() {
        Collections.shuffle(deckOfCards);
        return true;
    }

}
