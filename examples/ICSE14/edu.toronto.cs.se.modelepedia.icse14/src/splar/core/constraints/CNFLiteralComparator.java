package splar.core.constraints;

import java.util.Comparator;

public class CNFLiteralComparator implements Comparator {
	public int compare(Object obj1, Object obj2) {
		CNFLiteral bobj1 = (CNFLiteral)obj1;
		CNFLiteral bobj2 = (CNFLiteral)obj2;
		return bobj1.getVariable().getID().compareTo(bobj2.getVariable().getID());
	}
}


