import a.a.b;

public class a {
   private static final a.a a = b.a(a.class);
   private static b.b a = null;
   private static Object a = new Object();

   private a() {
   }

   private static void b() {
      synchronized(a) {
         a = new b.b();
      }
   }

   public static b.b a() {
      if (a == null) {
         b();
      }

      return a;
   }

   public static void a() {
      synchronized(a) {
         try {
            a.a();
         } catch (Exception var2) {
         }

         a = null;
      }
   }
}
