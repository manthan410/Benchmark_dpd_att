
import a.a.a.b.a;
import a.a.a.b.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class b extends a {
   private c a;

   public b(Class var1) {
      super(var1);
   }

   public b(Class var1, a.a.a.b.c var2) {
      super(var1, var2);
   }

   public a a() {
      a.a.a.b.b var1 = this.a();
      if (var1.a(a.a.a.a.a.a.class)) {
         List var2 = var1.a(a.a.a.a.a.a.class, Class.class, "modules");
         ArrayList var3 = new ArrayList();
         Iterator var5 = var2.iterator();

         while(var5.hasNext()) {
            Class var4 = (Class)var5.next();

            try {
               var3.add((d)var4.newInstance());
            } catch (Exception var7) {
               this.a().a(var4, var7);
            }
         }

         if (var3.size() > 0) {
            this.a = this.a((List)var3);
         }
      } else {
         this.a().a(a.a.a.a.a.a.class, this.a());
      }

      return super.a();
   }

   public a.a.a.a.b a(a var1) {
      a.a.a.a.b var2 = super.a(var1);
      return (a.a.a.a.b)(this.a != null ? new a.a.a.a.a(new a.a.a.a.a.a(var1, this.a), var2) : var2);
   }

   protected a.a.a.a.c a(a.a.a.b.b var1, a.a.a.c.a var2, a.a.a.d.a var3) {
      a.a.a.a.c var4 = super.a(var1, var2, var3);
      return this.a != null ? var4.a(this.a.a(a.a.a.a.d.class)) : var4;
   }

   protected Object a(Class var1, Class var2) {
      if (this.a != null) {
         Object var3 = null;

         try {
            var3 = this.a.b(var1);
         } catch (a.b.a.a.a var5) {
            var3 = this.a.b(var2);
         }

         if (var3 != null) {
            return var3;
         }
      }

      return super.a(var1, var2);
   }

   protected c a(List var1) {
      if (this.a != null) {
         return this.a;
      } else {
         Class var2 = this.a().a(a.a.a.a.a.a.class, Class.class, "container");
         a.b.a var3 = (a.b.a)this.a(a.b.a.class, var2);
         Iterator var5 = var1.iterator();

         while(var5.hasNext()) {
            d var4 = (d)var5.next();
            var4.a(var3);
         }

         return var3;
      }
   }

   protected c a() {
      return this.a;
   }
}
