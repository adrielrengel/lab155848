package mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import servlets.Venda;

@MessageDriven(name = "TopicVenda", activationConfig = {
	    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "topic/TopicVenda"),
	    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
	    @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge") })



public class MdbContabilidade implements MessageListener{

	@Override
	public void onMessage(Message rcvMessage) {
		ObjectMessage msg = null;
		try {
            if (rcvMessage instanceof ObjectMessage) {
                msg = (ObjectMessage) rcvMessage;
                Venda venda = (Venda) msg.getObject();

            } else {
 			   //loger nao necessario por hora
 		   }
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
		
	}

}
