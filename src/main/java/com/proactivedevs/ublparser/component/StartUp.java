package com.proactivedevs.ublparser.component;

import com.proactivedevs.ublparser.model.pojo.ubl.common.cac.OrderReference;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cbc.ID;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cbc.IssueDate;
import com.proactivedevs.ublparser.model.pojo.ubl.maindoc.invoice.Invoice;
import com.proactivedevs.ublparser.service.InvoiceService;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.time.Instant;
import java.util.Date;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class StartUp implements ApplicationRunner {

    @Autowired
    private InvoiceService invoiceService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        com.proactivedevs.ublparser.model.pojo.ubl.maindoc.invoice.ObjectFactory objectFactoryInvoice = new com.proactivedevs.ublparser.model.pojo.ubl.maindoc.invoice.ObjectFactory();
        com.proactivedevs.ublparser.model.pojo.ubl.common.cac.ObjectFactory objectFactoryCac = new com.proactivedevs.ublparser.model.pojo.ubl.common.cac.ObjectFactory();
        com.proactivedevs.ublparser.model.pojo.ubl.common.cbc.ObjectFactory objectFactoryCbc = new com.proactivedevs.ublparser.model.pojo.ubl.common.cbc.ObjectFactory();

        Invoice invoice = objectFactoryInvoice.createInvoice();

        IssueDate issueDate = objectFactoryCbc.createIssueDate();
        Instant now = new Date().toInstant();
        String dateTimeString = now.toString();
        XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(dateTimeString);
        issueDate.setValue(date2);

        invoice.setIssueDate(issueDate);

        OrderReference orderReference = objectFactoryCac.createOrderReference();

        ID id = objectFactoryCbc.createID();
        id.setValue("1234");

        orderReference.setID(id);
        orderReference.setIssueDate(issueDate);

        invoice.setOrderReference(orderReference);

        String xml = invoiceService.parseXML(invoice);

        System.out.println(xml);

        try (PrintStream out = new PrintStream(new FileOutputStream("/home/pedrofernando/Desktop/invoice.xml"))) {
            out.print(xml);
        }

    }

}
