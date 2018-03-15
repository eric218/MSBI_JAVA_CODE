package com.hpe.msbireport.domain;

public class RunTimeByDate {
	
	private String runnum;
	
	private String schedulename;
	
	private String startdate;

	private String servername;

	public String getServername() {
		return servername;
	}

	public void setServername(String servername) {
		this.servername = servername;
	}

	public String getRunnum() {
		return runnum;
	}

	public void setRunnum(String runnum) {
		this.runnum = runnum;
	}

	public String getSchedulename() {
		return schedulename;
	}

	public void setSchedulename(String schedulename) {
		this.schedulename = schedulename;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
}
