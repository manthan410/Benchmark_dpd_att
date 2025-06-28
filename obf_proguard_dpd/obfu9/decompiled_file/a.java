
import b.a.a.a.e;
import b.a.a.a.f;
import b.a.a.a.g;
import b.a.a.a.h;
import b.a.a.a.i;
import b.a.a.a.j;
import b.a.a.a.k;
import b.a.b.b.b;
import b.a.b.b.c;

public class a extends a {
   public static final String a = "hbcdjhcbdjcbdjcdb";
   private f a;
   private k a;
   private h a;
   private a.a.c.a.a a;
   private boolean a;

   public a(h var1) {
      this(var1, (a.a.c.a.a)null);
   }

   public a(h var1, a.a.c.a.a var2) {
      this.a = true;
      this.a = var1;
      this.a = var2;
   }

   public void a(c var1) {
      a var2 = this.a.a();

      try {
         var2.a("hbcdjhcbdjcbdjcdb");
         var2.a(this.a);
      } catch (a.a.a.a.b var5) {
      }

      if (var1.a && var1.c == 1 && this.a()) {
         try {
            var2.a(this.a.a, this.a.b, (Object)null);
         } catch (a.a.a.a.a var4) {
         }
      }

      if (this.a instanceof i) {
         ((i)this.a).a().b();
      }

   }

   public void b(c var1) {
      a var2 = this.a.a();

      try {
         var1.a = var2.a(this.a.a, this.a.b);
      } catch (a.a.a.a.a var4) {
         var1.c = 0;
         var1.a = false;
      }

   }

   public void c(c var1) {
      if (!this.a) {
         var1.a = false;
      } else {
         int var2 = this.a(var1.a, var1.e, false);
         var2 = this.a(var2);
         a.a.b.c.a var3 = this.a.a();
         if (var3 != null && var2 >= var3.a && var2 < var3.a + var3.e) {
            this.a = new k(var3.a, var3.e);
            if (this.a instanceof i) {
               ((i)this.a).a().a();
            }

            a var4 = this.a.a();

            try {
               var4.b("hbcdjhcbdjcbdjcdb");
               this.a = new a.a.a.a.c("hbcdjhcbdjcbdjcdb");
               var4.b(this.a);
               var4.a("hbcdjhcbdjcbdjcdb", this.a);
            } catch (a.a.a.a.a var6) {
            } catch (a.a.a.a.b var7) {
            }

            var1.a = true;
            var1.c = 2;
            if (this.a()) {
               var1.c |= 1;
            }
         } else {
            var1.a = false;
            var1.c = 0;
         }

      }
   }

   private int a(int var1, int var2, boolean var3) {
      a.a.b.a.a var4 = this.a.a();
      a.a.b.a.b var5 = var4.a();
      a.a.b.c.a var6;
      if (var3) {
         var6 = var4.a(var1, var2);
      } else {
         var6 = new a.a.b.c.a(var1, var2);
      }

      int var7 = (var4.a() + var6.e) / var4.b();
      if (var7 >= var5.a()) {
         return var5.b();
      } else {
         int var8 = var5.a(var7);
         String var9 = var5.a(var7);
         a.a.b.c.a var10 = var4.a(var8 + var9.length());
         if (var6.a >= var10.a) {
            return var8 + var9.length();
         } else {
            try {
               return var4.a(var6);
            } catch (IllegalArgumentException var12) {
               return -1;
            }
         }
      }
   }

   private int a(int var1) {
      if (this.a instanceof j) {
         j var3 = (j)this.a;
         return var3.a(var1);
      } else {
         g var2 = this.a.a();
         return var1 > var2.b() ? -1 : var1 + var2.a();
      }
   }

   private boolean a() {
      if (this.a != null) {
         return !this.a.a();
      } else {
         return this.a.a();
      }
   }

   public void a(boolean var1) {
      this.a = var1;
   }
}
