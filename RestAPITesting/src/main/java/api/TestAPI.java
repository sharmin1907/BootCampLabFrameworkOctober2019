package api;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestAPI {

    public String baseURI = RestAssured.baseURI = "http://info.venturepulse.org:8080/service-webapp/api";
    String employees = "AllEmployeeResources";
    String employeeWithId = "SingleEmployeeResources/";
    String create = "create";
    String update = "update/";
    String delete = "delete/";

    @Test(enabled = true)
    public void getAllEmployees() {
        Response response = given().when().get(employees).then().assertThat().statusCode(200).extract().response();
        System.out.println(response.asString());
        System.out.println(response.getStatusCode());

        JsonPath jsonPath = new JsonPath(response.asString());
        System.out.println(jsonPath.get("empName"));
    }


    @Test(enabled = false)
    public void getOneEmployee() {
        Response response = given().when().get(employeeWithId +"590a4acd35522970c7956cdf").then().assertThat().statusCode(200).extract().response();
        System.out.println(response.asString());
        System.out.println(response.getStatusCode());

        JsonPath jsonPath = new JsonPath(response.asString());
        System.out.println(jsonPath.get("empName"));
    }

    @Test(enabled = false)
    public void testPostData() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("empName", "KanijFatema");
        jsonObject.put("salary", "10000");
        jsonObject.put("department", "Engineering");

        Response response = given().header("Content-Type", "application/json")
                .body(jsonObject.toString()).when().post(create).then().statusCode(200).extract().response();
        System.out.println(response.asString());
    }

    @Test(enabled = false)
    public void testPutCall() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("empName","Matiur Rahman");
        jsonObject.put("salary","450k");
        jsonObject.put("department","Finance");

        Response response = given().contentType(ContentType.JSON).body(jsonObject.toString()).put(update + "590a4acd35522970c7956cdf");
        System.out.println(response.getStatusCode());

    }


    @Test(enabled = false)
    public void testDelete() {
        Response response = given().contentType(ContentType.JSON).delete(delete + "590a4acd35522970c7956cdf");
        System.out.println(response.statusCode());
    }
}
