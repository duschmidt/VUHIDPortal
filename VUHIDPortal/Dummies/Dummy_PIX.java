package VUHIDPortal.Dummies;

public class Dummy_PIX implements PIX
{
   public boolean PatientRegistryRecordRevised(Patient P)
   {
      System.out.println("Calling PatientRegistryRecordRevised function.");
      if (P.First_Name != null)
         System.out.println("First name is " + P.First_Name );
      else 
      {
         System.out.println("Need a first name.");
         return false;
      }
      if (P.Last_Name != null)
         System.out.println("Last name is " + P.Last_Name );
      else 
      {
         System.out.println("Need a last name.");
         return false;
      }
      //Should check other parameters
      return true;
   }

   public boolean PatientRegistryRecordAdded(Patient P)
   {
      System.out.println("Calling PatientRegistryRecordAdded function.");
      if (P != null)
         System.out.println("Adding user to database");
      return true;
   }

   public String[] PatientRegistryGetIdentifiersQuery(Patient P)
   {
      String[] IDs;
      IDs = new String[10];
      IDs[0] = "00000000000";
      IDs[1] = "8918232341";
      IDs[2] = "VuHID: 00000.12833";
      IDs[3] = P.VUHID_ID;
      System.out.println("Calling PatientRegistryGetIdentifiersQuery function. Returning IDs.");
      if (P == null)
      {
         System.out.println("Require patient information.");
         return null;
      }
      return IDs;
   }

   public boolean PatientRegistryDuplicatesResolved(Patient P1, Patient P2)
   {
      System.out.println("Calling PatientRegistryDuplicatesResolved function.");
      if ( P1 == null || P2 == null)
      {
         System.out.println("Invalid in put." );
         return false;
      }
      return true;
   }
}
