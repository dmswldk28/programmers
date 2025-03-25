package lv2;

public class kakao_2023_delivery {
	class Solution {
		public long solution(int cap, int n, int[] deliveries, int[] pickups) {
			long answer = 0;

			int dIdx = n - 1;
			int pIdx = n - 1;

			while (dIdx >= 0 || pIdx >= 0) {
				while (dIdx >= 0 && deliveries[dIdx] == 0) {
					dIdx--;
				}
				while (pIdx >= 0 && pickups[pIdx] == 0) {
					pIdx--;
				}

				if (dIdx < 0 && pIdx < 0) {
					break;
				}

				int cnt = Math.max(dIdx, pIdx) + 1;
				answer += cnt * 2;

				int dcnt = cap;
				int pcnt = cap;

				if (dIdx >= 0) {
					while (dcnt > 0 && dIdx >= 0) {
						if (dcnt >= deliveries[dIdx]) {
							dcnt -= deliveries[dIdx];
							deliveries[dIdx] = 0;
							dIdx--;
						} else {
							deliveries[dIdx] -= dcnt;
							dcnt = 0;
						}
					}
				}

				if (pIdx >= 0) {
					while (pcnt > 0 && pIdx >= 0) {
						if (pcnt >= pickups[pIdx]) {
							pcnt -= pickups[pIdx];
							pickups[pIdx] = 0;
							pIdx--;
						} else {
							pickups[pIdx] -= pcnt;
							pcnt = 0;
						}
					}
				}
			}

			return answer;
		}
	}

}
