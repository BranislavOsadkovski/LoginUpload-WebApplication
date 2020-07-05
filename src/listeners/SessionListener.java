package listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
@WebListener
public class SessionListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		//Notification marker
		System.out.println("Session Created:: ID="+se.getSession().getId());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		//Notification marker
		System.out.println("Session Destroyed:: ID="+se.getSession().getId());
	}
 
}
