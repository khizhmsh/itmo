import pokemons.*;
import ru.ifmo.se.pokemon.*;

public class Main {
    public static void main(String[] args){

        Abrock p1 = new Abrock("Abrock", 35);
        Ekans p2 = new Ekans("Ekans", 35);
        Maractus p3 = new Maractus("Maractus", 35);
        Slakoth p4 = new Slakoth("Slakoth", 35);
        Slaking p5 = new Slaking("Slaking", 47);
        Vigoroth p6 = new Vigoroth("Vigoroth", 35);

        Battle battle = new Battle();
        battle.addAlly(p1);
        battle.addAlly(p3);
        battle.addAlly(p5);

        battle.addFoe(p2);
        battle.addFoe(p4);
        battle.addFoe(p6);
        battle.go();
    }
}
