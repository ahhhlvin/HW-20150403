package nyc.c4q.ahhhlvin;

import java.net.URL;
import java.util.Scanner;

/**
 * Created by alvin2 on 3/30/15.
 * Alvin Kuang
 * C4Q Access Code 2.1
 *
 * Search engines like Google have programs called web-scapers which visit webpages and scrape the information displayed on the webpage. The displayable information is contained in html tags like p, table, h2 etc. When we make a GET request for a webpage, the HTML that is returned can also contain tags like script which often do not correspond to the displayable content on the webpage. Information inside script tags is not used by scapers and they often ignore these tags in the HTML. Write a class called WebPageSanitizer which implements a static method called String sanitize(String html) which removes all script tags and the information that they encapsulate and returns a sanitized version of the HTML string.
 */
public class WebPageSanitizer
{

    public static void main(String[] args)
    {
        String html = webToURL("http://www.google.com");
        System.out.println(StringSanitize(html));

    }


    public static String StringSanitize(String html)
    {

        int firstIndex;
        int secondIndex;

        // stores the amount of times "<script" appears in the HTML string
        int wordCount = HTTP.countWords(html, "<script");


        // for loop runs for as many times as the "<script" appears in the HTML string
        for(int i = 0; i < wordCount; i++)
        {

            firstIndex = html.indexOf("<script");
            secondIndex = html.indexOf("</script>", firstIndex);

            // creates a variable, "removePart", that contains a substring including the beginning and end tags, along with whatever is encapsulated by the 'firstIndex' and 'secondIndex' to allow for easier replacement/removal
            String removePart = html.substring(firstIndex, secondIndex) + 9;
            // replaces all the tags and what is encapsulated by the tags with nothing and saves that back as the original entered string HTML variable that is ultimately returned
            html = html.replace(removePart, "");

        }
        return html;
    }

    public static String webToURL(String webPage)
    {
        URL webUrl = HTTP.stringToURL(webPage);
        String str = HTTP.get(webUrl);

        // converts input of a URL string to an actual URL, gets the HTML code for that URL and then stores it as a variable, "str"
        return str;
    }

}
