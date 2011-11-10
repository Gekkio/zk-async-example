package example;

import java.util.List;

import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.ListModelList;

import example.lib.AsyncThreadPool;

public class WindowComposer extends GenericForwardComposer {

    private static final long serialVersionUID = -819677918391466305L;

    private Intbox amount;
    private Grid results;
    private Button runButton;

    /**
     * This event listener method will be called once the results are ready
     * 
     * @param event
     */
    public void onAsyncResult(ExampleResultEvent event) {
        visualizeProcessingEnd(event.results);
    }

    public void onClick$runButton() {
        // First we must make sure that server push is enabled
        if (!desktop.isServerPushEnabled()) {
            desktop.enableServerPush(true);
        }

        // We'll create a task object that contains all the required task parameters
        ExampleTask task = new ExampleTask(desktop, this, amount.intValue());
        // Then we'll submit the task for processing
        AsyncThreadPool.submit(task);

        visualizeProcessingStart();
    }

    /**
     * Visually indicates that processing has finished, and shows the results
     * 
     * @param resultData
     *            results from processing
     */
    private void visualizeProcessingEnd(List<Integer> resultData) {
        // Re-enable the button
        runButton.setDisabled(false);
        runButton.setLabel("Run task");

        // Let's visualize results in the grid
        results.setModel(new ListModelList(resultData));
    }

    /**
     * Visually indicates that processing has started
     */
    private void visualizeProcessingStart() {
        // Let's disable the button so the user cannot start another task while a previous one is processing
        runButton.setDisabled(true);
        runButton.setLabel("Running...");
    }

}
