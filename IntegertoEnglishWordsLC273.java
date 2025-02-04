//Time Complexity: O(1), because, there's limit in maximum number which is billion
//Space Complexity: O(1)

class Solution {
    
    String[] below_20 = {
       "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"  
    };
    
    String[] tens = {
        "", "Ten" ,"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };
    
    String[] thousands = {
        "", "Thousand", "Million", "Billion", "Trillion"
    };
    
    
    public String numberToWords(int num) {
        
        if(num == 0) return "Zero";
        
        int i=0;
        String result = "";
        
        while(num>0){
            
            int currNum = num % 1000;
            
            if(currNum != 0){
                
                result = helper(currNum) + thousands[i] + " " + result;
            }
            i++;
            num = num/1000;
        }
        return result.trim();
    }
    
    
    private String helper(int num){
        
        if(num == 0) return "";
        else if(num < 20) return below_20[num] + " ";
        else if(num < 100) return tens[num / 10] + " " + helper(num % 10);
        else return below_20[num / 100] + " Hundred " + helper(num % 100);
        
    }
    
    
    
    
//     public String numberToWords(int num) {
        
//         if(num == 0){
//             return "Zero";
//         }
        
//         String res = "";
//         int i=0;
        
//         while(num>0){
            
//             int h = num % 1000;
            
//             if(h!=0){
            
//                 String curr = toWord(h).trim();

//                 if(i!=0 && h!=0){
//                     res = curr + " "+thousands[i] +" "+res;
//                 }
//                 else{
//                     res = curr + res;
//                 }
//             }
//             i++;
//             num = num/1000;
            
//         }
//         return res.trim();
//     }
    
    
//     public String toWord(int num){
        
//         if(num<=19){
//             return below_20[num];
//         }
        
//         if(num<=99){
//             return tens[num/10] + " " + toWord(num%10);
//         }
//         return toWord(num/100) + " Hundred " + toWord(num%100); 
//     }
}
