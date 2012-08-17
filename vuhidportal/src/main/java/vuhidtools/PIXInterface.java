package vuhidtools;
import java.util.ArrayList;

public interface PIXInterface
{
   boolean PatientRegistryRecordRevised(Patient P);
   boolean PatientRegistryRecordAdded(Patient P);
   ArrayList<String> PatientRegistryGetIdentifiersQuery(Patient P);
   boolean PatientRegistryDuplicatesResolved(Patient P1, Patient P2);
}
