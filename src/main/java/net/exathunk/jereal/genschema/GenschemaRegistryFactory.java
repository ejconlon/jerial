package net.exathunk.jereal.genschema;

import net.exathunk.jereal.base.dsl.PushableContext;
import net.exathunk.jereal.base.dsl.Questionable;
import net.exathunk.jereal.base.jerializers.RegistryBuilder;
import net.exathunk.jereal.base.jerializers.RegistryFactory;
import net.exathunk.jereal.genschema.address.Address;
import net.exathunk.jereal.genschema.address.AddressJerializer;
import net.exathunk.jereal.genschema.calendar.Calendar;
import net.exathunk.jereal.genschema.calendar.CalendarJerializer;
import net.exathunk.jereal.genschema.card.Card;
import net.exathunk.jereal.genschema.card.CardJerializer;
import net.exathunk.jereal.genschema.geo.Geo;
import net.exathunk.jereal.genschema.geo.GeoJerializer;
import net.exathunk.jereal.genschema.hyperschema.HyperSchema;
import net.exathunk.jereal.genschema.hyperschema.HyperSchemaJerializer;
import net.exathunk.jereal.genschema.hyperschemaoruri.HyperSchemaOrUri;
import net.exathunk.jereal.genschema.hyperschemaoruri.HyperSchemaOrUriJerializer;
import net.exathunk.jereal.genschema.interfaces.Interfaces;
import net.exathunk.jereal.genschema.interfaces.InterfacesJerializer;
import net.exathunk.jereal.genschema.jsonref.JsonRef;
import net.exathunk.jereal.genschema.jsonref.JsonRefJerializer;
import net.exathunk.jereal.genschema.links.Links;
import net.exathunk.jereal.genschema.links.LinksJerializer;
import net.exathunk.jereal.genschema.schema.Schema;
import net.exathunk.jereal.genschema.schema.SchemaJerializer;

public class GenschemaRegistryFactory<T extends PushableContext<T, U>, U extends Questionable> extends RegistryBuilder<T, U> {

    public GenschemaRegistryFactory() {
        add(Address.class, new AddressJerializer());
        add(Calendar.class, new CalendarJerializer());
        add(Card.class, new CardJerializer());
        add(Geo.class, new GeoJerializer());
        add(HyperSchema.class, new HyperSchemaJerializer());
        add(HyperSchemaOrUri.class, new HyperSchemaOrUriJerializer());
        add(Interfaces.class, new InterfacesJerializer());
        add(JsonRef.class, new JsonRefJerializer());
        add(Links.class, new LinksJerializer());
        add(Schema.class, new SchemaJerializer());
    }

}
