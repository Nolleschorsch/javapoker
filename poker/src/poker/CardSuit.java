package poker;

public enum CardSuit {
	C("Clubs", "c"),
	D("Diamonds", "d"),
	H("Hearts", "h"),
	S("Spades", "s");
	
	private final String verboseString;
	private final String shortcutString;
	
	private CardSuit(String verboseString, String shortcutString) {
		this.verboseString = verboseString;
		this.shortcutString = shortcutString;
	}
	
	public String getVerboseString() {
		return this.verboseString;
	}
	
	public String getShortcutString() {
		return this.shortcutString;
	}
	
}
