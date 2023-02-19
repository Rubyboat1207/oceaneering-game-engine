package rubyboat.oceaneer.events;

public abstract class ShoutBack {
    public boolean shouldCancel;

    public abstract void scream();
    public abstract void scream(int number);
}
