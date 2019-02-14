package com.sunld.classpath.service;

import org.springframework.stereotype.Service;

@Service("serviceInterfaceImplUser")
public class ServiceInterfaceImplUser implements ServiceInterface{

	@Override
	public String doA() {
		// TODO Auto-generated method stub
//		System.out.println("==ServiceInterfaceImplUser==doA=====");
		return "==ServiceInterfaceImplUser==doA=====";
	}

}
