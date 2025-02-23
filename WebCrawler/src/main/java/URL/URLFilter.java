package URL;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class URLFilter {
    private Set<String> visitedURLs = ConcurrentHashMap.newKeySet();

    public boolean isNewURL(String url){
        return visitedURLs.add(url);
    }
}
