///**
// * 当时用配置文件时删掉该类
// */
//package com.sunld;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
///**
// * 自定义资源映射路径处理类
// * @author sunliaodong
// */
//@Configuration
////增加该注解之后WebMvcAutoConfiguration中配置就不会生效
////@EnableWebMvc
//public class MyWebMvcConfigurer implements WebMvcConfigurer{
//	
//	@Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		/**
//		 * 将/** 目录下的静态资源映射到classpath:/view/下
//		 * 直接访问http://127.0.0.1:8080/index_view.html，发现图片信息获取不到需要增加默认的资源映射
//		 * Locations of static resources. Defaults to classpath:[/META-INF/resources/,
//		 * /resources/, /static/, /public/].
//		 */
//        registry.addResourceHandler("/**").addResourceLocations(
//        			"classpath:/META-INF/resources/", 
//        			"classpath:/resources/",
//        			"classpath:/static/", 
//        			"classpath:/public/",
//        			"/",//对于/META-INF/resources/
//        			"classpath:/view/");
//        /**
//         * 将/view2/** 目录映射到classpath:/view2下
//         * 这种方式不影响springboot默认的静态资源映射路径，可以注释掉以上代码测试
//         */
//        registry.addResourceHandler("/view2/**").addResourceLocations(
//    			"classpath:/view2/");
//    }
//}
