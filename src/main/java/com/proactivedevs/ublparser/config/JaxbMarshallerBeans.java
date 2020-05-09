package com.proactivedevs.ublparser.config;

import com.proactivedevs.ublparser.model.pojo.ubl.maindoc.invoice.Invoice;
import com.sun.xml.bind.marshaller.NamespacePrefixMapper;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JaxbMarshallerBeans {

    // =========================================================================
    // =========================================================================
    //
    @Autowired
    @Qualifier("invoiceNamespacePrefixMapper")
    private NamespacePrefixMapper invoiceNamespacePrefixMapper;

    @Bean(name = "invoiceMarshaller")
    public Marshaller invoiceMarshaller() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Invoice.class);

        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "urn:oasis:names:specification:ubl:schema:xsd:Invoice-2 http://docs.oasis-open.org/ubl/os-UBL-2.1/xsd/maindoc/UBL-Invoice-2.1.xsd");
        marshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", invoiceNamespacePrefixMapper);

        return marshaller;
    }

    // =========================================================================
    // =========================================================================
    //
    @Autowired
    @Qualifier("creditNoteNamespacePrefixMapper")
    private NamespacePrefixMapper creditNoteNamespacePrefixMapper;

    @Bean(name = "creditNoteMarshaller")
    public Marshaller creditNoteMarshaller() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Invoice.class);

        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "urn:oasis:names:specification:ubl:schema:xsd:CreditNote-2 http://docs.oasis-open.org/ubl/os-UBL-2.1/xsd/maindoc/UBL-CreditNote-2.1.xsd");
        marshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", creditNoteNamespacePrefixMapper);

        return marshaller;
    }

}
