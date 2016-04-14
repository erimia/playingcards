package com.erimia.playing.cards;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

/**
 * Generic Class for an ordered set of cards 
 * (allow for a 'Hand', a single 'Deck', a multiple Deck Shoe, stacks for Solitare, etc.)<br>
 * 
 * NOTE: Currently only tested as part of the Deck class, may deserve its own tests for random sets of cards.<br>
 * 
 * NOT CURRENTLY THREAD SAFE !!!
 * 
 * @author erimia
 *
 */
public class OrderedSetOfCards{
	protected List<Card> cards;
	
	// Future growth, allow for games that cycle through card sets
	protected boolean singleDeal = true;
	
	protected int lastDealtCard = -1;
	
	/**
	 * Sort cards by face value only.
	 */
	public void sortByFaceValue(){
		cards.sort((c1, c2) -> Integer.compare(c1.getFaceValue(), c2.getFaceValue()));
	}
	
	/**
	 * Sort cards by suit then face value.
	 */
	public void sortBySuitAndFaceValue() {
		cards.sort((c1, c2) -> {
			int suitCompare = Integer.compare(c1.getSuit().getValue(), c2.getSuit().getValue());
			if (suitCompare != 0){
				return suitCompare;
			}
			return Integer.compare(c1.getFaceValue(), c2.getFaceValue());
		});
	}
	
	/**
	 * Deal a single card.
	 */
	public Optional<Card> dealOneCard(){
		if (lastDealtCard >= this.cards.size()-1){
			if (singleDeal){
				return Optional.empty();
			}
			lastDealtCard =-1;
		}
		lastDealtCard++;
		return Optional.of(this.cards.get(lastDealtCard));
	}
	
	/**
	 * Shuffle the set of cards randomly.
	 * 
	 * NOTE: this currently is not a cryptographically secure randomizer so it is not suited for
	 * gambling (someone may be able to game this sort on a large scale).
	 */
	public void shuffle(){
		IntStream.range(0, this.cards.size()).forEach(index -> {
			int rand = (int)(Math.random()*(index+1));
			Collections.swap(cards, index, rand);
		});
		
		// Reset last card dealt
		lastDealtCard = -1;
	}
}
