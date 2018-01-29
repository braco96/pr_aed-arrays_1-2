package aed;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.lang.management.ManagementFactory;
import java.util.Arrays;


/**
 * @author Guillermo Roman
 *
 */

public class Tester1 {

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
		boolean exception; 
		{
			Integer [] input = {};
			Integer [] output = {}; 
			exception = false;
			do_check(input,output,exception);
		}	
		
		{
			Integer [] input = null;
			Integer [] output = null; 
			exception = true;
			do_check(input,output,exception);
		}		
		
		{
			Integer [] input = {1};
			Integer [] output = {1}; 
			exception = false;
			do_check(input,output,exception);
		}		
		
		{
			Integer [] input = {1,1,1,1,1};
			Integer [] output = {1}; 
			exception = false;
			do_check(input,output,exception);
		}		

		{
			Integer [] input = {1,1,1,1,2};
			Integer [] output = {1,2}; 
			exception = false;
			do_check(input,output,exception);
		}		

		{
			Integer [] input = {1,2,1,1,1};
			Integer [] output = {1,2,1}; 
			exception = false;
			do_check(input,output,exception);
		}		

		{
			Integer [] input = {1,3,1,3,1};
			Integer [] output = {1,3,1,3,1}; 
			exception = false;
			do_check(input,output,exception);
		}		

		{
			Integer [] input = {new Integer(1000),new Integer(1000)};
			Integer [] output = {new Integer(1000)}; 
			exception = false;
			do_check(input,output,exception);
		}		

		{
			Integer [] input = {1000,999,1000,1000};
			Integer [] output = {1000,999,1000}; 
			exception = false;
			do_check(input,output,exception);
		}		

		{
			Integer [] input = {-128,-200};
			Integer [] output = {-128,-200}; 
			exception = false;
			do_check(input,output,exception);
		}		

		{
			Integer [] input = {2,1,1,1,1,2};
			Integer [] output = {2,1,2}; 
			exception = false;
			do_check(input,output,exception);
		}		

		{
			Integer [] input = {2,new Integer(1),1,1,1,2};
			Integer [] output = {2,1,2}; 
			exception = false;
			do_check(input,output,exception);
		}		

		{
			Integer [] input = {1,2,3,4,5,6};
			Integer [] output = {1,2,3,4,5,6}; 
			exception = false;
			do_check(input,output,exception);
		}		

		{
			Integer [] input = {3,3,3,1,1,1};
			Integer [] output = {3,1}; 
			exception = false;
			do_check(input,output,exception);
		}		

		System.out.println("\n Tester1: Test finalizado correctamente.");
	}

	/**
	 * Método que prueba el resultado obtenido al llamar a compactar
	 * @param array Array de entrada
	 * @param expected Resultado esperado
	 * @param exception ¿debe lanzar una excepción?
	 */
	static void do_check(Integer [] array, Integer [] expected, boolean exception) {

		Arrays1 checker = new Arrays1();

		Integer [] result;
		try {
			result = checker.compactar(array);
			
			if (result == array) {
				System.out.println("\n*** El array devuelto debe ser un nuevo array\n"); 
				throw new Error("Error en test: resultado incorrecto");		    
			}
			
			if (!Arrays.equals(result, expected)) {
				System.out.println("\n*** Tester1 Error: comprimir devuelve "+ printArray(result) + " " +
						"\n en lugar de " + printArray(expected) + " cuando se invoca con " + printArray(array)+ "\n"); 
				throw new Error("Error en test: resultado incorrecto");		    
			}
		} catch (IllegalArgumentException exc) {
			if (!exception) {
				System.out.println("\n*** Tester1 Error: NO se esperaba la excepcion: IllegalArgumentException\n ");
				exc.printStackTrace();
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
