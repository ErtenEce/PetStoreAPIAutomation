import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PetStoreAPI {

    @Test
    public void CreateUserInfo() {

        String payLoad = "{\n" +
                "  \"id\": 1357,\n" +
                "  \"username\": \"mugendai7\",\n" +
                "  \"firstName\": \"ece\",\n" +
                "  \"lastName\": \"mertem\",\n" +
                "  \"email\": \"nertenece@outlook.com\",\n" +
                "  \"password\": \"123456\",\n" +
                "  \"phone\": \"05632131636\",\n" +
                "  \"userStatus\": 0\n" +
                "}";
        RestAssured.given().body(payLoad).contentType(ContentType.JSON).when().post("https://petstore.swagger.io/v2/user").then().statusCode(200);
    }

    @Test
    public void UpdateUserInfo() {

        String payLoad = "{\n" +
                "  \"id\": 1234568,\n" +
                "  \"username\": \"mugendai8\",\n" +
                "  \"firstName\": \"ece\",\n" +
                "  \"lastName\": \"merten\",\n" +
                "  \"email\": \"lertenece@outlook.com\",\n" +
                "  \"password\": \"123456\",\n" +
                "  \"phone\": \"05632131636\",\n" +
                "  \"userStatus\": 0\n" +
                "}";
        RestAssured.given().body(payLoad).contentType(ContentType.JSON).when().put("https://petstore.swagger.io/v2/user/mugendai").then().statusCode(200);
    }

    @Test
    public void GetUserInfo(){

        RestAssured.get("https://petstore.swagger.io/v2/user/mugendai9");
    }

    @Test
    public void DeleteUserInfo() {

        RestAssured.given().contentType(ContentType.JSON).when().delete("https://petstore.swagger.io/v2/user/mugendai8").then().statusCode(200);
    }
    @Test
    public void LoginUserInfo() {

        String payLoad = "{\n" +
                "  \"username\": \"mugendai3\",\n" +
                "  \"password\": \"123456\"\n" +
                "}";
        RestAssured.given().queryParam(payLoad).contentType(ContentType.JSON).when().get("https://petstore.swagger.io/v2/user/login").then().statusCode(200);
    }

    @Test
    public void LogoutUserInfo() {

        RestAssured.given().contentType(ContentType.JSON).when().get("https://petstore.swagger.io/v2/user/logout").then().statusCode(200);
    }
}
