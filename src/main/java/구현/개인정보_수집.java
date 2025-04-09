package 구현;

/*
* 문제: 개인정보 수집
* 유형: 구현, 날짜
* 공부:
*   - LocalDate(시간 포함 x), Date(시간 포함 o) 타입
*   - LocalDate -> plusMonths, plusDays
*   - String -> LocalDate로 형 변환 할때, DatetimeFormatter 필요
* */
import java.util.*;
import java.time.*;
import java.time.format.*;

public class 개인정보_수집 {
    public ArrayList<Integer> solution(String today, String[] terms, String[] privacies) {

        // 약관 종류별 유효기간
        HashMap<String, Integer> termsMap = new HashMap<>();
        for (String x: terms){
            String[] term = x.split(" ");
            termsMap.put(term[0],Integer.parseInt(term[1]));
        }

        // 파기일자 계산
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate todayDate = LocalDate.parse(today, formatter);

        ArrayList<Integer> answer = new ArrayList<>();
        for (int i=0; i<privacies.length; i++){
            String[] privacy = privacies[i].split(" ");
            LocalDate startDate = LocalDate.parse(privacy[0],formatter);
            LocalDate endDate = startDate.plusMonths(termsMap.get(privacy[1]));
            if (!endDate.isAfter(todayDate)) answer.add(i+1);
        }

        return answer;
    }

}