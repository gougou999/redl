package ene.redl.spring.hiberante;

import java.util.List;

import ene.redl.spring.hiberante.mapping.AddressCensus;

public interface AddressCensusDao {
	
	public List<AddressCensus> getAddressCensuses(String chName);
	
	public List<AddressCensus> getAddressCensuses();
	
}
