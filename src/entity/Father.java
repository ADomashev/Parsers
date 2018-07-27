package entity;

public class Father extends FamilyMember{
	
	boolean military;

	public Father() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Father(String name, String surname, int age) {
		super(name, surname, age);
		// TODO Auto-generated constructor stub
	}

	public Father(String name, String surname, int age, boolean military) {
		super(name, surname, age);
		this.military = military;
	}

	

	@Override
	public String toString() {
		return "Father: "+" military=" + military + ", Name= " + super.getName() + ", Surname= " + super.getSurname()
				+ ", Age= " + super.getAge()+" ";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (military ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Father other = (Father) obj;
		if (military != other.military)
			return false;
		return true;
	}

}
