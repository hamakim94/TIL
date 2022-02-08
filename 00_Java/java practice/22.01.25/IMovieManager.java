package com.ssafy.ws07.step2;

public interface IMovieManager {
	void add(Movie m);
	Movie[] getList();
	Movie[] searchByTitle(String title);
	Movie[] getMovies();
	SeriesMovie[] getSeriesMovies();
	double getRunningTimeAvg();

}
