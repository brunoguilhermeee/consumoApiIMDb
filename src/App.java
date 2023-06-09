import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {

    public static void main(String[] args) throws Exception {

        // fazer uma conexão HTTP e buscar os top 250 filmes
        // String url = "https://imdb-api.com/en/API/Top250Movies/k_0ojt0yvm";
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        var parser = new JsonParser();
        List<Map<String, String>> ListaDeFilmes = parser.parse(body);
        

        for (Map<String,String> filme : ListaDeFilmes) {

            String urlImage = filme.get("image");
            String titulo = filme.get("title");
            InputStream InputStream = new URL(urlImage).openStream();
            String nomeArquivo = titulo + ".png";

            var geradora = new GeradoraDeFigurinhas();

            geradora.cria(InputStream, nomeArquivo);

            System.out.println(filme.get("title"));
            System.out.println();

    

        }


    }
}
