
public class Ifs
{
   // Demonstate many different kinds of if-statements
   public static void lotsOfIfs()
   {
      boolean someExpression = true;
      
      // This is an if-statement
      if (someExpression) {
         // If 'someExpression' evaluatates to 'true' then the code in the braces {} will be run
         // If 'someExpression' evaluates to 'false' then the code in the braces {} will be skipped
         System.out.println("'someExpression' was true");
      }
      
      // This is the same as above but doesn't have braces. It is valid Java but
      // it is considered good style to always use the braces
      if (someExpression)
         System.out.println("'someExpression' was true here too");
         
      // Beware of code that is indented wrong. 
      if (someExpression)
         System.out.println("This line only runs if 'someExpression' is true");
         System.out.println("This line always runs! The indentation does not matter. This is why we always use braces.");
   
      // Example showing how an if-else statement works
      if (someExpression)
      {
         System.out.println("This will be printed if the expression is true");
      }
      else
      {
         System.out.println("This will be printed if the expression is false");
         System.out.println("And so will this.");
      }
      
      float heightInInches = 36.0f;
      if (heightInInches > 42.0f)
      {
         System.out.println("You are tall enough to ride the ride");
      }
      
      if (heightInInches > 42.0f)
      {
         System.out.println("You are tall enough to ride the ride");
      }
      else
      {
         System.out.println("You are NOT tall enough to ride the ride. Try the merry go round.");
      }
      
      boolean accompaniedByAnAdult = true;
      float age = 15;
      
      // || means "or" so if either of the clauses are true then the whole expression is true.
      // If the age is greater than or equal to 17 OR accompanied by an adult then the expression is true
      if (age >= 17 || accompaniedByAnAdult)
      {
         System.out.println("You may watch an R rated movie");
      }
      
      // If - else if - else
      if (age <= 4)
      {
         System.out.println("You are a toddler");
      }
      else if (age <= 12)
      {
         System.out.println("You are a tween");
      }
      else if (age <= 19)
      {
         System.out.println("You are a teenager");
      }
      else if (age <= 39)
      {
         System.out.println("You are a young adult");
      }
      else if (age <= 49)
      {
         System.out.println("You are middle aged");
      }
      else
      {
         System.out.println("You are just plain old");
      }
      
      boolean runThisCode = false;
      if (runThisCode)
      {
         for (int i = 0; i < 5; ++i)
         {  
            System.out.println("Hello " + i);
         }
      }
      
     // Example of a if-statement that is actually an expression
     // (expression) ? true-expression : false-expression
     
      float a = 10.0f;
      float b = 5.0f;
      float larger = (a > b) ? a : b;      // larger will be set to 10.0f;
      float smaller = (a < b) ? a : b;     // smaller will be set to 5.0f;
     
     // Style : don't nest the ternary operator because it becomes an unreadable mess.
     // I started creating an example that was a valid big mess and gave up because I had
     // too hard of a time reading it.
     //float x = (a < b) ? ((a == b) ? a : b) : (a + 3) 
     
      System.out.println("SomeExpression equals " + ((someExpression) ? "True" : "False"));
     
     // In math you can say 
     // 0 < x < 50
     // to mean 'x' greater than zero and x is less then 50. 
     // You cannot do that in any computer language.
     // You must expand it out to two clauses.
      float x = 30.0f;
      if (x > 0.0f && x < 50.0f)  // x is greater than 0 AND x is less than 50
      {
         // Then do something
      }
   }
   
   // Compute the Mach number given an airspeed in miles per hour. Mach 1.0 is the speed
   // of sound.
   public static float machNumber(float airspeedInMph)
   {
      float machNumber = 0.0f;
      
      if (airspeedInMph > 0.0f)
      {  
         machNumber = airspeedInMph / 767.269f;
      }
      
      return machNumber;
   }
   
   // Compute the reference angle in Trigonometry for the given angle in degrees
   // The returned angle will be between -180 degrees and 180 degrees
   public static float referenceAngle180Degrees(float angleInDegrees)
   {
      if (angleInDegrees <= -180.0f)
      {
         angleInDegrees += 360.0f;  // same as angleInDegrees = angleInDegrees + 360.0f;
      }
      else if (angleInDegrees > 180.0f)
      {
         angleInDegrees -= 360.0f;  // same as angleInDegrees = angleInDegrees - 360.0f;
      }
      return angleInDegrees;
   }
   
   // This code pretends to generate the voice message in many airplanes that
   // says "Pull up!".
   private static void CheckPullUpWarning(Airplane airplane)
   {
      // && means "and" so all three of the clauses must be true for the whole expression to be true
      if (airplane.getAirspeedMph() > 0 && 
          airplane.getHeightAboveGroundFeet() < 3000 &&
          airplane.getClimbRateFeetPerMinute() < 0)
      {
         System.out.println("Pull up! Pull up!");
      }
   }
   
   public static void main(String[] args)
   { 
      lotsOfIfs();
      
      Airplane cessna172 = new Airplane(true, 120.0f, 2000, -1000);
      
      CheckPullUpWarning(cessna172);

      System.out.println("600mph is mach " + machNumber(600.0f));
      System.out.println("1000mph is mach " + machNumber(1000.0f));
   }
}