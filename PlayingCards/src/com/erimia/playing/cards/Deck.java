package com.erimia.playing.cards;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class representing a single Deck of Playing Cards.
 * 
 * NOT CURRENTLY THREAD SAFE !!!
 * 
 * @author erimia
 *
 */
public class Deck extends OrderedSetOfCards{
	
	private Deck(){
		this.cards = new ArrayList<>(Arrays.asList(Card.values()));
	};

	/**
	 * Factory method for a shuffled Deck.
	 */
	public static Deck buildShuffledDeck(){
		Deck retVal = new Deck();
		retVal.shuffle();
		return retVal;
	}
	
	/**
	 * Factory method for a sorted Deck.
	 */
	public static Deck buildSortedDeck(){
		Deck retVal = new Deck();
		retVal.sortBySuitAndFaceValue();
		return retVal;
	}
}
