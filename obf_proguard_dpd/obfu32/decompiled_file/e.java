
import java.util.ArrayList;

class e extends a {
   private ArrayList a = new ArrayList();
   private int c;
   private int d;
   private String a;

   e(String var1, int var2, int var3) {
      this.a = true;
      this.b = true;
      this.a = var1;
      this.c = var2;
      this.d = var2 + var3;
   }

   public d[] a() {
      return (d[])this.a.toArray(new d[this.a.size()]);
   }

   public int a(d var1) {
      if (var1.a()) {
         c var2 = var1.a();
         if (!var2.a().equals(this.a)) {
            return 0;
         }

         int var3 = var2.a();
         if (this.c <= var3 && var3 + var2.b() <= this.d) {
            this.a.add(var1);
         }
      }

      return super.a(var1);
   }

   public int a(b var1) {
      c var2 = var1.a();
      if (var2 != null) {
         if (!var2.a().equals(this.a)) {
            return 0;
         }

         int var3 = var2.a();
         if (var3 + var2.b() <= this.c || this.d <= var3) {
            return 0;
         }
      }

      return 0;
   }
}
