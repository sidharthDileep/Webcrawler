package URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.Set;
import java.util.stream.Collectors;

public class HTMLParser {
    public Set<String> extractLinks(String html){
        Document doc = Jsoup.parse(html);
        return doc.select("a[href]").stream()
                .map(e -> e.attr("abs:href"))
                .collect(Collectors.toSet());
    }
}
