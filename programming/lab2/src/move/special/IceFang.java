package move.special;

import ru.ifmo.se.pokemon.*;

public class IceFang extends SpecialMove {
    public IceFang() {
        super(Type.ICE, 65, 95);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        if (Math.random() <= 0.1) {
            Effect.freeze(p);
        }
    }
}
