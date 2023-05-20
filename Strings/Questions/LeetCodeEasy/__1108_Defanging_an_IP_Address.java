package Strings.Questions.LeetCodeEasy;
import java.util.*;

//  https://leetcode.com/problems/defanging-an-ip-address/description/

public class __1108_Defanging_an_IP_Address {
    class Solution {
        public String defangIPaddr(String address) {
            StringBuilder str = new StringBuilder();
            for(int i = 0; i < address.length(); i++){
                if(address.charAt(i) == '.'){
                    str.append("[.]");
                }
                else{
                    str.append(address.charAt(i));
                }
            }
            return str.toString();
        }
    }
}
