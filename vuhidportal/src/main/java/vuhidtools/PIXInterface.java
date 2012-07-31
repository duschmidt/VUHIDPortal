package vuhidtools;

public interface PIXInterface
{
   boolean PatientRegistryRecordRevised(Patient P);
   boolean PatientRegistryRecordAdded(Patient P);
   String[] PatientRegistryGetIdentifiersQuery(Patient P);
   boolean PatientRegistryDuplicatesResolved(Patient P1, Patient P2);
}
