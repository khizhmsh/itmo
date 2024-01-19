package move.special;

import ru.ifmo.se.pokemon.*;

public class DoubleTeam extends SpecialMove {
    public DoubleTeam() {
        super(Type.NORMAL, 0, 100);
    }

    @Override
    protected void applySelfEffects(Pokemon p) {
        Effect e = new Effect().chance(1).stat(Stat.EVASION, +1);
        p.addEffect(e);
    }
}
