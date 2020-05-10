package com.proactivedevs.ublparser.service;

import com.proactivedevs.ublparser.model.pojo.ubl.maindoc.invoice.Invoice;
import java.io.StringWriter;
import javax.xml.bind.JAXBException;
import javax.xml.transform.stream.StreamResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {

    @Autowired
    @Qualifier("invoiceMarshaller")
    private Jaxb2Marshaller invoiceMarshaller;

    public String parseXML(Invoice invoice) throws JAXBException {

        StringWriter sw = new StringWriter();

        invoiceMarshaller.marshal(invoice, new StreamResult(sw));

        String xml = sw.toString();

        // firmar xml               
        // setear firma                
        // volver a realizar marshall        
        //
        return xml;
    }

}
