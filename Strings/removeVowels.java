class Solution {
  
  public static void main(String[] args) {

    String string = "abfroegnrfgovgngr";
    
    String ans = "";
    
    // StringBuffer sb = new StringBuffer();
    String v = "aeiouAEIOU";
    for(int i = 0; i < string.length(); i++){
        if(v.indexOf(string.charAt(i)) > -1) continue; 
        ans+=(string.charAt(i));
    }
      System.out.println(ans);
    
  }
}
