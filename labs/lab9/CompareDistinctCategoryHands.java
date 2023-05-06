import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class CompareDistinctCategoryHands {
   public static void main(String[] args) {
      int p1wins = 0;
      try {
         for (String line : Files.readAllLines(Paths.get("distinctHandPairs.txt"))) {
            Hand hand1 = new Hand(line.substring(0, 14));
            Hand hand2 = new Hand(line.substring(14, 29).trim());
            
            int value1 = hand1.getHandValue();
            int value2 = hand2.getHandValue();
            
            if (value1 < value2) {
            	p2_winner(hand1, hand2);
            	System.out.print("\t\t\t    because Player 2 has higher hand value.\n");
            } else if (value1 > value2) {
            	p1_winner(hand1, hand2);
            	System.out.print("\t\t\t    because Player 1 has higher hand value.\n");
            	p1wins++;
            } else {
            	// Start working with each case when they have the same hand value
            	// Case 1: Both are Straight Flush or Flush or Straight or nothing, compare highest card
            	if (value1 == 8 || value1 == 5 || value1 == 4 || value1 == 0) {
            		if (hand1.getHighestCard() > hand2.getHighestCard()) {
            			p1_winner(hand1, hand2);
            			System.out.printf("\t\t\t    because Player 1 has the highest card of %s.\n", hand1.getHighestCard());
            			p1wins++;
            		} else {
            			p2_winner(hand1, hand2);
            			System.out.printf("\t\t\t    because Player 2 has the highest card of %s.\n", hand2.getHighestCard());
            		}
            	}
            	
            	// Case 2: Both are Four of a Kind, compare card in pair of 4
            	else if (value1 == 7) {
            		if (pairOf4(hand1) > pairOf4(hand2)) {
            			p1_winner(hand1, hand2);
            			System.out.printf("\t\t\t    because Player 1 has higher card of %s in a pair.\n", pairOf4(hand1));
            			p1wins++;
            		} else if (pairOf4(hand1) < pairOf4(hand2)) {
            			p2_winner(hand1, hand2);
            			System.out.printf("\t\t\t    because Player 2 has higher card of %s in a pair.\n", pairOf4(hand2));
            		} else {
            			// If both have the same card, compare highest card
            			if (hand1.getHighestCard() > hand2.getHighestCard()) {
            				p1_winner(hand1, hand2);
            				System.out.printf("\t\t\t    because Player 1 has the highest card of %s.\n", hand1.getHighestCard());
                			p1wins++;
                		} else {
                			p2_winner(hand1, hand2);
                			System.out.printf("\t\t\t    because Player 2 has the highest card of %s.\n", hand2.getHighestCard());
            			}
            		}
            	}
            	
            	// Case 3: Both are Full House or Three of a kind, compare card in pair of 3
            	else if (value1 == 6 || value1 == 3) {
            		if (pairOf3(hand1) > pairOf3(hand2)) {
            			p1_winner(hand1, hand2);
            			System.out.printf("\t\t\t    because Player 1 has higher card of %s in a pair.\n", pairOf3(hand1));
            			p1wins++;
            		} else if (pairOf3(hand1) < pairOf3(hand2)) {
            			p2_winner(hand1, hand2);
            			System.out.printf("\t\t\t    because Player 1 has higher card of %s in a pair.\n", pairOf3(hand2));
            		} else {
            			// If both have the same card, compare highest card
            			if (hand1.getHighestCard() > hand2.getHighestCard()) {
            				p1_winner(hand1, hand2);
            				System.out.printf("\t\t\t    because Player 1 has the highest card of %s.\n", hand1.getHighestCard());
                			p1wins++;
                		} else {
                			p2_winner(hand1, hand2);
                			System.out.printf("\t\t\t    because Player 2 has the highest card of %s.\n", hand2.getHighestCard());
            			}
            		}
            	}
            	
            	// Case 4: Both are Pair, compare card in pair of 2
            	else if (value1 == 1) {
            		if (pairOf2(hand1) > pairOf2(hand2)) {
            			p1_winner(hand1, hand2);
            			System.out.printf("\t\t\t    because Player 1 has higher card of %s in a pair.\n", pairOf2(hand1));
            			p1wins++;
            		} else if (pairOf2(hand1) < pairOf2(hand2)) {
            			p2_winner(hand1, hand2);
            			System.out.printf("\t\t\t    because Player 2 has higher card of %s in a pair.\n", pairOf2(hand2));
            		} else {
            			// If both have the same card, compare highest card
            			if (hand1.getHighestCard() > hand2.getHighestCard()) {
            				p1_winner(hand1, hand2);
            				System.out.print("\t\t\t    because Player 1 has the highest card\n");
                			p1wins++;
            			} else {
                			p2_winner(hand1, hand2);
                			System.out.print("\t\t\t    because Player 2 has the highest card\n");
            			}
            		}
            	}
            }
         }
         System.out.println("\nNumber of hands won by player 1: " + p1wins);
      } catch (Exception e) {
         System.out.println(e);
      }
   }
   
   // Return card of pair 2
   public static int pairOf2(Hand hand) {
	   for (Map.Entry<Integer, Integer> entry : hand.getRankFrequency().entrySet()) {
		   if (entry.getValue() == 2) {
			   return entry.getKey();
		   }
	   }
	   return -1;		// if there is no pair
   }
   
   // Return card of pair 3
   public static int pairOf3(Hand hand) {
	   for (Map.Entry<Integer, Integer> entry : hand.getRankFrequency().entrySet()) {
		   if (entry.getValue() == 3) {
			   return entry.getKey();
		   }
	   }
	   return -1;		// if there is no pair
   }
   
   // Return card of pair 4
   public static int pairOf4(Hand hand) {
	   int card = 0;
	   for (Map.Entry<Integer, Integer> entry : hand.getRankFrequency().entrySet()) {
		   if (entry.getValue() == 4) {
			   return entry.getKey();
		   }
	   }
	   return -1;		// if there is no pair
   }
   
   // Prints out the winner and the hand
   public static void p1_winner(Hand hand1, Hand hand2) {
	   System.out.println("\nPlayer 1: " + hand1 + "  (" + Hand.nameMap.get(hand1.getHandValue()) +
               ")\nPlayer 2: " + hand2 +  "  (" + Hand.nameMap.get(hand2.getHandValue()) +
               ")\n\t\t\t    Player 1 wins.");
   }
   
   public static void p2_winner(Hand hand1, Hand hand2) {
	   System.out.println("\nPlayer 1: " + hand1 + "  (" + Hand.nameMap.get(hand1.getHandValue()) +
               ")\nPlayer 2: " + hand2 +  "  (" + Hand.nameMap.get(hand2.getHandValue()) +
               ")\n\t\t\t    Player 2 wins.");
   }
   
   public static void tie(Hand hand1, Hand hand2) {
	   System.out.println("\nPlayer 1: " + hand1 + "  (" + Hand.nameMap.get(hand1.getHandValue()) +
               ")\nPlayer 2: " + hand2 +  "  (" + Hand.nameMap.get(hand2.getHandValue()) +
               ")\n\t\t\t\t Tie.");
   }
   
}