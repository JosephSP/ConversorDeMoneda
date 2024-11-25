package menu;
import java.util.Scanner;
import servicioConversor.ConsultaApi;

public class MenuPrincipal {
    Scanner scanner = new Scanner(System.in);
	public void IniciarMenu() {
		ConsultaApi consultor = new ConsultaApi();
		String monto;
		
		String separador = "****************************************************************";
		System.out.println(separador);
		// Se muestra el menu y segun la respuesta se llama a la api con las variables para obtener una respuesta
		System.out.println("Sea bienvenido/a al Conversor de Moneda =]"
				+ "\n\n"
				+ "1) Dólar =>> Peso Argentino\n"
				+ "2) Peso Argentino  =>> Dólar\n"
				+ "3) Dólar =>> Real Brasileño\n"
				+ "4) Real Brasileño =>> Dólar\n"
				+ "5) Dólar =>> Peso Colombiano\n"
				+ "6) Peso Colombiano =>> Dólar\n"
				+ "7) Salir\n"
				+ "Elija una opción válida:");
		
		System.out.println(separador);
		
		String seleccion = scanner.nextLine();
		
		switch (seleccion) {
		case "1": {
			System.out.println("Ingrese el valor que deseas convertir");
			monto = scanner.nextLine();
			consultor.Consulta("USD", "ARS", monto);
			IniciarMenu();
			break;
		}
		case "2": {
			System.out.println("Ingrese el valor que deseas convertir");
			monto = scanner.nextLine();
			consultor.Consulta("ARS", "USD", monto);
			IniciarMenu();
			break;
		}
		case "3": {
			System.out.println("Ingrese el valor que deseas convertir");
			monto = scanner.nextLine();
			consultor.Consulta("USD", "BRL", monto);
			IniciarMenu();
			break;
		}
		case "4": {
			System.out.println("Ingrese el valor que deseas convertir");
			monto = scanner.nextLine();
			consultor.Consulta("BRL", "USD", monto);
			IniciarMenu();
			break;
		}
		case "5": {
			System.out.println("Ingrese el valor que deseas convertir");
			monto = scanner.nextLine();
			consultor.Consulta("USD", "COP", monto);
			IniciarMenu();
			break;
		}
		case "6": {
			System.out.println("Ingrese el valor que deseas convertir");
			monto = scanner.nextLine();
			consultor.Consulta("COP", "USD", monto);
			IniciarMenu();
			break;
		}
		case "7": {
			System.out.println("Muchas gracias por usar esta aplicacion, que tengas buen dia :D");
			break;
		}
		default:
			System.out.println("Opcion invalida, intentelo denuevo");
			IniciarMenu();
			break;
		}
		
	}
}
