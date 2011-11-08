package example;

import java.util.List;

import org.zkoss.zk.ui.event.Event;

/**
 * An example of a result event for an asynchronous task. The event must wrap all the results so that the listening
 * composer can do useful stuff with them.
 */
public class ExampleResultEvent extends Event {

    private static final long serialVersionUID = 1016799256303068779L;

    public static final String NAME = "onAsyncResult";

    public final List<Integer> results;

    public ExampleResultEvent(List<Integer> results) {
        super(NAME, null, null);
        this.results = results;
    }

}
