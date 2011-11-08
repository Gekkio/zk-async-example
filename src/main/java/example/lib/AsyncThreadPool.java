package example.lib;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.zkoss.zk.ui.WebApp;
import org.zkoss.zk.ui.util.WebAppCleanup;
import org.zkoss.zk.ui.util.WebAppInit;

/**
 * A thread pool whose lifecycle is tied to ZK webapp life cycle
 */
public class AsyncThreadPool implements WebAppInit, WebAppCleanup {
    private static ExecutorService EXECUTOR_SERVICE;

    public void init(WebApp webApp) {
        if (EXECUTOR_SERVICE == null) {
            EXECUTOR_SERVICE = Executors.newFixedThreadPool(20);
        }
    }

    public void cleanup(WebApp webApp) {
        EXECUTOR_SERVICE.shutdownNow();
        EXECUTOR_SERVICE = null;
    }

    /**
     * Submits a new asynchronous task for processing
     * 
     * @param task
     */
    public static void submit(AsyncTask task) {
        EXECUTOR_SERVICE.submit(task);
    }

}