package 스택큐;

import java.util.*;

class DiskController {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, Comparator.comparingInt(job->job[0]));
        PriorityQueue<Task> pq = new PriorityQueue<>();
        int index = 0;
        int time = 0;
        int total = 0;
        Task task = new Task(index, jobs[0][0], jobs[0][1]);


        while (index <= jobs.length -1){
            while (task.requestTime <= time){
                pq.offer(task);
                index ++;
                if (index == jobs.length) break;
                task = new Task(index, jobs[index][0],jobs[index][1]);
            }
            System.out.println(pq.size());
            if (!pq.isEmpty()){
                Task current = pq.poll();
                time += current.duration;
                total += (time - current.requestTime);
            }else {

                time ++;
            }
        }

        while (!pq.isEmpty()){
            Task current = pq.poll();
            time+= current.duration;

            total += (time - current.requestTime);
        }
        return total/jobs.length;
    }
}

class Task implements Comparable<Task>{
    int taskNumber;
    int requestTime;
    int duration;

    Task(int taskNumber, int requestTime, int duration){
        this.taskNumber = taskNumber;
        this.requestTime = requestTime;
        this.duration = duration;
    }
    @Override
    public int compareTo(Task o){
        return Comparator.comparingInt((Task task) -> task.duration)
            .thenComparingInt(task -> task.requestTime)
            .thenComparingInt(task -> task.taskNumber)
            .compare(this,o);
    }

}