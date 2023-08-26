package api.endpoints;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payload.UserPayload;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserCrudOperations {

	
	public static Response createUser(UserPayload payload) {
		
		Response res=
		given()
		     .contentType(ContentType.JSON)
		     .accept(ContentType.JSON)
		     .body(payload)
		.when()
		      .post(Routes.post_url_user);
		      
		return res;
		
		
	}
	
	public static Response readUser(String username) {
		
		Response res=
		given()
		      .pathParam("username", username)
		.when()
		      .get(Routes.get_url_user);
		
		return res;
	}
	
	public static Response updateUser(String username,UserPayload payload){
	
		Response res=
		given()
		      .contentType(ContentType.JSON)
		      .accept(ContentType.JSON)
		      .pathParam("username", username)
		      .body(payload)
		 .when()
		       .put(Routes.put_url_user);
		
		return res;
	
		
	}
	
	public static Response deleteUser(String username) {
		
		Response res=
		given()
		      .pathParam("username", username)
		.when()
		      .delete(Routes.delete_url_user);
		
		return res;
		
		
	}
	
	
}
