package com.ssafy.ws07.step2;

public class MovieManagerImpl implements IMovieManager {
	private static int MAX_SIZE = 100;
	private Movie[] movieList = new Movie[MAX_SIZE];
	private int size = 0;
	//3. MovieManagerImpl 클래스를 객체가 1개만 유지되도록 Singleton 디자인 패턴을 적용한다.
	//4. MovieTest 클래스 내에 MovieManagerImpl 클래스 객체 생성 부분을 Singleton 제어자와 
	//디자인패턴을 적용한 코드로 변경하여 테스트한다.
	// 이부분 모르겠네 - 싱글톤 같네!?!?!?!?!?!!? 나는 객체 하나로 관리하겠다
	
	private static IMovieManager instance = new MovieManagerImpl(); 
		
	// 이걸 선언해줘야지, 외부에서 new를 통해 MovieNmanagerImpl 못만들어.. 그 대신 위에서 넣어줄게
	private MovieManagerImpl() {
	}
	
	static IMovieManager getInstance() {
		return instance;
	}

	@Override
	public void add(Movie m) {
		movieList[size++] = m;
	}

	@Override
	public Movie[] getList() {
		return movieList;
	}

	@Override
	public Movie[] searchByTitle(String title) {
		// 새 movie 배열을 만든다
		// mv에 넣을 인덱스 새로 지정
		Movie[] mv1 = new Movie[MAX_SIZE];
		int index = 0;
		
		for (int i = 0; i <size; i++) {
			int sel = movieList[i].getTitle().indexOf(title);
			if (sel != -1) {
				mv1[index++] = movieList[i];
			}
		}
		return mv1;
	}

	@Override
	public Movie[] getMovies() {
		// 새 movie 배열을 만든다
		// mv에 넣을 인덱스 새로 지정
		Movie[] mv2 = new Movie[MAX_SIZE];
		int index = 0;
		
		for (int i = 0; i <size; i++) {
			if (!(movieList[i] instanceof SeriesMovie)) {
				mv2[index++] = movieList[i];
			}
		}
		return mv2;
	}

	@Override
	public SeriesMovie[] getSeriesMovies() {
		// 새 movie 배열을 만든다
		// mv에 넣을 인덱스 새로 지정
		SeriesMovie[] smv = new SeriesMovie[MAX_SIZE];
		int index = 0;
		
		for (int i = 0; i <size; i++) {
			if (movieList[i] instanceof SeriesMovie) {
				smv[index++] = (SeriesMovie) movieList[i];
			}
		}
		return smv;

	}

	@Override
	public double getRunningTimeAvg() {
		double sum = 0.0;
		for(int i=0; i<size; i++) {
			sum += movieList[i].getRunningTime();
		}
		return sum / size;
	}

}
