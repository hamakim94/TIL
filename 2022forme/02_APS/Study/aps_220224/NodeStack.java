package aps_220224;

public class NodeStack {
	String data; // 현재 노드의 데이터
	NodeStack link; // 리스트의 마지막을 가리킴

	public NodeStack() {

	}

	public NodeStack(String data) {
		super();
		this.data = data;
		// node는 null값으로 생성
	}

}
