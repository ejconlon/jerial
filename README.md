Jereal
======

I started this to try to work with JSON-Schema in a strongly-typed language (Java).  In the process I wrote a bunch of stuff... JSON parser, AST nodes, visitors, code generators, serialization primitives, generated serialization and prototyping functions, etc.  In short, it turns a schema like this:

> {
>   "id": "http://example.com/bag",
>   "properties": {
>     "s": {
>       "type":"string"
>     },
>     "b": {
>       "type":"boolean"
>     },
>     "d": {
>       "type":"number"
>     },
>     "l": {
>       "type":"integer"
>     },
>     "next": {
>       "type":"#"
>     }
>   }
> }

into an object like this (modulo some plumbing):

> public class Bag {
>   String s;
>   Boolean b;
>   Long l;
>   Double d;
>   Bag next;
> }

and a (de)serialization function like this:

> public <...> serialize(Recurser recurser, DSL dsl, Bag domain) {
>     ObjectDSL objectDSL = dsl.seeObject();
>     objectDSL.seeString("s", domain.s);
>     objectDSL.seeBoolean("b", domain.b);
>     objectDSL.seeLong("l", domain.l);
>     objectDSL.seeDouble("d", domain.d);
>     objectDSL.seeWritable(recurser.seeCustom(dsl, domain.next, Bag.class));
>     return objectDSL;
> }

I'm just short of boostrapping the thing with a few core generated Schema classes, but to really be happy with that I'd have to go back and rework a few things.  The main headache is that union types are numerous in the core schemas, which makes the generated classes huge and awkward to work with.  I figure I've learned enough to move on now.
