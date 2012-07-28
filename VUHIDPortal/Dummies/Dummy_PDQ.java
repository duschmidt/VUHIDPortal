package VUHIDPortal.Dummies;

public class Dummy_PDQ implements PDQ
{
   public Patient[] PatientRegistryFindCandidatesQuery(Patient P)
   {
      Patient[] P_list;
      P_list = new Patient[5];
      P_list[0] = P;
      if (P == null)
      {
         System.out.println("Patient information was empty.");
         return null;
      }
      return P_list;
   }
}
