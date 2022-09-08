package com.eidiko.niranjana.main;

import java.util.Optional;

public class Pratice {

	public static void main(String[] args) {

		String str5 ="AfterNoon";
		Optional<String> optional5  = Optional.ofNullable(str5);
		System.out.println("optional5 ofNullable :"+optional5);				//Optional[AfterNoon]
		System.out.println("optional5 isPresent:"+optional5.isPresent());	//true
		System.out.println("optional5 get:"+optional5.get());  			//AfterNoon
		System.out.println("optional5 orElse :"+optional5.orElse(str5));			//AfterNoon
		System.out.println("optional5 orElse:"+optional5.orElse("no value"));	//AfterNoon
		System.out.println("optional5 hashCode:"+optional5.hashCode());               // -1271923908
		System.out.println("optional5 equals:"+optional5.equals(str5)); 		//false
		System.out.println("optional5 orElseThrow:"+optional5.orElseThrow());	//optional5 :AfterNoon
		System.out.println("toString"+optional5.toString());				//Optional[AfterNoon]
		System.out.println("orElseGet: "+optional5.orElseGet(null));	//AfterNoon
		System.out.println("Empty: "+optional5.empty());				//Optional.empty(return empty optional instance)
		System.out.println("isEmpty: "+optional5.isEmpty());                //false
		//System.out.println(optional5.ifPresent(i->i.endsWith("o")));
		System.out.println();
	}
}
