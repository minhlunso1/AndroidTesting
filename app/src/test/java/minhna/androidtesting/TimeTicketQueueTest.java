package minhna.androidtesting;

/**
 * Created by Administrator on 12-Aug-17.
 */
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
*   A queue contains a number of people who want to buy tickets. Each buying time takes 1 seconds
*   and in each turn can buy only one ticket. To continue, that person must be enqueued in the last list.
*   The best algorithm BigO(n)
 **/
public class TimeTicketQueueTest {
    int position;
    int[] listTicketQueue;

    @Before
    public void setUp() {
        position = 2;
        listTicketQueue = getTicketQueue();
    }

    @Test
    public void timeBuyingTicket_isCorret() throws Exception {
        int queueSize = listTicketQueue.length;

        int beforeCount = getListCountBefore(position);
        int afterCount = getListCountAfter(position, queueSize);
        int numberOfTicketInTargetPos = listTicketQueue[position];

        int time = beforeCount + afterCount + numberOfTicketInTargetPos;
        System.out.println("Before (s): " + beforeCount);
        System.out.println("After (s): " + afterCount);
        System.out.println("Time (s): " + time);
        assertEquals(11, time);
    }

    private int getListCountAfter(int position, int queueSize) {
        int afterCountList = 0;
        for (int i = position + 1; i < queueSize; i++) {
            if (listTicketQueue[position] - listTicketQueue[i] >= 0)
                afterCountList += listTicketQueue[i];
            else
                afterCountList += listTicketQueue[position];
        }
        return afterCountList;
    }

    private int getListCountBefore(int position) {
        int beforeCountList = 0;
        for (int i = position - 1; i >= 0; i--) {
            if (listTicketQueue[position] - listTicketQueue[i] >= 0)
                beforeCountList += listTicketQueue[i];
            else
                beforeCountList += listTicketQueue[position] - 1;
        }
        return beforeCountList;
    }

    public int[] getTicketQueue() {
        //3 2 3 1 -> 5
        //2 1 2 -> 9
        //[0] 2 1 -> 11
        return new int[]{1, 4, 3, 4, 2};
    }
}
