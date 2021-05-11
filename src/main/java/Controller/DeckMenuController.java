package Controller;

import Model.Cards.Card;
import Model.Cards.Magic.Magic;
import Model.Cards.Monster.Monster;
import Model.Deck.Deck;
import Model.Deck.MainDeck;
import Model.Deck.SideDeck;
import Model.Player;
import View.DeckMenuView;
import View.Regex;
import com.sanityinc.jargs.CmdLineParser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DeckMenuController {
    private Player player;
    private static DeckMenuController menu;

    public static DeckMenuController getInstance(Player player) {
        if (menu == null) {
            menu = new DeckMenuController();
        }
        menu.setPlayer(player);
        return menu;
    }

    public boolean run(String command) {
        ArrayList<String> menuRegex = Regex.getMenuRegex();
        ArrayList<String> deckMenuRegex = Regex.getDeckRegex();
        Matcher matcher;
        if (getMatcher(command, menuRegex.get(0)).find()) {
            enterMenu();
            return true;
        } else if (getMatcher(command, menuRegex.get(1)).find()) {
            return false;

        } else if (getMatcher(command, menuRegex.get(2)).find()) {
            showCurrentMenu();
            return true;

        } else if (getMatcher(command, deckMenuRegex.get(0)).find()) {
            matcher = getMatcher(command, deckMenuRegex.get(0));
            createDeck(matcher);
            return true;

        } else if (getMatcher(command, deckMenuRegex.get(1)).find()) {
            matcher = getMatcher(command, deckMenuRegex.get(1));
            deleteDeck(matcher);
            return true;

        } else if (getMatcher(command, deckMenuRegex.get(2)).find()) {
            matcher = getMatcher(command, deckMenuRegex.get(2));
            setActiveDeck(matcher);
            return true;

        } else if (getMatcher(command, deckMenuRegex.get(3)).find()) {
            addCard(command);
            return true;

        } else if (getMatcher(command, deckMenuRegex.get(4)).find()) {
            removeCard(command);
            return true;
        } else if (getMatcher(command, deckMenuRegex.get(5)).find()) {
            showAllDecks();
            return true;
        } else if (getMatcher(command, deckMenuRegex.get(6)).find()) {
            showSingleDeck(command);
            return true;
        } else if (getMatcher(command, deckMenuRegex.get(7)).find()) {
            showAllCards();
            return true;
        } else {
            DeckMenuView.getInstance(player).printing("invalid command");
            return true;
        }
    }

    private void enterMenu() {
        DeckMenuView.getInstance(player).printing("menu navigation is not possible");
    }

    private void showCurrentMenu() {
        DeckMenuView.getInstance(player).printing("Deck");
    }

    private void createDeck(Matcher matcher) {
        String name = "";
        if (matcher.find()) {
            name = matcher.group(1);
        }
        if (player.getDeckByName(name) != null) {
            DeckMenuView.getInstance(player).printing("deck with name " + name + " already exists");
        } else {
            Deck deck = new Deck(name);
            player.addDeck(deck);
            DeckMenuView.getInstance(player).printing("deck created successfully!");
        }
    }

    private void deleteDeck(Matcher matcher) {
        String name = "";
        if (matcher.find()) {
            name = matcher.group(1);
        }
        if (player.getDeckByName(name) == null) {
            DeckMenuView.getInstance(player).printing("deck with name " + name + " does not exist");
        } else {
            player.getDecks().remove(player.getDeckByName(name));
            DeckMenuView.getInstance(player).printing("deck deleted successfully");
        }
    }

    private void setActiveDeck(Matcher matcher) {
        String name = "";
        if (matcher.find()) {
            name = matcher.group(1);
        }
        if (player.getDeckByName(name) == null) {
            DeckMenuView.getInstance(player).printing("deck with name " + name + " does not exist");
        } else {
            player.setActiveDeck(player.getDeckByName(name));
            DeckMenuView.getInstance(player).printing("deck activated successfully");
        }
    }

    private void addCard(String command) {
        if (addCardCheck(command) != null) {
            ArrayList<String> data = addCardCheck(command);
            String cardName = data.get(0);
            String deckName = data.get(1);
            if (data.get(2).equals("true")) {
                player.getDeckByName(deckName).getSideDeck().addCard(player.getCardByName(cardName));
                DeckMenuView.getInstance(player).printing("card added to deck successfully");
            } else {
                player.getDeckByName(deckName).getMainDeck().addCard(player.getCardByName(cardName));
                DeckMenuView.getInstance(player).printing("card added to deck successfully");
            }
        }
    }

    private ArrayList<String> addCardCheck(String command) {
        ArrayList<String> data = new ArrayList<>();
        String[] stringWords = command.split(" ");
        CmdLineParser parser = new CmdLineParser();
        CmdLineParser.Option<String> card = parser.addStringOption('c', "card");
        CmdLineParser.Option<String> deck = parser.addStringOption('d', "deck");
        CmdLineParser.Option<Boolean> side = parser.addBooleanOption("side");
        try {
            parser.parse(stringWords);
        } catch (CmdLineParser.OptionException e) {
            DeckMenuView.getInstance(player).printing("invalid command");
            return null;
        }
        Boolean sideValue = parser.getOptionValue(side);
        String cardName = parser.getOptionValue(card);
        String deckName = parser.getOptionValue(deck);
        if (player.isCardAvailable(cardName)) {
            DeckMenuView.getInstance(player).printing("card with name " + cardName + " does not exist");
            return null;
        } else if (player.getDeckByName(deckName) == null) {
            DeckMenuView.getInstance(player).printing("deck with name " + deckName + " does not exist");
            return null;
        } else if (isDeckFull(deckName, sideValue)) {
            return null;
        } else if (player.getDeckByName(deckName).getNumberOfCardByName(cardName) == 3) {
            DeckMenuView.getInstance(player).printing("there are already three cards with name "
                    + cardName + " in deck " + deckName);
            return null;
        } else {
            data.add(cardName);
            data.add(deckName);
            if (sideValue) data.add("true");
            else data.add("false");
            return data;
        }
    }

    private boolean isDeckFull(String deckName, Boolean sideValue) {
        if (sideValue) {
            if (player.getDeckByName(deckName).getSideDeck().getNumberOfCards() == 15) {
                DeckMenuView.getInstance(player).printing("side deck is full");
                return true;
            }
        } else {
            if (player.getDeckByName(deckName).getMainDeck().getNumberOfCards() == 60) {
                DeckMenuView.getInstance(player).printing("main deck is full");
                return true;
            }
        }
        return false;
    }

    private void removeCard(String command) {
        if (removeCardCheck(command) != null) {
            ArrayList<String> data = removeCardCheck(command);
            String cardName = data.get(0);
            String deckName = data.get(1);
            String sideValue = data.get(2);
            if (sideValue.equals("true")) {
                Card card = player.getDeckByName(deckName).getSideDeck().getCardByName(cardName);
                player.getDeckByName(deckName).getSideDeck().removeCard(card);
            } else {
                Card card = player.getDeckByName(deckName).getMainDeck().getCardByName(cardName);
                player.getDeckByName(deckName).getMainDeck().removeCard(card);
            }
            DeckMenuView.getInstance(player).printing("card removed form deck successfully");
        }
    }

    private ArrayList<String> removeCardCheck(String command) {
        String[] strings = command.split(" ");
        CmdLineParser parser = new CmdLineParser();
        CmdLineParser.Option<String> card = parser.addStringOption('c', "card");
        CmdLineParser.Option<String> deck = parser.addStringOption('d', "deck");
        CmdLineParser.Option<Boolean> side = parser.addBooleanOption("side");
        try {
            parser.parse(strings);
        } catch (CmdLineParser.OptionException e) {
            DeckMenuView.getInstance(player).printing("invalid command");
            return null;
        }
        String cardName = parser.getOptionValue(card);
        String deckName = parser.getOptionValue(deck);
        Boolean sideValue = parser.getOptionValue(side);
        if (player.getDeckByName(deckName) == null) {
            DeckMenuView.getInstance(player).printing("deck with name " + deckName + " does not exist");
            return null;
        } else if (!isInDeck(cardName, deckName, sideValue)) {
            if (sideValue)
                DeckMenuView.getInstance(player).printing("card with name " + cardName + " does not exist in side deck");
            else
                DeckMenuView.getInstance(player).printing("card with name " + cardName + " does not exist in main deck");
            return null;
        } else {
            ArrayList<String> data = new ArrayList<>();
            data.add(cardName);
            data.add(deckName);
            if (sideValue) data.add("true");
            else data.add("false");

            return data;
        }

    }

    private boolean isInDeck(String cardName, String deckName, Boolean sideValue) {
        MainDeck mainDeck = player.getDeckByName(deckName).getMainDeck();
        SideDeck sideDeck = player.getDeckByName(deckName).getSideDeck();
        if (sideValue) {
            if (sideDeck.getCardByName(cardName) == null) return false;
        } else {
            if (mainDeck.getCardByName(cardName) == null) return false;
        }
        return true;
    }

    private void showAllDecks() {
        ArrayList<Deck> decks = player.getDecks();
        Collections.sort(decks, new DeckCompare());
        Deck activeDeck = player.getActiveDeck();
        StringBuilder result = new StringBuilder("Decks:\nActive deck:\n");
        if (activeDeck != null) result.append(activeDeck.getName() + "\n");
        result.append("Other decks:\n");
        for (Deck deck : decks) {
            if (deck != activeDeck) {
                String deckName = deck.getName();
                int sideDeckNumber = deck.getSideDeck().getNumberOfCards();
                int mainDeckNumber = deck.getMainDeck().getNumberOfCards();
                String validation;
                if (mainDeckNumber >= 40) validation = "valid";
                else validation = "invalid";
                result.append(deckName + ": main deck " + mainDeckNumber + ", side deck " + sideDeckNumber + ", " + validation + "\n");
            }
        }
        String printResult = result.toString();
        DeckMenuView.getInstance(player).printing(printResult);

    }

    private void showSingleDeck(String command) {
        if (showSingleDeckCheck(command) == null) {
            DeckMenuView.getInstance(player).printing("invalid command");
        } else {
            String result = showSingleDeckCheck(command);
            DeckMenuView.getInstance(player).printing(result);
        }
    }

    private String showSingleDeckCheck(String command) {
        String[] strings = command.split(" ");
        CmdLineParser parser = new CmdLineParser();
        CmdLineParser.Option<String> deck = parser.addStringOption('d', "deck-name");
        CmdLineParser.Option<Boolean> side = parser.addBooleanOption("side");
        try {
            parser.parse(strings);
        } catch (CmdLineParser.OptionException e) {
            return null;
        }
        String deckName = parser.getOptionValue(deck);
        Boolean sideValue = parser.getOptionValue(side);
        StringBuilder result = new StringBuilder("Deck: " + deckName + "\n");
        if (sideValue) result.append("Side deck:\n");
        else result.append("Main deck:\n");
        result.append("Monsters:\n");
        ArrayList<Card> cards = player.getCards();
        Collections.sort(cards,new CardCompare());
        for (Card card : cards) {
            if (card instanceof Monster) {
                result.append(card.getName() + " : " + card.getDescription() + "\n");
            }
        }
        result.append("Spell and Traps:\n");
        for (Card card : cards) {
            if (card instanceof Magic) {
                result.append(card.getName() + " : " + card.getDescription() + "\n");
            }
        }
        String printResult = result.toString();
        return printResult;

    }
    private void showAllCards(){
        ArrayList<Card> cards = player.getCards();
        Collections.sort(cards,new CardCompare());
        StringBuilder result = new StringBuilder();
        for (Card card : cards){
            result.append(card.getName() + " : " + card.getDescription() + "\n");
        }
        DeckMenuView.getInstance(player).printing(result.toString());
    }
    static class DeckCompare implements Comparator<Deck> {
        public int compare(Deck deckOne, Deck deckTwo) {
            return deckOne.getName().compareTo(deckTwo.getName());
        }
    }
    static class CardCompare implements Comparator<Card>{
        public int compare(Card cardOne,Card cardTwo){
            return cardOne.getName().compareTo(cardTwo.getName());
        }
    }

    private void setPlayer(Player player) {
        this.player = player;
    }

    private Matcher getMatcher(String command, String regex) {
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(command);
    }
}
