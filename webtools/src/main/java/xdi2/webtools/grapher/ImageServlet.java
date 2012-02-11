package xdi2.webtools.grapher;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ImageServlet
 */
public class ImageServlet extends HttpServlet {

	private static final long serialVersionUID = 123784683432874632L;

	public ImageServlet() {

		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String imageId = request.getParameter("imageId");
		byte[] image = ImageCache.get(imageId);
		
		response.setContentType("image/png");
		response.getOutputStream().write(image);
		response.getOutputStream().flush();
		response.getOutputStream().close();
	}
}
