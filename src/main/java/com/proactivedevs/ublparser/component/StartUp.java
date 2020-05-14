package com.proactivedevs.ublparser.component;

import com.proactivedevs.ublparser.service.InvoiceService;
import java.io.FileOutputStream;
import java.io.PrintStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import com.proactivedevs.ublparser.builder.InvoiceBuilder;
import com.proactivedevs.ublparser.facade.common.CAC_Facade;
import com.proactivedevs.ublparser.facade.common.CBC_Facade;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cac.AddressLine;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cac.AddressType;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cac.CountryType;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cac.LocationType;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cac.PartyIdentification;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cac.PartyLegalEntity;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cac.PartyTaxScheme;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cac.PartyType;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cbc.AdditionalAccountID;
import java.util.Date;

@Component
public class StartUp implements ApplicationRunner {

    @Autowired
    private InvoiceService invoiceService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        final String invoice_ublVersionID = "UBL 2.1";
        final String invoice_customizationID = "05";
        final String invoice_profileID = "DIAN 2.1";
        final String invoice_profileExecutionID = "2";
        final String invoice_id = "SETP990000312";
        final String invoice_uuid = "6fb91bf7159fdbf5560f6afa567a55205f8704200ce8330c1c162eaffa4aeb9caabdc4995eb24a3f32de0198b287e214";
        final String invoice_uuid_schemeID = "2";
        final String invoice_uuid_schemeName = "CUFE-SHA384";
        Date now = new Date();
        final Date invoice_issueDate = now;
        final Date invoice_issueTime = now;
        final String invoice_invoiceTypeCode = "01";
        final String[] invoice_notes = {""};
        final String invoice_documentCurrencyCode = "COP";
        final String invoice_lineCountNumeric = "1";
        final String invoice_orderReference_id = "1";
        final Date invoice_orderReference_issueDate = now;

        // ---------------------------------------------------------------------
        // AccountingSupplierParty
        // ---------------------------------------------------------------------
        //
        final AdditionalAccountID[] invoice_accountingSupplierParty_additionalAccountIDs = {
            CBC_Facade.getAdditionalAccountID(
            "195",
            "CO, DIAN (Dirección de Impuestos y Aduanas Nacionales)",
            "1"
            )
        };

        final PartyType invoice_accountingSupplierParty_party = CAC_Facade.getParty(
                new String[]{"GLOBALTEK DEVELOPMENT"},
                CAC_Facade.getPhysicalLocation(
                        CAC_Facade.getRegistrationAddress(
                                "11001",
                                "BOGOTÁ, D.C.",
                                "BOGOTÁ, D.C.",
                                "11",
                                new AddressLine[]{
                                    CAC_Facade.getAddressLine("Cl. 23 b Bis #81 a 44")
                                },
                                CAC_Facade.getCountry(
                                        "COLOMBIA",
                                        "es",
                                        "CO",
                                        "6",
                                        "United Nations Economic Commission for Europe",
                                        "urn:oasis:names:specification:ubl:codelist:gc:CountryIdentificationCode-2.1"
                                )
                        )
                ),
                new PartyTaxScheme[]{
                    CAC_Facade.getPartyTaxScheme(
                            "GLOBALTEK DEVELOPMENT",
                            CBC_Facade.getCompanyID("195", "CO, DIAN (Dirección de Impuestos y Aduanas Nacionales)", "9", "31", "900133732"),
                            CBC_Facade.getTaxLevelCode("05", "O-99"),
                            CAC_Facade.getRegistrationAddress(
                                    "11001",
                                    "BOGOTÁ, D.C.",
                                    "BOGOTÁ, D.C.",
                                    "11",
                                    new AddressLine[]{
                                        CAC_Facade.getAddressLine("Cl. 23 b Bis #81 a 44")
                                    },
                                    CAC_Facade.getCountry(
                                            "COLOMBIA",
                                            "es",
                                            "CO",
                                            "6",
                                            "United Nations Economic Commission for Europe",
                                            "urn:oasis:names:specification:ubl:codelist:gc:CountryIdentificationCode-2.1"
                                    )
                            ),
                            CAC_Facade.getTaxScheme("01", "IVA")
                    )
                },
                new PartyLegalEntity[]{
                    CAC_Facade.getPartyLegalEntity(
                            "GLOBALTEK DEVELOPMENT",
                            CBC_Facade.getCompanyID(
                                    "195",
                                    "CO, DIAN (Dirección de Impuestos y Aduanas Nacionales)",
                                    "9",
                                    "31",
                                    "900133732"
                            ),
                            CAC_Facade.getCorporateRegistrationScheme("SETP", "01673867")
                    )
                },
                CAC_Facade.getConact("KATHERINE", "3213052134", "Katherine.hurtado@gtd.com.co")
        );

        // ---------------------------------------------------------------------
        // ---------------------------------------------------------------------
        // 
        final PartyIdentification[] invoice_taxRepresentativeParty_partyIdentifications = {
            CAC_Facade.getPartyIdentification(
            "195",
            "CO, DIAN (Dirección de Impuestos y Aduanas Nacionales)",
            "9",
            "31",
            "900133732"
            )
        };

        final String invoice_paymentMeans_id = "1";
        final String invoice_paymentMeans_paymentMeansCode = "10";
        final String[] invoice_paymentMeans_paymentIDs = {"1"};

