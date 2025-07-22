package lv1;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 가장 많이 받은 선물
public class kakao_2024_present {

	public static void main(String[] args) {
		String[] friends = {"joy", "brad", "alessandro", "conan", "david"};
		String[] gifts = {"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"};
		int answer = 0;
		
		StringTokenizer st;
		
		Map<String, Integer> map = new HashMap<>();
		for(int i=0; i<friends.length; i++) {
			map.put(friends[i], i);
		}
		
		int[][] arr = new int[friends.length][friends.length];
		int[] point = new int[friends.length];
		int[] count = new int[friends.length];
		
		for(int i=0; i<gifts.length; i++) {
			st = new StringTokenizer(gifts[i]);
			String a = st.nextToken();
			String b = st.nextToken();
			
			int aidx = map.get(a);
			int bidx = map.get(b);
			
			arr[aidx][bidx]++;
			point[aidx]++;
			point[bidx]--;
		}
		
		for(int i=0; i<friends.length; i++) {
			for(int j=i+1; j<friends.length; j++) {
				if(arr[i][j] > arr[j][i]) {
					count[i]++;
				}else if(arr[i][j] < arr[j][i]){
					count[j]++;
				}else {
					if(point[i] > point[j]) {
						count[i]++;
					}else if(point[i] < point[j]) {
						count[j]++;
					}
				}
			}
			answer = Math.max(answer, count[i]);
		}
		
		System.out.println(answer);
	}

}
