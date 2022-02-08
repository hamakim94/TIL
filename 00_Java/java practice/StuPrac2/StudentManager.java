package StuPrac2;

public class StudentManager {
	Student[] arr = new Student[100];
	int cnt = 0;
	
	void addStudent(Student s) {
		arr[cnt++] = s;
	}
	
	int getStudent(String name) {
		int idx = -1;
		for(int i = 0; i< cnt; i++) {
			if (name.equals(arr[i].getName())) {
				idx = i;
			}
		}
		return idx;
	}
	void changeMajor(String name, String major) {
		int idx = getStudent(name);
		if (idx == -1) {
			System.out.println("nothing");
		} else {
			arr[idx].setMajor(major);
	}
		
	}
}
