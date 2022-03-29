package com.crio.shorturl;
import java.util.Random;

import java.util.HashMap;

 
public class XUrlimpl implements XUrl  {

    HashMap<String,String> urlMap = new HashMap<>();  
    HashMap<String,String> reverseUrlMap = new HashMap<>();
    HashMap<String,Integer> count = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String registerNewUrl(String longUrl) {
        if(urlMap.containsKey(longUrl)){
            return urlMap.get(longUrl);
        }else{
            Random rand = new Random();
            int urlLen = 9;
            char [] shortURL = new char[urlLen];
            String randChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";

            for(int i = 0; i < urlLen; i++ )
                shortURL[i] = randChars.charAt(rand.nextInt(randChars.length()));

            StringBuilder sb = new StringBuilder("http://short.url/");
            sb.append(new String(shortURL));
            System.out.println(sb);

            urlMap.put(longUrl,sb.toString());
            reverseUrlMap.put(sb.toString(),longUrl);
            return sb.toString();
        }

    }

    @Override
    public String registerNewUrl(String longUrl, String shortUrl) {
        // TODO Auto-generated method stub
        if(reverseUrlMap.containsKey(shortUrl)){
            return null;
        }else{
            urlMap.put(longUrl,shortUrl);
            reverseUrlMap.put(shortUrl,longUrl);
            return shortUrl;
        }
    }

    @Override
    public String getUrl(String shortUrl) {
        // TODO Auto-generated method stub //It should retrieve the long URL that corresponds to the given shortUrl and return it.
        String ans = "";
        if(reverseUrlMap.containsKey(shortUrl)){
            ans = reverseUrlMap.get(shortUrl);
            if(count.containsKey(ans)){
                int c = count.get(ans);
                c +=1;
                count.put(ans,c);
            }else{
                count.put(ans,1);

            }
            return ans;

        }else{
            return null;
        }
        
        

        
    }

    @Override
    public Integer getHitCount(String longUrl) {
        // TODO Auto-generated method stub
        if(count.containsKey(longUrl)){
            return count.get(longUrl);
        }else{
            return 0;
        }
    }

    @Override
    public String delete(String longUrl) {
        // TODO Auto-generated method stub
        //It should remove the longUrl mapping that is currently tracked.
        reverseUrlMap.remove(urlMap.get(longUrl));
         urlMap.remove(longUrl);
         
         return null;
    }


    }




