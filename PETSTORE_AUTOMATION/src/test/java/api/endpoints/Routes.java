package api.endpoints;


/*swagger uri=https://petstore.swagger.io
 * create user(post)--->https://petstore.swagger.io/v2/user
 * Get user(get)--->https://petstore.swagger.io/v2/user/{username}
 * Update User(put)--->https://petstore.swagger.io/v2/user/{username}
 *Delete User(delete)---->https://petstore.swagger.io/v2/user/{username} 
 */

public class Routes {
	
	public static String base_url="https://petstore.swagger.io/v2";
	
	//User Module EndPoints
	public static String post_url_user=base_url+"/user";
	public static String get_url_user=base_url+"/user/{username}";
	public static String put_url_user=base_url+"/user/{username}";
	public static String delete_url_user=base_url+"/user/{username}";
	

	//store module endpoints
	//
	//
	
	
	//pet module endpoints
	
	
}
