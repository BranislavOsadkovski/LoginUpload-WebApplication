package listeners;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
@WebListener
public class ServletRequestListenerClass implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		ServletRequest servletRequest = sre.getServletRequest();
		//Notification marker
		System.out.println("ServletRequest Destroyed RemoteIP= " + servletRequest.getRemoteAddr());
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		ServletRequest servletRequest = sre.getServletRequest();
		//Notification marker
		System.out.println("ServletRequest Initialized RemoteIP= " + servletRequest.getRemoteAddr());
	}

}
