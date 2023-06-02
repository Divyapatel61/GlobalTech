package fun;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;


public class GameTests
{


	@Test
	public void Get_test() {

		baseURI="http://localhost:3000/";
		//GET-1
		
		
		
		given().
		get("/Game").
	then().
		statusCode(200).
		log().all();

//		//GET-2
//		given().
//		param("id", "1").
//		get("/subjects").then().
//		statusCode(200).
//		log().all();
	}
}
