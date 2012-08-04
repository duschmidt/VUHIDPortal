package vuhidtools;

public class VUHIDPortal implements PIXInterface, PDQInterface, VUHIDSenderInterface{

	private PDQ PDQService = null;
	private PIX PIXService = null;
	private VUHIDSender VSender = null;

	public VUHIDPortal(){
		PDQService = new PDQ();
		PIXService = new PIX();
		VSender = new VUHIDSender();
	}

	public String getNewOVID() throws Exception {
		return VSender.getNewOVID();
	}

}