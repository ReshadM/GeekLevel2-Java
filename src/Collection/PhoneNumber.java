package Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PhoneNumber {

        public static List<String[]> contacts = new ArrayList<>();

        public static void main(String[] args) {
            add("Голинковский", "+79118880654");
            add("Голинковский", "+79522229977");
            get("Голинковский");
            add("Лихачев", "+79117775566");
            add("Лихачев", "+79214545563");
            get("Лихачев");
            add("Новиков", "+79119991133");
            get("Новиков");
        }

        public static void add(String lastName, String phoneNumber) {
            for (String[] contact : contacts) {
                if (lastName.equals(contact[0])){
                    contacts.toArray();
                    contacts.lastIndexOf(phoneNumber);
                }
            }
            contacts.add(new String[] {lastName, phoneNumber});
        }

        public static void get(String lastName){
            for (String[] contact : contacts) {
                if (lastName.equals(contact[0])){
                    System.out.println(Arrays.toString(contact));
                    if (!(lastName.equals(contact[0]))){
                        System.out.println("Вы ввели фамилию не верно");
                    }
                }
            }
        }
}

