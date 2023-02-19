package rubyboat.oceaneer.gamelogic.events;

import rubyboat.oceaneer.events.ShoutBack;

public class TickShoutBack extends ShoutBack {
    TickShout shout;
    boolean skipNextTick = false;

    public boolean shouldSkipNextTick(boolean toggle) {
        if(toggle && skipNextTick) {
            skipNextTick = false;
            return true;
        }
        return skipNextTick;
    }

    public TickShoutBack() {
        super();
    }

    public void setShout(TickShout shout) {
        this.shout = shout;
    }

    @Override
    public void scream() {
        scream(0);
    }

    @Override
    public void scream(int number) {
        if(number == 0) {
            // All good
        }
    }
}
