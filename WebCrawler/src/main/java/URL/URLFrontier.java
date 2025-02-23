package URL;

import redis.clients.jedis.Jedis;

import java.util.Comparator;
import java.util.PriorityQueue;

public class URLFrontier {
    private PriorityQueue<URLTask> queue = new PriorityQueue(Comparator.comparing(URLTask::getPriority));

    public void addURL(String url, int priority){
        queue.add(new URLTask(url, priority));
    }

    public URLTask getNextUrl(){
        return queue.poll();
    }
}
