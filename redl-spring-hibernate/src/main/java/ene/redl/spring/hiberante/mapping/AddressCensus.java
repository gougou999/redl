package ene.redl.spring.hiberante.mapping;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Lt_MudidiTongJi")
public class AddressCensus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Id")
	private int id;
	
	@Basic
    @Column(name="Total", nullable = false, insertable = true, updatable = true)
	private int total;
	
	@Basic
    @Column(name="ShouYe", nullable = false, insertable = true, updatable = true)
	private int shouYe;
	
	@Basic
    @Column(name="JingQu", nullable = false, insertable = true, updatable = true)
	private int jingQu;
	
	@Basic
    @Column(name="LvYouYouJi", nullable = false, insertable = true, updatable = true)
	private int lvYouYouJi;
	
	@Basic
    @Column(name="PingCe", nullable = false, insertable = true, updatable = true)
	private int pingCe;
	
	@Basic
    @Column(name="News", nullable = false, insertable = true, updatable = true)
	private int news;
	
	@Basic
    @Column(name="Yuding", nullable = false, insertable = true, updatable = true)
	private int yuding;
	
	@Basic
    @Column(name="ZhengWen", nullable = false, insertable = true, updatable = true)
	private int zhengWen;
	
	@Basic
    @Column(name="TuPian", nullable = false, insertable = true, updatable = true)
	private int tuPian;
	
	@Basic
    @Column(name="ZuJi", nullable = false, insertable = true, updatable = true)
	private int zuJi;
	
	@Basic
    @Column(name="ChName", nullable = false, insertable = true, updatable = true)
	private String chName;
	
	@Basic
    @Column(name="Date", nullable = false, insertable = true, updatable = true)
	private int date;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getShouYe() {
		return shouYe;
	}
	public void setShouYe(int shouYe) {
		this.shouYe = shouYe;
	}
	public int getJingQu() {
		return jingQu;
	}
	public void setJingQu(int jingQu) {
		this.jingQu = jingQu;
	}
	public int getLvYouYouJi() {
		return lvYouYouJi;
	}
	public void setLvYouYouJi(int lvYouYouJi) {
		this.lvYouYouJi = lvYouYouJi;
	}
	public int getPingCe() {
		return pingCe;
	}
	public void setPingCe(int pingCe) {
		this.pingCe = pingCe;
	}
	public int getNews() {
		return news;
	}
	public void setNews(int news) {
		this.news = news;
	}
	public int getYuding() {
		return yuding;
	}
	public void setYuding(int yuding) {
		this.yuding = yuding;
	}
	public int getZhengWen() {
		return zhengWen;
	}
	public void setZhengWen(int zhengWen) {
		this.zhengWen = zhengWen;
	}
	public int getTuPian() {
		return tuPian;
	}
	public void setTuPian(int tuPian) {
		this.tuPian = tuPian;
	}
	public int getZuJi() {
		return zuJi;
	}
	public void setZuJi(int zuJi) {
		this.zuJi = zuJi;
	}
	public String getChName() {
		return chName;
	}
	public void setChName(String chName) {
		this.chName = chName;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	
}
