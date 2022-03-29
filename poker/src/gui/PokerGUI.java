package gui;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import poker.Card;
import poker.CardSuit;
import poker.Deck;
import poker.Hand;
import poker.HandEvaluator;

public class PokerGUI extends Application {

	private Stage stage;
	private int handCount;
	
	@Override
	public void start(Stage stage) throws Exception {
		try {
			
			this.stage = stage;
			this.handCount = 10;
			this.refresh();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void refresh() {
		
		var gridpane = this.getPokerHandsGridPane();
		
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(50);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(50);
        gridpane.getColumnConstraints().addAll(col1,col2);
		gridpane.setVgap(50);
		gridpane.setHgap(50);

		var scene = new Scene(gridpane);
		
		this.stage.setScene(scene);
		this.stage.setMaximized(true);
		
		this.stage.show();
		
	}
	
	public void setHandCount() {
		
	}
	
	public GridPane getPokerHandsGridPane() {
		
        GridPane grid = new GridPane();

        var deck = new Deck();
		var hands = deck.shuffleUpAndDeal(this.handCount);
		
		var he = new HandEvaluator();
		var result = he.evaluateWinner(hands);
		
		var winnerList = Arrays.asList(result.get(0).split("\\r?\\n"));
		var loserList = Arrays.asList(result.get(1).split("\\r?\\n"));

		
		var fooList = Stream.concat(winnerList.stream(), loserList.stream())
                .collect(Collectors.toList());
        
		var dealButton = new Button("Deal new hands");
		dealButton.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent t) {
            	refresh();
            }
        });
		
		grid.add(dealButton, 0, 0);
		
		var options = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		var comboBox = new ComboBox<Integer>();
		comboBox.getItems().addAll(options);
		comboBox.getSelectionModel().select(this.handCount - 1);
		comboBox.setOnAction((e) -> {
            this.handCount = comboBox.getSelectionModel().getSelectedIndex() + 1;
		});
		grid.add(comboBox, 1, 0);
		
		var count = 0;
		var row = 1;
		var col = 0;

		for (Hand hand : hands) {
			
			if (count == 5) {
				row = 1;
				col = 1;
			}
			
			var isWinner = count < winnerList.size();
			var pokerhandGroup = this.getPokerhandGroup(fooList.get(count), isWinner);
			
			var textFlow = new TextFlow();
			
			for (Card card : hand.getCards()) {
				var cardText = getCardText(card);
				textFlow.getChildren().add(cardText);
			}
			
			
			grid.add(textFlow, col, row);
			grid.add(pokerhandGroup, col, row + 1);

			row += 2;
			count++;
		}
		
		return grid;
		
	}
	
	public Label getPokerhandGroup(String handInfo, boolean isWinner) {
		

		var handInfoLabel = new Label(handInfo);
		var handInfoColor = isWinner ? Color.GREEN : Color.RED;
		handInfoLabel.setTextFill(handInfoColor);
		handInfoLabel.setFont(new Font(20));
		handInfoLabel.setWrapText(true);
		
		return handInfoLabel;
		
	}
	
	public Text getCardText(Card card) {
		
		var suit = card.getSuit();
		
		Color textColor;
		
		if(suit == CardSuit.C) {
			textColor = Color.GREEN;
		} else if (suit == CardSuit.D) {
			textColor = Color.BLUE;
		} else if (suit == CardSuit.H) {
			textColor = Color.RED;
		} else  {
			textColor = Color.BLACK;
		}
		
		var cardText = new Text(card.getShortcutString() + " ");
		cardText.setFill(textColor);
		cardText.setFont(new Font(30));
		
		return cardText;
		
	}
	
}
