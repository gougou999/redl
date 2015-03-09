package ene.redl.spring.hiberante.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangrui on 2014/7/8.
 */
public interface BaseDao<T> {
    /**
     * 保存对象
     * @param o
     * @return
     */
    public Serializable save(T o);

    /**
     * 保存或更新对象
     * @param o
     */
    public void saveOrUpdate(T o);

    /**
     * 删除对象
     * @param o
     */
    public void delete(T o);

    /**
     * 根据id删除队形
     * @param id
     */
    public void delete(Serializable id);

    /**
     * 更新对象
     * @param o
     */
    public void update(T o);

    /**
     * 根据id加载对象
     * @param id
     * @return
     */
    public T load(int id);

    /**
     * 根据id获得对象
     * @param id
     * @return
     */
    public T get(Serializable id);

    /**
     * 合并对象
     * @param o
     */
    public void merge(T o);

    /**
     * 判断对象是否存在
     * @param id
     * @return
     */
    public boolean exists(Serializable id);

    /**
     * 清空session
     */
    public void clear();

    /**
     * 强制清空session
     */
    public void flush();











    /**
     * 根据hql查询
     * @param hql
     * @return List<T>
     */
    public List<T> list(String hql);
    public List<T> list(String hql, Object o);
    public List<T> list(String hql, Object[] o);

    /**
     * 基于别名和查询参数的混合列表对象
     * @param hql
     * @param o
     * @param alias
     * @return
     */
    public List<T> list(String hql, Object[] o, Map<String, Object> alias);
    public List<T> listByAlias(String hql, Map<String, Object> alias);

    /**
     * 根据hql查询
     * @param hql
     * @return List<T>
     */
    public Page<T> find(String hql);
    public Page<T> find(String hql, Object o);
    public Page<T> find(String hql, Object[] o);

    /**
     * 基于别名和查询参数的混合列表对象
     * @param hql
     * @param o
     * @param alias
     * @return
     */
    public Page<T> find(String hql, Object[] o, Map<String, Object> alias);
    public Page<T> findByAlias(String hql, Map<String, Object> alias);

    /**
     * 查询一组对象
     * @param hql
     * @return
     */
    public Object queryObject(String hql);
    public Object queryObject(String hql, Object o);
    public Object queryObject(String hql, Object[] o);
    public Object queryObject(String hql, Object[] args, Map<String, Object> alias);
    public Object queryObjectByAlias(String hql, Map<String, Object> alias);

    /**
     * 更新一组对象
     * @param hql
     */
    public void updateByHql(String hql);
    public void updateByHql(String hql, Object o);
    public void updateByHql(String hql, Object[] o);

    /**
     * 根据SQL查询一组对象（不分页）,不包含关联对象
     * @param sql 查询的sql语句
     * @param o 查询条件
     * @param c 查询的实体对象
     * @param isEntity 该对象是否是一个Hibernate所管理的尸体,如果不是需要使用setResultTransform查询
     * @return
     */
    public <N extends Object>List<N> listBySql(String sql, Object[] o, Class<?> c, boolean isEntity);
    public <N extends Object>List<N> listBySql(String sql, Object o, Class<?> c, boolean isEntity);
    public <N extends Object>List<N> listBySql(String sql, Class<?> c, boolean isEntity);
    public <N extends Object>List<N> listBySql(String sql, Object[] o, Map<String, Object> alias, Class<?> clz, boolean isEntity);
    public <N extends Object>List<N> listByAliasSql(String sql, Map<String, Object> alias, Class<?> clz, boolean isEntity);

    /**
     * 根据SQL查询一组对象（分页）,不包含关联对象
     * @param sql 查询的sql语句
     * @param o 查询条件
     * @param c 查询的实体对象
     * @param isEntity 该对象是否是一个Hibernate所管理的尸体,如果不是需要使用setResultTransform查询
     * @return
     */
    public <N extends Object>Page<N> findBySql(String sql, Object[] o, Class<?> c, boolean isEntity);
    public <N extends Object>Page<N> findBySql(String sql, Object o, Class<?> c, boolean isEntity);
    public <N extends Object>Page<N> findBySql(String sql, Class<?> clz, boolean isEntity);
    public <N extends Object>Page<N> findBySql(String sql, Object[] o, Map<String, Object> alias, Class<?> clz, boolean isEntity);
    public <N extends Object>Page<N> findByAliasSql(String sql, Map<String, Object> alias, Class<?> clz, boolean isEntity);

}
