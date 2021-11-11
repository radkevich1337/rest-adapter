package com.example.gazpromtask.service;

import org.eclipse.persistence.internal.oxm.ByteArraySource;
import org.springframework.stereotype.Service;

import javax.xml.soap.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Service
public class SoapClientService {
    private final String URL = "http://www.dneonline.com/calculator.asmx";
    private final String TEMP_URL = "http://tempuri.org/";

    private final SOAPConnectionFactory connectionFactory;
    private final MessageFactory messageFactory;
    private final ByteArraySource messageSource;

    public SoapClientService() throws SOAPException {
        this.connectionFactory = SOAPConnectionFactory.newInstance();
        this.messageFactory = MessageFactory.newInstance();

        this.messageSource = new ByteArraySource(("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>").getBytes(StandardCharsets.UTF_8));
    }

    public int sendMessage(int intA, int intB, String operation) throws SOAPException, InterruptedException {
        Thread.sleep(2000);

        SOAPMessage message = messageFactory.createMessage();

        MimeHeaders headers = message.getMimeHeaders();
        headers.addHeader("SOAPAction", TEMP_URL + operation);

        SOAPPart part = message.getSOAPPart();
        part.setContent(messageSource);

        SOAPEnvelope envelope = part.getEnvelope();
        SOAPBody body = envelope.getBody();
        SOAPElement element = body.addChildElement(operation, "tem");
        element.addChildElement("intA", "tem").addTextNode(String.valueOf(intA));
        element.addChildElement("intB", "tem").addTextNode(String.valueOf(intB));

        SOAPConnection connection = connectionFactory.createConnection();
        SOAPMessage soapMessage = connection.call(message, URL);
        connection.close();

        return Integer.parseInt(soapMessage.getSOAPPart().getEnvelope().getBody().getTextContent());
    }
}
