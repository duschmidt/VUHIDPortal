package vuhidtools;
import java.lang.String;

public class Patient
{
   public String First_Name;
   public String Last_Name;
   public String VUHID_ID;
   public String DOB;      //Possible make this into a date
   
   public Patient()
   {
   }
   public Patient(String FN, String LN, String Vid, String birthday)
   {
      First_Name = FN;
      Last_Name = LN;
      VUHID_ID = Vid;
      DOB = birthday;
   }
   public static boolean match(Patient P1){
      // Should return true if all none null fields of P1 (first name, last name, etc) match all non null fields of P2
      // P1.field != null && P2.field != null and P1.field == P2.field
      // If the above is true for all fields then the match is true
      return true;
   }
   public boolean CheckPatient()
   {
   
      if (First_Name == null)
      {
         System.out.println("Require First name.");
         return false;
      }
      if (Last_Name == null)
      {
         System.out.println("Require Last name.");
         return false;
      }
      if (VUHID_ID == null)
      {
         System.out.println("Require VUHID ID.");
         return false;
      }
      if (DOB == null)
      {
         System.out.println("Requeire a DOB.");
         return false;
      }
      return true;
   }
}
