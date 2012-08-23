package vuhidtools;
import java.lang.String;

public class Patient
{
   public String FirstName;
   public String LastName;
   public String VUHID_ID;
   public String DOB;      //Possible make this into a date
   public String gender;
   public String email;
   public String phoneNumber;
   public String address;
   public String city;
   public String state;
   public String zip;
   public String EMPIId;
   public String bloodType;
   public String bedID;
   public String contactFirstName;
   public String contactLastName;
   public String contactPhoneNumber;
   public String contactAddress;
   public int    weightLbs; 
   public int    heightInches;
   public boolean   deceased;
   
   public Patient()
   {
   }

   //PI: (ADDED 4th ARG; BOOLEAN FOR 'DECEASED') public Patient(String FN, String LN, String Vid)
   public Patient(String FN, String LN, String Vid, boolean tf)
   {
      FirstName = FN;
      LastName = LN;
      VUHID_ID = Vid;
      //PI: (UNCOMMENTED THIS.) //deceased = tf;
      deceased = tf;
   }

   public Patient(String FN, String LN, String Vid, String birthdate, String gd, String e_mail, String phoneNum,
                  String addr, String cty, String states, String zp, String EMPI_Id, String blood, String bed,
                  String contactFN, String contactLN, String contactPhone, String contactAddr,
                  int weight, int height, boolean TF)
   {
      FirstName          = FN;
      LastName           = LN;
      VUHID_ID           = Vid;
      DOB                = birthdate;
      gender             = gd;
      email              = e_mail;
      phoneNumber        = phoneNum;
      address            = addr;
      city               = cty;
      state              = states;
      zip                = zp;
      EMPIId             = EMPI_Id;
      bloodType          = blood;
      bedID              = bed;
      contactFirstName   = contactFN;
      contactLastName    = contactLN;
      contactPhoneNumber = contactPhone;
      contactAddress     = contactAddr;
      weightLbs          = weight;
      heightInches       = height;
      deceased           = TF;
   }
/* //PI: (REPLACED ALL 'this' REFERENCES WITH NEW FIRST ARG 'P1') 
   public boolean match(Patient P){
      // Should return true if all none-null fields of 'this' Patient (first, last name, etc)
      //  matches all non-null fields of Patient P
      // this.field != null && P.field != null and this.field == P.field
      // If the above is true for all fields then the match is true
      if (this.CheckPatient() == false || P.CheckPatient() == false)
         return false;
      else if (!this.FirstName.equals(P.FirstName))
         return false;
      else if (!this.LastName.equals(P.LastName))
         return false;
      else if (!this.VUHID_ID.equals(P.VUHID_ID))
         return false;
      else if (!this.DOB.equals(P.DOB))
         return false;
      else if (!this.gender.equals(P.gender))
         return false;
      else if (!this.email.equals(P.email))
         return false;
      else if (!this.phoneNumber.equals(P.phoneNumber))
         return false;
      else if (!this.address.equals(P.address))
         return false;
      else if (!this.city.equals(P.city))
         return false;
      else if (!this.state.equals(P.state))
         return false;
      else if (!this.zip.equals(P.zip))
         return false;
      else if (!this.EMPIId.equals(P.EMPIId))
         return false;
      else if (!this.bloodType.equals(P.bloodType))
         return false;
      else if (!this.bedID.equals(P.bedID))
         return false;
      else if (!this.contactFirstName.equals(P.contactFirstName))
         return false;
      else if (!this.contactLastName.equals(P.contactLastName))
         return false;
      else if (!this.contactPhoneNumber.equals(P.contactPhoneNumber))
         return false;
      else if (!this.contactAddress.equals(P.contactAddress))
         return false;
      else if (this.weightLbs != P.weightLbs)
         return false;
      else if (this.heightInches != P.heightInches)
         return false;
      else if (this.deceased != P.deceased)
         return false;
      return true;
   }*/
   //PI: (CHANGED TO 'static', AND ADDED A SECOND ARG) public boolean match(Patient P1, Patient P2){
   public static boolean match(Patient P1, Patient P2){
      // Should return true if all none-null fields of 'this' Patient (first, last name, etc)
      //  matches all non-null fields of Patient P
      // this.field != null && P.field != null and this.field == P.field
      // If the above is true for all fields then the match is true
      if (P1.CheckPatient() == false || P2.CheckPatient() == false)
         return false;
      else if (!P1.FirstName.equals(P2.FirstName))
         return false;
      else if (!P1.LastName.equals(P2.LastName))
         return false;
      else if (!P1.VUHID_ID.equals(P2.VUHID_ID))
         return false;
      else if (!P1.DOB.equals(P2.DOB))
         return false;
      else if (!P1.gender.equals(P2.gender))
         return false;
      else if (!P1.email.equals(P2.email))
         return false;
      else if (!P1.phoneNumber.equals(P2.phoneNumber))
         return false;
      else if (!P1.address.equals(P2.address))
         return false;
      else if (!P1.city.equals(P2.city))
         return false;
      else if (!P1.state.equals(P2.state))
         return false;
      else if (!P1.zip.equals(P2.zip))
         return false;
      else if (!P1.EMPIId.equals(P2.EMPIId))
         return false;
      else if (!P1.bloodType.equals(P2.bloodType))
         return false;
      else if (!P1.bedID.equals(P2.bedID))
         return false;
      else if (!P1.contactFirstName.equals(P2.contactFirstName))
         return false;
      else if (!P1.contactLastName.equals(P2.contactLastName))
         return false;
      else if (!P1.contactPhoneNumber.equals(P2.contactPhoneNumber))
         return false;
      else if (!P1.contactAddress.equals(P2.contactAddress))
         return false;
      else if (P1.weightLbs != P2.weightLbs)
         return false;
      else if (P1.heightInches != P2.heightInches)
         return false;
      else if (P1.deceased != P2.deceased)
         return false;
      return true;
   }
   public boolean CheckPatient()
   {
      if (FirstName == null)
      {
         System.out.println("Require First name.");
         return false;
      }
      if (LastName == null)
      {
         System.out.println("Require Last name.");
         return false;
      }
      if (VUHID_ID == null)
      {
         System.out.println("Require VUHID ID.");
         return false;
      }
      if (DOB == null)
      {
         System.out.println("Require a DOB.");
         return false;
      }
      if (gender == null) {
         System.out.println("Require gender.");
         return false;
      }
      if (email == null) {
         System.out.println("Require an email address.");
         return false;
      }
      if (phoneNumber == null) {
         System.out.println("Require phone number.");
         return false;
      }
      if (address == null) {
         System.out.println("Require an address.");
         return false;
      }
      if (city == null) {
         System.out.println("Require city.");
         return false;
      }
      if (state == null) {
         System.out.println("Require state.");
         return false;
      }
      if (zip == null) {
         System.out.println("Require zip code.");
         return false;
      }
      if (EMPIId == null) {
         System.out.println("Require EMPI ID.");
         return false;
      }
      if (bloodType == null) {
         System.out.println("Require blood type.");
         return false;	
      }
      if (bedID == null) {
         System.out.println("Require bed ID.");
         return false;
      }
      if (contactFirstName == null) {
         System.out.println("Require a contact First Name.");
         return false;
      }
      if (contactLastName == null) {
         System.out.println("Require a contact Last Name.");
         return false;
      }
      if (contactPhoneNumber == null) {
         System.out.println("Require a contact phone number.");
         return false;
      }
      if (contactAddress == null) {
         System.out.println("Require a contact address.");
         return false;
      }
      if (weightLbs == 0) {
         System.out.println("Require weight in lbs.");
         return false;
      }
      if (heightInches == 0) {
         System.out.println("Require height in inches.");
         return false;
      }
      return true;
   }
}
