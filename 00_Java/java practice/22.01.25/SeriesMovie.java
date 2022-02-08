package com.ssafy.ws07.step2;

public class SeriesMovie extends Movie {
	private int seriesNum;
	private String episode;
	
	SeriesMovie(){
		
	}
	SeriesMovie(int id, String title, String director, String genre, int runningTime,int seriesNum, String episode){
		super(id, title, director, genre, runningTime);
		this.seriesNum = seriesNum;
		this.episode = episode;
	}
	public int getSeriesNum() {
		return seriesNum;
	}
	public void setSeriesNum(int seriesNum) {
		this.seriesNum = seriesNum;
	}
	public String getEpisode() {
		return episode;
	}
	public void setEpisode(String episode) {
		this.episode = episode;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + " seriesNum = " + seriesNum + " episode = " + episode;
	}
	
}
