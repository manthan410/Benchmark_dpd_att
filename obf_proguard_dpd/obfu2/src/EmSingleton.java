
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class EmSingleton {
    private static final Logger logger = LoggerFactory.getLogger(EmSingleton.class);
    private static EventManager instance_ = null;
    private static Object syncObject_ = new Object();
    private EmSingleton() {
        super();
    }
    private static void intialize() throws Exception {
        synchronized (syncObject_) {
            instance_ = new EventManager();
        }
    }
    public static EventManager get() throws Exception {
        if (instance_ == null) {
            intialize();
        }
        return instance_;
    }
    public static void release() {
        synchronized (syncObject_) {
            try {
                instance_.stopLogListener();
            } catch (Exception e) {
            }
            instance_ = null;
        }
    }
}