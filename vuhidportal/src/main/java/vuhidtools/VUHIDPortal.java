/* VUHIDPortal.java: Sent from Peter to Teja via email at about 1:15am on Saturday, 2012-08-18. It includes modifications
 * made by Peter to the original version to account for the new "EMPI" class that Damon made. (Basically, eliminated PIX
 * and PDQ classes, and replaced with single EMPI class, and then changed methods to return ArrayLists instead of arrays.)
 * Around 4:30pm on 2012-08-18, merged more of Long's transaction logging code. */

package vuhidtools;
import java.util.ArrayList;

import vuhidtools.logger.TransactionLogger;

public class VUHIDPortal implements PIXInterface, PDQInterface, VUHIDSenderInterface
{
   private EMPI EMPIService = null;
   private VUHIDSender VSender = null;
   private TransactionLogger logger = new TransactionLogger();

   public VUHIDPortal() {
      EMPIService = new EMPI();
      VSender = new VUHIDSender();
   }

   public boolean PatientRegistryRecordRevised(Patient P)
   {
	  int TransactionID = logger.newTransaction(TransactionLogger.PIXPatientRegistryRecordRevised);
	  boolean result = EMPIService.PatientRegistryRecordRevised(P);
	  logger.setTransactionCompleted(TransactionID, result);
      return result;
   }

   public boolean PatientRegistryRecordAdded(Patient P)
   {
      int TransactionID = logger.newTransaction(TransactionLogger.PIXPatientRegistryRecordAdded);
	  boolean result = EMPIService.PatientRegistryRecordAdded(P);
	  logger.setTransactionCompleted(TransactionID, result);
      return result;
   }

   public ArrayList<String> PatientRegistryGetIdentifiersQuery(Patient P)
   {
      int TransactionID = logger.newTransaction(TransactionLogger.PIXPatientRegistryGetIdentifiersQuery);
	  ArrayList<String> result = EMPIService.PatientRegistryGetIdentifiersQuery(P);
      //PI: (NEED TO CONVERT FROM ARRAYLIST TO ARRAY)
      String[] array = result.toArray(new String[result.size()]);
	  logger.setTransactionCompleted(TransactionID, array);
      return result;
   }

   public boolean PatientRegistryDuplicatesResolved(Patient P1, Patient P2)
   {
      int TransactionID = logger.newTransaction(TransactionLogger.PIXPatientRegistryDuplicatesResolved);
	  boolean result = EMPIService.PatientRegistryDuplicatesResolved(P1, P2);
	  logger.setTransactionCompleted(TransactionID, result);
      return result;
   }

   public ArrayList<Patient> PatientRegistryFindCandidatesQuery(Patient P)
   {
	  String[] values = new String[1];
	  values[0] = P.VUHID_ID;
      int TransactionID = logger.newTransaction(TransactionLogger.PDQPatientRegistryFindCandidatesQuery, values);
	  ArrayList<Patient> result = EMPIService.PatientRegistryFindCandidatesQuery(P);
	  logger.setTransactionCompleted(TransactionID);
      return result;
   }

   public String getNewOVID() throws Exception
   {
      int TransactionID = logger.newTransaction(TransactionLogger.VUHIDNewOVID);
	  String result = VSender.getNewOVID();
	  logger.setTransactionCompleted(TransactionID, result);
      return result;
   }

   public String getNewPVID(String privacyClass) throws Exception
   {
	  String[] values = new String[1];
	  values[0] = privacyClass;
      int TransactionID = logger.newTransaction(TransactionLogger.VUHIDNewPVID, values);
	  String result = VSender.getNewPVID(privacyClass);
	  logger.setTransactionCompleted(TransactionID, result);
      return result;
   }

   public int getStatusOfID(String ID) throws Exception
   {
	  String[] values = new String[1];
	  values[0] = ID;
      int TransactionID = logger.newTransaction(TransactionLogger.VUHIDIDStatus, values);
	  int result = VSender.getStatusOfID(ID);
	  logger.setTransactionCompleted(TransactionID, result);
      return result;
   }

   public int retireID(String ID, String reason) throws Exception
   {
	  String[] values = new String[2];
	  values[0] = ID;
	  values[1] = reason;
      int TransactionID = logger.newTransaction(TransactionLogger.VUHIDRetireID, values);
	  int result = VSender.retireID(ID, reason);
	  logger.setTransactionCompleted(TransactionID, result);
      return result;
   }

   public int terminateID(String ID, String reason) throws Exception
   {
      String[] values = new String[2];
	  values[0] = ID;
	  values[1] = reason;
      int TransactionID = logger.newTransaction(TransactionLogger.VUHIDTerminateID, values);
	  int result = VSender.terminateID(ID, reason);
	  logger.setTransactionCompleted(TransactionID, result);
      return result;
   }

   public String getReplacementID(String ID, String reason) throws Exception
   {
      String[] values = new String[2];
	  values[0] = ID;
	  values[1] = reason;
      int TransactionID = logger.newTransaction(TransactionLogger.VUHIDReplaceID, values);
	  String result = VSender.getReplacementID(ID, reason);
	  logger.setTransactionCompleted(TransactionID, result);
      return result;
   }

   public String[] getDataLocations(String ID) throws Exception
   {
      String[] values = new String[1];
	  values[0] = ID;
      int TransactionID = logger.newTransaction(TransactionLogger.VUHIDRequestDataLocations, values);
	  String[] result = VSender.getDataLocations(ID);
	  logger.setTransactionCompleted(TransactionID, result);
      return result;
   }

   public boolean getIsOVID(String ID) throws Exception
   {
      return VSender.getIsOVID(ID);
   }

   public boolean getIsPVID(String ID) throws Exception
   {
      return VSender.getIsPVID(ID);
   }

   public boolean getIsWellFormed(String ID) throws Exception
   {
      return VSender.getIsWellFormed(ID);
   }

   public String getPrivacyClass(String ID) throws Exception
   {
      return VSender.getPrivacyClass(ID);
   }
}
