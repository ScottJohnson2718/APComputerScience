
public class Airplane
{
   private boolean landingGearUp;
   private float airspeedMph;
   private float heightAboveGroundFeet;
   private float climbRateFeetPerMinute;
   
   public Airplane(boolean l, float a, float h, float c)
   {
      landingGearUp = l;
      airspeedMph = a;
      heightAboveGroundFeet = h;
      climbRateFeetPerMinute = c;
   }
   
   public boolean getLandingGearUp()
   {
      return landingGearUp;
   }
   
   public float getAirspeedMph()
   {
      return airspeedMph;
   }
   
   public float getHeightAboveGroundFeet()
   {
      return heightAboveGroundFeet;
   }
   
   public float getClimbRateFeetPerMinute()
   {
      return climbRateFeetPerMinute;
   }
}