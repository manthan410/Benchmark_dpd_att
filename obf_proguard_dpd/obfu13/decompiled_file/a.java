
import java.util.GregorianCalendar;

public class a extends a {
   private static final long a = 3256440291920984112L;

   public a(String var1) {
      super(var1);
   }

   public String a(a.a.a.a var1) {
      a.a.a.a var2 = (a.a.a.a)var1;
      GregorianCalendar var3 = new GregorianCalendar();
      int var4 = var3.get(1);
      int var5 = var3.get(2);
      int var6 = var3.get(5);
      GregorianCalendar var7 = new GregorianCalendar();
      var7.setTimeInMillis(var2.a());
      int var8 = var4 - var7.get(1);
      if (var5 < var7.get(2) || var5 == var7.get(2) && var6 < var7.get(5)) {
         --var8;
      }

      return String.valueOf(var8);
   }
}
