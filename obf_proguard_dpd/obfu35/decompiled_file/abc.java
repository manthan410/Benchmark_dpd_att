
interface a {
   void a();
}

class d implements a {
   d() {
   }

   public void a() {
   }
}

class c implements a {
   c() {
   }

   public void a() {
   }
}

class b {
   private a a;

   b() {
   }

   public void a(a var1) {
      this.a = var1;
   }

   public void a() {
      this.a.a();
   }
}