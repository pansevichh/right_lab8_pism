import java.net.SocketPermission;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        ArrayList someStrings = new ArrayList();
        String menu = "1. Add element\n" +
                "2. Delete element from the end\n" +
                "3. Search for the repeating elements\n" +
                "4. Reverse all strings\n" +
                "5. Search for the substring\n" +
                "6. Display collection\n" +
                "8. Exit" ;

        int flag = 0;

        someStrings.add("Hello");
        someStrings.add("It's Dasha");
        someStrings.add("Pansevich Dasha you know");

        while(flag==0) {
            System.out.println(menu);
            Scanner in1 = new Scanner(System.in);
            System.out.print("Write a number: ");
            int choice = in1.nextInt();

            switch (choice) {
                case (1):
                    System.out.println("Write your string: \n");
                    Scanner in2 = new Scanner(System.in);
                    String addedString = in2.nextLine();
                    someStrings.add(addedString);
                    break;
                case (2):
                    String deletedString = (someStrings.get(someStrings.size() - 1)).toString();
                    someStrings.remove(someStrings.get(someStrings.size()-1));
                    System.out.println("You've deleted: " + " ' " + deletedString + " ' ");
                    break;
                case (3):
                    Map<String, Integer> words = new HashMap<String, Integer>();
                    for (int i = 0; i < someStrings.size(); i++) {
                        String tempString = someStrings.get(i).toString();

                        if (!words.containsKey(tempString)) {
                            words.put(tempString, 1);
                        } else {
                            words.put(tempString, words.get(tempString) + 1);
                        }
                    }
                    for (Map.Entry<String, Integer> entry : words.entrySet()) {
                        if(entry.getValue()>1) {
                            System.out.println("String = " + entry.getKey() + ", Times = " + entry.getValue());
                        }
                    }
                    break;
                case (4):
                    int counter;
                    for (counter = 0; counter < someStrings.size(); counter++) {
                        String reverse = new StringBuffer(someStrings.get(counter).toString()).reverse().toString();
                        System.out.println(reverse);
                    }
                    break;
                case (5):
                    System.out.println("Enter the substring: \n");
                    Scanner in3 = new Scanner(System.in);
                    String subStr = in3.nextLine();
                    int existingSubstrings = 0;
                    for(int i = 0; i<someStrings.size()-1; i++){
                        if(someStrings.get(i).toString().lastIndexOf(subStr) != -1){
                            existingSubstrings++;
                            System.out.println("Your substring contains in: " + someStrings.get(i).toString());
                        }
                    }
                    if(existingSubstrings==0){
                        System.out.println("Your substring doesn't contain in any string. :( \n");
                    }
                    break;
                case (6):
                    for(int i = 0; i<someStrings.size()-1; i++){
                        System.out.println("["+ i + "]" + someStrings.get(i));
                    }
                    break;
                case (8):
                    flag = 1;
                    break;
                default:
                    System.out.println("Something is wrong with your choice!");
            }
        }
    }
}