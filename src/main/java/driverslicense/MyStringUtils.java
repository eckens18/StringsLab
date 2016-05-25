package driverslicense;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MyStringUtils {

    public static String arrayToString(String [] array){
        String wholeString = "";
        for(int i=0;i<array.length;i++){
            if(i==array.length-1){
                wholeString += array[i];
            }
            else {
                wholeString += array[i] + ",";
            }
        }
        return wholeString;
    }

    public static String [] stringToArrayOfStrings(String string){
        String [] arrayOfStrings = string.split("\n");
        return arrayOfStrings;
    }

    public static String reverseCapitalizeString(String string){
        String [] array = string.toUpperCase().split("\\s");
        String wholeString = "";
        for(int i = 0 ;i<array.length;i++){
            wholeString += array[i].substring(0,1).toLowerCase() + array[i].substring(1) + " ";
        }
        return wholeString.trim();
    }

    public static String reverseSpellingOfString(String string){
        String [] array = string.split("\\s");
        String dummyString = "";
        for(String entry : array) {
            dummyString += new StringBuilder(entry).reverse()+" ";
        }
        return dummyString.trim();
    }

    public static String separateEachWordOnNewLine(String string){
        String [] array = string.split("\\s");
        String dummyString = "";
        for(String entry : array){
            dummyString += entry+"\n";
        }
        return dummyString.trim();
    }

    public static ArrayList<String> getArrayOfAllSubstrings(String string){
        ArrayList<String> arraylist = new ArrayList<>();
        String dummy = "";
        for (int i = 0; i < string.length(); i++) {
            for (int j = 1; j <= string.length()-i; j++) {
                 dummy = string.substring(i,j+i);
                arraylist.add(dummy);
            }
        }
        return arraylist;
    }











}
