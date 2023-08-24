package com.ssafy.hw10.step2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class UserManagerImpl implements IUserManager {

	private ArrayList<User> userList = new ArrayList<>();

	// 싱글턴 만들기
	// 생성자 private => 응 외부에서 못 불러와, 못 불러오니 내부에서 만들어줄게
	private UserManagerImpl() {
		loadData(); // 여기서 부르면 되겠지?
	}

	// 응 new는 여기만 써, 그냥 자체로 new로 만든 객체를 정적으로 만들어, UserManagerImpl 객체는 여기서만 만들거야.
	// 그리고 외부에서 못부름 ^^ , UserManagerImpl 객체를 IUserManager타입으로 받아줄게(왜 인터페이스 타입을 꼭
	// 써야할까?)
	private static IUserManager instance = new UserManagerImpl();

	// 응 이것도 정적이야. 너는 getInstance하면 내가 만들어놓은 정적인 instance객체만 슬 수 있어~
	// 즉, 객체 하나만 만들어서 그것만 관리할래 ^^
	static IUserManager getinstance() {
		return instance;
	}

	@Override
	/**
	 * UserManager안에있는 userList 에 접근에서, User객체를 하나씩 넣어줘
	 * 
	 * @param u : User 클래스 new 해서 객체로 넣어줄래!?
	 */
	public void add(User user) {
		userList.add(user);
	}

	@Override
	/**
	 * 고객 구분없이 다 가져와줘!
	 * 
	 * @return 우리가 만들었던 추억(userList에 배열)을 돌려줘!
	 */
	public ArrayList<User> getList() {
		return userList;
	}

	/**
	 * 유저 자료형만 담고있는 배열!
	 * 
	 * @return ArrayList<User> 인 userList에 User type만 배열로 가져와
	 */
	public ArrayList<User> getUsers() {

		ArrayList<User> only_user = new ArrayList<User>();
		for (int i = 0; i < userList.size(); i++) {
			if (!(userList.get(i) instanceof VipUser)) {
				only_user.add(userList.get(i));
			}
		}
		return only_user;
	}

	/**
	 * VipUser 자료형만 담고있는 배열 반환
	 * 
	 * @return VipUser[]배열에 VipUser type만 배열로 가져와
	 */
	public ArrayList<VipUser> getVipUsers() {

		ArrayList<VipUser> vips = new ArrayList<VipUser>();

		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i) instanceof VipUser) {
				// user[i번째] 는 VipUser라는 자식클래스 객체로부터 만들어짐, 따라서 VipUser로 쓰려면 다시 형변환
				vips.add((VipUser) userList.get(i));
			}
		}
		return vips;
	}

	/**
	 * 글자를 포함하는 이름을 가진 사람들을 배열로 만들어서 반환해줌
	 * 
	 * @param name : 포함되야할 글자
	 * @return 특정 이름을 포함한 userList 어레이리스트
	 */
	public ArrayList<User> searchByName(String name) throws NameNotFoundException {

		ArrayList<User> searchName = new ArrayList<User>();

		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getName().contains(name)) {
				searchName.add(userList.get(i));
			}
		}
		if (searchName.size() > 0) {
			return searchName;
		} else {
			throw new NameNotFoundException(name);
		}
	}

	/**
	 * 모든 User들의 평균 나이를 계산해줌
	 * 
	 * @return 평균 나이(double)
	 */
	public double getAgeAvg() {
		double sum = 0.0;
		for (int i = 0; i < userList.size(); i++) {
			sum += userList.get(i).getAge();
		}
		return sum / userList.size();
	}

	@Override
	public void saveData() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.dat"))) {
			oos.writeObject(userList);
		} catch (FileNotFoundException e) {
			e.getStackTrace();
		} catch (IOException e) {
			e.getStackTrace();
		}

	}

	@Override
	public void loadData() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))) {
			Object readed = ois.readObject();
			if (readed == null) {
				System.out.println("해당 이름의 파일은 없습니다");
			} else {
				userList = (ArrayList<User>) readed;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
