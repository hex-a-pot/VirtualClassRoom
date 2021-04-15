package com.layers.model;

public class Marks {

	private long id;
	private int maths;
	private int chemistry;
	private int physics;
	private int cs;
	private int english;

	Marks() {
		super();
	}

	public Marks(long id, int maths, int chemistry, int physics, int cs, int english) {
		this.id = id;
		this.maths = maths;
		this.chemistry = chemistry;
		this.physics = physics;
		this.cs = cs;
		this.english = english;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getMaths() {
		return maths;
	}

	public void setMaths(int maths) {
		this.maths = maths;
	}

	public int getChemistry() {
		return chemistry;
	}

	public void setChemistry(int chemistry) {
		this.chemistry = chemistry;
	}

	public int getPhysics() {
		return physics;
	}

	public void setPhysics(int physics) {
		this.physics = physics;
	}

	public int getCs() {
		return cs;
	}

	public void setCs(int cs) {
		this.cs = cs;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}
	
	

}
