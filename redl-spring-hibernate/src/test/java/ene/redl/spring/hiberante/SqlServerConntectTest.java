package ene.redl.spring.hiberante;


import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import ene.redl.spring.hiberante.dao.BaseDao;
import ene.redl.spring.hiberante.mapping.AddressCensus;
import ene.redl.spring.hiberante.mapping.CookieInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext-hibernate.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback=true)
@Transactional
public class SqlServerConntectTest extends AbstractJUnit4SpringContextTests{

	@Resource
	private CookieInfoDao cookieInfoDao;
	
	@Resource
	private AddressCensusDao addressCensusDao;
	
	@Resource
	BaseDao<CookieInfo> baseDao;
	
	@Resource
	BaseDao<AddressCensus> censusBaseDao;
	
	@Test
	public void test(){
		//userDataDao.getUserDataList();
		//userInfoDao.getUserData("e688403d1e0fc177e8b836624dc7a371");
		//baseDao.get(1);
		
		/*User user = new User();
        user.setUsername("Hibernate");
        user.setPassword("123456789");
        baseDao.save(user);*/
		for (int i = 0; i < 50; i++) {
			List<CookieInfo> infos = cookieInfoDao.getUserDataList();	
			System.out.println("Count " + i + " : " + infos.size());
		}
		
		/*AddressCensus census = new AddressCensus();
		census.setChName("shanghai");
		census.setJingQu(2);
		census.setLvYouYouJi(2);
		census.setNews(5);
		census.setPingCe(4);
		census.setShouYe(4);
		census.setTotal(7);
		census.setTuPian(6);
		census.setYuding(6);
		census.setZhengWen(7);
		census.setZuJi(93);
		censusBaseDao.save(census);
		
		List<AddressCensus> list = addressCensusDao.getAddressCensuses("北京");
		System.out.println(list.size());*/
	}
}
