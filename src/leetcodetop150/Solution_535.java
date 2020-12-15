package leetcodetop150;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: xuejing
 * @date: 2020/12/12 16:06
 */
public class Solution_535 {

    Map<String,String> map = new HashMap<>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        // 如何将长的url变成短的 url，我们想到可以变成 hashcode
        String s = Integer.toHexString(longUrl.hashCode());
        map.put(s,longUrl);
        return s;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }

    public static void main(String[] args) {
        System.out.println("sdfsdf".hashCode());
        System.out.println(Integer.toHexString("sdfsdf".hashCode()));
    }
}
