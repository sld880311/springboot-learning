package com.sunld.producer.feign;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import feign.Feign;
import feign.RequestInterceptor;
import feign.RequestTemplate;

@Configuration
@ConditionalOnClass({ Feign.class })
public class FeignConfig implements RequestInterceptor{
	
	private Logger LOG = LoggerFactory.getLogger(FeignConfig.class);
	
	@Bean
	public WebMvcRegistrations feignWebRegistrations() {
		return new WebMvcRegistrations() {
			@Override
			public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
				LOG.error("================feignWebRegistrations=================");
				return new FeginRequestMappingHandlerMapping();
			}
		};
	}
	
	private static class FeginRequestMappingHandlerMapping 
		extends RequestMappingHandlerMapping{
		@Override
		protected boolean isHandler(Class<?> beanType) {
			return super.isHandler(beanType) && !beanType.isInterface();
		}
	}

	@Override
	public void apply(RequestTemplate requestTemplate) {
		ServletRequestAttributes attributes = (ServletRequestAttributes)
				RequestContextHolder.getRequestAttributes();
		LOG.error("================apply=================");
		if(attributes == null || requestTemplate == null) {
			return ;
		}
		HttpServletRequest request = attributes.getRequest();
		if(request == null) {
			return ;
		}
	}

}
