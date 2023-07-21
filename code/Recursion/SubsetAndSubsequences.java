package Recursion;

public class SubsetAndSubsequences {
    public static void skip(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);

        if(ch=='a'){
            skip(p,up.substring(1));
        }
        else{
            skip(p+ch,up.substring(1));
        }
    }
    public static String skipCharacter(String up){
        if(up.isEmpty()){
            return "";
        }
        if(up.startsWith("apple")){
            return skipCharacter(up.substring(5));
        }
        else{
            return up.charAt(0)+skipCharacter(up.substring(1));
        }
    }
    public static void subsets(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        subsets(p+ch,up.substring(1));
        subsets(p,up.substring(1));
    }
    public static void main(String[] args) {
        subsets("","abc");
    }
}
