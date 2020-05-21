package Basics;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class Youtility {

    public static void main(String[] args) {
        RestAssured.baseURI = "https://restcountries.eu";
        String getPlaceResponse1 = given().log().all().
                when().get("/rest/v2/capital/london").
                then().assertThat().log().all().statusCode(200).extract().response().asString();

        JsonPath js3 = ReUsableMethod.rawToJson(getPlaceResponse1); //json path class takes a String as an argument and converts that into Json so it parses Json.
        String capital = js3.getString("[0].capital");
        System.out.println(capital);
        String expectedCurrency = "British pound";
        String actualCurrency = js3.getString("currencies[0].name[0].");
        System.out.println(actualCurrency);
        Assert.assertEquals(expectedCurrency,actualCurrency);

    }
}