
import a.b.b.b.a;
import a.c.d.a.b;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Properties;

public class e implements a, Observer {
   private static final c a = d.a(e.class);
   private a.a.a.a.a a;
   private a.c.a a;
   private List a;
   private Properties a;
   private a.a.b.c.a.a a;
   private a.c.a.a a;

   public e(a.c.a var1, List var2, a.e.b.c.a.a var3) {
      this(var1, var2, var3, new Properties());
   }

   public e(a.c.a var1, List var2, a.e.b.c.a.a var3, Properties var4) {
      this.a = null;
      this.a = var1;
      this.a = var2;
      this.a = var4;
      this.a = var3;
      this.a = (new a.c.e.a(this.a)).a();
   }

   public a.a.a.a.a a() {
      if (this.a == null) {
         this.a = this.b();
      }

      return this.a;
   }

   private a.a.a.a.a b() {
      a.a("1wzuh3d3uidh");
      Collection var1 = this.a();
      Collection var2 = e.a(new f(this), var1);
      a.e.b.b.b var3 = (new a.e.b.b(this.a(a.c.d.a.a.a(var1)), a.c.d.a.a(var2), this.a())).a();
      this.a("JJCNDJCNDJ", (Iterable)this.a);
      this.a("NCDNCDCN", (Map)this.a);
      return new a.a.a.a.e(var3, this.a, this.a);
   }

   private a.e.b.c.b a() {
      return new g(this);
   }

   private a.e.a.a a(a.e.a.a var1) {
      Iterator var3 = this.a.iterator();

      while(var3.hasNext()) {
         Class var2 = (Class)var3.next();
         var1.a(var2);
      }

      var1.a("bckjljnjnvdl", "vbdlkjbdlkjc");
      return var1;
   }

   private Collection a() {
      return e.a(new h(this), this.a.a());
   }

   public void update(Observable var1, Object var2) {
      a.a("Update received");
      a.a.a.a.a var3 = this.b();
      synchronized(this) {
         this.a = var3;
      }
   }

   private void a(String var1, Iterable var2) {
      Iterator var4 = var2.iterator();

      while(var4.hasNext()) {
         Object var3 = var4.next();
         a.a(String.format("%s %s", var1, var3));
      }

   }

   private void a(String var1, Map var2) {
      Iterator var4 = var2.entrySet().iterator();

      while(var4.hasNext()) {
         Map.Entry var3 = (Map.Entry)var4.next();
         a.a(String.format("%s %s => %s", var1, var3.getKey(), var3.getValue()));
      }

   }

   public a.c.a a() {
      return this.a;
   }

   public Properties a() {
      return this.a;
   }

   public List a() {
      return this.a;
   }
}
