import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class MessageServer {

	public static final int PORT = 8080;

	public static void main(String[] args) throws Exception {
		Server server = new Server(PORT);

		ServletHandler handler = new ServletHandler();
		handler.addServletWithMapping(new ServletHolder(new MessageServlet()), "/pie");
		handler.addServletWithMapping(new ServletHolder(new MessageServlet()), "/cake");
		handler.addServletWithMapping(new ServletHolder(new BulmaMessageServlet()), "/bulma");

		server.setHandler(handler);
		server.start();
		server.join();
	}
}
