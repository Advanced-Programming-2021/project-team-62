package Model.Cards.Magic;

import Model.Cards.Card;
import Model.Enums.Icon;

public class Magic extends Card {
    public Icon icon;

    public Magic(String name, String description, String type, String cardNumber, String cardType,Icon icon){
        super(name,description,type,cardNumber,cardType);
        setIcon(icon);
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public Icon getIcon() {
        return icon;
    }
}
