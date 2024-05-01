import java.util.ArrayList;
import java.util.List;

public class subsetSum {

    public static List<Integer> subsetSumPositiveMultiple(int[] S, int k) {
        int n = S.length;
        boolean[] dp = new boolean[k + 1];
        dp[0] = true;

        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < n; j++) {
                if (S[j] <= i) {
                    dp[i] = dp[i] || dp[i - S[j]];
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        int currentSum = k;
        while (currentSum > 0) {
            for (int j = 0; j < n; j++) {
                if (currentSum >= S[j] && dp[currentSum - S[j]]) {
                    result.add(S[j]);
                    currentSum -= S[j];
                    break;
                }
            }
        }

       return result;
    }

    public static void main(String[] args) {
        int[] S = {5, 1, 3};
        int k = 7;

        List<Integer> solution = subsetSumPositiveMultiple(S, k);

        System.out.println("Subset that sums to " + k + ": " + solution);
    }
}
