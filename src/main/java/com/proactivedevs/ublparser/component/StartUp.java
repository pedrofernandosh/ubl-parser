package com.proactivedevs.ublparser.component;

import com.proactivedevs.ublparser.config.JaxbObjectFactoryFacade;
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

        Invoice invoice = JaxbObjectFactoryFacade.getINVOICE().createInvoice();

        // ID
        ID id = JaxbObjectFactoryFacade.getCBC().createID();
        id.setValue("SETP990000312");

        invoice.setID(id);

        // IssueDate
        IssueDate issueDate = JaxbObjectFactoryFacade.getCBC().createIssueDate();
        Instant now = new Date().toInstant();
        String dateTimeString = now.toString();
        XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(dateTimeString);
        issueDate.setValue(date2);

        invoice.setIssueDate(issueDate);

        // AccountingSupplierParty
        // AccountingCustomerParty
        // LegalMonetaryTotal
        // InvoiceLine
        // ---------------------------------------------------------------------
        //
        String xml = invoiceService.parseXML(invoice);

        System.out.println(xml);

        try (PrintStream out = new PrintStream(new FileOutputStream("/home/pedrofernando/Desktop/invoice.xml"))) {
            out.print(xml);
        }

        // ---------------------------------------------------------------------
    }

}
