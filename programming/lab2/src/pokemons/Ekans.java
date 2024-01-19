package pokemons;

import move.special.Acid;
import move.special.Screech;
import move.special.SludgeBomb;
import ru.ifmo.se.pokemon.*;

public class Ekans extends Pokemon {
    // покемон 1 поколения
    public Ekans(String name, int lvl){
        super(name, lvl);
        super.setType(Type.POISON);
        super.setStats(55, 70, 55, 40, 55, 85);

        this.setMove( new Screech(),  new SludgeBomb(), new Acid());

    }
}
