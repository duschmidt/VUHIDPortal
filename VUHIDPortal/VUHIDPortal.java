package VUHIDPortal;

public class VUHIDPortal implements PIX, PDQ
{
   //PIX
   public boolean PatientRegistryRecordRevised(Patient P)
   {
      return false;
   }
   public boolean PatientRegistryRecordAdded(Patient P)
   {
      return false;
   }
   public String[] PatientRegistryGetIdentifiersQuery(Patient P)
   {
      String[] s = new String[3];
      return s;
   }
   public boolean PatientRegistryDuplicatesResolved(Patient P1, Patient P2)
   {
      return false;
   }
   
   //PDQ
   public Patient[] PatientRegistryFindCandidatesQuery(Patient P)
   {
      Patient[] P_list = new Patient[5];
      P_list[0] = new Patient();
      return P_list;
   }
}
