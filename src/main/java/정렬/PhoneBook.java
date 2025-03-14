package 정렬;
/*
문제: 전화번호 접두사 인증
유형: 문자열 정렬
    - 숫자를 정렬할때는 아스키 번호 기준
    - 0001 -> 001 -> 01
*/

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

