package 정렬;
 import java.util.Arrays;

 class PhoneBook {

     public boolean solution(String[] phone_book) {
         Arrays.sort(phone_book);
         String prev = phone_book[0];
         for(int i=1; i < phone_book.length;i++){
             if (phone_book[i].startsWith(prev)) return false;
             prev = phone_book[i];
         }
         return true;
     }
 }