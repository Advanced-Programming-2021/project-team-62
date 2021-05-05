package Model.Cards;


public class Card {
    public String name, description, type, cardNumber, cardType;

    public Card(String name, String description, String type, String cardNumber, String cardType) {
        this.setName(name);
        this.setDescription(description);
        this.setType(type);
        this.setCardNumber(cardNumber);
        this.setCardType(cardType);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardType() {
        return cardType;
    }
}
