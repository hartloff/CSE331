package lecture3.intervalscheduling;

import java.util.*;

/**
 * Created by jessehartloff on 6/2/15.
 */
public class EarliestStartTime {

    public static Set<Interval> generateSolution(IntervalSchedulingProblem intervalSchedulingProblem){

        Set<Interval> scheduledTasks = new HashSet<>();
        List<Interval> intervalList = new ArrayList<>();
        intervalList.addAll(intervalSchedulingProblem.getIntervals());


        Collections.sort(intervalList, new StartTimeComparator());


        int currentEndTime = 0;
        for(Interval interval : intervalList){
            if(interval.getStartTime() >= currentEndTime){
                scheduledTasks.add(interval);
                currentEndTime = interval.getEndTime();
            }
        }

        return scheduledTasks;
    }

    private static class StartTimeComparator implements Comparator<Interval>{
        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.getStartTime() - o2.getStartTime();
        }
    }

}
