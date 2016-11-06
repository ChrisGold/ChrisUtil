package de.ChrisGold.ChrisUtil;

/**
 * @author Christian Goldapp
 * @version 1.0
 */
public class Stopwatch {

    private long nanosTimeAtStart;
    private long nanosTimeAtStop;
    private boolean isRunning;

    public Stopwatch() {
        nanosTimeAtStart = System.nanoTime();
        isRunning = true;
    }

    public Stopwatch(boolean startRunning) {
        if (startRunning) {
            nanosTimeAtStart = System.nanoTime();
            isRunning = true;
        } else isRunning = false;
    }

    public void start() {
        nanosTimeAtStart = System.nanoTime();
        isRunning = true;
    }

    public long stop() {
        nanosTimeAtStop = System.nanoTime();
        isRunning = false;
        return nanosTimeAtStop - nanosTimeAtStart;
    }

    public long getElapsedTime() {
        if (isRunning) {
            long nanosSoFar = System.nanoTime();
            nanosSoFar = nanosSoFar - nanosTimeAtStart;
            return nanosSoFar;
        } else {
            return nanosTimeAtStop - nanosTimeAtStart;
        }
    }

    @Override
    public String toString() {
        return String.format("%dms elapsed.", getElapsedTime() / 1000);
    }
}
