package com.hamakim.moviemvc.model.dto;


public class Movie {
	private String title;
	private String genre;
	private String director;
	private int runningTime;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public int getRunningTime() {
		return runningTime;
	}
	public void setRunningTime(int runningTime) {
		this.runningTime = runningTime;
	}
	@Override
	public String toString() {
		return "Movie [title=" + title + ", genre=" + genre + ", director=" + director + ", runningTime=" + runningTime
				+ "]";
	}
	
	
	
}
