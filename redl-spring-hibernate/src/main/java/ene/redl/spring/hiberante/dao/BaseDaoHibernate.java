package ene.redl.spring.hiberante.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by zhangrui on 2014/7/8.
 */
@SuppressWarnings("unchecked")
@Repository("baseDao")
public class BaseDaoHibernate<T> implements BaseDao<T> {
    @Autowired
    private SessionFactory sessionFactory;

    //泛型反射类
    private Class<T> entityClass;

    /*//通过反射获取子类确定的泛型类
    public BaseDaoHibernate(){
        Type genType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

        entityClass = (Class) params[0];
    }*/
    protected Session getSession(){
        return sessionFactory.openSession();
    }

    @Override
    public Serializable save(T o) {
    	Session session = this.getSession();
    	Serializable ser = (Serializable) session.save(o);
    	session.close();
        return ser;
    }

    @Override
    public void saveOrUpdate(T o) {
    	Session session = this.getSession();
    	session.saveOrUpdate(o);
    	session.close();
    }

    @Override
    public void delete(T o) {
    	Session session = this.getSession();
    	session.delete(o);
    	session.close();
    }

    @Override
    public void delete(Serializable id) {
    	Session session = this.getSession();
    	session.delete(get(id));
    	session.close();
    }

    @Override
    public void update(T o) {
    	Session session = this.getSession();
    	session.update(o);
    	session.close();
    }

    
	@Override
    public T load(int id) {
		Session session = this.getSession();
		T t = (T) session.load(entityClass, id);
		session.close();
        return t;
    }

    @Override
    public T get(Serializable id) {
    	Session session = this.getSession();
    	T t = (T) session.get(this.entityClass, id);
    	session.close();
        return t;
    }

    @Override
    public void merge(T o) {
    	Session session = this.getSession();
    	session.merge(o);
        session.close();
    }

    @Override
    public boolean exists(Serializable id) {
        return false;
    }

    @Override
    public void clear() {
    	Session session = this.getSession();
    	session.clear();
        session.close();
    }

    @Override
    public void flush() {
    	Session session = this.getSession();
    	session.flush();
        session.close();
    }




    @Override
    public List<T> list(String hql) {
    	Session session = this.getSession();
    	List<T> list = this.list(hql,null);
    	session.close();
        return list;
    }

    @Override
    public List<T> list(String hql, Object o) {
        return this.list(hql, new Object[]{o});
    }

    @Override
    public List<T> list(String hql, Object[] o) {
    	return this.list(hql, o, null);
    }

    @Override
    public List<T> list(String hql, Object[] o, Map<String, Object> alias) {
        hql = initSort(hql);
        Session session = getSession();
        Query query = session.createQuery(hql);
        setAliasParameter(query, alias);
        setParameter(query, o);
        List<T> list = query.list();
        session.close();
        return list;
    }

    @Override
    public List<T> listByAlias(String hql, Map<String, Object> alias) {
        return this.list(hql, null, alias);
    }

    @Override
    public Page<T> find(String hql) {
        return this.find(hql,null);
    }

    @Override
    public Page<T> find(String hql, Object o) {
        return this.find(hql, new Object[]{o});
    }

    @Override
    public Page<T> find(String hql, Object[] o) {
        return this.find(hql, o, null);
    }

    @Override
    public Page<T> find(String hql, Object[] o, Map<String, Object> alias) {
    	Session session1 = this.getSession();
    	Session session2 = this.getSession();
        hql = initSort(hql);
        String cq = getCountHql(hql,true);
        Query cquery = session1.createQuery(cq);
        Query query =  session2.createQuery(hql);
        //设置别名参数
        setAliasParameter(query, alias);
        setAliasParameter(cquery, alias);
        //设置参数
        setParameter(query, o);
        setParameter(cquery, o);
        Page<T> pages = new Page<T>();
        setPagers(query,pages);
        List<T> datas = query.list();
        pages.setDatas(datas);
        long total = (Long)cquery.uniqueResult();
        pages.setTotal(total);
        session1.close();
        session2.close();
        return pages;
    }

    @Override
    public Page<T> findByAlias(String hql, Map<String, Object> alias) {
        return this.find(hql,null, alias);
    }

    @Override
    public Object queryObject(String hql) {
        return this.queryObject(hql,null);
    }

    @Override
    public Object queryObject(String hql, Object o) {
        return this.queryObject(hql, new Object[]{o});
    }

    @Override
    public Object queryObject(String hql, Object[] o) {
        return this.queryObject(hql, o,null);
    }

