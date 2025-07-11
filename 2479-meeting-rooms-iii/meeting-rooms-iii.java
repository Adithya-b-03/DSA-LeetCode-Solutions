import java.util.*;

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        // Sort meetings by start time
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        // Count of meetings held by each room
        int[] count = new int[n];

        // Min-heap for available rooms (sorted by room number)
        PriorityQueue<Integer> freeRooms = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            freeRooms.offer(i);
        }

        // Min-heap for busy rooms: (end time, room number)
        PriorityQueue<long[]> busyRooms = new PriorityQueue<>(
            (a, b) -> a[0] == b[0] ? Long.compare(a[1], b[1]) : Long.compare(a[0], b[0])
        );

        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];
            long duration = end - start;

            // Free up rooms whose meetings have ended
            while (!busyRooms.isEmpty() && busyRooms.peek()[0] <= start) {
                long[] roomInfo = busyRooms.poll();
                freeRooms.offer((int) roomInfo[1]);
            }

            if (!freeRooms.isEmpty()) {
                // Use the available room with the smallest index
                int room = freeRooms.poll();
                busyRooms.offer(new long[]{end, room});
                count[room]++;
            } else {
                // Delay the meeting to the earliest available end time
                long[] roomInfo = busyRooms.poll();
                long newEndTime = roomInfo[0] + duration;
                int room = (int) roomInfo[1];
                busyRooms.offer(new long[]{newEndTime, room});
                count[room]++;
            }
        }

        // Find the room with the most meetings (and smallest index in case of tie)
        int maxMeetings = 0, resultRoom = 0;
        for (int i = 0; i < n; i++) {
            if (count[i] > maxMeetings) {
                maxMeetings = count[i];
                resultRoom = i;
            }
        }

        return resultRoom;
    }
}
