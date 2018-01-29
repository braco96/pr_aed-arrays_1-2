package aed;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.lang.management.ManagementFactory;


/**
 * @author Guillermo Roman
 *
 */

public class Tester2 {

	public static void main(String[] args) {

		
		try {
			String[] ids = ManagementFactory.getRuntimeMXBean().getName()
					.split("@");
			BufferedWriter bw = new BufferedWriter(new FileWriter("pid"));
			bw.write(ids[0]);
			bw.close();
		} catch (Exception e) {
			System.out.println("Avisa al profesor de fallo sacando el PID");
		}
		
		boolean exception = false;
		boolean result;

		{
			Integer [] input = {};
			Integer [] output = {};
			result = true;
			do_check(input,output,result,exception);
		}	
		
		{
			Integer [] input = null;
			Integer [] output = {};
			result = false;
			do_check(input,output,result,exception);
		}	
		
		{
			Integer [] input = {};
			Integer [] output = null;
			result = false;
			do_check(input,output,result,exception);
		}	
		
		{
			Integer [] input = {};
			Integer [] output = {1};
			result = false;
			do_check(input,output,result,exception);
		}	
		
		{
			Integer [] input = {1};
			Integer [] output = {};
			result = false;
			do_check(input,output,result,exception);
		}	
		
		{
			Integer [] input = {1};
			Integer [] output = {1};
			result = true;
			do_check(input,output,result,exception);
		}	

		{
			Integer [] input = {1,2};
			Integer [] output = {2,1};
			result = true;
			do_check(input,output,result,exception);
		}
		
		{
			Integer [] input = {1,2};
			Integer [] output = {1,2};
			result = false;
			do_check(input,output,result,exception);
		}	

		{
			Integer [] input = {1,2,3,4};
			Integer [] output = {3,2,1};
			result = false;
			do_check(input,output,result,exception);
		}	

		{
			Integer [] input = {1,2,3,4,5};
			Integer [] output = {5,4,3,2};
			result = false;
			do_check(input,output,result,exception);
		}	

		{
			Integer [] input = {1,2,3,4,5};
			Integer [] output = {5,4,3,2,1};
			result = true;
			do_check(input,output,result,exception);
		}	

		{
			Integer [] input = {1,2,3,4};
			Integer [] output = {4,3,2,1};
			result = true;
			exception = false;
			do_check(input,output,result,exception);
		}	
		
		{
			Integer [] input = {1,2,3,4};
			Integer [] output = {4,3,2,1};
			result = true;
			do_check(input,output,result,exception);
		}	

		{
			Integer [] input = {null};
			Integer [] output = {null};
			result = true;
			do_check(input,output,result,exception);
		}	

		{
			Integer [] input = {null,null};
			Integer [] output = {null,null};
			result = true;
			do_check(input,output,result,exception);
		}	

		{
			Integer [] input = {null,1};
			Integer [] output = {1,null};
			result = true;
			do_check(input,output,result,exception);
		}	

		{
			Integer [] input = {null,1,null};
			Integer [] output = {1,null};
			result = false;
			do_check(input,output,result,exception);
		}	

		{
			Integer [] input = {1,null};
			Integer [] output = {null,1,null};
			result = false;
			do_check(input,output,result,exception);
		}	

		{
			Integer [] input = {1};
			Integer [] output = {null};
			result = false;
			do_check(input,output,result,exception);
		}	
		
		{
			Integer [] input = {null,2,null};
			Integer [] output = {null,1,null};
			result = false;
			do_check(input,output,result,exception);
		}	

		{
			Integer [] input = {1,null,1};
			Integer [] output = {1,null,1};
			result = true;
			do_check(input,output,result,exception);
		}	
		
		{
			Integer [] input = {999,1000,null};
			Integer [] output = {null,1000,999};
			result = true;
			do_check(input,output,result,exception);
		}	

		{
			Integer [] input = {999,1000};
			Integer [] output = {1000,999};
			result = true;
			do_check(input,output,result,exception);
		}	


		System.out.println("\n Tester2: Test finalizado correctamente.");
	}

	/**
	 * Método que prueba el resultado obtenido al llamar a sonInversos
	 * @param array Array de entrada 1
	 * @param array2 Array de entrada 2
	 * @param expected Resultado esperado
	 * @param exception ¿debe lanzar una excepción?
	 */
	static void do_check(Integer [] array, Integer [] array2, 
						 boolean expected, boolean exception) {

		Arrays2 checker = new Arrays2();

		boolean result;
		try {
			result = checker.sonInversos(array,array2);
			if (result != expected) {
				System.out.println("\n*** Tester1 Error: comprimir devuelve "+ result + " " +
						"\n en lugar de " + expected + " cuando se invoca con (" + 
						printArray(array) + "," + printArray(array2) + ")\n"); 
				throw new Error("Error en test: resultado incorrecto");		    
			}
		} catch (IllegalArgumentException exc) {
			if (!exception) {
				System.out.println("\n*** Tester1 Error: Se esperaba la excepcion: IllegalArgumentException\n"+exc.toString());
				throw new Error("Error en test: resultado incorrecto");
			}
		} catch (Exception exc) {
			System.out.println("\n*** Tester1 Error: devuelve la siguiente excepcion \n");
			exc.printStackTrace();
			throw new Error("Error en test: resultado incorrecto");		
		}
	}

	static String printArray(Integer[] arr) {
		if (arr == null) {
			return "'null'"; 
		}
		StringBuffer result = new StringBuffer();
		result.append("[");
		for (int i=0; i<arr.length; i++) {
			result.append(arr[i]);
			if (i<arr.length-1) {
				result.append(",");
			}
		}
		result.append("]");
		return result.toString();
	}
}
