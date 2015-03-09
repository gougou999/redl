package ene.redl.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ene.redl.spring.hiberante.mapping.AddressCensus;

@Service
public interface AddressCensusService {
	
	public List<AddressCensus> getAddressCensusList(String chName);
	
	public List<AddressCensus> getAddressCensusList();
	
}
