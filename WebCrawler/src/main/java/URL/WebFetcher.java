package URL;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.jsoup.Connection;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class WebFetcher {
    private static final int TIME_OUT = 5000;

    public String fetchPage(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();

        client.setConnectTimeout(TIME_OUT, TimeUnit.MILLISECONDS);
        client.setReadTimeout(TIME_OUT, TimeUnit.MILLISECONDS);

        Request request = new Request.Builder()
                .url(url).header("User-Agent", "WebCrawler")
                .build();

        try{
            Response response = client.newCall(request).execute();

            return response.body().string();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
