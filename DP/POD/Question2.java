package DP.POD;

import java.util.Arrays;

public class Question2 {
    public static void main(String[] args) {
        String[] schedule = {"08:00", "09:30", "11:00", "13:00", "15:00"};
        String currentTime = "12:15";
     //   String[] schedule = {"00:00", "14:00", "19:55"};
       // String currentTime = "00:00";


        int minutesAgo = minutesSinceLastBusLeft(schedule, currentTime);
        System.out.println("Minutes since the last bus left: " + minutesAgo);
    }
    public static int minutesSinceLastBusLeft(String[] schedule, String time) {
        Arrays.sort(schedule);

        int lastBusIndex = -1;
        for (int i = 0; i < schedule.length; i++) {
            if (schedule[i].compareTo(time) < 0) {
                lastBusIndex = i;
            }
        }

        if (lastBusIndex == -1) {
            return -1;
        }

        // Assuming the schedule and current time are in HH:mm format
        int lastBusHour = Integer.parseInt(schedule[lastBusIndex].substring(0, 2));
        int lastBusMinute = Integer.parseInt(schedule[lastBusIndex].substring(3));

        int currentHour = Integer.parseInt(time.substring(0, 2));
        int currentMinute = Integer.parseInt(time.substring(3));

        int minutesSinceLastBus = (currentHour - lastBusHour) * 60 + (currentMinute - lastBusMinute);

        return minutesSinceLastBus;


    }
}
