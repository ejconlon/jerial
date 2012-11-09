package net.exathunk.jereal.genschema;

import net.exathunk.jereal.base.dsl.PushableContext;
import net.exathunk.jereal.base.dsl.Questionable;
import net.exathunk.jereal.base.jerializers.RegistryBuilder;
import net.exathunk.jereal.base.jerializers.RegistryFactory;
import net.exathunk.jereal.genschema.address.Address;
import net.exathunk.jereal.genschema.address.AddressContainer;
import net.exathunk.jereal.genschema.address.AddressContainerJerializer;
import net.exathunk.jereal.genschema.address.AddressJerializer;
import net.exathunk.jereal.genschema.calendar.Calendar;
import net.exathunk.jereal.genschema.calendar.CalendarContainer;
import net.exathunk.jereal.genschema.calendar.CalendarContainerJerializer;
import net.exathunk.jereal.genschema.calendar.CalendarJerializer;
import net.exathunk.jereal.genschema.card.Card;
import net.exathunk.jereal.genschema.card.CardContainer;
import net.exathunk.jereal.genschema.card.CardContainerJerializer;
import net.exathunk.jereal.genschema.card.CardJerializer;
import net.exathunk.jereal.genschema.geo.Geo;
import net.exathunk.jereal.genschema.geo.GeoContainer;
import net.exathunk.jereal.genschema.geo.GeoContainerJerializer;
import net.exathunk.jereal.genschema.geo.GeoJerializer;
import net.exathunk.jereal.genschema.hyperschema.HyperSchema;
import net.exathunk.jereal.genschema.hyperschema.HyperSchemaContainer;
import net.exathunk.jereal.genschema.hyperschema.HyperSchemaContainerJerializer;
import net.exathunk.jereal.genschema.hyperschema.HyperSchemaJerializer;
import net.exathunk.jereal.genschema.hyperschemaoruri.HyperSchemaOrUri;
import net.exathunk.jereal.genschema.hyperschemaoruri.HyperSchemaOrUriContainer;
import net.exathunk.jereal.genschema.hyperschemaoruri.HyperSchemaOrUriContainerJerializer;
import net.exathunk.jereal.genschema.hyperschemaoruri.HyperSchemaOrUriJerializer;
import net.exathunk.jereal.genschema.interfaces.Interfaces;
import net.exathunk.jereal.genschema.interfaces.InterfacesContainer;
import net.exathunk.jereal.genschema.interfaces.InterfacesContainerJerializer;
import net.exathunk.jereal.genschema.interfaces.InterfacesJerializer;
import net.exathunk.jereal.genschema.jsonref.JsonRef;
import net.exathunk.jereal.genschema.jsonref.JsonRefContainer;
import net.exathunk.jereal.genschema.jsonref.JsonRefContainerJerializer;
import net.exathunk.jereal.genschema.jsonref.JsonRefJerializer;
import net.exathunk.jereal.genschema.links.Links;
import net.exathunk.jereal.genschema.links.LinksContainer;
import net.exathunk.jereal.genschema.links.LinksContainerJerializer;
import net.exathunk.jereal.genschema.links.LinksJerializer;
import net.exathunk.jereal.genschema.schema.Schema;
import net.exathunk.jereal.genschema.schema.SchemaContainer;
import net.exathunk.jereal.genschema.schema.SchemaContainerJerializer;
import net.exathunk.jereal.genschema.schema.SchemaJerializer;

public class GenschemaRegistryFactory<T extends PushableContext<T, U>, U extends Questionable> extends RegistryBuilder<T, U> {

    public GenschemaRegistryFactory() {
        add(Address.class, new AddressJerializer());
        add(AddressContainer.class, new AddressContainerJerializer());
        add(Calendar.class, new CalendarJerializer());
        add(CalendarContainer.class, new CalendarContainerJerializer());
        add(Card.class, new CardJerializer());
        add(CardContainer.class, new CardContainerJerializer());
        add(Geo.class, new GeoJerializer());
        add(GeoContainer.class, new GeoContainerJerializer());
        add(HyperSchema.class, new HyperSchemaJerializer());
        add(HyperSchemaContainer.class, new HyperSchemaContainerJerializer());
        add(HyperSchemaOrUri.class, new HyperSchemaOrUriJerializer());
        add(HyperSchemaOrUriContainer.class, new HyperSchemaOrUriContainerJerializer());
        add(Interfaces.class, new InterfacesJerializer());
        add(InterfacesContainer.class, new InterfacesContainerJerializer());
        add(JsonRef.class, new JsonRefJerializer());
        add(JsonRefContainer.class, new JsonRefContainerJerializer());
        add(Links.class, new LinksJerializer());
        add(LinksContainer.class, new LinksContainerJerializer());
        add(Schema.class, new SchemaJerializer());
        add(SchemaContainer.class, new SchemaContainerJerializer());
    }

}
