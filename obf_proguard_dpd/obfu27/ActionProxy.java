
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.io.Serializable;
@SuppressWarnings("serial")
final class ActionProxy implements Action, Serializable {
    private final String command;
    private final ActionListener listener;
    public ActionProxy(final String command, final ActionListener listener) {
        super();
        this.command = command;
        this.listener = listener;
    }
    public boolean isEnabled() {
        return true;
    }
    public void setEnabled(final boolean enabled) {
    }
    public void addPropertyChangeListener(final PropertyChangeListener listener) {
    }
    public void removePropertyChangeListener(final PropertyChangeListener listener) {
    }
    public Object getValue(final String valueName) {
        if (Action.NAME.equals(valueName)) {
            return listener;
        }
        if (Action.ACTION_COMMAND_KEY.equals(valueName)) {
            return command;
        }
        return null;
    }
    public void putValue(final String valueName, final Object value) {
    }
    public void actionPerformed(final ActionEvent event) {
        listener.actionPerformed(event);
    }
}
