package nural.smart.cdleganes.data;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

/**
 * Created by alvaro on 9/6/17.
 */

public class HoraBlanquiazul extends XMLParser {

    public HoraBlanquiazul() {
        super();
        super.url = "http://somoslega.com/rss";
        super.origen = "somoslega";
    }

    protected String readImageURL(XmlPullParser parser) throws IOException, XmlPullParserException {
        String imageURL = "";
        parser.require(XmlPullParser.START_TAG, ns, enclosureParser);
        imageURL = parser.getAttributeValue(null, urlParser);
        parser.nextTag();
        parser.require(XmlPullParser.END_TAG, ns, enclosureParser);
        //Devolvemos NULL en la image, ya que, no tienen imagen
        //de Hora Blazquiazul
        return imageURL;
    }

    // Processes title tags in the feed.
    protected String readDescription(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, ns, descriptionParser);
        String title = readText(parser);
        parser.require(XmlPullParser.END_TAG, ns, descriptionParser);
        return "";
    }
}