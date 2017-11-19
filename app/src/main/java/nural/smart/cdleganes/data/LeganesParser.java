package nural.smart.cdleganes.data;

/**
 * Created by alvaro on 4/2/17.
 */

public class LeganesParser extends XMLParser {

    public LeganesParser() {
        super();
        super.url = "https://www.deportivoleganes.com/rss";
        super.origen = "Oficial Leganés";
    }

}
