
public class Person {
	private String name;
	private int age;
	private boolean isdriver;

	public Person(String name, int age, boolean isdriver) {
		super();
		this.name = name;
		this.age = age;
		this.isdriver = isdriver;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isIsdriver() {
		return isdriver;
	}

	public void setIsdriver(boolean isdriver) {
		this.isdriver = isdriver;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", isdriver=" + isdriver + "]";
	}
	

}
