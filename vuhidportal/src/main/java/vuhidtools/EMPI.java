package vuhidtools;
import java.util.ArrayList;

public class EMPI implements PIXInterface,PDQInterface
{
   EMPI()
   {
      //Populate P_List
      P_List = new ArrayList<Patient>();
      //PI: (REPLACED LAST ARG WITH BOOLEAN FOR 'DECEASED') P_List.add(new Patient("Dustin", "Schmidt", "000001", null));
      P_List.add(new Patient("Dustin", "Schmidt", "000001", false));
      //PI: (REPLACED LAST ARG WITH BOOLEAN FOR 'DECEASED') P_List.add(new Patient("Peter", "Inslee", "000002", null));
      P_List.add(new Patient("Peter", "Inslee", "000002", false));
   }

	public boolean PatientRegistryRecordRevised(Patient P){
      if (P == null)
         return false;
      for (int i = 0; i < P_List.size(); i++)
      {
         if (Patient.match(P,P_List.get(i)))
         {
            P_List.set(i, P);   //Replaces P_List[i] with P
		      return true;
         }
      }
		return false;
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
      for (int i = 0; i < P_List.size(); i++)
      {
         if (Patient.match(P,P_List.get(i)))
         {
            //Add IDs
            s.add(P_List.get(i).VUHID_ID);
         }
      }
      
      return s;
   }

   public boolean PatientRegistryDuplicatesResolved(Patient P1, Patient P2)
   {
      boolean Made_a_Change = false;   //return value
      if (P1 == null || P2 == null)
         return false;

      //Search for matches and then replace them
      //Currently replaces all matches
      for (int i = 0; i < P_List.size(); i++)
      {
         if (Patient.match(P1,P_List.get(i)))
         {
            P_List.set(i, P2);
            Made_a_Change = true;  //make this line "return true" if you want it to change only one element
         }
      }
      return Made_a_Change;
   }

   //PDQ Function
   public ArrayList<Patient> PatientRegistryFindCandidatesQuery(Patient P) {
      ArrayList<Patient> list = new ArrayList<Patient>();
      for (int i = 0; i < P_List.size(); i++)
      {
         if (Patient.match(P,P_List.get(i)))
         {
            list.add(P_List.get(i));
         }
      }
      return list;
   }

   private ArrayList<Patient> P_List;

}
