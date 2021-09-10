
public class Dog
{
   private String name;
   public String breed;
   public int age;
   
   // Default constructor
   public Dog()
   {
   }
   
   public Dog(String n, String b, int a)
   {
      name = n;
      breed = b;
      age = a;
   }
   
   public void setName(String name)
   {
      this.name = name;
   }
   public String getName()
   {
      return name;
   }
   
   public void bark()
   {
      System.out.println(name + " says Woof");
   }
   
   public String toString()
   {
      return name + " is a " + breed + " and is " + age + " years old";
   }
}