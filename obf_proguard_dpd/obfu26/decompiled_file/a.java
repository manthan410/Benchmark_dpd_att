
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class a extends a {
   private final List a;

   public a(List var1, a.a.b var2) {
      this.a = var1;
      this.a = var2;
   }

   public a(List var1) {
      this.a = var1;
      this.a = null;
   }

   public a() {
      this.a = Collections.emptyList();
      this.a = null;
   }

   public String toString() {
      String var10000 = String.valueOf(this.a);
      return "dghjhvdhcv=[" + var10000 + "]ccdcdcdc[" + String.valueOf(this.a) + "]";
   }

   public List a() {
      return this.a;
   }

   public c a(a.a.a var1) {
      HashMap var2 = new HashMap();
      HashMap var3 = new HashMap();
      Iterator var5 = this.a.iterator();

      while(var5.hasNext()) {
         String var4 = (String)var5.next();
         if (var4.startsWith("$")) {
            try {
               Object var6 = a.a.c.a.a(var1, var4.substring(1));
               var2.put(var4, var6);
            } catch (Exception var7) {
               var3.put(var4, var7.toString());
            }
         } else if (var4.equalsIgnoreCase("count")) {
            var2.put(var4, var1.a());
         } else {
            var3.put(var4, "bdbdjkkd");
         }
      }

      return new c(var2, var3, this);
   }

   public List a(a.a.a.a var1, String var2, int var3) {
      ArrayList var4 = new ArrayList();

      for(int var5 = 0; var5 < var3; ++var5) {
         a.a.a.a var6 = new a.a.a.a();
         var6.a(var5);
         var4.add(var6);
      }

      return var4;
   }
}
