import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class SimpleWebServer {
    public static void main(String[] args) throws IOException {
        int port = 8080;
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/", new VpcDemoHandler());
        server.setExecutor(null);
        System.out.println("Server is running on port " + port);
        server.start();
    }

    static class VpcDemoHandler implements HttpHandler {
        public void handle(HttpExchange exchange) throws IOException {
            String response = "<!DOCTYPE html>"
                    + "<html>"
                    + "<head>"
                    + "<title>VPC Demo Project</title>"
                    + "<style>"
                    + "body { font-family: Arial, sans-serif; text-align: center; padding: 50px; background-color: #f4f4f4; }"
                    + "h1 { color: #0073e6; font-size: 36px; }"
                    + "h2 { color: #333; font-size: 28px; margin-top: 10px; }"
                    + "p { font-size: 20px; color: #666; }"
                    + "</style>"
                    + "</head>"
                    + "<body>"
                    + "<h1>Welcome to VPC Demo Project</h1>"
                    + "<h2>Welcome to AWS Series</h2>"
                    + "<p>This is a simple VPC project hosted on an EC2 instance.</p>"
                    + "<p>Explore AWS networking concepts with this demo.</p>"
                    + "</body>"
                    + "</html>";

            exchange.getResponseHeaders().set("Content-Type", "text/html");
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}
