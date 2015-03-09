package ene.redl.spring.hiberante;

import java.util.List;

import org.springframework.stereotype.Repository;

import ene.redl.spring.hiberante.mapping.CookieInfo;

@Repository
public interface CookieInfoDao {
	
	public List<CookieInfo> getUserDataList();
	
	public List<CookieInfo> getUserData(String cookieId);
	
	public List<CookieInfo> getUserData(String currentUrl, String dateSeq);
	
}
