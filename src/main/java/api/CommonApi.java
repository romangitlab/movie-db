package api;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.specification.RequestSpecification;
import helpers.Helper;

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
        return new JsonParser().parse(json).getAsJsonObject().get(jsonElement);
    }

    protected static JsonElement getJsonArray(String json, String jsonElement) {
        json = "{\"results\":["+ json +"]}";

        return new JsonParser().parse(json).getAsJsonObject().get(jsonElement);
    }

    public static String pageBody(String mediaType, Boolean status, String id, String page) {
        return
                "{" +
                        "\"media_type\":\"" + mediaType + "\"," +
                        "\"media_id\":\"" + id + "\"," +
                        "\""+page+"\":" + status + "" +
                        "}";
    }

    public static String listBody() {
        return
                "{" +
                    "\"name\":\""+ Helper.randomData() +"\"," +
                    "\"description\":\"Random list\"," +
                    "\"language\":\"en\"" +
                "}";


    }

    public static String rateBody(String rate) {
        return
                "{" +
                        "\"value\":\"" + rate + "\"" +
                        "}";
    }

    public static String mediaBody(String rate) {
        return
                "{" +
                    "\"media_id\":\"" + rate + "\"" +
                "}";
    }
}
