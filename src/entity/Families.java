package entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Families {
	
	private List<Family> listFamily;

	public Families() {
		listFamily = new ArrayList<>();
	}

	public Families(List<Family> listFamily) {
		super();
		this.listFamily = listFamily;
	}

	public List<Family> getListFamily() {
		return listFamily;
	}

	public void addFamily(Family family) {
		listFamily.add(family);
	}

	@Override
	public String toString() {
		return "Families: "+"\n" + printListFamilies() ;
	}
	
	private String printListFamilies() {
		Iterator<Family> itr = listFamily.iterator();
		String result = "";
		while(itr.hasNext()) {
			result += itr.next().toString();
		}
		return result;
	}

}
