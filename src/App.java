import java.util.Scanner;

public class App {
    
	private static Scanner input;
	private static double valor1, valor2, resultado;
	private static String operacion;
	
	public static void main(String[] args) {
		input = new Scanner(System.in);
	
		
		System.out.println("Ingrese el primer número");		
		valor1 = capturarDatoDouble();
		input.nextLine(); 
		System.out.println("Ingrese la operación (+,-,/,x,%) o 'salir'");
		operacion = capturarDato();
		
		while(operacion.compareTo("salir") != 0) {
						
			System.out.println("Ingrese el siguiente número");
			valor2 = capturarDatoDouble();
			input.nextLine();
			
			resultado = IdentificoOp();	   
			valor1=resultado;               
			
			System.out.println("="+valor1); 
			System.out.println("Ingrese la operación o 'salir"); 
			
			operacion = capturarDato();
		}
		System.exit(0);	

	}
	
	private static double capturarDatoDouble() { 
	    return input.nextDouble();
	}
	
	private static String capturarDato() {  
	    return input.nextLine();
	}
	
	public static double suma(double a, double b) { 
		return a+b;
	}
	
	public static double resta(double a, double b) { 
		return a-b;
	}
	
	public static double multiplicacion(double a, double b) { 
		return a*b;
	}
	
	public static double modulo(double a, double b) {  
		return a%b;
	}
	
	public static void div(double a, double b) { 
		if(b == 0) { 			
			System.out.println("error");
		}
		else {  
			System.out.println("La división es: ");
			resultado = a/b;
			resultado = redondearDecimales(resultado, 4);
		}
	}
	
	private static double IdentificoOp() {
	    if( operacion.contains("+"))  {  	    	
	    	resultado= suma(valor1,valor2);
	    	resultado = redondearDecimales(resultado, 4); 
	    	
	    }
	    
	    if(operacion.contains("-")) {  
	    	resultado= resta(valor1,valor2); 
	    	resultado = redondearDecimales(resultado, 4);
	    }
	    
	    if(operacion.contains("x")) { 	
	    	resultado = multiplicacion(valor1,valor2); 
	    	resultado = redondearDecimales(resultado, 4); 
	    }
	    
	   
	    if(operacion.contains("%")) {
	    	
	    	resultado = modulo(valor1,valor2);
	    	resultado = redondearDecimales(resultado, 4);
	    }
	    
	    if(operacion.contains("/")) {	    	

	    	div(valor1,valor2);	    
	    }
	    
	    return resultado; 
	}
	
	
	public static double redondearDecimales(double valorInicial, int numeroDecimales) { 
        double parteEntera, resultado;
        resultado = valorInicial;
        parteEntera = Math.floor(resultado);
        resultado=(resultado-parteEntera)*Math.pow(10, numeroDecimales);
        resultado=Math.round(resultado);
        resultado=(resultado/Math.pow(10, numeroDecimales))+parteEntera;
        return resultado;
    }

}
