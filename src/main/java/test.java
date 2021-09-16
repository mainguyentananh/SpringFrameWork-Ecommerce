import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class test {
	
	public static void main(String []args) {
//		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//		System.out.println(bCryptPasswordEncoder.encode("user"));
//		String t = "444";
//		if(!t.equalsIgnoreCase("444"))
//		{
//			System.out.println("dung");
//		}
//		System.out.println("sai");
//		Random rand = new Random();
//		  for (int i=0; i<5; i++) {
//	            
//	            int ranNum = rand.nextInt(100)+1;
//	            System.out.println("Random number is " + ranNum);
//	        }
//		  
//		  int page =(int)Math.ceil(9/4)+1; 
//		  
//		  System.out.println(page);
		List<Integer> a =new ArrayList<>();
		
		for (int i = 1; i <= 3; i++) {
			a.add(i);
		}
		
//		for (Integer integer : a) {
//			System.out.println(integer);
//		}
		
		System.out.println(a.size());
		
//			while (i < sachTuongTu.size()) {
//			if(chiTietSach.getId() == sachTuongTu.get(i).getId())
//			{
//				sachTuongTu.remove(i);
//				break;
//			}
//			i++;
//		}

	}
}
