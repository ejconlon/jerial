package net.exathunk.jereal.genschema.card;

import java.util.List;
import java.util.Map;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.gen.Any2;
import net.exathunk.jereal.base.gen.Any3;
import net.exathunk.jereal.genschema.card.GeneratedCard;
import net.exathunk.jereal.genschema.card.GeneratedCardContainer;
import net.exathunk.jereal.genschema.links.GeneratedLinksContainer;

public interface GeneratedCardContainerLike {

        boolean hasGeneratedCard();
        GeneratedCard getGeneratedCard();
        void setGeneratedCard(GeneratedCard value);

}
