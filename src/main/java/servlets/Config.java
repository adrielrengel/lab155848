package servlets;

import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSDestinationDefinitions;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@JMSDestinationDefinitions(
		 value = {
			        @JMSDestinationDefinition(
			            name = "java:/queue/QueuePedido",	//caixa de mercado
			            interfaceName = "javax.jms.Queue",
			            destinationName = "QueuePedido"
			        ),
			        @JMSDestinationDefinition(
			            name = "java:/topic/TopicVenda",	//assinatura de revista
			            interfaceName = "javax.jms.Topic",
			            destinationName = "TopicVenda"
			        )
			    })


@WebServlet
public class Config extends HttpServlet {

}
