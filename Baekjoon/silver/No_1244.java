package Baekjoon.silver;
import java.io.*;
import java.util.*;

// 스위치 켜고 끄기 - 실버 4
public class No_1244 {
	static int light_num, student_num;
	static int[] list;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		light_num = Integer.parseInt(br.readLine());
		list = new int[light_num + 1];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= light_num; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}

		student_num = Integer.parseInt(br.readLine());
		for (int s = 0; s < student_num; s++) {
			st = new StringTokenizer(br.readLine(), " ");
			int gender = Integer.parseInt(st.nextToken());
			int pos = Integer.parseInt(st.nextToken());

			switch (gender) {
			case 1:
				boy(pos);
				break;

			case 2:
				girl(pos);
				break;
			}
		}

		for (int i = 1; i <= light_num; i++) {
			System.out.print(list[i] + " ");
			if (i % 20 == 0)
				System.out.println();
		}
	}

	static void boy(int pos) {
		for (int i = pos; i <= light_num; i += pos) {
			if (list[i] == 1)
				list[i] = 0;
			else
				list[i] = 1;
		}
	}

	static void girl(int pos) {
		int left_idx = pos, right_idx = pos;
		
		if(list[pos] == 1) list[pos] = 0;
		else list[pos] = 1;
		
		while (true) {
			if(left_idx == 1 || right_idx == light_num) break;
			if (list[left_idx - 1] == list[right_idx + 1]) {
				if (list[left_idx - 1] == 1) {
					list[left_idx - 1] = 0;
					list[right_idx + 1] = 0;
				} else {
					list[left_idx - 1] = 1;
					list[right_idx + 1] = 1;
				}
				left_idx--;
				right_idx++;
			} else {
				break;
			}
		}
	}
}
