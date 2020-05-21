package Basics;

import io.restassured.path.json.JsonPath;

public class ReUsableMethod {
    public static JsonPath rawToJson(String response){
        JsonPath js= new JsonPath(response);
        return js;


    }
}
