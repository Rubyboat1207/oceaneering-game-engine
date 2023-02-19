package rubyboat.oceaneer.gamelogic;

import rubyboat.oceaneer.ThreadManager;
import rubyboat.oceaneer.events.ShoutBack;
import rubyboat.oceaneer.gamelogic.events.TickShout;
import rubyboat.oceaneer.input.Keyboard;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class GameLogicManager implements Runnable {
    public static GameLogicManager instance;
    public int desiredTickrate;
    public TickShout tickShout;
    public boolean shouldStop = false;
    Timer timer = new Timer();
    public Keyboard keyboard;

    public GameLogicManager() {
        this(20);
    }

    public GameLogicManager(int tickRate) {
        this.desiredTickrate = tickRate;
        this.tickShout = new TickShout();
        instance = this;
        ThreadManager.instance.setGameLoopInitialized();
    }

    static long tickRate = 0;

    @Override
    public void run() {

        System.out.println((long)  ((1.0 / this.desiredTickrate) * 1000L));

        timer.scheduleAtFixedRate(new TimerTask() {
            long lastExecution = System.currentTimeMillis();
            @Override
            public void run() {
                //how many ticks per second on average
                tickRate = (long) (1000.0 / (System.currentTimeMillis() - lastExecution));
                lastExecution = System.currentTimeMillis();
                if(shouldStop) {
                    timer.cancel();
                    return;
                }
                tickShout.Invoke();
            }
        }, 0, (long) ((1.0 / this.desiredTickrate) * 1000L));

        tickShout.subscribe(this::doGameTick);
    }

    void doGameTick(ShoutBack shoutBack) {
        //System.out.println("Tick");
    }

    public static long getLatestTickrate() {
        return tickRate;
    }
}
