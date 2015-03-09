package ene.redl.spring.hiberante.mapping;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Lt_Stats201501")
public class CookieInfo {
	
	/**
	 * 主键ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Id")
	private int id;
	
	/**
	 * CookieId
	 */
	@Basic
    @Column(name="CookieId", nullable = false, insertable = true, updatable = true)
	private String cookieId;
	
	/**
	 * 标题
	 */
	@Basic
    @Column(name="Title", nullable = false, insertable = true, updatable = true)
	private String title;
	
	
	/**
	 *  用户ID
	 */
	@Basic
    @Column(name="UserId", nullable = false, insertable = true, updatable = true)
	private int userId;
	
	/**
	 *来源地址
	 */
	@Basic
    @Column(name="Referer", nullable = false, insertable = true, updatable = true)
	private String referer;
	
	/**
	 * 当前地址
	 */
	@Basic
    @Column(name="CurrentUrl", nullable = false, insertable = true, updatable = true)
	private String currentUrl;
	
	/**
	 * 记录时间
	 */
	@Basic
    @Column(name="AddTime", nullable = false, insertable = true, updatable = true)
	private Date addTime;
	
	/**
	 * 时间戳
	 */
	@Basic
    @Column(name="Timestamp", nullable = false, insertable = true, updatable = true)
	private String timestamp;
	
	/**
	 * 停留时间
	 */
	@Basic
    @Column(name="Duration", nullable = false, insertable = true, updatable = true)
	private int duration;
	
	/**
	 * 停留时间(关闭)
	 */
	@Basic
    @Column(name="Duration2", nullable = false, insertable = true, updatable = true)
	private int duration2;
	
	/**
	 * 浏览器
	 */
	@Basic
    @Column(name="Browser", nullable = false, insertable = true, updatable = true)
	private String brower;
	
	/**
	 * 分辨率
	 */
	@Basic
    @Column(name="Resolution", nullable = false, insertable = true, updatable = true)
	private String resolution;
	
	/**
	 * IP地址
	 */
	@Basic
    @Column(name="IP", nullable = false, insertable = true, updatable = true)
	private String ip;
	
	/**
	 * 操作系统
	 */
	@Basic
    @Column(name="OS", nullable = false, insertable = true, updatable = true)
	private String os;
	
	/**
	 * 操作系统
	 */
	@Basic
    @Column(name="AccessClientType", nullable = false, insertable = true, updatable = true)
	private int accessClientType;
	
	/**
	 * URL来源
	 */
	@Basic
    @Column(name="RegionName", nullable = false, insertable = true, updatable = true)
	private String regionName;
	
	/**
	 * IP地址地域编号
	 */
	@Basic
    @Column(name="ChannelId", nullable = false, insertable = true, updatable = true)
	private int channelId;
	
	/**
	 * 频道ID
	 */
	@Basic
    @Column(name="ActionType", nullable = false, insertable = true, updatable = true)
	private int actionType;
	
	/**
	 * 时间串
	 */
	@Basic
    @Column(name="DateSeq", nullable = false, insertable = true, updatable = true)
	private int dateSeq;
	
	/**
	 * 进入网页顺序
	 */
	@Basic
    @Column(name="UserViewSeq", nullable = false, insertable = true, updatable = true)
	private int userViewSeq;
	
	/**
	 * 进入网页前一个页面
	 */
	@Basic
    @Column(name="RefererUrlType", nullable = false, insertable = true, updatable = true)
	private int refererUrlType;
	
	/**
	 * 用户搜索关键字
	 */
	@Basic
    @Column(name="KeyWords", nullable = false, insertable = true, updatable = true)
	private String keyWords;
	
	/**
	 * 频道名称
	 */
	@Basic
    @Column(name="ChName", nullable = false, insertable = true, updatable = true)
	private String chName;
	
	/**
	 * 当前Url业务名称
	 */
	@Basic
    @Column(name="BizName", nullable = false, insertable = true, updatable = true)
	private String bizName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCookieId() {
		return cookieId;
	}
	public void setCookieId(String cookieId) {
		this.cookieId = cookieId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getReferer() {
		return referer;
	}
	public void setReferer(String referer) {
		this.referer = referer;
	}
	public String getCurrentUrl() {
		return currentUrl;
	}
	public void setCurrentUrl(String currentUrl) {
		this.currentUrl = currentUrl;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getDuration2() {
		return duration2;
	}
	public void setDuration2(int duration2) {
		this.duration2 = duration2;
	}
	public String getBrower() {
		return brower;
	}
	public void setBrower(String brower) {
		this.brower = brower;
	}
	public String getResolution() {
		return resolution;
	}
	public void setResolution(String resolution) {
		this.resolution = resolution;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public int getAccessClientType() {
		return accessClientType;
	}
	public void setAccessClientType(int accessClientType) {
		this.accessClientType = accessClientType;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public int getChannelId() {
		return channelId;
	}
	public void setChannelId(int channelId) {
		this.channelId = channelId;
	}
	public int getActionType() {
		return actionType;
	}
	public void setActionType(int actionType) {
		this.actionType = actionType;
	}
	public int getDateSeq() {
		return dateSeq;
	}
	public void setDateSeq(int dateSeq) {
		this.dateSeq = dateSeq;
	}
	public int getUserViewSeq() {
		return userViewSeq;
	}
	public void setUserViewSeq(int userViewSeq) {
		this.userViewSeq = userViewSeq;
	}
	public int getRefererUrlType() {
		return refererUrlType;
	}
	public void setRefererUrlType(int refererUrlType) {
		this.refererUrlType = refererUrlType;
	}
	public String getKeyWords() {
		return keyWords;
	}
	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}
	public String getChName() {
		return chName;
	}
	public void setChName(String chName) {
		this.chName = chName;
	}
	public String getBizName() {
		return bizName;
	}
	public void setBizName(String bizName) {
		this.bizName = bizName;
	}
	
}
