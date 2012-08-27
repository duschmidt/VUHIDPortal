package vuhid_tools.server;
import java.util.ArrayList;

import vuhid_tools.shared.Patient;

//interface for PIX

public interface PIXInterface
{
   boolean PatientRegistryRecordRevised(Patient P);
   boolean PatientRegistryRecordAdded(Patient P);
   ArrayList<String> PatientRegistryGetIdentifiersQuery(Patient P);
   boolean PatientRegistryDuplicatesResolved(Patient P1, Patient P2);
}
