package com.bean;

import java.util.HashMap;

public class Expression {
	 private String expString;
	 private String expMessage;
	
	 public String getExpMessage() {
		return expMessage;
	}
	public void setExpMessage(String expMessage) {
		this.expMessage = expMessage;
	}
	private HashMap result=new HashMap();
	 
	 
	 public String getexpString() {return expString;}
     public void setexpString(String expString) {this.expString = expString;}
 
    
     public HashMap getResult() {
		return result;
		}
	public void setResult(HashMap result) {
		this.result = result;
	}
     @Override
     public String toString() {
             return "Expression [expString="+ expString +"]";
     }
   }
