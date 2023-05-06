public class TestCard {
   public static void main(String[] args) {
      Card card = new Card("AH");
      System.out.println(card);
      System.out.println(card.getRank() + " " + card.getSuit());
      System.out.println(card.getCard() == card);

      card = new Card("JS");
      System.out.println(card.getRank() + " " + card.getSuit());

//      card = new Card("55");  // should throw an exception
//      System.out.println(card);
   }
}