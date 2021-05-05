package Model.Cards.Monster;

import Model.Cards.Card;
import Model.Enums.Attribute;
import Model.Enums.WarPosition;

public class Monster extends Card {
    private int level, attack, defence;
    Attribute attribute;
    WarPosition warPosition;


    public Monster(String name, String description, String type, String cardNumber, String cardType, int level, int attack, int defence, Attribute attribute) {
        super(name, description, type, cardNumber, cardType);
        this.level = level;
        this.attack = attack;
        this.attribute = attribute;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return this.level;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getAttack() {
        return this.attack;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getDefence() {
        return this.defence;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    public Attribute getAttribute() {
        return this.attribute;
    }

    public void setWarPosition(WarPosition warPosition) {
        this.warPosition = warPosition;
    }

    public WarPosition getWarPosition() {
        return this.warPosition;
    }


}
