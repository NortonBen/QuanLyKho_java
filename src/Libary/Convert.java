
package Libary;


public class Convert {
    public static int ToInt(String text){
        int so = 0;
        so = Integer.parseInt(text);
        return so;
    }
    
    
    public static double ToDouble(String text){
        double so = 0;
        so  = Double.parseDouble(text);
        return so;
    }
    
    public static String toString(int so){
        String str = null;
        str = String.valueOf(so);
        return str;
    }
}
