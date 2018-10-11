package ar.com.informatorio.calidad.test.services;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ar.com.informatorio.calidad.model.Product;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ProductTest {

	@BeforeMethod
	public void setUp() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 3000;
		RestAssured.basePath = "/api/product";
	}

	@Test
	public void getAll() {
		Response response = RestAssured.given().log().all().get();
		response.prettyPrint();
		
		assertEquals(response.getStatusCode(), 200);
		JsonPath json = response.jsonPath();
		assertFalse(json.getList("products").isEmpty(), "Lista de productos vacia.");
		assertEquals(json.getInt("products[0].id"), 1);
		assertEquals(json.getInt("products[0].cantidad"), 12);
		assertEquals(json.getString("products[0].nombre"), "monitor");
	}
	
	@Test
	public void getByIdUsingPathParam() {
		Response response = RestAssured.given().log().all()
				.pathParam("productId", "1").get("/{productId}");
		response.prettyPrint();
		assertEquals(response.getStatusCode(), 200);
		JsonPath json = response.jsonPath();
		assertEquals(json.getInt("id"), 1);
		assertEquals(json.getInt("cantidad"), 12);
		assertEquals(json.getString("nombre"), "monitor");
	}
	
	@Test
	public void addProduct() {
		Product product = new Product(15, "webcam", 31);
		Response response = RestAssured.given().log().all().contentType(ContentType.JSON).body(product).post();
		response.prettyPeek();
		assertEquals(response.getStatusCode(), 201);
		JsonPath json = response.jsonPath();
		assertEquals(json.getString("message"), "El producto se ha recibido");
	}
	
	@Test
	public void addProductBadRequest() {
		Response response = RestAssured.given().log().all()
				.contentType(ContentType.JSON).post();
		response.prettyPeek();
		assertEquals(response.getStatusCode(), 400);
		JsonPath json = response.jsonPath();
		assertEquals(json.getString("message"), "bad Request");
	}
	
	@Test(dependsOnMethods = { "addProduct" })
	public void getByIdUsingQueryParam() {
		Response response = RestAssured.given().log().all()
				.queryParam("productId", "15").get();
		response.prettyPrint();
		assertEquals(response.getStatusCode(), 200);
		JsonPath json = response.jsonPath();
		assertEquals(json.getInt("id"), 15);
		assertEquals(json.getInt("cantidad"), 31);
		assertEquals(json.getString("nombre"), "webcam");
	}
	
	@Test(dependsOnMethods = { "getByIdUsingQueryParam" })
	public void deleteProduct() {
		Response response = RestAssured.given().log().all()
				.pathParam("productId", "15").delete("/{productId}");
		response.prettyPrint();
		assertEquals(response.getStatusCode(), 200);
		JsonPath json = response.jsonPath();
		assertEquals(json.getString("message"), "El producto ha sido eliminado exitosamente.");

	}
	
}