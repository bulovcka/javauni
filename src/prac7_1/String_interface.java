package prac7_1;

public interface String_interface {
    static int lenght(String str){
        int res = 0;
        for (char c : str.toCharArray()){
            res += 1;
        }
        return res;
    }
    static String odd(String str){
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < str.length(); i++){
            if (i % 2 == 1 || str.charAt(i) == '\t'){
                res.append(str.charAt(i));
            }
        }
        return res.toString();
    }
    static String reverse(String str){
        StringBuilder res = new StringBuilder();
        for (int i = str.length() - 1; i>=0; i--){
            if (str.charAt(i) == '\t'){
                res.append('\t');
            }else{
                res.append(str.charAt(i));
            }
        }
        return res.toString();
    }
}
