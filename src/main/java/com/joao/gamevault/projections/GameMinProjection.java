package com.joao.gamevault.projections;

public interface GameMinProjection {

	Long getId();
	String getTitle();
	Integer getYear();
	String getImgUrl();
	String getShortDescription();
	String getPosition();
}
