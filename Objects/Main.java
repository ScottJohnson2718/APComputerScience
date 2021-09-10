
public class Main
{
   public static void main(String arg[])
   {
      Dog t = new Dog("Teddy", "Tibetian Spaniel", 10);
      Dog h = new Dog("Hana", "Saluki", 2);
      Dog k = new Dog("Kona", "Golden Retreiver", 8);
      
      // Sometimes I yell at Teddy when he is barking at the neighbors.
      // When I yell at him, I call him "Tedward".
      t.setName("Tedward");
      
      System.out.println(t);
      System.out.println(h);
      System.out.println(k);
      
      t.bark();
      h.bark();
      k.bark();
      
//       String a = "hello";
//       String b = "there";
//       String c = "hello";
//       
//       if (a == c)
//       {
//          System.out.println("a == c");
//       }
   }
}