package pokemons;
import move.special.*;
import ru.ifmo.se.pokemon.*;
import pokemons.Ekans;
public class Abrock extends Ekans {
    // покемон 2 поколения
    public Abrock(String name, int lvl){
        super(name, lvl);
        // this.setType(Type.POISON); так как в родительском уже указан
        this.setStats(55, 70, 55, 40, 55, 85);

        // остальные атаки добавлять не надо, так они есть в родительсском классе Ekans
        IceFang a1 = new IceFang();
        this.addMove(a1);
    }
}
