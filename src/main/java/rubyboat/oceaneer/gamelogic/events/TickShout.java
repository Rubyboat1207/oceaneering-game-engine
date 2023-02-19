package rubyboat.oceaneer.gamelogic.events;

import rubyboat.oceaneer.events.GeneralShout;
import rubyboat.oceaneer.events.ShoutBack;

public class TickShout extends GeneralShout {
    public TickShout() {
        super(new TickShoutBack());
    }

    @Override
    public void Invoke() {
        if(((TickShoutBack) this.shoutBack).shouldSkipNextTick(true)) {
            //return;
        }
        super.Invoke();
    }
}
