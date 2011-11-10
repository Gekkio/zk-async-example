package example;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Window;

public class MainComposer extends GenericForwardComposer {

    private static final long serialVersionUID = -611069335553460893L;

    private int counter = 1;

    public void onClick$addButton() {
        Window window = (Window) Executions.createComponents("~./example/window.zul", self, null);

        window.setTitle("Task window " + counter);

        // Add the new window to a slightly random position
        int left = (int) (Math.random() * 50);
        int top = (int) (Math.random() * 50);
        window.setLeft(left + "%");
        window.setTop(top + "%");

        counter += 1;
    }

    public void onClick$alertButton() {
        Clients.alert("Test");
    }

}
