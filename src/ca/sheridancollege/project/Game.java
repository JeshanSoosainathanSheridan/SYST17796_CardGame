package ca.sheridancollege.project;

import java.util.Scanner;

public class Game {

    static GroupOfCards deck = new GroupOfCards();
    static String name = "";
    static Player player = new Player("");
    static Player dealer = new Player("");
    static int playerWins = 0;
    static int dealerWins = 0;

    public static void main(String args[]) {
        deck.createDeck();
        System.out.println("Hello, Welcome to our blackjack game! What is your name? ");
        Scanner s = new Scanner(System.in);

        int x = 0;
        while (x != 1) {
            name = s.nextLine();
            if (!name.isEmpty()) {
                x = 1;
            } else {
                System.out.println("Please enter a valid name.");
            }
        }
        String a = "";
        while (!a.toLowerCase().contains("no")) {
            x = 0;

            begin();

            if (dealer.handValue() == 21) {
                x = 1;
                System.out.println("The dealer got blackjack!");
            }

            //hit 21 immidently
            if (player.handValue() == 21) {
                x = 1;
                System.out.println("You hit blackjack!!!");
            }

            //loop of hitting and stand
            while (x != 1) {
                System.out.println("Would you like to hit or stand?");
                String hitOrStand = s.nextLine().toLowerCase();
                int handValue = 0;
                if (hitOrStand.contains("hit")) {//HIT
                    player.Hit();
                    System.out.println("You hit a " + player.getCard(player.handLength() - 1));
                    handValue = player.handValue();
                    System.out.println("Your hand value:" + handValue);
                } else {//STAND
                    System.out.println("You have decided to stand");
                    x = 1;//end loop
                }

                if (handValue > 21) {//BUST
                    x = 1;//end loop
                    System.out.println("You busted!");
                } else if (handValue == 21) {//HIT 21
                    x = 1;//end loop
                    System.out.println("You hit 21!");
                }
            }

            System.out.println("The dealer's cards were:");
            System.out.println(dealer.getCard(0));
            System.out.println(dealer.getCard(1));

            int dealerHandValue = 0;
            if (player.handValue() == 21 && dealer.handValue() == 21) {
                System.out.println("You both have 21! Draw");
            } else if (player.handValue() == 21) {//dealer draws until hits 21 if u hit 21
                while (dealer.handValue() <= 21) {
                    dealer.Hit();
                    System.out.println("The Dealer hit a " + dealer.getCard(dealer.handLength() - 1));
                    System.out.println("The Dealers Hand Value is: " + dealer.handValue());
                    if (dealer.handValue() > 21) {//on bust
                        System.out.println("The dealer bust!");
                        playerWins++;
                    } else if (dealerHandValue == 21) {//draw
                        System.out.println("The dealer hit 21 as well!");
                    }

                    //1 sec break
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                    //end of break
                }
            } else if (dealer.handValue() == 21) {
                System.out.println("You lose");
                dealerWins++;
            } else {
                x = 0;
                while (x != 1) {
                    if (player.handValue() > 21) {//on bust
                        dealerWins++;
                        System.out.println("Dealer wins.");
                        x = 1;
                    } else {
                        boolean v = true;
                        while (v) {
                            if (dealer.handValue() < player.handValue()) {
                                System.out.println("The Dealer will now draw a card.");
                                dealer.Hit();
                                System.out.println(dealer.getCard(dealer.handLength() - 1));
                                System.out.println("The Dealers Hand Value is: " + dealer.handValue());
                                if (dealer.handValue() > 21) {
                                    System.out.println("The dealer bust!");
                                    playerWins++;
                                    v = false;
                                    x = 1;
                                } else if (dealer.handValue() == player.handValue()) {//draw
                                    System.out.println("Draw");
                                    v = false;
                                    x = 1;
                                }

                                //1 sec break
                                try {
                                    Thread.sleep(2000);
                                } catch (InterruptedException ex) {
                                    Thread.currentThread().interrupt();
                                }
                            } else {
                                System.out.println("Dealer wins!");
                                dealerWins++;

                            }
                        }
                    }
                }
            }
            //continue?
            System.out.println("Would you like to play one more? (yes or no)");
            a = s.nextLine();
        }
        System.out.println("Your Score:" + playerWins + "\nDealer's score:" + dealerWins);

    }

    public static void begin() {

        player = new Player(name);
        dealer = new Player("Dealer");

        System.out.println("Hello " + player.getPlayerName() + ", here are two cards for you and two cards for the dealer!");
        player.Hit();
        player.Hit();
        dealer.Hit();
        dealer.Hit();

        System.out.println("Dealer's Cards:");
        System.out.println("-Hidden-");
        System.out.println(dealer.getCard(1));

        System.out.println("Your Cards:");
        System.out.println(player.getCard(0));
        System.out.println(player.getCard(1));

    }

}
