import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubdomainVisits811 {
    public static void main(String[] args) {
        String[] cpdomains = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        System.out.println(subdomainVisits(cpdomains));
    }

    public static List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> visitsMap = new HashMap<>();
        for (String domains : cpdomains) {
            int i = domains.indexOf(' ');
            int visitCount = Integer.parseInt(domains.substring(0, i));
            String domain = domains.substring(i + 1);
            for (i = 0; i < domain.length(); i++)
                if (domain.charAt(i) == '.') {
                    String subDomain = domain.substring(i + 1);
                    visitsMap.put(subDomain, visitsMap.getOrDefault(subDomain, 0) + visitCount);
                }
            visitsMap.put(domain, visitsMap.getOrDefault(domain, 0) + visitCount);
        }
        List<String> result = new ArrayList<>();
        for (String subDomain : visitsMap.keySet())
            result.add(visitsMap.get(subDomain) + " " + subDomain);
        return result;
    }
}
