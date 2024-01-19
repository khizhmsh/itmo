package move.attack;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Type;

public class FocusEnergy extends PhysicalMove {
    // нельзя реализовать эффект
    public FocusEnergy() {
        super(Type.NORMAL, 0, 100);
    }
}
