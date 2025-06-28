
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

public abstract class a implements ListDataListener {
   public a() {
   }

   public abstract void a(ListDataEvent var1);

   public void b(ListDataEvent var1) {
      this.a(var1);
   }

   public void c(ListDataEvent var1) {
      this.a(var1);
   }

   public void d(ListDataEvent var1) {
      this.a(var1);
   }
}
