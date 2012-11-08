package net.exathunk.jereal.genschema.card;

import java.lang.String;
import java.util.List;
import java.util.Map;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.dsl.*;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.gen.Ref1;
import net.exathunk.jereal.base.gen.Ref2;
import net.exathunk.jereal.base.gen.Ref3;
import net.exathunk.jereal.base.jerializers.*;
import net.exathunk.jereal.genschema.address.AddressContainer;
import net.exathunk.jereal.genschema.card.Card;
import net.exathunk.jereal.genschema.geo.GeoContainer;

public class CardContainer implements CardContainerLike, CardContainerRefable {

    private final Ref<Card> card;

    public CardContainer() {
        card = new RefImpl<Card>();
    }

    @Override
    public boolean hasCard() {
        return !card.isEmptyRef();
    }
    @Override
    public Card getCard() {
        return card.getRef();
    }
    @Override
    public void setCard(Card value) {
        card.setRef(value);
    }
    @Override
    public Ref<Card> getCardRef() {
        return card;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("CardContainer{ ");
        if (!card.isEmptyRef()) sb.append("card='").append(card).append("', ");
        return sb.append("}").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof CardContainerRefable) {
            CardContainerRefable other = (CardContainerRefable) o;
            if (!getCardRef().equals(other.getCardRef())) return false;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + card.hashCode();
        return result;
    }

}
