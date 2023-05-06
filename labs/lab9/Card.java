/**
 * Implementation of a playing card. This class implements the
 * Comparable interface and compares cards by rank, with an
 * undefined order for cards of the same suit.
 */
public class Card implements Comparable<Card> {
   private String card;
   private int rank;
   private char suit;

   // Constructor: creates a Card object from the String cardname.
   // cardname must be in the correct format: two characters
   // representing rank and suit. E.g., "JH" (jack of hearts)
   public Card(String cardname) {
      check(cardname); // check if cardname is in valid format
      this.card = cardname;
      char rank = cardname.charAt(0);
      if      (rank == 'A') this.rank = 14;
      else if (rank == 'K') this.rank = 13;
      else if (rank == 'Q') this.rank = 12;
      else if (rank == 'J') this.rank = 11;
      else if (rank == 'T') this.rank = 10;
      else this.rank = Character.getNumericValue(rank);
      this.suit = cardname.charAt(1);
   }

   // getters
   public int getRank()  { return rank; }
   public char getSuit() { return suit; }
   public Card getCard() { return this; }

   @Override
   public int compareTo(Card that) { return this.rank - that.rank; }

   @Override
   public String toString() { return card; }

   // check if the card is in a valid format
   private void check(String card) {
      if (card.length() != 2)
         throw new RuntimeException("WRONG CARD");
      if ( !"23456789TJQKA".contains( card.substring(0,1) ) )
         throw new RuntimeException("WRONG RANK");
      if ( !"SHDC".contains( card.substring(1,2) ) )
         throw new RuntimeException("WRONG SUIT");
   }
}