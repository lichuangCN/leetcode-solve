package site.muzhi.leetcode.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lichuang
 * @date 2023/12/27
 * 811.子域名访问计数
 */
public class $811_subdomainVisits {


    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (String cpdomain : cpdomains) {
            String[] e = cpdomain.split(" ");
            Integer c = Integer.valueOf(e[0]);
            String domain = e[1];
            while (domain.contains(".")) {
                int sum = map.getOrDefault(domain, 0) + c;
                map.put(domain, sum);

                // 层级计算域名
                domain = domain.substring(domain.indexOf(".") + 1);
            }
            // 顶级域名
            int sum = map.getOrDefault(domain, 0) + c;
            map.put(domain, sum);
        }

        // 拼接
        map.forEach((k, v) -> {
            ans.add(v + " " + k);
        });
        return ans;
    }
}
