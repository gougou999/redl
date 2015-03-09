package ene.redl.spring.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext-service.xml"})
public class ServiceTest extends AbstractJUnit4SpringContextTests{

	@Resource
	CookieService cookieService;
	
	@Test
	public void test(){
		System.out.println(cookieService == null);
		cookieService.getUserDataList();
		cookieService.getUserData("xxxxxxxx");
	}
}
