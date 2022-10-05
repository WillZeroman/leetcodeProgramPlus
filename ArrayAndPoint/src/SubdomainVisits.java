import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisits {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String domain : cpdomains) {
            String[] data = domain.split(" ");
            int count = Integer.parseInt(data[0]);
            String domainStr = data[1];
            String web1 = domainStr;
            putIntoMap(map, web1, count);
            if (web1.indexOf(".") != -1) {
                String web2 = web1.substring(web1.indexOf('.') + 1);
                putIntoMap(map, web2, count);
                if (web2.indexOf(".") != -1) {
                    String web3 = web2.substring(web2.indexOf('.') + 1);
                    putIntoMap(map, web3, count);
                }
            }
        }
        List<String> ans = new ArrayList<>(map.size());
        for (String web : map.keySet()) {
            int count = map.get(web);
            ans.add(count + " " + web);
        }
        return ans;
    }

    private void putIntoMap(Map<String, Integer> map, String web, int count) {
        int c = map.getOrDefault(web, 0);
        c += count;
        map.put(web, c);
    }

    public static void main(String[] args) {
        System.out.println(new SubdomainVisits().subdomainVisits(new String[]{"9001 discuss" +
                ".leetcode.com"}));
        System.out.println(new SubdomainVisits().subdomainVisits(new String[]{"900 google.mail" +
                ".com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"}));
    }
}
