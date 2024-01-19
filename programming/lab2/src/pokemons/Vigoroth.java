package pokemons;
import move.attack.FocusEnergy;
import move.special.Flamethrower;
import ru.ifmo.se.pokemon.*;
import pokemons.Slaking;
public class Vigoroth extends Slakoth{
    // покемон 2 поколения
    public Vigoroth(String name, int lvl) {
        super(name, lvl);
        // this.setType(Type.NORMAL); так как в родительском уже указан
        this.setStats(55, 70, 55, 40, 55, 85);

        // остальные атаки есть в родительсском классе Slakoth

        this.addMove( new FocusEnergy());
    }
}
