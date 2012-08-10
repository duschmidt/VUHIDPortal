package vuhidtools;

public class VUHIDPortal implements PIXInterface, PDQInterface, VUHIDSenderInterface {

   private PDQ PDQService = null;
   private PIX PIXService = null;
   private VUHIDSender VSender = null;

   public VUHIDPortal() {
      PDQService = new PDQ();
      PIXService = new PIX();
      VSender = new VUHIDSender();
   }

   public boolean PatientRegistryRecordRevised(Patient P) {
      return PIXService.PatientRegistryRecordRevised(P);
   }

   public boolean PatientRegistryRecordAdded(Patient P) {
      return PIXService.PatientRegistryRecordAdded(P);
   }

   public String[] PatientRegistryGetIdentifiersQuery(Patient P) {
      return PIXService.PatientRegistryGetIdentifiersQuery(P);
   }

   public boolean PatientRegistryDuplicatesResolved(Patient P1, Patient P2) {
      return PIXService.PatientRegistryDuplicatesResolved(P1, P2);
   }

   public Patient[] PatientRegistryFindCandidatesQuery(Patient P) {
      return PDQService.PatientRegistryFindCandidatesQuery(P);
   }

   public String getNewOVID() throws Exception {
      return VSender.getNewOVID();
   }

   public String getNewPVID() throws Exception {
      return VSender.getNewPVID();
   }

   public int getStatusOfID(String ID) throws Exception {
      return VSender.getStatusOfID(ID);
   }

   public int retireID(String ID, String reason) throws Exception {
      return VSender.retireID(ID, reason);
   }

   public int terminateID(String ID, String reason) throws Exception {
      return VSender.terminateID(ID, reason);
   }

   public String getReplacementID() throws Exception {
      return VSender.getReplacementID(); 
   }

   public String[] getDataLocations(String ID, String response_uri) throws Exception {
      return VSender.getDataLocations(ID, response_uri);
   }

   public boolean getIsOVID(String ID) throws Exception {
      return VSender.getIsOVID(ID);
   }

   public boolean getIsPVID(String ID) throws Exception {
      return VSender.getIsPVID(ID);
   }

   public boolean getIsWellFormed(String ID) throws Exception {
      return VSender.getIsWellFormed(ID);
   }

   public String getPrivacyClass(String ID) throws Exception {
      return VSender.getPrivacyClass(ID);
   }
}
