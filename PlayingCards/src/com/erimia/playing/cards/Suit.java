package com.erimia.playing.cards;

/**
 * Represents the 4 playing card suits
 * 
 * Value is 0-3 (Hearts, Spades, Clubs, Diamonds).
 * 
 * @author erimia
 *
 */
public enum Suit {
	Hearts(0), Spades(1), Clubs(2), Diamonds(3);
	private int value;
	
	private Suit(int value){
		this.value = value;
	}
	
	/**
	 * @return value associated with this Suit (provided externally for sorting,
	 * generally you will want to use 'name' for a better human readable value
	 */
	public int getValue(){
		return value;
	}
}
