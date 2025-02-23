package URL;

public class URLTask {
    String url;
    int priority;

    public URLTask(String url, int priority) {
        this.url = url;
        this.priority = priority;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
