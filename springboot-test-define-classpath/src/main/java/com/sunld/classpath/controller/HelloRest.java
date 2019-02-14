package com.sunld.classpath.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunld.classpath.service.ServiceInterface;

@RestController
public class HelloRest {

	@Autowired(required = true)
	@Qualifier("serviceInterfaceImplUser")
	private ServiceInterface serviceInterfaceImplUser;
	
	@Autowired(required = true)
	@Qualifier("serviceInterfaceImplProject")
	private ServiceInterface serviceInterfaceImplProject;
	
	@RequestMapping("/hello")
	public String hello() throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("hello").append("\r\n");
		sb.append("world").append("\r\n");
		if(serviceInterfaceImplUser != null) {
			String a = serviceInterfaceImplUser.doA();
			sb.append(a).append("\r\n");
		}
		if(serviceInterfaceImplProject != null) {
			String a = serviceInterfaceImplProject.doA();
			sb.append(a).append("\r\n");
		}
//		List<String> classes = this.scanPackages("com.sunld.classpath.service");
//		for(String cl : classes) {
//			sb.append(cl).append("\r\n");
//		}
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	public static List<String> scanPackages(String packageName){
		List<String> clzList=new ArrayList<>();
		//获取指定包的完整路径
		String packagesUrl = Thread.currentThread().getContextClassLoader()
				.getResource(packageName.replaceAll("\\.", "/")).getFile();
		File scanFile=new File(packagesUrl);
		String[] filenameList=scanFile.list();
		for(String filename:filenameList){
			File file=new File(scanFile,filename);
			if(file.isDirectory()){
				scanPackages(packageName+"."+filename);
			}else{
				if(filename.indexOf(".class")>0)
					clzList.add(packageName+"."+filename.replace(".class",""));
			}
		}
		return clzList;
	}

	
}
