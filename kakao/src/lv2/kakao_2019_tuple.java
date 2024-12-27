package lv2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 튜플
public class kakao_2019_tuple {

	public static void main(String[] args) {
		String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
		
//		String[] s1 = s.substring(2, s.length()-2).split("},\\{");
//		
//		int size = s1.length;
//		int[] answer = new int[size];
//		
//		Map<Integer, int[]> map = new HashMap<>();
//		
//		for(int i=0; i<size; i++) {
//			String[] s2 = s1[i].split(",");
//			int size2 = s2.length;
//			int[] arr = new int[size2]; 
//			for(int j=0; j<size2; j++) {
//				arr[j] = Integer.parseInt(s2[j]);
//			}
//			map.put(size2, arr);
//		}
//		
//		List<Integer> list = new ArrayList<>();
//		for(int i=1; i<=size; i++) {
//			int[] arr = map.get(i);
//			for(int j=0; j<arr.length; j++) {
//				if(!list.contains(arr[j])) {
//					list.add(arr[j]);
//				}
//			}
//		}
//		
//		int idx = 0;
//		for (Integer n : list) {
//			answer[idx++] = n;
//		}
		
		Set<String> set = new HashSet<>();
        String[] arr = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");
        Arrays.sort(arr, (a, b)->{return a.length() - b.length();});
        int[] answer = new int[arr.length];
        int idx = 0;
        for(String s1 : arr) {
            for(String s2 : s1.split(",")) {
                if(set.add(s2)) answer[idx++] = Integer.parseInt(s2);
            }
        }
		
		System.out.println(Arrays.toString(answer));
	}

}
