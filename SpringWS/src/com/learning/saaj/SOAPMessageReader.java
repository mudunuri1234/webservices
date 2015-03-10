package com.learning.saaj;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.soap.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

public class SOAPMessageReader {

    public static void main(String args[]) {
        try {
            SOAPMessageReader reader = new SOAPMessageReader();

            //reader.readSOAPHeader();

            //reader.readSOAPBody();

            //reader.readSOAPFault();

            reader.readSOAPMessageAttachments();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void readSOAPHeader() throws Exception {
        //Getting the soap header from a soap message.
        SOAPMessageCreator creator = new SOAPMessageCreator();
        SOAPMessage saopMessage = creator.createMessageHeader();
        SOAPHeader soapHeader = saopMessage.getSOAPPart().getEnvelope().getHeader();
        Iterator iterator = soapHeader.getChildElements();

        //Getting first header block
        SOAPHeaderElement transactionElement = (SOAPHeaderElement) iterator.next();
        String headerBlockName = transactionElement.getNodeName();
        String value = transactionElement.getValue();
        System.out.println("----- Header Block Name ----" + headerBlockName + "---- value ----" + value);

        //Getting first header block attributes
        boolean mustUnderstand = transactionElement.getMustUnderstand();
        String role = transactionElement.getRole();
        boolean relay = transactionElement.getRelay();
        System.out.println("---------- mustUnderstand--------" + mustUnderstand);
        System.out.println("---------- role --------" + role);
        System.out.println("---------- relay --------" + relay);

        //Getting second header block and its attributes.
        String loggerHeaderBlockName = "";
        String loggerRole = "";
        while (iterator.hasNext()) {
            SOAPHeaderElement loggerElement = (SOAPHeaderElement) iterator.next();
            loggerHeaderBlockName = loggerElement.getNodeName();
            loggerRole = loggerElement.getRole();
        }
        System.out.println("---------- logger role --------" + loggerRole);
        System.out.println("---------- Header Block Name-------" + loggerHeaderBlockName);
    }

    private void readSOAPBody() throws Exception {
        //Getting the soap body from a soap message.
        SOAPMessageCreator creator = new SOAPMessageCreator();
        SOAPMessage saopMessage = creator.createMessageBody();
        SOAPBody soapBody = saopMessage.getSOAPPart().getEnvelope().getBody();

        //Getting the soap body element and its contents
        Iterator iterator = soapBody.getChildElements();
        SOAPBodyElement bodyElement = (SOAPBodyElement) iterator.next();
        System.out.println("---------- Body Element Name-------" + bodyElement.getNodeName());

        String employeeId = null;
        if (soapBody.getElementName().getLocalName().equals("Body")) {
            for (Element result : getElements(bodyElement.getElementsByTagName("employeeId"))) {
                employeeId = getNamedElement(result, "employeeId").getTextContent();
            }
        }
        System.out.println("----- employeeId ------" + employeeId);
    }

    private void readSOAPFault() throws Exception {
        //Getting the soap fault from a soap message.
        SOAPMessageCreator creator = new SOAPMessageCreator();
        SOAPMessage saopMessage = creator.createMessageFaultSOAP12();
        SOAPFault soapFault = saopMessage.getSOAPPart().getEnvelope().getBody().getFault();

        //Getting the fault information from fault message
        String code = soapFault.getFaultCode();
        String reason = soapFault.getFaultReasonText(Locale.US);
        String role = soapFault.getFaultRole();
        Detail detail = soapFault.getDetail();
        String conetnt = detail.getTextContent();

        System.out.println("----- code ------" + code);
        System.out.println("----- reason ------" + reason);
        System.out.println("----- role ------" + role);
        System.out.println("----- conetnt ------" + conetnt);
    }

    private void readSOAPMessageAttachments() throws Exception {
        //Getting the soap message that contain attachments.
        SOAPMessageCreator creator = new SOAPMessageCreator();
        SOAPMessage saopMessage = creator.createMessageWithAttachment();
        Iterator iterator = saopMessage.getAttachments();

        //Iterating over the attachments to get the required attachment data.
        Object content = "";
        while (iterator.hasNext()) {
            AttachmentPart attachment = (AttachmentPart) iterator.next();
            String contentId = attachment.getContentId();
            String contentType = attachment.getContentType();
            if ("text/plain".equalsIgnoreCase(contentType)) {
                content = attachment.getContent();
            }
        }
        System.out.println("----- attachment content is ------" + content);
    }

    private static List<Element> getElements(NodeList nodes) {
        List<Element> result = new ArrayList<Element>(nodes.getLength());
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = (Node) nodes.item(i);
            if (node instanceof Element) {
                result.add((Element) node);
            }
        }
        return result;
    }

    private static Element getNamedElement(Element element, String name) {
        if (!element.getNodeName().equals(name))
            throw new IllegalArgumentException("Expected " + name + ",but got " + element.getNodeName());
        return element;
    }

}
