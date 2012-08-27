package vuhid_tools.server;
import java.util.ArrayList;

import vuhid_tools.shared.Patient;

//Interface for PDQ implementation

public interface PDQInterface
{
   ArrayList<Patient> PatientRegistryFindCandidatesQuery(Patient P);
}
