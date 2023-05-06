import java.util.Arrays;

public class TestHand {
   public static void main(String[] args) {
      // TEST 0: highestCard(), showRanks(), rankFrequency()
      Hand hand = new Hand("8C TS KC 9H 4S");  // nothing hand (hand rank = 0)
      System.out.println(hand);               // [8C, TS, KC, 9H, 4S]
      System.out.println("hand rank: " + hand.getHandValue()); // 0
      System.out.println(Arrays.toString(hand.getCardRanks()));   // [13, 10, 9, 8, 4]
      System.out.println(Arrays.toString(hand.getRankFrequency().entrySet().toArray())); // format: [4=1, 8=1, 9=1, 10=1, 13=1]
      System.out.println(hand.getRankFrequency()); // format: {4=1, 8=1, 9=1, 10=1, 13=1}
      System.out.println("-------------------------");

      // TEST 1: Full house
      System.out.println("\tFull House:");
      hand = new Hand("7D 7S 5D 7C 5H"); // hand rank = 6
      System.out.print  ("Card ranks:" + Arrays.toString(hand.getCardRanks()));
      System.out.println(", hand rank = " + hand.getHandValue());  // 6
      System.out.println("Rank frequency map: " + hand.getRankFrequency());
      System.out.println(hand.isFullHouse()); // true
      System.out.println(new Hand("AS AH AD KC KS").isFullHouse()); // true
      System.out.println(new Hand("2S 2D AC 2H 3S").isFullHouse()); // false
      System.out.println("-------------------------");

      // TEST 2: isFlush() - returns true if it is a straight flush or just a flush
      System.out.println("\tFlush:");
      hand = new Hand("7S 8S 5H 5S 6S");
      System.out.print  ("Card ranks:" + Arrays.toString(hand.getCardRanks())); //[8, 7, 6, 5, 5]
      System.out.println(", hand rank = " + hand.getHandValue());  // 1 (pair)
      System.out.println("Is this a flush? " + hand.isFlush()); // false
      hand = new Hand("7S 8S 5S AS 6S");
      System.out.print  ("Card ranks:" + Arrays.toString(hand.getCardRanks())); //[14, 8, 7, 6, 5]
      System.out.println(", hand rank = " + hand.getHandValue());  // 5
      System.out.println("Is this a flush? " + hand.isFlush()); // true
      System.out.println(new Hand("AS AD AH AC TS").isFlush()); // false
      System.out.println(new Hand("AS 2S 3S 5S 4S").isFlush()); // true
      System.out.println("-------------------------");

      // TEST 3: isStraightFlush() - returns true if it is both straight and a flush
      System.out.println("\tStraight Flush:");
      hand = new Hand("7S 8S 9S JS TS");
      System.out.print  ("Card ranks:" + Arrays.toString(hand.getCardRanks())); //[11, 10, 9, 8, 7]
      System.out.println(", hand rank = " + hand.getHandValue());  // 8 (straight flush)
      System.out.println("Is this a straight flush? " + hand.isStraightFlush()); // true
      System.out.println(new Hand("AS 8S 9S JS TS").isStraightFlush()); // false
      System.out.println(new Hand("AS KH QS JD TS").isStraightFlush()); // false
      System.out.println(new Hand("2D 3S 5S 4H JS").isStraightFlush()); // false
      System.out.println(Arrays.toString(new Hand("AS QS JD TS 9H").getCardRanks())); // [14, 12, 11, 10, 9]
      System.out.println(new Hand("AS QS JD TS 9H").isStraightFlush()); // false
      System.out.println("-------------------------");

      // TEST 4: isStraight() - returns true if it is a straight or a straight flush
      System.out.println("\tStraight:");
      hand = new Hand("7S 8S 9S JS TS");
      System.out.print  ("Card ranks:" + Arrays.toString(hand.getCardRanks())); //[11, 10, 9, 8, 7]
      System.out.println(", hand rank = " + hand.getHandValue());  // 8 (straight flush)
      System.out.println("Is this a straight? " + hand.isStraight()); // true
      System.out.println("Is this a straight flush? " + hand.isStraightFlush()); // true

      System.out.println(new Hand("7S 8S 9S JS TH").isStraight()); // true
      System.out.print  ("Card ranks:" + Arrays.toString(new Hand("7S 8S 9S JS TH").getCardRanks())); //[11, 10, 9, 8, 7]
      System.out.println(", hand rank = " + new Hand("7S 8S 9S JS TH").getHandValue());  // 4 (straight)
      System.out.println(new Hand("AS 2S 3H 4S 5S").isStraight()); // true
      System.out.println(Arrays.toString(new Hand("AS 2S 3H 4S 5S").getCardRanks())); // [5, 4, 3, 2, 1]
      System.out.println(new Hand("AS KH QS JS TS").isStraight()); // true
      System.out.println(Arrays.toString(new Hand("AS KH QS JS TS").getCardRanks())); // [14, 13, 12, 11, 10]
      System.out.println("-------------------------");

      // TEST 5: isFourOfaKind()
      System.out.println("\tFour of a Kind:");
      hand = new Hand("7S 8S 7H 7C 7D");
      System.out.print  ("Card ranks:" + Arrays.toString(hand.getCardRanks())); // [8, 7, 7, 7, 7]
      System.out.println(", hand rank = " + hand.getHandValue());  // 7 (four of a kind)
      System.out.println("Is this a four of a kind? " + hand.isFourOfaKind()); // true
      System.out.println(new Hand("7S 8S 7H 7C AD").isFourOfaKind()); // false
      System.out.println(new Hand("8S AS AH AC AD").isFourOfaKind()); // true
      System.out.println(new Hand("AS KS QH 7C 7D").isFourOfaKind()); // false
      System.out.println("-------------------------");

      // TEST 5: isThreeOfaKind()
      System.out.println("\tThree of a kind:");
      hand = new Hand("JS JC JH KC AD");
      System.out.print  ("Card ranks:" + Arrays.toString(hand.getCardRanks())); // [14, 13, 11, 11, 11]
      System.out.println(", hand rank = " + hand.getHandValue());  // 3 (three of a kind)
      System.out.println("Is this a three of a kind? " + hand.isThreeOfaKind()); // true
      System.out.println(new Hand("7S 7D 7H 7C AD").isThreeOfaKind()); // false
      System.out.println(new Hand("JS 2S JH AC JD").isThreeOfaKind()); // true
      System.out.println(new Hand("JS JC JH KC KD").isThreeOfaKind()); // false
      System.out.println("-------------------------");

      // TEST 6: isPair()
      System.out.println("\tPair:");
      hand = new Hand("JS JC 2H KC AD");
      System.out.print  ("Card ranks:" + Arrays.toString(hand.getCardRanks())); // [14, 13, 11, 11, 2]
      System.out.println(", hand rank = " + hand.getHandValue());  // 1 (one pair)
      System.out.println("Is this a one-pair? " + hand.isPair()); // true
      System.out.println(new Hand("JS JC JH KC AD").isPair()); // false
      System.out.println(new Hand("JS TC 2H KC KH").isPair()); // true
      System.out.println(new Hand("JS JC JH JD AD").isPair()); // false
      System.out.println(new Hand("2H 3C 4H 5C 2S").isPair()); // true
      System.out.println(new Hand("JS JC TH KD KC").isPair()); // false
      System.out.println("-------------------------");

      // TEST 7: isTwoPair()
      System.out.println("\tTwo Pair:");
      hand = new Hand("JS JC AH KD AD");
      System.out.print  ("Card ranks:" + Arrays.toString(hand.getCardRanks())); // [14, 14, 13, 11, 11]
      System.out.println(", hand rank = " + hand.getHandValue());  // 2 (two pair)
      System.out.println("Is this a two-pair? " + hand.isTwoPair()); // true
      System.out.println(new Hand("JS JC AH JD AD").isTwoPair()); // false
      System.out.println(new Hand("AS KC 2H 2D AD").isTwoPair()); // true
      System.out.println(new Hand("AS 2S 3S 4S 5S").isTwoPair()); // false
      System.out.println("-------------------------");

      // TEST 8: isNothing
      System.out.println("\tNothing Hand:");
      hand = new Hand("JS JC AH KD AD");
      System.out.print  ("Card ranks:" + Arrays.toString(hand.getCardRanks())); // [14, 14, 13, 11, 11]
      System.out.println(", hand rank = " + hand.getHandValue());  // 2 (two pair)
      System.out.println("Is this a 'nothing hand'? " + hand.isNothing()); // false

      hand = new Hand("JS TC 9H 8D 2D");
      System.out.print  ("Card ranks:" + Arrays.toString(hand.getCardRanks())); // [11, 10, 9, 8, 2]
      System.out.println(", hand rank = " + hand.getHandValue());  // 0 (nothing)
      System.out.println("Is this a 'nothing hand'? " + hand.isNothing()); // true
      System.out.println(new Hand("JS JC TH KD KS").isNothing()); // false
      System.out.println(new Hand("AS KS QS JS 2D").isNothing()); // true
      System.out.println(new Hand("AS KS QS JS 2S").isNothing()); // false

      System.out.println("-------------------------");
      System.out.println("\tMiscellaneous (satisfied with the above tests but could add more):");
      Integer[] a = new Hand("7D 7S 5D 7C 5H").getCardRanks();
      System.out.println(Arrays.toString(a)); // [7, 7, 7, 5, 5]
      System.out.println(hand.getRankFrequency()); //{2=1, 8=1, 9=1, 10=1, 11=1}

      a = new Hand("5D 4S 3D 2C AH").getCardRanks();
      System.out.println(Arrays.toString(a)); // [5, 4, 3, 2, 1]
      System.out.println("-----------------");
   }
}