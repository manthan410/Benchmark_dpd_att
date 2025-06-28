import java.util.Collection;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;

public interface a {
   JComboBox a(Collection var1, boolean var2);

   JComboBox a(Object[] var1, boolean var2);

   JComboBox a();

   JComboBox b();

   DefaultCellEditor a(JTextField var1);

   TableCellEditor a(JComboBox var1);
}
