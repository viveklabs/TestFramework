package Interview;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestClass {

    public static void main(String[] args) {

        /*String s = "Vivek";

        char[] ch = s.toLowerCase().toCharArray();
        int count = 1;
        Map<Character, Integer> newMap = new HashMap<>();

        for (char temp : ch) {
            if (!newMap.containsKey(temp)) {
                newMap.put(temp, count);
            } else {
                newMap.put(temp, newMap.get(temp) + 1);
                count = 1;
            }
        }

        for (char temp1 : newMap.keySet()){
            System.out.println(temp1 + " : "+ newMap.get(temp1));
        }*/


        //-----------

 /*       String s1= "123Welcome2Nagarro123";
        String s2 = s1.replaceAll("[^0-9]"," ");
        String[] s3 = s2.split("\\s");
        int sum=0;
        for (String temp : s3) {
            if (temp.length() > 0){
                int i = Integer.valueOf(temp);
                sum = sum + i;
            }
        }
        System.out.println(sum);*/

        //-------

 /*       String s1 = "nagarro123";
       // String s2 = s1.substring(0,7);
        String s2 = s1.replaceAll("[0-9]","");
       // String s3 = s1.substring(7);
        String s3 = s1.replaceAll("[^0-9]","");
        char[] ch = s2.toCharArray();
        String reverseWord="";
        for (int i = ch.length-1;i>=0;i--){
            reverseWord = reverseWord + String.valueOf(ch[i]);
        }
        System.out.println(reverseWord+s3);*/

        //------------

        RequestSpecification reqSpec = given()
                .baseUri("https://reqres.in/")
                .header("x-api-key", "reqres-free-v1")
                .contentType(ContentType.JSON);

        ResponseSpecification respSpec = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectBody("name",equalTo("morpheus"))
                .build();


        // POST
        String requestBody = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";
        Response response = given()
                .spec(reqSpec)
                .body(requestBody)
                .when()
                .post("/api/users");


        System.out.println(response.statusCode());
        Assert.assertEquals(response.statusCode(),201,"Status Code");
        Assert.assertEquals(response.jsonPath().getString("name"),"morpheus","Name");
        System.out.println(response.jsonPath().getString("name"));
        System.out.println(response.jsonPath().getString("job"));

        System.out.println("------------------------------------------------------");
        System.out.println("------------------------------------------------------");
        System.out.println("------------------------------------------------------");


        // PUT
        String reqBody1 = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"zion resident\"\n" +
                "}";

                response = given()
                .spec(reqSpec)
                .body(reqBody1)
                .log().all()
                .when()
                .put("/api/users/2")
                        .then()
                        .log().ifValidationFails()
                            .spec(respSpec)
                            .statusCode(200)
                            .body("name",equalTo("morpheus"))
                            .extract().response();

        System.out.println(response.statusCode());
        System.out.println(response.jsonPath().getString("name"));
        System.out.println(response.jsonPath().getString("job"));

    }
}
