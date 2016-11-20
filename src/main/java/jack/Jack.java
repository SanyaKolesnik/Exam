package jack;

import java.util.*;

/**
 * Created by stale on 20.11.2016.
 */
public class Jack {
    public static void main (String[] args) {
        String text = "25.84553";
        double number = Double.parseDouble(text);
        System.out.println(number);
        String text2 = "гж976ти34.рв32";
        String text3 = "1234567890";
        StringBuilder one= new StringBuilder(text2);
        StringBuilder second= new StringBuilder(text3);
        StringBuilder third= new StringBuilder("");

        for (int i = 0; i < one.length(); i++) {
            for (int j = 0; j < second.length(); j++) {
                if (one.charAt(i) == second.charAt(j)) {
                    third.append(one.charAt(i));
                }
            }
        }
        System.out.println(third);

        int arr[][][]=new int[10][10][10];
        int i,j,k,l=0;
        for (i=0;i<10;i++)
            for(j=0;j<10;j++)
            for(k=0;k<10;k++){
                arr[i][j][k]= l ;
                l++;

            }
        for (i=0;i<10;i++) {
            for (j = 0; j < 10; j++) {
                for (k = 0; k < 10; k++) {
                    System.out.print(arr[i][j][k] + ",");
                }
                System.out.println();
            }
            System.out.println();
        }
        List<String> list=new ArrayList<String>();
        list.add("Маша");
        list.add("Петя");
        list.add("Александр");

        System.out.println(sort(list));






    }
    public static void drink(){
        System.out.println("drink");
    }

    public static class Bar  {



    }
    public static List<String> sort(List<String>list){
        Collections.sort(list, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o1.toString().compareTo(o2.toString());
            }
        });

        return list;
    }


}
