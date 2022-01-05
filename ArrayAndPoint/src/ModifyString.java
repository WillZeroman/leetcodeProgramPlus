public class ModifyString {
    public String modifyString(String s) {
        StringBuilder ans = new StringBuilder();

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '?') {
                if( i == 0) {
                    char next = s.length()==1?'?':s.charAt(1);
                    for(int j=0;j<26;j++){
                        char cur = (char) ('a'+j);
                        if(cur !=next){
                            ans.append(cur);
                            break;
                        }
                    }
                } else if (i == s.length()-1){
                   char prev = ans.charAt(i-1);
                   if(prev == 'a'){
                       ans.append('b');
                   }else {
                       ans.append('a');
                   }
                } else {
                    char prev = ans.charAt(i-1);
                    char next = s.charAt(i+1);
                    for(int j=0;j<26;j++){
                        char cur = (char) ('a'+j);
                        if(cur!=prev && cur !=next){
                            ans.append(cur);
                            break;
                        }
                    }
                }
            }else {
                ans.append(ch);
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ModifyString().modifyString("?zs"));
        System.out.println(new ModifyString().modifyString("??"));
        System.out.println(new ModifyString().modifyString("ubv?w"));
        System.out.println(new ModifyString().modifyString("j?qg??b"));
        System.out.println(new ModifyString().modifyString("??qg??b"));
        System.out.println(new ModifyString().modifyString("?aqg??b"));
    }
}
