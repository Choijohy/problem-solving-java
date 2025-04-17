package 구현;
import java.util.*;

/*
문제: 주차 요금 계산
카테고리: 구현
공부:
    - Math.ceil()의 return 값은 double이다.
    - Math.ceil()의 파라미터가 int라면 (double)로 타입캐스팅 필요 - 정확하게 계산됨
    - Math.ceil()의 return 결과를 정수로 취급해야 한다면 (int)타입 캐스팅 필요
    - HashMap 관련: HashMap.Entry<> + map.entrySet(), map.computeIfAbsent(key, k-> value 생성), map.values()
*/

class 주차_요금_계산 {
    public void caculateParkingTime(Car car, int outHour, int outMinute){
        String[] inTime = car.inTime.split(":");
        int inHour = Integer.parseInt(inTime[0]);
        int inMinute = Integer.parseInt(inTime[1]);

        int parked = 0; //분 단위

        if (inMinute > outMinute){
            outHour--;
            parked += (60-inMinute) + outMinute;
        } else{
            parked += (outMinute - inMinute);
        }
        parked += (outHour - inHour)*60;

        car.parked += parked;
        car.inTime = "";
    }

    public ArrayList<Integer> solution(int[] fees, String[] records) {
        int defaultTime = fees[0];
        int defaultFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        HashMap<Integer, Car> map = new HashMap<>();

        for (String record:records){
            String[] temp = record.split(" ");
            String time = temp[0];
            int carNumber = Integer.parseInt(temp[1]);
            String type = temp[2];
            Car car = map.computeIfAbsent(carNumber, key-> new Car(carNumber, 0));

            if (type.equals("IN")) car.inTime = time;
            else {
                String[] outTime = time.split(":");
                int outHour = Integer.parseInt(outTime[0]);
                int outMinute = Integer.parseInt(outTime[1]);
                caculateParkingTime(car, outHour, outMinute);
            }

        }

        ArrayList<Car> cars = new ArrayList<>();

        for(Car car:map.values()){
            if (car.inTime != "") caculateParkingTime(car, 23, 59);

            if (car.parked > defaultTime){
                //car.fee = defaultFee + (int)Math.ceil((double)(car.parked - defaultTime)/unitTime)*unitFee;
                car.fee = (car.parked - defaultTime)%unitTime == 0 ? defaultFee + ((car.parked - defaultTime)/unitTime)*unitFee : defaultFee + ((car.parked - defaultTime)/unitTime +1)*unitFee;
            } else car.fee = defaultFee;
            cars.add(car);
        }

        Collections.sort(cars);

        ArrayList<Integer> answer = new ArrayList<>();
        for (Car car:cars) answer.add(car.fee);

        return answer;
    }
}

class Car implements Comparable<Car>{
    int number; // 차량 번호
    int fee;    // 주차 요금
    int parked; // 누적 주차 시간
    String inTime; // 가장 최근 입차 시각

    Car(int number, int fee){
        this.number = number;
        this.fee = fee;
        this.parked = 0;
        this.inTime = "";
    }

    @Override
    public int compareTo(Car o) {
        return this.number - o.number;
    }
}