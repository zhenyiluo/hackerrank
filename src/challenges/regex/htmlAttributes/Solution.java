package challenges.regex.htmlAttributes;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String[] html = new String[n];
        for(int i = 0; i < n; i++){
            html[i] = in.nextLine();
        }
        solve(n, html);

    }
    public static void solve(int n, String[] html){
        Map<String,Set<String>> map = new TreeMap<String,Set<String>>();
        for (int i = 0; i < n; i++) {
            Pattern tag = Pattern.compile("(<([a-z0-9]+)([^>])*>)");
            Pattern attribute = Pattern.compile(" ([a-z]+)=");
            Matcher matcherForTag = tag.matcher(html[i]);
            while (matcherForTag.find()){
                Set<String> attributes = new TreeSet<String>();
                Matcher matcherForAttributes = attribute.matcher(matcherForTag.group());
                while (matcherForAttributes.find()) {
                    attributes.add(matcherForAttributes.group(1));
                }
                if (!map.containsKey(matcherForTag.group(2))) {
                    map.put(matcherForTag.group(2), attributes);
                } else {
                    attributes.addAll(map.get(matcherForTag.group(2)));
                    map.put(matcherForTag.group(2), attributes);
                }
            }

        }
        StringBuilder sb = new StringBuilder("");
        for(String tag : map.keySet()){
            sb.append(tag + ":");
            Set<String> set = map.get(tag);
            for(String s : set){
                sb.append(s + ",");
            }
            if(sb.charAt(sb.length()-1) == ','){
                sb.deleteCharAt(sb.length()-1);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}