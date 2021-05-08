package Controller;

import Model.Deck.Deck;
import Model.Player;
import View.DeckMenuView;
import View.Regex;
import com.sanityinc.jargs.CmdLineParser;

import java.util.ArrayList;
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

        } else if (getMatcher(command, deckMenuRegex.get(3)).find()) {

            return true;
        } else if (getMatcher(command, deckMenuRegex.get(4)).find()) {

            return true;
        } else if (getMatcher(command, deckMenuRegex.get(5)).find()) {

            return true;
        } else if (getMatcher(command, deckMenuRegex.get(6)).find()) {

            return true;
        } else if (getMatcher(command, deckMenuRegex.get(7)).find()) {

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
        }else {
            player.setActiveDeck(player.getDeckByName(name));
            DeckMenuView.getInstance(player).printing("deck activated successfully");
        }
    }
    private void addCard(String command){
        if (addCardCheck(command) != null){
            ArrayList<String> data = addCardCheck(command);
            String cardName = data.get(0);
            String deckName = data.get(1);
            if (data.get(2).equals("true")){
                player.getDeckByName(deckName).getSideDeck().addCard(player.getCardByName(cardName));
                DeckMenuView.getInstance(player).printing("card added to deck successfully");
            }else {
                player.getDeckByName(deckName).getMainDeck().addCard(player.getCardByName(cardName));
                DeckMenuView.getInstance(player).printing("card added to deck successfully");
            }
        }
    }
    private ArrayList<String> addCardCheck(String command){
        ArrayList<String> data = new ArrayList<>();
        String[] stringWords = command.split(" ");
        CmdLineParser parser = new CmdLineParser();
        CmdLineParser.Option<String> card = parser.addStringOption('c',"card");
        CmdLineParser.Option<String> deck = parser.addStringOption('d',"deck");
        CmdLineParser.Option<Boolean> side = parser.addBooleanOption("side");
        try {
            parser.parse(stringWords);
        }catch (CmdLineParser.OptionException e){
            DeckMenuView.getInstance(player).printing("invalid command");
            return null;
        }
        Boolean sideValue = parser.getOptionValue(side);
        String cardName = parser.getOptionValue(card);
        String deckName = parser.getOptionValue(deck);
        if (player.isCardAvailable(cardName)){
            DeckMenuView.getInstance(player).printing("card with name "+cardName+" does not exist");
            return null;
        }else if (player.getDeckByName(deckName)==null){
            DeckMenuView.getInstance(player).printing("deck with name "+deckName+" does not exist");
            return null;
        }else if (isDeckFull(deckName,sideValue)){
            return null;
        }else if (player.getDeckByName(deckName).getNumberOfCardByName(cardName)==3){
            DeckMenuView.getInstance(player).printing("there are already three cards with name "
                    +cardName+" in deck "+deckName);
            return null;
        }else{
            data.add(cardName);
            data.add(deckName);
            if (sideValue) data.add("true");
            else data.add("false");
            return data;
        }
    }
    private boolean isDeckFull(String deckName,Boolean sideValue){
        if (sideValue){
            if (player.getDeckByName(deckName).getSideDeck().getNumberOfCards()==15){
                DeckMenuView.getInstance(player).printing("side deck is full");
                return true;
            }
        }else {
            if (player.getDeckByName(deckName).getMainDeck().getNumberOfCards()==60){
                DeckMenuView.getInstance(player).printing("main deck is full");
                return true;
            }
        }
        return false;
    }

    private void setPlayer(Player player) {
        this.player = player;
    }

    private Matcher getMatcher(String command, String regex) {
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(command);
    }
}
