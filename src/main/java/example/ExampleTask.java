package example;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zk.ui.Desktop;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;

import example.lib.AsyncTask;

/**
 * An example of an asyncronous task. This doesn't do any meaningful work but shows the basic idea.
 */
public class ExampleTask extends AsyncTask {

    private final int amount;

    protected ExampleTask(Desktop desktop, EventListener eventListener, int amount) {
        super(desktop, eventListener);
        this.amount = amount;
    }

    @Override
    protected Event execute() {
        List<Integer> results = new ArrayList<Integer>(amount);

        for (int i = 0; i < amount; i++) {
            int randomNumber = (int) (Math.random() * 100);
            results.add(randomNumber);
        }

        // We'll sleep for amount * 5s to simulate a long-running process
        try {
            Thread.sleep(amount * 5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new ExampleResultEvent(results);
    }

}
