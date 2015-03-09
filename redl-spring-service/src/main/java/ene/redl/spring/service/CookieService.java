package ene.redl.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ene.redl.spring.hiberante.mapping.CookieInfo;

@Service
public interface CookieService {
	  
	public List<CookieInfo> getUserDataList();
	
	public List<CookieInfo> getUserData(String cookieId);
	
	public List<CookieInfo> getUserData(String currentUrl, String dateSeq);
	
	public String test();
	
}
