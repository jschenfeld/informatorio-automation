package ar.com.informatorio.calidad.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgExamples extends BaseTest{

	@BeforeSuite
	public void method() {
		System.out.println("BeforeSuite: primer metodo en ejecutarse en una suite");
	}
	
	@BeforeClass
	public void method1() {
		System.out.println("BeforeClass: primer metodo en ejecutarse en una clase");
	}

	@BeforeTest
	public void method2() {
		System.out.println("BeforeTest: Antes que el test");
	}

	@BeforeMethod
	public void method3() {
		System.out.println("BeforeMethod: antes que cada metodo anotado con @Test");
	}

	@Test
	public void method4() {
		System.out.println("test 1");
	}
	
	@Test
	public void test5() {
		System.out.println("test 2");
		assertEquals(false, true);
	}
	
	@Test
	public void test2() {
		System.out.println("test 3");
	}
	
	@Test
	public void test3() {
		System.out.println("test 4");
	}

	@AfterMethod
	public void method5() {
		System.out.println("AfterMethod este se ejecuta dsp de cada metodo anotado con @test");
	}
	
	@AfterClass
	public void method6() {
		System.out.println("AfterClass este se ejecuta dsp del ultimo metodo de la clase");
	}
	
	@AfterSuite
	public void method7() {
		System.out.println("AfterSuite este se ejecuta al final de toda la suite");
	}
}