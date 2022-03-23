import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Hand implements Comparable<Hand> {

	private List<Card> cards;
	
	Hand(List<Card> cards) {

		//this.cards = cards;
		//Collections.sort(this.cards);
		this.cards = this.sortByOccurences(cards);
	}
	
	List<Card> getCards() {
		return this.cards;
	}
	
	Card getCard(int index) {
		return this.cards.get(index);
	}

	int getSize() {
		return this.cards.size();
	}
	
	public String toString() {
		
		return this.cards.stream().map(Object::toString)
                .collect(Collectors.joining(", "));

	}
	
	private List<Card> sortByOccurences(List<Card> cards) {
		
		var values = new ArrayList<Integer>();
		for (Card c: cards) {
			values.add(c.getNumericValue());
		}
		
		
		cards.sort((card1, card2) -> {
			int freq1 = Collections.frequency(values, card1.getNumericValue());
			int freq2 = Collections.frequency(values, card2.getNumericValue());
		    var cmp = Integer.compare(freq1, freq2);
		    if (cmp == 0)
		        cmp = Integer.compare(card1.getNumericValue(), card2.getNumericValue());
		    return cmp;
		});

		
		Collections.reverse(cards);
		
		return cards;

		
		
	}
	
	public int compareTo(Hand hand) {
		
		for(var i=0; i<5; i++) {
			
			if (this.getCard(i).getNumericValue() > hand.getCard(i).getNumericValue()) {
				return -1;
			} else if (this.getCard(i).getNumericValue() < hand.getCard(i).getNumericValue()) {
				return 1;
			}
		}
		return 0;
	}
}
