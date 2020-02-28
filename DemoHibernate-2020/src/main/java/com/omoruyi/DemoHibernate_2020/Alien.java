package com.omoruyi.DemoHibernate_2020;




import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;





@Entity
@Table(name="AlienTable")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class Alien {

	@Id
	private int aid;
	private String aname;
	private String acolor;
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getAcolor() {
		return acolor;
	}
	public void setAcolor(String acolor) {
		this.acolor = acolor;
	}
	@Override
	public String toString() {
		return "Alien [aid=" + aid + ", aname=" + aname + ", acolor=" + acolor + "]";
	}
	
	
	
	
	
}
