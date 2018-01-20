public class Robot {
	private String name;
	private double cubeOnSwitch;
	private double cubeOnScale;
	private double tossOnSwitchClose;
	private double tossOnScaleClose;
	private double tossOnSwitchFar;
	private double tossOnScaleFar;
	private double singleClimb;
	private double dualClimb;
	private boolean launch;
	private boolean dual;
	
	public Robot(String name, int cubeOnSwitch, int singleClimb, boolean launch, boolean dual) {
		this.name = name;
		this.cubeOnSwitch = (double)(cubeOnSwitch)/20;
		this.cubeOnScale = (double) (cubeOnSwitch)/20;
		this.singleClimb = (double)(singleClimb)/20;
		if(dual)
			this.dualClimb = 0.75*this.singleClimb;
		else
			this.dualClimb = 0;
		this.dual = dual;
		if(launch) {
			this.tossOnSwitchClose = (double)(17/20);
			this.tossOnScaleClose = (double)(10/20);
			this.tossOnSwitchFar = (double)(10/20);
			this.tossOnScaleFar = (double)(7/20);
		} else {
			this.tossOnSwitchClose = 0;
			this.tossOnScaleClose = 0;
			this.tossOnSwitchFar = 0;
			this.tossOnScaleFar = 0;
		}
		this.launch = launch;
	}
	
	public String getName() {
		return name;
	}
	
	public String getCubeOnSwitch() {
		return (int)(cubeOnSwitch*100) + "%";
	}
	
	public String getCubeOnScale() {
		return (int)(cubeOnScale*100) + "%";
	}
	
	public String getTossOnSwitchClose() {
		return (int)(tossOnSwitchClose*100) + "%";
	}
	
	public String getTossOnScaleClose() {
		return (int)(tossOnScaleClose*100) + "%";
	}
	
	public String getTossOnSwitchFar() {
		return (int)(tossOnSwitchFar*100) + "%";
	}
	
	public String getTossOnScaleFar() {
		return (int)(tossOnScaleFar*100) + "%";
	}
	
	public String getSingleClimb() {
		return (int)(singleClimb*100) + "%";
	}
	
	public String getDualClimb() {
		return (int)(dualClimb*100) + "%";
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setCubeOnSwitch(int val) {
		this.cubeOnSwitch = val;
	}
	
	public void setCubeOnScale(int val) {
		this.cubeOnScale = val;
	}
	
	public void setTossOnSwitchClose(int val) {
		this.tossOnSwitchClose = val;
	}
	
	public void setTossOnScaleClose(int val) {
		this.tossOnScaleClose = val;
	}
	
	public void setTossOnSwitchFar(int val) {
		this.tossOnSwitchFar = val;
	}
	
	public void setTossOnScaleFar(int val) {
		this.tossOnScaleFar = val;
	}
	
	public void setSingleClimb(int val) {
		this.singleClimb = val;
	}
	
	public void setDualClimb(int val) {
		this.dualClimb = val;
	}
	
	public boolean returnProb(int stat) {
		int val = 0;
		switch(stat) {
			case 1: val = (int)(cubeOnSwitch*20); break;
			case 2: val = (int)(cubeOnScale*20); break;
			case 3: val = (int)(tossOnSwitchClose*20); break;
			case 4: val = (int)(tossOnScaleClose*20); break;
			case 5: val = (int)(tossOnSwitchFar*20); break;
			case 6: val = (int)(tossOnScaleFar*20); break;
			case 7: val = (int)(singleClimb*20); break;
			case 8: val = (int)(dualClimb*20); break;
		}
		int prob = (int)(Math.random()*20) + 1; 
		if(prob <= val)
			return true;
		return false;
	}
	
	public String returnStats() {
		String s = "";
		s += "**" + name + "**";
		s += "\nClimb: ";
		s += dual ? "dual - " + getDualClimb() + " single - " + getSingleClimb() : 
			"single - " + getSingleClimb();
		s += "\nLaunch: ";
		s += launch ? "yes" : "no";
		s += "\nSwitch: " + getCubeOnSwitch() + "\nScale: " + getCubeOnScale();
		return s;
	}
}
