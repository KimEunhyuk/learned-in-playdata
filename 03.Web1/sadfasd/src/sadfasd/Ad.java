package sadfasd;

import java.util.ArrayList;
import java.util.HashMap;

public class Ad {

	public static void main(String[] args) {
		
		ArrayList<Member> sixjo = new ArrayList<Member>();
//		HashMap<String, Member> sixjo = new HashMap<String, Member>();
//		sixjo.put("Kim1", new Member("Kim Eunhyuk", 21, "M"));
//		sixjo.put("Kim2", new Member("Kim Young-ae", 22, "F"));
//		sixjo.put("Kim3", new Member("Kim Jinjoo", 20, "F"));
		
		sixjo.add(new Member("eun", "Kim Eunhyuk", 21, "M"));
		sixjo.add(new Member("young", "Kim Young-ae", 22, "F"));
		sixjo.add(new Member("jin", "Kim Jinjoo", 20, "F"));

		System.out.println(sixjo);



	}
	
}
