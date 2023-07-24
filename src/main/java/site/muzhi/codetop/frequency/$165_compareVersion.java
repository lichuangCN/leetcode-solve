package site.muzhi.codetop.frequency;

/**
 * @author lichuang
 * @date 2023/07/24
 * 165.比较版本号
 */
public class $165_compareVersion {

    // 输入：version1 = "0.1", version2 = "1.1"
    // 输出：-1

    // 输入：version1 = "1.0", version2 = "1.0.0"
    // 输出：0

    public static void main(String[] args) {
        $165_compareVersion demo = new $165_compareVersion();
        demo.compareVersion("0.1", "1.1");
    }

    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int len1 = v1.length, len2 = v2.length, i = 0, j = 0;
        while (i < len1 || j < len2) {
            int v_1 = 0, v_2 = 0;
            if (i < len1) {
                v_1 = Integer.valueOf(v1[i++]);
            }
            if (j < len2) {
                v_2 = Integer.valueOf(v2[j++]);
            }
            if (v_1 > v_2) {
                return 1;
            }
            if (v_1 < v_2) {
                return -1;
            }
        }
        return 0;
    }
}
