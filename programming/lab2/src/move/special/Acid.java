package move.special;

import ru.ifmo.se.pokemon.*;

public class Acid extends SpecialMove {
    public Acid() {
        super(Type.POISON, 40, 100);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        Effect e = new Effect().chance(0.1).stat(Stat.SPECIAL_DEFENSE, -1);
        p.addEffect(e);
    }
}
