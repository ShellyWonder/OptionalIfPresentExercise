package com.coderscampus.domain;

public class SuspectLocation {
private String name;
private String city;

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public SuspectLocation(String name, String city) {
	super();
	this.name = name;
	this.city = city;
			
}

}
