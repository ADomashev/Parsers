package entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Family {
	private int id;
	private Mother mother;
	private Father father;
	private List<Child> listChild;

	public Family() {
		super();
		listChild = new ArrayList<>();
	}

	public Family(Mother mother, Father father, List<Child> listChild) {
		super();
		this.mother = mother;
		this.father = father;
		this.listChild = listChild;
		listChild = new ArrayList<>();
	}
	public void addChild(Child child) {
		listChild.add(child);
	}

	public Mother getMother() {
		return mother;
	}

	public void setMother(Mother mother) {
		this.mother = mother;
	}

	public Father getFather() {
		return father;
	}

	public void setFather(Father father) {
		this.father = father;
	}

	public List<Child> getListChild() {
		return listChild;
	}

	public void setListChild(List<Child> listChild) {
		this.listChild = listChild;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	private String printListChild() {
		Iterator<Child> itr = listChild.iterator();
		String result = "";
		while(itr.hasNext()) {
			result+=itr.next().toString();
		}
		return result;
	}

	@Override
	public String toString() {
		return "Family:"+"id = "+getId()+"\n" + mother +"\n" + father + "\n" + printListChild() + "\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((father == null) ? 0 : father.hashCode());
		result = prime * result + ((listChild == null) ? 0 : listChild.hashCode());
		result = prime * result + ((mother == null) ? 0 : mother.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Family other = (Family) obj;
		if (father == null) {
			if (other.father != null)
				return false;
		} else if (!father.equals(other.father))
			return false;
		if (listChild == null) {
			if (other.listChild != null)
				return false;
		} else if (!listChild.equals(other.listChild))
			return false;
		if (mother == null) {
			if (other.mother != null)
				return false;
		} else if (!mother.equals(other.mother))
			return false;
		return true;
	}

}
