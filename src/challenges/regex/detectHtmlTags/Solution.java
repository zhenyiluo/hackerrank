package challenges.regex.detectHtmlTags;

/**
 * Created by Zhenyi Luo on 15-3-31.
 */

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
        Set<String> tags = new TreeSet<String>();
        Pattern tag = Pattern.compile("(<\\s*([a-z0-9]+)([^>])*>)");
        Pattern tagA = Pattern.compile("(\\[[^\\[]*\\])(\\([^\\(]*\\))");
        for (int i = 0; i < n; i++) {
            Matcher matcherForTag = tag.matcher(html[i]);
            while (matcherForTag.find()){
                tags.add(matcherForTag.group(2));
            }
            Matcher matcherForTagA = tagA.matcher(html[i]);
            if(matcherForTagA.find()){
                tags.add("a");
            }

        }
        StringBuilder sb = new StringBuilder("");
        for(String s : tags){
            sb.append(s + ";");

        }
        if(sb.charAt(sb.length()-1) == ';'){
            sb.deleteCharAt(sb.length()-1);
        }
        System.out.println(sb.toString());
    }
}
