import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = countUniqueMaxNumbers(arr, n);
        System.out.println(result);
    }

    public static int countUniqueMaxNumbers(int[] arr, int n) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            maxHeap.offer(arr[i]);
            frequencyMap.put(arr[i], frequencyMap.getOrDefault(arr[i], 0) + 1);
        }

        int uniqueCount = 0;

        while (!maxHeap.isEmpty()) {
            int maxNum = maxHeap.poll();

            if (frequencyMap.containsKey(maxNum) && frequencyMap.get(maxNum) == 1) {
                uniqueCount++;
            }

            frequencyMap.remove(maxNum);

            int halfNum = maxNum / 2;

            if (halfNum > 0) {
                maxHeap.offer(halfNum);
                frequencyMap.put(halfNum, frequencyMap.getOrDefault(halfNum, 0) + 1);
            }
        }

        return uniqueCount;
    }
}
