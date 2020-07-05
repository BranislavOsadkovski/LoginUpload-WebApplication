package listeners;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;
@WebListener
public class AppContextAttributeListener implements ServletContextAttributeListener{

	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		String name =(String)event.getName();
		String  strValue= event.getValue().toString();
		//Notification marker
		System.out.println("ServletContext added attribute ={"+name+":"+ strValue+"}");
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		//Notification marker
		System.out.println("ServletContext removed attribute ={"+event.getName()+":"+event.getValue()+"}");
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		//Notification marker
		System.out.println("ServletContext replaced attribute ={"+event.getName()+":"+event.getValue()+"}");
	}

	
	
	
}
