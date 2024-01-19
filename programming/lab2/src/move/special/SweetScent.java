package move.special;

import ru.ifmo.se.pokemon.*;

public class SweetScent extends SpecialMove {
    public SweetScent() {
        super(Type.NORMAL, 0, 100);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        Effect e = new Effect().chance(1).stat(Stat.EVASION, -1);
        p.addEffect(e);
    }
}
