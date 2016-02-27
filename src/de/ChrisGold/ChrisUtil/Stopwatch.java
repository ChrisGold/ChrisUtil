package de.ChrisGold.ChrisUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Christian Goldapp
 * @version 1.0
 */
public class Stopwatch {

    private long millisTimeAtStart;
    private long millisTimeAtStop;
    private boolean isRunning;

    public Stopwatch() {
        millisTimeAtStart = System.currentTimeMillis();
        isRunning = true;
    }

    public Stopwatch(boolean startRunning) {
        if (startRunning) {
            millisTimeAtStart = System.currentTimeMillis();
            isRunning = true;
        } else isRunning = false;
    }

    public void start() {
        millisTimeAtStart = System.currentTimeMillis();
        isRunning = true;
    }

    public long stop() {
        millisTimeAtStop = System.currentTimeMillis();
        isRunning = false;
        return millisTimeAtStop - millisTimeAtStart;
    }

    public long getElapsedTime() {
        if (isRunning) {
            long millisSoFar = System.currentTimeMillis();
            millisSoFar = millisSoFar - millisTimeAtStart;
            return millisSoFar;
        } else {
            return millisTimeAtStop - millisTimeAtStart;
        }
    }

}
