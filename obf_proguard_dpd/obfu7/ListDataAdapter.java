
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
public abstract class ListDataAdapter implements ListDataListener
{
    public abstract void listDataChanged(ListDataEvent e);
    public void intervalAdded(ListDataEvent e)
    {
        listDataChanged(e);
    }
    public void intervalRemoved(ListDataEvent e)
    {
        listDataChanged(e);
    }
    public void contentsChanged(ListDataEvent e)
    {
        listDataChanged(e);
    }
}
