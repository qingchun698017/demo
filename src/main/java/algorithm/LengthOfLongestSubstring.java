/*
 * Copyright (c) 2001-2019 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;



/**
 * 给定一个字符串，找出不含有重复符的最长字串的长度
 * abcabcbb->abc->3
 * bbbb->b->1
 * pwwkew->wke->3
 *
 * @author wqc
 * @version V1.0
 * @since 2019-07-17 15:16
 */
public class LengthOfLongestSubstring {

    //暴力遍历
    public int lengthOfLongSubstring1(String s){
        int n = s.length();
        int ans = 0;
        for(int i = 0 ;i<n;i++){
            for(int j=i+1;j<=n;j++){
                if(allUnique(s,i,j)){
                    ans = Math.max(ans,j-i);
                }
            }

        }
        return  ans;
    }

    public boolean allUnique(String s,int start,int end){
        Set<Character> set = new HashSet<>();
        for (int i=start;i<end;i++){
            if(set.contains(s.charAt(i))){
                return false;
            }
            set.add(s.charAt(i));
        }
        return true;
    }

    //滑动窗口
    public int lengthOfLongSubstring2(String s){
        int n = s.length(),i=0,j=0;
        int ans = 0;
        Set<Character> set = new HashSet<>();
        while(i<n && j<n){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans,j-i);
            }else{
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    //优化滑动窗口
    public int lengthOfLongSubstring3(String s){
        int n=s.length(),ans=0;
        Map<Character,Integer> map = new HashMap<>();
        for (int j=0,i=0;j<n;j++){
            if(map.containsKey(s.charAt(j))){
                i = Math.max(map.get(s.charAt(j)),i);
            }

            ans = Math.max(ans,j-i+1);
            map.put(s.charAt(j),j+1);
        }
        return ans;
    }


}
