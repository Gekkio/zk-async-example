package example.lib;

import org.zkoss.zk.ui.Desktop;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;

/**
 * A base class for asynchronous tasks that send results back by wrapping them in a ZK event
 */
public abstract class AsyncTask implements Runnable {
    /**
     * The desktop that will receive the resulting event
     */
    private final Desktop desktop;
    /**
     * The event listener that will receive the resulting event
     */
    private final EventListener eventListener;

    protected AsyncTask(Desktop desktop, EventListener eventListener) {
        this.desktop = desktop;
        this.eventListener = eventListener;
    }

    /**
     * Executes the actual task
     * 
     * @return task results wrapped in a ZK event or null
     */
    protected abstract Event execute();

    public final void run() {
        Event result = this.execute();
        if (desktop.isAlive() && result != null) {
            Executions.schedule(desktop, eventListener, result);
        }
    }

}