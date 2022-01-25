package com.ssafy.ws06.step2;

public class MovieTest {
	public static void main(String[] args) {
		MovieManager moviemanager = new MovieManager();
		Movie m = new Movie( 1, "인절미", "김민균", "떡", 3); 
		Movie m1 = new SeriesMovie( 2, "해삼1", "김민균", "해산물", 4, 1, "멍개천국"); 
		Movie m2 = new SeriesMovie( 3, "해삼2", "김민균", "해산물", 5, 2, "멍개천국"); 
		Movie m3 = new SeriesMovie( 4, "해삼3", "김민균", "해산물", 6, 3, "멍개천국"); 
		Movie m4 = new SeriesMovie( 5, "해삼4", "김민균", "해산물", 7, 4, "멍개천국"); 
		moviemanager.add(m);
		moviemanager.add(m1);
		moviemanager.add(m2);
		moviemanager.add(m3);
		moviemanager.add(m4);
		Movie m5 = new SeriesMovie( 6, "말미잘1", "김민균", "바다", 4, 1, "니모"); 
		Movie m6 = new SeriesMovie( 7, "말미잘2", "김민균", "바다", 5, 2, "니모"); 
		Movie m7 = new SeriesMovie( 8, "말미잘3", "김민균", "바다", 6, 3, "니모"); 
		Movie m8 = new SeriesMovie( 9, "말미잘4", "김민균", "바다", 7, 4, "니모"); 
		Movie m9 = new Movie( 10, "물고기 단편선", "김민균", "장르", 7); 
		moviemanager.add(m5);
		moviemanager.add(m6);
		moviemanager.add(m7);
		moviemanager.add(m8);
		moviemanager.add(m9);
		
		System.out.println("-------------------------------------------------------");
		System.out.println("전체 출력");
		System.out.println();
		
		// 전체 moviemanager 속 배열 출력
		// 첫 시도, getSize를 만들어서, for문을 돌렸음
		
//		for (int i = 0; i< moviemanager.getSize(); i++) {
//			System.out.println(moviemanager.getList()[i].toString());
//		}
		int index1 = 0;
		while (moviemanager.getList()[index1] != null) {
			System.out.println(moviemanager.getList()[index1++].toString());

		}
		System.out.println("-------------------------------------------------------");
		System.out.println("Movie만 출력");
		System.out.println();
		int index2 = 0;
		// 전체를 출력하기 위해, while문을 돈다
		while (moviemanager.getMovies()[index2] != null) {
			System.out.println(moviemanager.getMovies()[index2++].toString());
		}
		System.out.println("-------------------------------------------------------");
		System.out.println("Series만 출력");
		System.out.println();
		int index3 = 0;
		// 전체를 출력하기 위해, while문을 돈다
		
		while (moviemanager.getSeriesMovies()[index3] != null) {
			System.out.println(moviemanager.getSeriesMovies()[index3++].toString());
		}
		System.out.println("-------------------------------------------------------");
		System.out.println("해삼 포함만 출력(SearchByTitle)만 출력");
		System.out.println();
		int index4 = 0;
		// 전체를 출력하기 위해, while문을 돈다
		
		while (moviemanager.searchByTitle("해삼")[index4] != null) {
			System.out.println(moviemanager.getSeriesMovies()[index4++].toString());
		}
		
	
		System.out.println("-------------------------------------------------------");
		System.out.println("평균 시간 출력");
		System.out.println();
		System.out.println(moviemanager.getRunningTimeAvg());
	}
}
