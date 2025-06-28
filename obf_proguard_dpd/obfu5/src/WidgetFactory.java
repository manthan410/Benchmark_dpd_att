
import java.util.Collection;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;
public interface WidgetFactory {
    JComboBox<String> createComboBox(Collection<String> model, boolean sort);
    <E> JComboBox<E> createComboBox(E[] model, boolean sort);
    <E> JComboBox<E> createComboBox();
    <E> JComboBox<E> createUndoableComboBox();
    DefaultCellEditor createCellEditor(JTextField textField);
    TableCellEditor createCellEditor(JComboBox<?> combo);
}
