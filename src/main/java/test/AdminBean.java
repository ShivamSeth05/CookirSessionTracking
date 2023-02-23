package test;

import java.io.Serializable;

@SuppressWarnings("serial")
public class AdminBean implements Serializable{
private String id,pass;


public AdminBean() {
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getPass() {
	return pass;
}

public void setPass(String pass) {
	this.pass = pass;
}

}
