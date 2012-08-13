package vuhidtools;

public class PIX implements PIXInterface{

	public boolean PatientRegistryRecordRevised(Patient P){
		return true;
	}
   public boolean PatientRegistryRecordAdded(Patient P)
   {
      return true;
   }
   public String[] PatientRegistryGetIdentifiersQuery(Patient P)
   {
      String[] s = new String[5];
      return s;
   }
   public boolean PatientRegistryDuplicatesResolved(Patient P1, Patient P2)
   {
      return true;
   }
}
