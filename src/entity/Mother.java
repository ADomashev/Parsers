package entity;

public class Mother extends FamilyMember {
	private String maidenName;

	public Mother(String name, String surname, int age, String maidenName) {
		super(name, surname, age);
		this.maidenName = maidenName;
	}

	public Mother() {
		super();

	}

	public Mother(String name, String surname, int age) {
		super(name, surname, age);
	}

	public String getMaidenName() {
		return maidenName;
	}

	public void setMaidenName(String maidenName) {
		this.maidenName = maidenName;
	}

	@Override
	public String toString() {
		return "Mother: Name = " + super.getName() + ", Surname = " + super.getSurname() + ", maidenName = " + getMaidenName()
				+ ", Age = " + super.getAge() + " ";
	}

}
