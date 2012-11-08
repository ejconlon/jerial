package net.exathunk.jereal.genschema.card;

import java.lang.String;
import java.util.List;
import java.util.Map;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.dsl.*;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.gen.Any2;
import net.exathunk.jereal.base.gen.Any3;
import net.exathunk.jereal.base.jerializers.*;
import net.exathunk.jereal.genschema.address.GeneratedAddressContainer;
import net.exathunk.jereal.genschema.card.GeneratedCard;
import net.exathunk.jereal.genschema.geo.GeneratedGeoContainer;

public class GeneratedCardContainer implements GeneratedCardContainerLike, GeneratedCardContainerRefable {

    private final Ref<GeneratedCard> generatedCard;

    public GeneratedCardContainer() {
        generatedCard = new RefImpl<GeneratedCard>();
    }

    @Override
    public boolean hasGeneratedCard() {
        return !generatedCard.isEmptyRef();
    }
    @Override
    public GeneratedCard getGeneratedCard() {
        return generatedCard.getRef();
    }
    @Override
    public void setGeneratedCard(GeneratedCard value) {
        generatedCard.setRef(value);
    }
    @Override
    public Ref<GeneratedCard> getGeneratedCardRef() {
        return generatedCard;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("GeneratedCardContainer{ ");
        if (!generatedCard.isEmptyRef()) sb.append("generatedCard='").append(generatedCard).append("', ");
        return sb.append("}").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof GeneratedCardContainerLike) {
            GeneratedCardContainerLike other = (GeneratedCardContainerLike) o;
            if (hasGeneratedCard()) {
                if (!other.hasGeneratedCard()) return false;
                else if (!getGeneratedCard().equals(other.getGeneratedCard())) return false;
            } else if (other.hasGeneratedCard()) return false;
            return true;
        } else if (o instanceof GeneratedCardContainerRefable) {
            GeneratedCardContainerRefable other = (GeneratedCardContainerRefable) o;
            if (!getGeneratedCardRef().equals(other.getGeneratedCardRef())) return false;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + generatedCard.hashCode();
        return result;
    }

}
