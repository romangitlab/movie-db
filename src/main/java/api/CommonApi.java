package api;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CommonApi {

    private static Properties properties;
    protected final static String baseApiUrl = getApiProperties().getProperty("baseApiUrl");
    private final static String api_key = getApiProperties().getProperty("api_key");
    private final static String session_id = getApiProperties().getProperty("session_id");

    public static Properties getApiProperties(){

        if (properties == null) {
            properties = new Properties();

            try {
                properties.load(new FileInputStream("src/main/resources/api.properties"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return properties;
    }

    public static RequestSpecification requestSpecification() {
        RequestSpecification requestSpecification = RestAssured.given()
                .queryParam("Content-Type", "application/json;charset=utf-8")
                .queryParam("api_key", api_key)
                .queryParam("session_id", session_id);

        return requestSpecification;
    }

    public static RequestSpecification requestSpecification(String body) {
        RequestSpecification requestSpecification = RestAssured.given()
                .queryParam("api_key", api_key)
                .queryParam("session_id", session_id)
                .contentType("application/json;charset=utf-8")
                .body(body);

        return requestSpecification;
    }

    protected static JsonElement getJsonElement(String json, String jsonElement) {
        JsonElement parsed = new JsonParser().parse(json);

        return parsed.getAsJsonObject().get(jsonElement);
    }

    public static String  favoriteBody(String mediaType, Boolean status, String id) {
        return
                "{" +
                        "\"media_type\":\"" + mediaType + "\"," +
                        "\"media_id\":\"" + id + "\"," +
                        "\"favorite\":" + status + "" +
                        "}";
    }

    public static String bodyTo(String mediaType, Boolean status, String id, String page) {
        return
                "{" +
                        "\"media_type\":\"" + mediaType + "\"," +
                        "\"media_id\":\"" + id + "\"," +
                        "\""+page+"\":" + status + "" +
                        "}";
    }

    public static String rateBody(String rate) {
        return
                "{" +
                        "\"value\":\"" + rate + "\"" +
                        "}";
    }
}
