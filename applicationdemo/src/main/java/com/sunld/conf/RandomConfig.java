package com.sunld.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource(value = {"classpath:/random.properties"}, encoding="UTF-8")
@Component
@ConfigurationProperties(prefix = "com.sunld")
public class RandomConfig {
	//获取随机字符串:${random.value}
	private String randomValue;
	//获取随机int:${random.int}
	private String randomInt;
	//获取10以内的随机数：${random.int(10)}
	private String ranomdInt10;
	//获取10-20的随机数：${random.int[10,20]}
	private String randomInt10_20;
	//获取随机long：${random.long}
	private String randomLong;
	//获取随机uuid：${random.uuid}
	private String randomUuid;
	
	
	//get\set
	public String getRandomValue() {
		return randomValue;
	}
	public void setRandomValue(String randomValue) {
		this.randomValue = randomValue;
	}
	public String getRandomInt() {
		return randomInt;
	}
	public void setRandomInt(String randomInt) {
		this.randomInt = randomInt;
	}
	public String getRanomdInt10() {
		return ranomdInt10;
	}
	public void setRanomdInt10(String ranomdInt10) {
		this.ranomdInt10 = ranomdInt10;
	}
	public String getRandomInt10_20() {
		return randomInt10_20;
	}
	public void setRandomInt10_20(String randomInt10_20) {
		this.randomInt10_20 = randomInt10_20;
	}
	public String getRandomLong() {
		return randomLong;
	}
	public void setRandomLong(String randomLong) {
		this.randomLong = randomLong;
	}
	public String getRandomUuid() {
		return randomUuid;
	}
	public void setRandomUuid(String randomUuid) {
		this.randomUuid = randomUuid;
	}
	@Override
	public String toString() {
		return "RandomConfig [randomValue=" + randomValue + ", randomInt=" + randomInt + ", ranomdInt10=" + ranomdInt10
				+ ", randomInt10_20=" + randomInt10_20 + ", randomLong=" + randomLong + ", randomUuid=" + randomUuid
				+ "]";
	}
	
}
