package svkreml.sitemon.share.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UrlDto {
    String url;
    String regex;
    List<String> lastRegexMatches;
    List<String> deltaRegexMatches;
    Date lastUpdate;
    Date lastChange;


    public static UrlDto getMock() {
        List<String> lastRegexMatches = new ArrayList<>();
        List<String> deltaRegexMatches = new ArrayList<>();


        return new UrlDto("localhost/123/123",
                "^[a-z]$",
                lastRegexMatches,
                deltaRegexMatches,
                new Date(),
                new Date());
    }


}
