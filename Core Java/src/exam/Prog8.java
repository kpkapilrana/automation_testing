package exam;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Prog8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap<Integer,String> emp = new HashMap<Integer,String>();
		
		emp.put(101, "Sushil");
		emp.put(102, "Kapil");
		
		
		Set<Integer> s = emp.keySet();
		
		Iterator<Integer> iter = s.iterator();
		
		while(iter.hasNext()) {
			Integer id = iter.next();
			
			String name = emp.get(id);
			
			System.out.println(id);
			System.out.println(name);
		}
	
	}

}
