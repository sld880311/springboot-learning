package com.sunld.classpath.service;

import org.springframework.stereotype.Service;

@Service("serviceInterfaceImplProject")
public class ServiceInterfaceImplProject implements ServiceInterface{

	@Override
	public String doA() {
		// TODO Auto-generated method stub
//		System.out.println("==ServiceInterfaceImplProject==doA=====");
		return "==ServiceInterfaceImplProject==doA=====";
	}

}
