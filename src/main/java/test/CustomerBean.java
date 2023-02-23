package test;
import java.io.Serializable;

@SuppressWarnings("serial")
public class CustomerBean implements Serializable{

	private String cname,cmid,ccity,cstate,cpass;
	private long phon;
	private int cpincode;
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCmid() {
		return cmid;
	}
	public void setCmid(String cmid) {
		this.cmid = cmid;
	}
	public String getCcity() {
		return ccity;
	}
	public void setCcity(String ccity) {
		this.ccity = ccity;
	}
	public String getCstate() {
		return cstate;
	}
	public void setCstate(String cstate) {
		this.cstate = cstate;
	}
	public String getCpass() {
		return cpass;
	}
	public void setCpass(String cpass) {
		this.cpass = cpass;
	}
	public long getPhon() {
		return phon;
	}
	public void setPhon(long phon) {
		this.phon = phon;
	}
	public int getCpincode() {
		return cpincode;
	}
	public void setCpincode(int cpincode) {
		this.cpincode = cpincode;
	}


}