        final String invoice_paymentExchangeRate_sourceCurrencyCode = "COP";
        final String invoice_paymentExchangeRate_sourceCurrencyBaseRate = "1.00";
        final String invoice_paymentExchangeRate_targetCurrencyCode = "COP";
        final String invoice_paymentExchangeRate_targetCurrencyBaseRate = "1.00";
        final String invoice_paymentExchangeRate_calculationRate = "1.00";
        final Date invoice_paymentExchangeRate_date = now;

        final String invoice_legalMonetaryTotal_currency = "COP";
        final String invoice_legalMonetaryTotal_lineExtensionAmount = "60000.00";
        final String invoice_legalMonetaryTotal_taxExclusiveAmount = "0.00";
        final String invoice_legalMonetaryTotal_taxInclusiveAmount = "60000.00";
        final String invoice_legalMonetaryTotal_allowanceTotalAmount = "0.00";
        final String invoice_legalMonetaryTotal_chargeTotalAmount = "0.00";
        final String invoice_legalMonetaryTotal_payableAmount = "60000.00";

        final String invoice_invoiceLine_currency = "COP";
        final String invoice_invoiceLine_id = "1";
        final String invoice_invoiceLine_invoicedQuantity = "20.0000";
        final String invoice_invoiceLine_LineExtensionAmount = "60000.00";
        final boolean invoice_invoiceLine_freeOfChargeIndicator = false;
        final String[] invoice_invoiceLine_item_descriptions = {"PRODUCTO EXCLUIDO"};
        final String invoice_invoiceLine_item_standardItemIdentification_id = "prod-excluido";
        final String invoice_invoiceLine_item_standardItemIdentification_id_schemeID = "999";
        final String invoice_invoiceLine_item_standardItemIdentification_id_schemeName = "Estandar del contribuyente";
        final String invoice_invoiceLine_price_priceAmount = "3000.00";
        final String invoice_invoiceLine_price_baseQuantity = "20.0000";
        final String invoice_invoiceLine_price_baseQuantity_unitCode = "EA";

        // ---------------------------------------------------------------------
        // populate invoice object
        // ---------------------------------------------------------------------
        //
        InvoiceBuilder ib = new InvoiceBuilder();

        ib
                // UBLExtensions
                .setUBLVersionID(invoice_ublVersionID)
                .setCustomizationID(invoice_customizationID)
                .setProfileID(invoice_profileID)
                .setProfileExecutionID(invoice_profileExecutionID)
                .setID(invoice_id)
                .setUUID(invoice_uuid_schemeID, invoice_uuid_schemeName, invoice_uuid)
                .setIssueDate(invoice_issueDate)
                .setIssueTime(invoice_issueTime)
                .setInvoiceTypeCode(invoice_invoiceTypeCode)
                .addNote(invoice_notes[0])
                .setDocumentCurrencyCode(invoice_documentCurrencyCode)
                .setLineCountNumeric(invoice_lineCountNumeric)
                .setOrderReference(
                        invoice_orderReference_id,
                        invoice_orderReference_issueDate
                )
                .setAccountingSupplierParty(
                        invoice_accountingSupplierParty_additionalAccountIDs,
                        invoice_accountingSupplierParty_party
                )
                // AccountingCustomerParty
                .setTaxRepresentativeParty(invoice_taxRepresentativeParty_partyIdentifications)
                .addPaymentMeans(
                        invoice_paymentMeans_id,
                        invoice_paymentMeans_paymentMeansCode,
                        invoice_paymentMeans_paymentIDs
                )
                .setPaymentExchangeRate(
                        invoice_paymentExchangeRate_sourceCurrencyCode,
                        invoice_paymentExchangeRate_sourceCurrencyBaseRate,
                        invoice_paymentExchangeRate_targetCurrencyCode,
                        invoice_paymentExchangeRate_targetCurrencyBaseRate,
                        invoice_paymentExchangeRate_calculationRate,
                        invoice_paymentExchangeRate_date)
                .setLegalMonetaryTotal(
                        invoice_legalMonetaryTotal_currency,
                        invoice_legalMonetaryTotal_lineExtensionAmount,
                        invoice_legalMonetaryTotal_taxExclusiveAmount,
                        invoice_legalMonetaryTotal_taxInclusiveAmount,
                        invoice_legalMonetaryTotal_allowanceTotalAmount,
                        invoice_legalMonetaryTotal_chargeTotalAmount,
                        invoice_legalMonetaryTotal_payableAmount
                )
                .addInvoiceLine(
                        invoice_invoiceLine_currency,
                        invoice_invoiceLine_id,
                        invoice_invoiceLine_invoicedQuantity,
                        invoice_invoiceLine_LineExtensionAmount,
                        invoice_invoiceLine_freeOfChargeIndicator,
                        invoice_invoiceLine_item_descriptions,
                        invoice_invoiceLine_item_standardItemIdentification_id_schemeID,
                        invoice_invoiceLine_item_standardItemIdentification_id_schemeName,
                        invoice_invoiceLine_item_standardItemIdentification_id,
                        invoice_invoiceLine_price_priceAmount,
                        invoice_invoiceLine_price_baseQuantity,
                        invoice_invoiceLine_price_baseQuantity_unitCode
                );

        // ---------------------------------------------------------------------
        // ---------------------------------------------------------------------
        //
        String xml = invoiceService.parseXML(ib.build());

        System.out.println(xml);

        try (PrintStream out = new PrintStream(new FileOutputStream("/home/pedrofernando/Desktop/invoice.xml"))) {
            out.print(xml);
        }

        // ---------------------------------------------------------------------
    }

}
