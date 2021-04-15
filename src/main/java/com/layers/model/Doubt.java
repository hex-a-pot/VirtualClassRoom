package com.layers.model;

public class Doubt {
	
	private long studId;
	private long doubtId;
	private String doubtDesc;
	
	Doubt()
	{
		super();
	}
	public Doubt(long studId, long doubtId, String doubtDesc)
	{
		this.studId = studId;
		this.doubtId = doubtId;
		this.doubtDesc = doubtDesc;
	}
	public Doubt(long studId,String doubtDesc)
	{
		this.studId = studId;
		this.doubtDesc = doubtDesc;
	}
	public long getStudId() {
		return studId;
	}
	public void setStudId(long studId) {
		this.studId = studId;
	}
	public long getDoubtId() {
		return doubtId;
	}
	public void setDoubtId(long doubtId) {
		this.doubtId = doubtId;
	}
	public String getDoubtDesc() {
		return doubtDesc;
	}
	public void setDoubtDesc(String doubtDesc) {
		this.doubtDesc = doubtDesc;
	}
	
	

}
