package vuhidtools;

public class VUHIDPortalTester {

    //add new VuHID Portal to test methods
    private static final VUHIDPortal vp = new VUHIDPortal();

    public static void main(String[] args) {

        //section to test getStatusOfID routine
        int temp = 0;
        try {
            temp = vp.getStatusOfID("0000000000000009.523079864000000");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("\nResponse code for check of ID should be 200; is: " + temp);
       }
    }//end main()
}
