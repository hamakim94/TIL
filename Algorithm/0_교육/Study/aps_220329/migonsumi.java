package aps_220329;

import java.util.ArrayList;

public class migonsumi {
	public static void main(String[] args) {
		ArrayList<Integer> migon = new ArrayList<>();
		migon.add(128);
		migon.add(128);
		
		ArrayList<Integer> sumi = new ArrayList<>();
		sumi.add(128);
		
		System.out.println(migon.get(1) == migon.get(0));
		System.out.println(migon.get(1) == sumi.get(0));
		System.out.println(migon.get(1) == migon.get(1));
		
	}
}
