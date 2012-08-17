package vuhidtools;
import java.util.ArrayList;

public class EMPI implements PIXInterface,PDQInterface
{
   EMPI()
   {
      //Populate P_List
      P_List = new ArrayList<Patient>();
      P_List.add(new Patient("Dustin", "Schmidt", "000001", null));
      P_List.add(new Patient("Peter", "Inslee", "000002", null));
   }
	public boolean PatientRegistryRecordRevised(Patient P){
      if (P == null)
         return false;
      for (int i = 0; i < P_List.size(); i++)
      {
         if (P.match(P_List.get(i)))
         {
            P_List.set(i, P);   //Replaces P_List[i] with P
		      return true;
         }
      }
		return true;
	}
   public boolean PatientRegistryRecordAdded(Patient P)
   {
      if (P == null)
         return false;
      return P_List.add(P);
   }
   public ArrayList<String> PatientRegistryGetIdentifiersQuery(Patient P)
   {
      ArrayList<String> s = new ArrayList<String>();
      return s;
   }
   public boolean PatientRegistryDuplicatesResolved(Patient P1, Patient P2)
   {
      if (P1 == null || P2 == null)
         return false;
      int index;
      for (int i = 0; i < P_List.size(); i++)
      {
         if (P1.match(P_List.get(i)))
         {
            P_List.set(i, P2);
         }
      }
      return true;
   }

   //PDQ
   public ArrayList<Patient> PatientRegistryFindCandidatesQuery(Patient P) {
      ArrayList<Patient> list = new ArrayList<Patient>();
      for (int i = 0; i < P_List.size(); i++)
      {
         if (P.match(P_List.get(i)))
         {
            list.add(P_List.get(i));
         }
      }
      return list;
   }

   private ArrayList<Patient> P_List;

}
