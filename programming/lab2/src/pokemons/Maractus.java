package pokemons;
import move.special.*;
import ru.ifmo.se.pokemon.*;

public class Maractus extends Pokemon{
    // покемон 1 поколения
    public Maractus(String name, int lvl){
        super(name, lvl);
        this.setType(Type.GRASS);
        this.setStats(55, 70, 55, 40, 55, 85);

        Confide a1 = new Confide();
        this.addMove(a1);

        EnergyBall a2 = new EnergyBall();
        this.addMove(a2);

        PoisonJab a3 = new PoisonJab();
        this.addMove(a3);

        SweetScent a4 = new SweetScent();
        this.addMove(a4);
    }
}
