import java.util.*;
import java.io.*;


public class ST_로봇이지나간경로
{
    // 4로 나눈 나머지가, 다음 방향으로 정해진다.
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {-1, 0, 1, 0};
    static char[][] map;
    static char[] direction = {'<','^', '>', 'v'};
    static int R,C;
    static boolean[][] visited;

    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        for(int i=0; i<R; i++){
            map[i] = br.readLine().toCharArray();
        }
        Queue<Car> startCar = new LinkedList<>();
        // 3면을 갈 수 없는 시작점을 찾기
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                if(map[r][c] == '#'){
                    int blockCnt = 0;
                    findStart : for(int i=0; i<4; i++){
                        int nr = r + dr[i];
                        int nc = c + dc[i];
                        if(nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] == '.') blockCnt++;
                        if(blockCnt == 3){
                            for(int j=0; j<4; j++){
                                nr = r + dr[j];
                                nc = c + dc[j];
                                if(nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] == '#'){
                                    startCar.add(new Car(r,c,j));
                                    break findStart;
                                }
                            }

                        }
                    }
                }
            }

        } // end findStart;

        Car car1 = startCar.poll();
        String answer1 = getActions(car1);
        Car car2 = startCar.poll();
        String answer2 = getActions(car2);

        if(answer1.length() <= answer2.length()){
            System.out.println( (car1.row+1) + " " + (car1.col+1));
            System.out.println(direction[car1.status]);
            System.out.println(answer1);

        } else{
            System.out.println((car2.row+1) + " " + (car2.col+1));
            System.out.println(direction[car2.status]);
            System.out.println(answer2);
        }

    }

    static String getActions(Car car){
        StringBuilder sb = new StringBuilder();
        Queue<Car> queue = new LinkedList<>();
        visited = new boolean[R][C];
        queue.add(car);
        visited[car.row][car.col] = true;
        while(!queue.isEmpty()){
            Car nowCar = queue.poll();
            for(int i=0; i<4; i++){
                int nr1 = nowCar.row + dr[(nowCar.status + i)%4];
                int nc1 = nowCar.col + dc[(nowCar.status + i)%4];
                if(nr1 <0 || nr1 >= R || nc1 < 0 || nc1 >= C || map[nr1][nc1] == '.') continue;
                int nr2 = nowCar.row + dr[(nowCar.status + i)%4]*2;
                int nc2 = nowCar.col + dc[(nowCar.status + i)%4]*2;
                if(nr2 <0 || nr2 >= R || nc2 < 0 || nc2 >= C || map[nr2][nc2] == '.' || visited[nr2][nc2]) continue;
                if(i == 0){
                    sb.append('A');
                } else if (i == 1){
                    sb.append('R').append('A');
                } else if (i == 3){
                    sb.append('L').append('A');
                }
                visited[nr2][nc2] = true;
                queue.add(new Car(nr2,nc2,(nowCar.status+i)%4));
            }
        }
        return sb.toString();
    }

    static class Car{
        int row;
        int col;
        int status;

        public Car(int row, int col, int status){
            this.row = row;
            this.col = col;
            this.status = status;
        }
    }
}