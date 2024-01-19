package pokemons;

import move.special.Confide;
import move.special.DoubleTeam;
import move.special.EnergyBall;
import move.special.Flamethrower;
import ru.ifmo.se.pokemon.*;

public class Slakoth extends Pokemon {
    // покемон 1 поколения
    public Slakoth(String name, int lvl) {
        super(name, lvl);
        this.setType(Type.NORMAL);
        this.setStats(55, 70, 55, 40, 55, 85);

        DoubleTeam a1 = new DoubleTeam();
        this.addMove(a1);

        Flamethrower a2 = new Flamethrower();
        this.addMove(a2);
    }
}
