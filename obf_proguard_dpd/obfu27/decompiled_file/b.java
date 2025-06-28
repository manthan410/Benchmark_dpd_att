

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.io.Serializable;

final class b implements a, Serializable {
   private final String c;
   private final ActionListener a;

   public b(String var1, ActionListener var2) {
      this.c = var1;
      this.a = var2;
   }

   public boolean a() {
      return true;
   }

   public void a(boolean var1) {
   }

   public void a(PropertyChangeListener var1) {
   }

   public void b(PropertyChangeListener var1) {
   }

   public Object a(String var1) {
      if (a.a.a.a.equals(var1)) {
         return this.a;
      } else {
         return a.a.a.b.equals(var1) ? this.c : null;
      }
   }

   public void a(String var1, Object var2) {
   }

   public void a(ActionEvent var1) {
      this.a.actionPerformed(var1);
   }
}
