package com.ssafy.ws06.step2;

public class MovieManager {
	private static int MAX_SIZE = 100;
	private Movie[] movieList = new Movie[MAX_SIZE];
	private int size = 0;
	
	//나중에 print하기 편하려고, size를 getter만들자

	public int getSize() {
		return this.size;
	}

	void add(Movie movie) {
		movieList[size++] = movie;
	}
	

	Movie[] getList() {
		return movieList;
	}
	
	//뭔지 몰랐는데, 알고보니 Movietype만 받아오라 이거네요.
	Movie[] getMovies() { 
		Movie[] mv = new Movie[MAX_SIZE];
		int cnt = 0;
		for (int i = 0; i< size; i++) {
			// if (movieList[i] instanceof Movie) 이렇게 하니까 안 되네, SeriesMovie는 여전히 상속받잖아..
			if (!(movieList[i] instanceof SeriesMovie)) {
				mv[cnt++] = movieList[i];
			} 
		}
		return mv ;
	}

	SeriesMovie[] getSeriesMovies() {
		int size = 0;
		// 일단 movie형태 배열인 , series_movie 생성
		SeriesMovie[] series_movies = new SeriesMovie[MAX_SIZE];
		// 불안하면 그냥 다 훑기, 여기에 size 넣어서 안 돌아갔음~
		for (int i = 0; i < MAX_SIZE; i++) {

			// SeriesMovie seriesmovie = (SeriesMovie) movieList[i];
			if (movieList[i] instanceof SeriesMovie) {
				// movieList[i]마다, seriesmovie로 형변환
				series_movies[size++] = (SeriesMovie) movieList[i];

			}
		}
		return series_movies;
	}

	Movie[] searchByTitle(String title) {
		int cnt = 0;
		Movie[] new_movie = new Movie[MAX_SIZE];
		
		for (int i = 0; i < size; i++) {
			// 일부를 포함하게 하려면 어떻게 해야하지? => String method, index of!
			int k = movieList[i].getTitle().indexOf(title); // title을 포함하니?
			// System.out.println(k);
			if (k != -1) {
				new_movie[cnt++] = movieList[i];
			}
		}
		return new_movie;
	}

	double getRunningTimeAvg() {
		double sum = 0.0;
		for (int i = 0; i < size; i++) {
			sum += movieList[i].getRunningTime();
		}
		return sum / size;
	}

}
