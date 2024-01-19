package move.special;

import ru.ifmo.se.pokemon.*;

public class Screech extends SpecialMove{
    public Screech() {
        super(Type.NORMAL, 0, 85);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        Effect e = new Effect().chance(1).stat(Stat.DEFENSE, -2);
        p.addEffect(e);
    }
}
