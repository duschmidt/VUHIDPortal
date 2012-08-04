package vuhidtools;

//public class VUHIDPortal implements PIXInterface, PDQInterface, VUHIDSender{
public class VUHIDPortal{
	private PDQ PDQService = null;
	private PIX PIXService = null;
	private VUHIDSender VSender = null;

	public VUHIDPortal(){
		PDQService = new PDQ();
		PIXService = new PIX();
		VSender = new VUHIDSender();
	}

	public String getNewOVID() throws Exception {
		return VSender.getNewOvid();
	}

}