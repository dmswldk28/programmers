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
//
// 처음 시도했던 것 : map으로 배열 크기, 배열 저장해놓고
//		하나씩 set에 add 한 다음에 출력하려고 하니
//		set에는 index 개념이 없어서 순서가 보장되지 않음
// 애초에 첫 배열을 *배열 크기순으로 정렬*하고 set에 add하면 되는 거였음
// if(set.add(s2)) <-- 이걸로 새로 add 됐는지 확인 가능
		
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
