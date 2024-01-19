package move.special;

import ru.ifmo.se.pokemon.*;

public class Confide extends SpecialMove {
    public Confide() {
        super(Type.NORMAL, 0, 100);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        Effect e = new Effect().chance(1).stat(Stat.SPECIAL_ATTACK, -1);
        p.addEffect(e);
    }
}
