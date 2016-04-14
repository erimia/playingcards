package com.erimia.playing.cards;

/**
 * Represents a playing card including it's suit and value
 * 
 * @author erimia
 *
 */
public enum Card {
	//Hearts
	AceOfHearts(1, Suit.Hearts), TwoOfHearts(2, Suit.Hearts), ThreeOfHearts(3, Suit.Hearts),
	FourOfHearts(4, Suit.Hearts), FiveOfHearts(5, Suit.Hearts), SixOfHearts(6, Suit.Hearts),
	SevenOfHearts(7, Suit.Hearts), EightOfHearts(8, Suit.Hearts), NineOfHearts(9, Suit.Hearts),
	TenOfHearts(10, Suit.Hearts), JackOfHearts(11, Suit.Hearts), QueenOfHearts(12, Suit.Hearts),
	KingOfHearts(13, Suit.Hearts),
	
	// Spades
	AceOfSpades(1, Suit.Spades), TwoOfSpades(2, Suit.Spades), ThreeOfSpades(3, Suit.Spades),
	FourOfSpades(4, Suit.Spades), FiveOfSpades(5, Suit.Spades), SixOfSpades(6, Suit.Spades),
	SevenOfSpades(7, Suit.Spades), EightOfSpades(8, Suit.Spades), NineOfSpades(9, Suit.Spades),
	TenOfSpades(10, Suit.Spades), JackOfSpades(11, Suit.Spades), QueenOfSpades(12, Suit.Spades),
	KingOfSpades(13, Suit.Spades),
	
	// Clubs
	AceOfClubs(1, Suit.Clubs), TwoOfClubs(2, Suit.Clubs), ThreeOfClubs(3, Suit.Clubs),
	FourOfClubs(4, Suit.Clubs), FiveOfClubs(5, Suit.Clubs), SixOfClubs(6, Suit.Clubs),
	SevenOfClubs(7, Suit.Clubs), EightOfClubs(8, Suit.Clubs), NineOfClubs(9, Suit.Clubs),
	TenOfClubs(10, Suit.Clubs), JackOfClubs(11, Suit.Clubs), QueenOfClubs(12, Suit.Clubs),
	KingOfClubs(13, Suit.Clubs),
	
	// Diamonds
	AceOfDiamonds(1, Suit.Diamonds), TwoOfDiamonds(2, Suit.Diamonds), ThreeOfDiamonds(3, Suit.Diamonds),
	FourOfDiamonds(4, Suit.Diamonds), FiveOfDiamonds(5, Suit.Diamonds), SixOfDiamonds(6, Suit.Diamonds),
	SevenOfDiamonds(7, Suit.Diamonds), EightOfDiamonds(8, Suit.Diamonds), NineOfDiamonds(9, Suit.Diamonds),
	TenOfDiamonds(10, Suit.Diamonds), JackOfDiamonds(11, Suit.Diamonds), QueenOfDiamonds(12, Suit.Diamonds),
	KingOfDiamonds(13, Suit.Diamonds);
	
	// Stored as an int for easy sorting
	// Values are 1=Ace, 2-10 = 2-10, 11=Jack, 12=Queen, 13=King
	private int faceValue;
	private Suit suit;
	
	private Card(int faceValue, Suit suit){
		this.faceValue = faceValue;
		this.suit = suit;
	}

	/**
	 * Retrieve the face value of this card as an integer.<br>
	 * 
	 * This method is only provided for ease of sorting,
	 * do not use this method for anything human readable (including log files).<br>
	 * 
	 * Values are 1=Ace, 2-10 = 2-10, 11=Jack, 12=Queen, 13=King
	 * 
	 * @return face value as an int for easy sorting 
	 */
	public int getFaceValue() {
		return faceValue;
	}

	/**
	 * @return the Suit for this card
	 */
	public Suit getSuit() {
		return suit;
	}
}
