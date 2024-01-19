package pokemons;

import move.special.Acid;
import move.special.Screech;
import move.special.SludgeBomb;
import ru.ifmo.se.pokemon.*;

public class Ekans extends Pokemon {
    // покемон 1 поколения
    public Ekans(String name, int lvl){
        super(name, lvl);
        this.setType(Type.POISON);
        this.setStats(55, 70, 55, 40, 55, 85);

        Screech a1 = new Screech();
        this.addMove(a1);

        SludgeBomb a2 = new SludgeBomb();
        this.addMove(a2);

        Acid a3 = new Acid();
        this.addMove(a3);
    }
}

