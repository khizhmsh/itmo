package pokemons;
import move.special.Confide;
import move.special.EnergyBall;
import move.special.Flamethrower;
import ru.ifmo.se.pokemon.*;
import pokemons.Slakoth;

public class Slaking extends Vigoroth{
    // покемон 3 поколения
    public Slaking(String name, int lvl) {
        super(name, lvl);
        // this.setType(Type.NORMAL); так как в родительском уже указан
        this.setStats(55, 70, 55, 40, 55, 85);

        // остальные атаки добавлять не надо, так они есть в родительсском классе Vigoroth
        Flamethrower a1 = new Flamethrower();
        this.addMove(a1);
    }
}
