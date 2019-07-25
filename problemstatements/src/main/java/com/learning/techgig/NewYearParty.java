package com.learning.techgig;

import java.util.ArrayList;
import java.util.List;

public class NewYearParty {
	/*public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int testCaseCount = Integer.parseInt(br.readLine());
			for (int i = 0; i < testCaseCount; i++) {
				int   len = Integer.parseInt(br.readLine());
				int[] a   = Stream.of(br.readLine().split(" ", len)).mapToInt(Integer::parseInt).toArray();

				int maxSum = FindMaxSum(a, a.length);
				System.out.println(maxSum);
			}
		}
	}*/

  public static void main(String[] args) {
    int         testCases = 7;
    List<int[]> list      = new ArrayList<>(testCases);
    list.add(new int[] {-1, 7, 8, -5, 4});
		list.add(new int[] {3, 2, 1, -1});
		list.add(new int[] {11, 12, -2, -1});
		list.add(new int[] {4, 5, 4, 3});
		list.add(new int[] {5, 10, 4, -1});
		list.add(new int[] {6, 7, 1, 3, 8, 2, 4});
		list.add(new int[] {5, 3, 4, 11, 2});
    for (int[] a : list) {
      System.out.println(getPairsCount(a, FindMaxSum(a, a.length)));
    }
  }

  private static int FindMaxSum(int[] arr, int n) {
    int incl = arr[0];
    int excl = 0;
    int excl_new;
    int i;
    for (i = 1; i < n; i++) {
      excl_new = (incl > excl) ? incl : excl;
      incl = excl + arr[i];
      excl = excl_new;
    }
    return ((incl > excl) ? incl : excl);
  }

  private static List<Integer> getPairsCount(int[] arr, int sum) {
    int           int_sum  = 0;
    List<Integer> integers = new ArrayList<>();
    for (int i1 : arr) {
      int_sum += i1;
      if (int_sum == sum) {
        integers.add(i1);
        break;
      } else if (int_sum > sum) {
        int_sum -= i1;
      } else {
        integers.add(i1);
      }
    }
    return integers;
  }
}