import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String[] input = br.readLine().split("-");
      StringBuilder sb = new StringBuilder();
      for(String temp : input){
        sb.append(temp.charAt(0));
      }
      System.out.println(sb);

      
    }
}
