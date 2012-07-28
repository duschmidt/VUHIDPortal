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
      String s = {"iaje", "ioaje", "oajea", "aoivja,ed"};
      return s;
   }
   public boolean PatientRegistryDuplicatesResolved(Patient P1, Patient P2)
   {
      return false;
   }
   
   //PDQ
   public Patient[] PatientRegistryFindCandidatesQuery(Patient P)
   {
      Patient Dustin = new Patient();
      return Dustin;
   }
}
