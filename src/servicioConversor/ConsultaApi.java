package servicioConversor;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.*;



public class ConsultaApi {
	String ApiKey = "3c61bf64cac50d0df48db008";
	public void Consulta(String monedaInicial, String monedaFinal, String monto) {
		// primero verificamos si el monto es un numero valido usando una clase que compara usando regex
		if (!esNumero(monto)) {
			System.out.println("Valor ingresado no es numero");
			return;
		}
		
		// si el monto es valido hacemos el llamado a la api
		try {
            // creamos el HttpClient
            HttpClient client = HttpClient.newHttpClient();

            // armamos la consulta con los valores ingresados:
            HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://v6.exchangerate-api.com/v6/" + ApiKey + "/pair/"
                			+ monedaInicial 
                			+ "/" + monedaFinal 
                			+ "/" + monto))
                .GET()
                .build();

            // Enviamos la consulta y capturamos la respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // manejamos el json de respuesta con regex por temas de simpleza y obtenemos el resultado
            String respuesta = response.body();
            String regex = "\"conversion_result\":([0-9.]+)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(respuesta);
            
            matcher.find();
            String resultadoConversion = matcher.group(1);

            System.out.println("El valor " + monto + " [" + monedaInicial 
            					+ "] corresponde al valor final de =>>> " + resultadoConversion 
            					+ " [" + monedaFinal + "]");
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	public static boolean esNumero(String cadena) {
        // Usamos una expresión regular para validar enteros o decimales
        return cadena.matches("-?\\d+(\\.\\d+)?");
    }
	
}
