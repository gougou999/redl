package ene.redl.spring.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ene.redl.spring.hiberante.CookieInfoDao;
import ene.redl.spring.hiberante.mapping.CookieInfo;
import ene.redl.spring.service.CookieService;

@Service("CookieService")
public class CookieServiceImpl implements CookieService{

	@Resource
	private CookieInfoDao cookieInfoDao;
	
	@Override
	public List<CookieInfo> getUserDataList() {
		return cookieInfoDao.getUserDataList();
	}

	@Override
	public List<CookieInfo> getUserData(String cookieId) {
		return cookieInfoDao.getUserData(cookieId);
	}

	@Override
	public String test() {
		return "This is a test";
	}

	@Override
	public List<CookieInfo> getUserData(String currentUrl, String dateSeq) {
		return cookieInfoDao.getUserData(currentUrl, dateSeq);
	}
	
}
