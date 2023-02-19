package rubyboat.oceaneer.events;

import java.util.ArrayList;

public class GeneralShout {
    ArrayList<ShoutListener> listeners = new ArrayList<>();
    ArrayList<Integer> requestedPriorities = new ArrayList<>();
    protected ShoutBack shoutBack;

    public GeneralShout(ShoutBack shoutBack) {
        this.shoutBack = shoutBack;
    }

    public void Invoke() {
        for (ShoutListener listener : listeners) {
            listener.onShout(shoutBack);
            if(shoutBack.shouldCancel) {
                shoutBack.shouldCancel = false;
                return;
            }
        }
    }

    public void subscribe(ShoutListener listener) {
        subscribe(listener, 0);
    }

    public void subscribe(ShoutListener listener, int priority) {
        if(priority == 0) {
            listeners.add(0, listener);
            requestedPriorities.add(0, priority);
            return;
        }
        for(int i = 0; i < listeners.size(); i++) {
            if(requestedPriorities.get(i) < priority) {
                listeners.add(i, listener);
                requestedPriorities.add(i, priority);
                return;
            }
        }
    }

    public void Unsubscribe(ShoutListener listener) {
        listeners.remove(listener);
    }

    public interface ShoutListener {
        void onShout(ShoutBack shoutBack);
    }
}
