package online.labuladong.algo.doublepointer.array;

/**
 * @author: DongShaowei
 * @create: 2024-10-03 16:20
 * @description:
 */
public class T567Inclusion {

    /**
     * 检查 s1 的排列是否是 s2 的子串
     */
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        // 字符字典
        int[] tarDict = new int[26];
        int[] winDict = new int[26];

        // 初始化两个字符字典
        for (int i = 0; i < s1.length(); i++) {
            tarDict[s1.charAt(i) - 'a']++;
        }

        int l = 0, r = 0;
        while (r < s1.length()) {
            winDict[s2.charAt(r++) - 'a']++;
        }

        if (covering(winDict, tarDict)) return true;

        while (r < s2.length()) {
            if (!covering(winDict, tarDict)) {
                // 固定窗口往右滑动
                winDict[s2.charAt(r++) - 'a']++;
                // 左边收缩
                winDict[s2.charAt(l++) - 'a']--;
            }
            if (covering(winDict, tarDict)) return true;
        }
        return false;
    }

    /**
     * 判断 winDict 是否包含 tarDict
     * @param winDict
     * @param tarDict
     * @return
     */
    private boolean covering(int[] winDict, int[] tarDict) {
        for (int i = 0; i < winDict.length; i++) {
            if (winDict[i] - tarDict[i] < 0) {
                return false;
            }
        }
        return true;
    }
}
