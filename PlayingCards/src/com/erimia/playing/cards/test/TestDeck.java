package com.erimia.playing.cards.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.Test;

import com.erimia.playing.cards.Card;
import com.erimia.playing.cards.Deck;

/**
 * Test methods for the Deck class, could be generalized to test OrderedSetOfCards
 * 
 * @author erimia
 *
 */
public class TestDeck {

	@Test
	public void testDeckContainsOneOfEachCard() {
		Deck shuffledDeck = Deck.buildShuffledDeck();
		List<Card> retrievedCards = new ArrayList<Card>();
		Optional<Card> lastCard;
		do{
			lastCard = shuffledDeck.dealOneCard();
			lastCard.ifPresent(retrievedCards::add);
		} while (lastCard.isPresent());

		Assert.assertEquals("Deck does not contain all cards, wrong deck dize", Card.values().length, retrievedCards.size());
		Assert.assertTrue(retrievedCards.containsAll(Arrays.asList(Card.values())));
		
		// Check for duplicates
		Set<Card> distinct = new HashSet<>(retrievedCards);
		// Note - this could be improved to say what was a duplicate, but believe this is an
		// edge case that should be easy to find the issue
		Assert.assertEquals("Deck Contained Duplicates", distinct.size(), retrievedCards.size());
	}
	
	@Test
	public void testThatDrawingAFiftyThirdCardIsEmpty(){
		Deck shuffledDeck = Deck.buildShuffledDeck();
		// Deal 52 cards
		IntStream.range(1,53).forEach(i -> {
			Assert.assertTrue("Drawing one of the first 52 cards was empty : " + i,shuffledDeck.dealOneCard().isPresent());
		});
		Assert.assertFalse("Drawing a 53rd card was not empty",shuffledDeck.dealOneCard().isPresent());
	}
	
	/**
	 * Test Shuffling to make sure that cards are not in the same order.
	 * NOTE: Technically possible for this to fail ... haven't seen that happen yet
	 */
	@Test
	public void testShuffleProducesUniqueCardOrder(){
		Deck shuffledDeck = Deck.buildShuffledDeck();
		
		List<Card> retrievedCards = new ArrayList<Card>();
		Optional<Card> lastCard;
		do{
			lastCard = shuffledDeck.dealOneCard();
			lastCard.ifPresent(retrievedCards::add);
		} while (lastCard.isPresent());
		
		shuffledDeck.shuffle();
		List<Card> retrievedCards2 = new ArrayList<Card>();
		do{
			lastCard = shuffledDeck.dealOneCard();
			lastCard.ifPresent(retrievedCards2::add);
		} while (lastCard.isPresent());
		Assert.assertNotEquals("Shuffled deck was the same", retrievedCards, retrievedCards2);
	}
	
	@Test
	public void testSortedDeck(){
		Deck deck = Deck.buildSortedDeck();
		
		Optional<Card> lastCard = Optional.empty();
		
		do {
			Optional<Card> nextCard = deck.dealOneCard();
			lastCard.ifPresent((card)-> nextCard.ifPresent((card2)-> {
				Assert.assertTrue("Suit not in order", card2.getSuit().getValue() >= card.getSuit().getValue());
				if (card.getSuit().equals(card2.getSuit())){
					Assert.assertTrue("Face value not in order", card2.getFaceValue() >= card.getFaceValue());
				}
			}));
			lastCard = nextCard;
		} while (lastCard.isPresent());
	}
}
