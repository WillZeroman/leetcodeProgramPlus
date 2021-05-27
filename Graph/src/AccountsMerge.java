import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<Account> accountList = new ArrayList<>();
        Map<String, List<Account>> emailsMap = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            List<String> tempAccount = accounts.get(i);
            Account account = new Account();
            account.name = tempAccount.get(0);
            account.emails = tempAccount.subList(1, tempAccount.size());
            accountList.add(account);
            for (String tempEmail : account.emails) {
                if (emailsMap.containsKey(tempEmail)) {
                    emailsMap.get(tempEmail).add(account);
                } else {
                    List<Account> list = new ArrayList<>();
                    list.add(account);
                    emailsMap.put(tempEmail, list);
                }
            }
        }

        return null;
    }

    class Account {
        int id;
        String name;
        List<String> emails;
    }
}
