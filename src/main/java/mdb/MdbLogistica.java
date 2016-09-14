package mdb;

import java.util.logging.Logger;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

public class MdbLogistica implements MessageListener {

	private final static Logger LOGGER = Logger.getLogger(MdbLogistica.class.toString());

	@Override
	public void onMessage(Message rcvMessage) {
		ObjectMessage msg = null;
//aqui vai começar as loucuras, ele vai recebera  mensagem, avisar que recebeu e depois de dormir ele despacha
		try {
			if (rcvMessage instanceof ObjectMessage) {
				msg = (ObjectMessage) rcvMessage;

				LOGGER.info("Mensagem: " + msg);
				
				Thread.sleep(30000);

				LOGGER.info("Entrega foi despachada");
			} else {
				LOGGER.warning("Desculpe, nao deu, erro : " + rcvMessage.getClass().getName());
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
