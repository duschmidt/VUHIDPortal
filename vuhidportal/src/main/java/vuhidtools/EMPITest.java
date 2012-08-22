package vuhidtools;

public class EMPITest
{
   public static void main(String[] args)
   {
      EMPI empi = new EMPI();

      Patient p = new Patient("test", "test", "0000123", null);
      Patient empty = new Patient(null, null, null, null);

      //Test RecordRevised
      try 
      {
         if (empi.PatientRegistryRecordRevised(p))
            empi.Print();
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
/*
      //Test RecordRevised with empty patient
      try
      {
         if (empi.PatientRegistryRecordRevised(empty))
            empi.Print();
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
*/
      //Test Add a patient
      try
      {
         if (empi.PatientRegistryRecordAdded(empty))
            empi.Print();
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }

   }
}
