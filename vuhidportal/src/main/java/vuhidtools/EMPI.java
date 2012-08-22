package vuhidtools;
import java.util.ArrayList;

//This class emulates what we believe the EMPI does.

public class EMPI implements PIXInterface,PDQInterface
{
   private ArrayList<Patient> P_List;     //List of patients 

   public EMPI()
   {
      P_List = new ArrayList<Patient>();

      //Populate P_List
      P_List.add(new Patient("Dustin", "Schmidt", "000001", null));
      P_List.add(new Patient("Peter", "Inslee", "000002", null));
      P_List.add(new Patient("Teja", "Pitla", "000003", null));
      P_List.add(new Patient("Robert", "Hickey", "000004", null));
      P_List.add(new Patient("Vy", "Le", "000005", null));
      P_List.add(new Patient("Long", "Phan", "000006", null));
      P_List.add(new Patient("Damon", "Liang", "000007", null));
      P_List.add(new Patient("Bart", "Massey", "000008", null));
      P_List.add(new Patient("Jen", "Henni", "000009", null));
      P_List.add(new Patient("Barry", "Hieb", "000010", null));
   }

   //Edits an existing Patient's information. 
   //Does so by replacing the existing ones with the one passed in
	public boolean PatientRegistryRecordRevised(Patient P){
      if (P == null)
         return false;
      
      Patient Search_Patient = new Patient();      //Patient used for searching
      Search_Patient.VUHID_ID = P.VUHID_ID;        //Only search by VUHID_ID
      
      for (int i = 0; i < P_List.size(); i++)
      {
         if (Patient.match(Search_Patient,P_List.get(i)))
         {
            P_List.set(i, P);   //Replaces P_List[i] with P
		      return true;
         }
      }
		return false;
	}

   //Adds a Patient to the ArrayList P_List
   public boolean PatientRegistryRecordAdded(Patient P)
   {
      if (P == null)
         return false;
      if (P_List.contains(P))
      {
         System.out.println("Patient already added");
         return false;
      }
      else
      {
         return P_List.add(P);
      }
   }

   //Gets all of the VUHID IDs belonging to a Patient P.
   public ArrayList<String> PatientRegistryGetIdentifiersQuery(Patient P)
   {
      ArrayList<String> IDs = new ArrayList<String>();
      for (int i = 0; i < P_List.size(); i++)
      {
         if (Patient.match(P,P_List.get(i)))
         {
            //Add IDs
            IDs.add(P_List.get(i).VUHID_ID);
         }
      }
      
      return IDs;
   }

   //Takes two patients, takes all instances of P1 in P_list and replaces it with P2
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
   //Searchs for any patients matching P. 
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
   
   public void Print()
   {
      for (int i = 0; i < P_List.size(); i++)
      {
         System.out.println(P_List.get(i).First_Name);
      }
   }
}
