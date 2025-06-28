

import a.a.b.a.c;
import a.a.b.a.d;
import a.a.b.a.f;
import a.a.b.a.g;
import java.io.File;
import java.net.URI;
import java.util.logging.Level;

class e implements c {
   private final f a;

   public e(f var1) {
      this.a = var1;
   }

   public File a() {
      return this.a.a().b().a();
   }

   public File b() {
      a var1 = a.a.b.b.c.a(this.a);

      try {
         int var2 = this.a(var1);
         if (var2 < 5) {
            var1 = this.a(var1);
         }
      } catch (a.a.b.b.f var3) {
         a.b.a.a.a(Level.WARNING, "hcgdcgjdgcj(" + var3.a() + ")vckhehckhc");
      }

      if (var1 != null && var1.a().exists()) {
         return var1.a();
      } else {
         a.b.a.a.a(Level.WARNING, "jkagcgcjclckdjlckc");
         return new File(System.getProperty("java.home"));
      }
   }

   private a a(a var1) {
      a[] var2 = var1.a().a();
      a[] var6 = var2;
      int var5 = var2.length;

      for(int var4 = 0; var4 < var5; ++var4) {
         a var3 = var6[var4];
         if (this.a(var3) >= 5) {
            return var3;
         }
      }

      return null;
   }

   protected int a(a var1) {
      if (!(var1 instanceof b)) {
         throw new a.a.b.b.f();
      } else {
         String var2 = ((b)var1).a();
         if (var2 != null && var2.length() >= 3) {
            try {
               return var2.startsWith("1.") ? Integer.parseInt(var2.substring(2, 3)) : Integer.parseInt(var2.substring(0, var2.indexOf(46)));
            } catch (NumberFormatException var4) {
               throw new a.a.b.b.f(var2);
            }
         } else {
            throw new a.a.b.b.f(var2);
         }
      }
   }

   public boolean a() {
      return this.a.a().a();
   }

   public URI a() {
      return this.a.a().a();
   }

   public d[] a() {
      try {
         return this.a.a(true);
      } catch (g var2) {
         throw new RuntimeException(var2);
      }
   }

   public String a() {
      return this.a.a();
   }

   public boolean b() {
      int var1 = this.a.a().a(a.a.b.a.e.a, false, a.a.a.a.b.a);
      return var1 == 0;
   }

   public String b() {
      return (new a.a.b.a.a(new a.a.b.a.b())).a(this.a);
   }

   public a.a.a.b.b a() {
      try {
         return this.a.a();
      } catch (g var2) {
         throw new RuntimeException(var2);
      }
   }

   public boolean a(a.a.a.a.b var1) {
      return this.a.a(var1) || var1.a().equals(this.a.a());
   }

   public boolean b(a.a.a.a.b var1) {
      return var1.a().equals(this.a.a());
   }
}
