package ene.redl.spring.hiberante.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import ene.redl.spring.hiberante.AddressCensusDao;
import ene.redl.spring.hiberante.mapping.AddressCensus;

@Repository("AddressCensus")
public class AddressCensusDaoHibernate extends BaseDaoHibernate<AddressCensus> 
		implements AddressCensusDao{

	@Override
	public List<AddressCensus> getAddressCensuses(String chName) {
		String hql = "from AddressCensus where chName = '" +chName+ "'";
		return this.list(hql);
	}

	@Override
	public List<AddressCensus> getAddressCensuses() {
		String hql = "from AddressCensus ";
		return this.list(hql);
	}

}
