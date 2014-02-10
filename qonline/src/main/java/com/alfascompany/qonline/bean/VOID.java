package com.alfascompany.qonline.bean;

import java.io.Serializable;

public class VOID implements Serializable {
	
	private static final long serialVersionUID = 7621876415677347406L;

	public static VOID value = new VOID();

	public String a;

	public VOID() {
	}

	public VOID(String a) {
		this.a = a;
	}
}
