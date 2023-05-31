package site.muzhi.leetcode.offerII;

/**
 * @author lichuang
 * @date 2023/05/31
 */
public class $64_MagicDictionary {

    class MagicDictionary {
        String[] dicts;

        public MagicDictionary() {

        }

        public void buildDict(String[] dictionary) {
            dicts = dictionary;
        }

        public boolean search(String searchWord) {
            for (String dict : dicts) {
                if (searchWord.length() != dict.length() || searchWord.equals(dict)) {
                    continue;
                }
                int diff = 0;
                for (int i = 0; i < dict.length(); i++) {
                    diff = dict.charAt(i) == searchWord.charAt(i) ? diff : diff + 1;
                    // 超过2个字符不相同，则不需要继续比较
                    if (diff > 1) {
                        break;
                    }
                }
                if (diff == 1) {
                    return true;
                }
            }
            return false;
        }
    }

}