    @Override
    public Object queryObject(String hql, Object[] args, Map<String, Object> alias) {
    	Session session = this.getSession();
        Query query = session.createQuery(hql);
        setAliasParameter(query, alias);
        setParameter(query, args);
        Object obj = query.uniqueResult();
        session.close();
        return obj;
    }

    @Override
    public Object queryObjectByAlias(String hql, Map<String, Object> alias) {
        return this.queryObject(hql,null,alias);
    }

    @Override
    public void updateByHql(String hql) {
        this.updateByHql(hql,null);
    }

    @Override
    public void updateByHql(String hql, Object o) {
        this.updateByHql(hql,new Object[]{o});
    }

    @Override
    public void updateByHql(String hql, Object[] o) {
    	Session session = this.getSession();
        Query query = session.createQuery(hql);
        setParameter(query, o);
        query.executeUpdate();
        session.close();
    }

    @Override
    public <N> List<N> listBySql(String sql, Object[] args, Class<?> clz, boolean hasEntity) {
        return this.listBySql(sql, args, null, clz, hasEntity);
    }

    @Override
    public <N> List<N> listBySql(String sql, Object o, Class<?> c, boolean isEntity) {
        return null;
    }

    @Override
    public <N> List<N> listBySql(String sql, Class<?> c, boolean isEntity) {
        return null;
    }

    @Override
    public <N> List<N> listBySql(String sql, Object[] o, Map<String, Object> alias, Class<?> clz, boolean isEntity) {
        return null;
    }

    @Override
    public <N> List<N> listByAliasSql(String sql, Map<String, Object> alias, Class<?> clz, boolean isEntity) {
        return null;
    }

    @Override
    public <N> Page<N> findBySql(String sql, Object[] o, Class<?> c, boolean isEntity) {
        return null;
    }

    @Override
    public <N> Page<N> findBySql(String sql, Object o, Class<?> c, boolean isEntity) {
        return null;
    }

    @Override
    public <N> Page<N> findBySql(String sql, Class<?> clz, boolean isEntity) {
        return null;
    }

    @Override
    public <N> Page<N> findBySql(String sql, Object[] o, Map<String, Object> alias, Class<?> clz, boolean isEntity) {
        return null;
    }

    @Override
    public <N> Page<N> findByAliasSql(String sql, Map<String, Object> alias, Class<?> clz, boolean isEntity) {
        return null;
    }


    //==============================================================
    /**
     * 查询排序
     * @param hql
     * @return
     */
    private String initSort(String hql) {
        String order = SystemContext.getOrder();
        String sort = SystemContext.getSort();
        if(sort != null && !sort.trim().equals("")) {
            hql+=" order by "+sort;
            if(!order.equals("desc"))
                hql+=" asc";
            else
                hql+=" desc";
        }
        return hql;
    }
    /**
     * 设置别名查询
     * @param query
     * @param alias
     */
    @SuppressWarnings("rawtypes")
	private void setAliasParameter(Query query,Map<String,Object> alias) {
        if(alias != null) {
            Set<String> keys = alias.keySet();
            for(String key:keys) {
                Object val = alias.get(key);
                if(val instanceof Collection) {
                    //查询条件是列表
                    query.setParameterList(key, (Collection)val);
                } else {
                    query.setParameter(key, val);
                }
            }
        }
    }

    /**
     * 设置查询参数
     * @param query
     * @param o
     */
    private void setParameter(Query query,Object[] o) {
        if(o !=null && o.length>0) {
            int index = 0;
            for(Object arg:o) {
                query.setParameter(index++, arg);
            }
        }
    }

    /**
     * 设置分页
     * @param query
     * @param pages
     */
    @SuppressWarnings("rawtypes")
    private void setPagers(Query query, Page pages) {
        Integer pageSize = SystemContext.getPageSize();
        Integer pageOffset = SystemContext.getPageOffset();
        if(pageOffset==null||pageOffset<0) pageOffset = 0;
        if(pageSize==null||pageSize<0) pageSize = 15;
        pages.setOffset(pageOffset);
        pages.setSize(pageSize);
        query.setFirstResult(pageOffset).setMaxResults(pageSize);
    }

    /**
     * 获得记录集个数
     * @param hql
     * @param isHql
     * @return
     */
    private String getCountHql(String hql,boolean isHql) {
        String e = hql.substring(hql.indexOf("from"));
        String c = "select count(*) "+e;
        if(isHql)
            c = c.replaceAll("fetch", "");
        return c;
    }
}
