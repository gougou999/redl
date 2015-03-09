package ene.redl.spring.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ene.redl.spring.hiberante.AddressCensusDao;
import ene.redl.spring.hiberante.mapping.AddressCensus;
import ene.redl.spring.service.AddressCensusService;

@Service("AddressCensusService")
public class AddressCensusServiceImpl implements AddressCensusService{

	@Resource
	private AddressCensusDao addressCensusDao;
	
	@Override
	public List<AddressCensus> getAddressCensusList(String chName) {
		return addressCensusDao.getAddressCensuses(chName);
	}

	@Override
	public List<AddressCensus> getAddressCensusList() {
		return addressCensusDao.getAddressCensuses();
	}

}
