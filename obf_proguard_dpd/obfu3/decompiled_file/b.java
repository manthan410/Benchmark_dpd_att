import b.a.a.c.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class b extends a {
   private a.a.a.b a;

   public b(a.a.b.a var1) {
      super(var1);
   }

   protected List a() {
      ArrayList var1 = new ArrayList();
      Iterator var3 = this.a.iterator();

      while(var3.hasNext()) {
         Object var2 = var3.next();
         var1.add(var2.getClass());
      }

      return var1;
   }

   public Object a(Class var1) {
      Iterator var3 = this.a.iterator();

      while(var3.hasNext()) {
         Object var2 = var3.next();
         if (var1.equals(var2.getClass())) {
            return var2;
         }
      }

      throw new a.a(var1, this);
   }
}
