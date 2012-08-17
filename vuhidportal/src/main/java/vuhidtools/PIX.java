package vuhidtools;

public class PIX implements PIXInterface{

	public boolean PatientRegistryRecordRevised(Patient P){
      if (P == null)
         return false;
      if (P.First_Name == null || P.LastName == null)
         return false;
		return true;
	}
   public boolean PatientRegistryRecordAdded(Patient P)
   {
      if (P == null)
         return false;
      if (P.First_Name == null || P.LastName == null)
         return false;
      return true;
   }
   public String[] PatientRegistryGetIdentifiersQuery(Patient P)
   {
      String[] s = new String[5];
      return s;
   }
   public boolean PatientRegistryDuplicatesResolved(Patient P1, Patient P2)
   {
      if (P1 == null || P2 == null)
         return false;
      return true;
   }
}
