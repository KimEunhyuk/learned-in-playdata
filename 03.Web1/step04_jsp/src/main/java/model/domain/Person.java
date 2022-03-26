package model.domain;

public class Person {
	private String id;
	private int age;
	public Person() {
		System.out.println("Person의 기본 생성자");
	}
	public Person(String id, int age) {
		this.id = id;
		this.age = age;
		System.out.println("Person의 생성자");
	}
	public String getId() {
		System.out.println("Person의 getId()");
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getAge() {
		System.out.println("Person의 getAge()");
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Person [id=");
		builder.append(id);
		builder.append(", age=");
		builder.append(age);
		builder.append("]");
		return builder.toString();
	}

}
