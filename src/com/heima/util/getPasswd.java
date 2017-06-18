package com.heima.util;
import java.util.ArrayList;
import java.util.List;
public class getPasswd {
	
	 public static String getPswd(String[] arr,Integer num){
	  StringBuffer b = new StringBuffer();
	  java.util.Random r;
	  int k ;
	  int m = 76 - 15;
	  
	  for(int i=0;i<num;i++){
	    r = new java.util.Random();
	    k = r.nextInt();
	    
	    b.append(String.valueOf(arr[Math.abs(k % m)]));
	  }
	  
	  return b.toString();
	 }
	 
	 public static String passwd(Integer num){
		  StringBuffer buf = new StringBuffer("a,b,c,d,e,f,g,h,i,g,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z");
		  buf.append(",A,B,C,D,E,F,G,H,I,G,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z");
		  //buf.append(",~,@,#,$,%,^,&,*,(,),_,+,|,`,.");
		  buf.append(",1,2,3,4,5,6,7,8,9,0");
		  String[] arr = buf.toString().split(",");
		  List<String> pswdList = new ArrayList<String>();
		  pswdList.add(getPswd(arr,num));
//		  for(int i=0;i<1;i++){
//		   ;
//		  }
//		  
		  System.out.println(pswdList.toString());
		  for(int i=0;i<pswdList.size();i++){
		   System.out.println(pswdList.get(i));
		  }
		 
		 return pswdList.toString().replace("[","").replace("]", "");
	 }
	
	
}
