package com.bridgeit.objectOrientedPrograms;

class DeckOfCards {
	public static void main(String[] args) {

		String SUITS[] = { "Clubs", "Diamonds", "Hearts", "Spades" }; // array for the suits
		String RANKS[] = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };// array for
																											// the ranks
		// set all cards
		int count1 = 0;
		int n = SUITS.length * RANKS.length; // for checking the length of the suits and ranks
		String deck[] = new String[n];
		for (int i = 0; i < RANKS.length; i++) {
			for (int j = 0; j < SUITS.length; j++) {
				deck[SUITS.length * i + j] = RANKS[i] + " of " + SUITS[j];
				System.out.println(deck[SUITS.length * i + j]);
				count1++;
			}
		}
		System.out.println(count1);
		// shuffle all cards
		System.out.println();
		System.out.println();
		for (int i = 0; i < n; i++) {
			int r = i + (int) (Math.random() * (n - i));
			System.out.println(r);
			String temp = deck[r];
			deck[r] = deck[i];
			deck[i] = temp;
		}

		// for(int k = 0; k<n ;k++)
		// {
		// System.out.println("array of deck"+deck[k]);
		// }
		String[][] p = new String[13][4];
		int count = 0;
		for (int i = 0; i < 13; i++) {
			for (int j = 0; j < 4; j++) {
				if (count == deck.length)
					break;
				p[i][j] = deck[count];
				// System.out.println("In p array"+p[i][j]);
				count++;
			}
		}
		int ply = 1;
		while (ply < 5) {
			for (int i = 0; i < 4; i++) {
				System.out.println("\n\nFor Player: " + ply + "\n");
				for (int j = 0; j < 9; j++) {
					System.out.println(p[j][i]);
				}
				ply++;
			}
		}

	}
}
