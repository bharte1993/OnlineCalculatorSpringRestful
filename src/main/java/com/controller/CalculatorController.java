package com.controller;

import java.util.HashMap;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Expression;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    Object result1;
    Expression exp1=new Expression();
    HashMap result=new HashMap();
    
	ScriptEngineManager manager= new ScriptEngineManager();
    ScriptEngine engine=manager.getEngineByName("js");
	
	 @RequestMapping(value="/add", method=RequestMethod.GET)
	    public int getAdd(@RequestParam(value="firstNo" ,required =true) int firstNo, @RequestParam(value="secondNo",required =false) int secondNo) {
	     int result1=(firstNo+secondNo);
		 return result1;
	    }
	 @RequestMapping(value="/sub", method=RequestMethod.GET)
	    public int getSub(@RequestParam("firstNo") int firstNo, @RequestParam("secondNo") int secondNo) {
	     int result1=(firstNo-secondNo);
		 return result1;
	    }
	 @RequestMapping(value="/string/{str}",method=RequestMethod.GET)
	    public String getString(@PathVariable String str) {
	     return str;
	    }
	 @RequestMapping(value="/stringparam", method=RequestMethod.GET)
	    public String getStringByParam(@RequestParam(value="str" ,required =true) String str) {
	      return str;
	    }
	 @RequestMapping(value="/stringexp", method=RequestMethod.GET)
	    public Object calculateExpression(@RequestParam(value="exp" ,required =false ,defaultValue ="+") String exp) {
		
	      try {
	    	   System.out.println(exp);
	    	   result1 = engine.eval(exp);
	    	   System.out.println(result1);
	    	    return result1;
	      }
	      catch(Exception e){
	    	  System.out.println("catch");
	    	  return "Bad Expression";
	      }
	   }
	 
	 @RequestMapping(value="/stringbody", method=RequestMethod.POST)
	    public @ResponseBody Expression calculateExpressionByBody(@RequestBody Expression exp1) {
	
	      try {
	    	  //exp1 = new ObjectMapper().readValue(exp, Expression.class);
	    	   System.out.println(exp1.getexpString());
	    	   exp1.setExpMessage("Success");
	           result.put("Answer",engine.eval(exp1.getexpString()).toString());
	           result.put("Error","No Error");
	    	   exp1.setResult(result);
	    	   return exp1;
	      }
	      catch(Exception e){
	    	  System.out.println("catch");
	    	   exp1.setExpMessage("Fail");
	    	   result.put("Answer","Syntex Error");
	           result.put("Error","Bad Expression");
	           exp1.setResult(result);
	    	   return exp1;
	    	  
	     }
	   }

	 @RequestMapping(value="/ajaxJquery", method=RequestMethod.GET)
	    public @ResponseBody Expression calculateExpressionAjaxJQuery(@RequestParam(value="exp" ) String exp) {
		 try {
			  System.out.println(exp);
	    	   exp1.setexpString(exp);
	    	   exp1.setExpMessage("Success");
	           result.put("Answer",engine.eval(exp));
	           result.put("Error","No Error");
	    	   exp1.setResult(result);
	    	   return exp1;
	      }
	      catch(Exception e){
	    	  System.out.println("catch");
	    	   exp1.setExpMessage("Fail");
	    	   result.put("Answer","Null");
	           result.put("Error","Bad Expression");
	           exp1.setResult(result);
	    	   return exp1;
	    	  
	     }
		 
	}
	    String  lastoperation ="";
	 
	 @RequestMapping(value="/onlinecalculator", method=RequestMethod.POST)
	   public @ResponseBody Expression onlinecalculatorExpressionAjaxJQuery(@RequestBody Expression exp1) throws Exception {
			int c1=0;
			int c2=0;
			
			 
	          String display1=exp1.getexpString();
	          System.out.println(exp1);
		boolean	checkOperations=display1.contains("+")||display1.contains("-")||display1.contains("*")||display1.contains("/");
		if(display1.length()>0&&display1.charAt(0)=='-') {
		     System.out.println("in");
		     checkOperations=false;
		}    
		if(checkOperations) {
		    	System.out.println("in");
				for (int i=display1.length()-1;i>0; --i){
					if(display1.charAt(i)=='('){
				         c1++;
				     }
				       if(display1.charAt(i)==')'){
				         c2++;
				 }

				       if(c1==c2){
				         if(display1.charAt(i)=='+'||display1.charAt(i)=='-'||display1.charAt(i)=='*'||display1.charAt(i)=='/'){
				        	 lastoperation=display1.substring(i, display1.length());
				        	 break;
				        }
				      }
				 }
			}
		    if(checkOperations){
		 try {
			  
			  System.out.println(display1);
	    	   exp1.setExpMessage("success");
	           result.put("Answer",engine.eval(display1));
	           result.put("Error","No Error");
	    	   exp1.setResult(result);
	    	   exp1.setexpString(engine.eval(display1).toString());
	    	   return exp1;
	      }
	      catch(Exception e){
	    	  System.out.println("catch");
	    	   exp1.setExpMessage("Fail");
	    	   result.put("Answer","Syntex Error");
	           result.put("Error","Bad Expression");
	           exp1.setResult(result);
	    	   return exp1;
	    	  
	     }
	  }
		    else {
		    	  try {  
		    		  if(display1.length()<1) {
		    			   lastoperation="";
		    		   }
		    		  display1=display1+lastoperation;
					  System.out.println(display1);
					   exp1.setexpString(display1);
			    	   exp1.setExpMessage("success");
			           result.put("Answer",engine.eval(display1));
			           result.put("Error","No Error");
			    	   exp1.setResult(result);
			    	   exp1.setexpString(engine.eval(display1).toString());
			    	   return exp1;
			      }
		    	
		    	catch(Exception e){
			    	  System.out.println("catch");
			    	   exp1.setExpMessage("Fail");
			    	   result.put("Answer","Syntex Error");
			           result.put("Error","Bad Expression");
			           exp1.setResult(result);
			    	   return exp1;
			    	  
			     }
		    	
		    }
		 
   }
 }
	 

