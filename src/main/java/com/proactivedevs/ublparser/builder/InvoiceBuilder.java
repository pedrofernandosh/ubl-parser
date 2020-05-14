package com.proactivedevs.ublparser.builder;

import com.proactivedevs.ublparser.facade.common.CBC_Facade;
import com.proactivedevs.ublparser.facade.ObjectFactoryFacade;
import com.proactivedevs.ublparser.facade.common.CAC_Facade;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cac.PartyIdentification;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cac.PartyType;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cbc.AdditionalAccountID;
import com.proactivedevs.ublparser.model.pojo.ubl.maindoc.invoice.Invoice;
import java.util.Date;
import javax.xml.datatype.DatatypeConfigurationException;

public class InvoiceBuilder {

    // =========================================================================
    // =========================================================================
    //
    private Invoice invoice;

    // =========================================================================
    // =========================================================================
    //
    public InvoiceBuilder() {
        this.invoice = ObjectFactoryFacade.get_INVOICE().createInvoice();
    }

    // =========================================================================
    // =========================================================================
    //
    public InvoiceBuilder setUBLVersionID(String value) {

        this.invoice.setUBLVersionID(CBC_Facade.getUBLVersionID(value));

        return this;
    }

    // =========================================================================
    // =========================================================================
    //
    public InvoiceBuilder setCustomizationID(String value) {

        this.invoice.setCustomizationID(CBC_Facade.getCustomizationID(value));

        return this;
    }

    // =========================================================================
    // =========================================================================
    //
    public InvoiceBuilder setProfileID(String value) {

        this.invoice.setProfileID(CBC_Facade.getProfileID(value));

        return this;
    }

    // =========================================================================
    // =========================================================================
    //
    public InvoiceBuilder setProfileExecutionID(String value) {

        this.invoice.setProfileExecutionID(CBC_Facade.getProfileExecutionID(value));

        return this;
    }

    // =========================================================================
    // =========================================================================
    //
    public InvoiceBuilder setID(String id) {

        this.invoice.setID(CBC_Facade.getID(id));

        return this;
    }

    // =========================================================================
    // =========================================================================
    //
    public InvoiceBuilder setUUID(String schemeId, String schemeName, String value) {

        this.invoice.setUUID(CBC_Facade.getUUID(schemeId, schemeName, value));

        return this;
    }

    // =========================================================================
    // =========================================================================
    //
    public InvoiceBuilder setIssueDate(Date date) throws DatatypeConfigurationException {

        this.invoice.setIssueDate(CBC_Facade.getIssueDate(date));

        return this;
    }

    // =========================================================================
    // =========================================================================
    //
    public InvoiceBuilder setIssueTime(Date date) throws DatatypeConfigurationException {

        this.invoice.setIssueTime(CBC_Facade.getIssueTime(date));
        return this;
    }

    // =========================================================================
    // =========================================================================
    //
    public InvoiceBuilder setInvoiceTypeCode(String value) {

        this.invoice.setInvoiceTypeCode(CBC_Facade.getInvoiceTypeCode(value));

        return this;
    }

    // =========================================================================
    // =========================================================================
    //
    public InvoiceBuilder addNote(String value) {

        this.invoice.getNotes().add(CBC_Facade.getNote(value));

        return this;
    }

    // =========================================================================
    // =========================================================================
    //
    public InvoiceBuilder setDocumentCurrencyCode(String value) {

        this.invoice.setDocumentCurrencyCode(CBC_Facade.getDocumentCurrencyCode(value));

        return this;
    }

    // =========================================================================
    // =========================================================================
    //
    public InvoiceBuilder setLineCountNumeric(String value) {

        this.invoice.setLineCountNumeric(CBC_Facade.getLineCountNumeric(value));

        return this;
    }

    // =========================================================================
    // =========================================================================
    //
    public InvoiceBuilder setOrderReference(
            String id,
            Date issueDate
    ) throws DatatypeConfigurationException {

        this.invoice.setOrderReference(CAC_Facade.getOrderReference(id, issueDate));

        return this;
    }

    // =========================================================================
    // =========================================================================
    //
    public InvoiceBuilder setAccountingSupplierParty(
            AdditionalAccountID[] additionalAccountIDs,
            PartyType party
    ) {

        this.invoice.setAccountingSupplierParty(CAC_Facade.getAccountingSupplierParty(additionalAccountIDs, party));

        return this;
    }

    // =========================================================================
    // =========================================================================
    //
    public InvoiceBuilder addPaymentMeans(
            String id,
            String paymentMeansCode,
            String[] paymentIDs
    ) {

        this.invoice.getPaymentMeans().add(CAC_Facade.getPaymentMeans(
                id,
                paymentMeansCode,
                paymentIDs
        ));

        return this;
    }

    // =========================================================================
    // =========================================================================
    //
    public InvoiceBuilder setPaymentExchangeRate(
            String sourceCurrencyCode,
            String sourceCurrencyBaseRate,
            String targetCurrencyCode,
            String targetCurrencyBaseRate,
            String calculationRate,
            Date date
    ) throws DatatypeConfigurationException {

        this.invoice.setPaymentExchangeRate(CAC_Facade.getPaymentExchangeRate(
                sourceCurrencyCode,
                sourceCurrencyBaseRate,
                targetCurrencyCode,
                targetCurrencyBaseRate,
                calculationRate,
                date
        ));

        return this;
    }

    // =========================================================================
    // =========================================================================
    //
    public InvoiceBuilder setTaxRepresentativeParty(
            PartyIdentification[] partyIdentifications
    ) {

        this.invoice.setTaxRepresentativeParty(CAC_Facade.getTaxRepresentativeParty(partyIdentifications));

        return this;
    }

    // =========================================================================
    // =========================================================================
    //
    public InvoiceBuilder setLegalMonetaryTotal(
            String currency,
            String lineExtensionAmount,
            String taxInclusiveAmount,
            String taxExclusiveAmount,
            String allowanceTotalAmount,
            String chargeTotalAmount,
            String payableAmount
    ) {

        this.invoice.setLegalMonetaryTotal(CAC_Facade.getMonetaryTotalType(
                currency,
                lineExtensionAmount,
                taxInclusiveAmount,
                taxExclusiveAmount,
                allowanceTotalAmount,
                chargeTotalAmount,
                payableAmount
        ));

        return this;
    }

    // =========================================================================
    // =========================================================================
    //
    public InvoiceBuilder addInvoiceLine(
            String currency,
            String id,
            String invoicedQuantity,
            String lineExtensionAmount,
            boolean freeOfChargeIndicator,
            String[] item_descriptions,
            String item_standardItemIdentification_id_schemeId,
            String item_standardItemIdentification_id_schemeName,
            String item_standardItemIdentification_id,
            String price_priceAmount,
            String price_baseQuantity,
            String price_baseQuantity_unitCode
    ) {

        this.invoice.getInvoiceLines().add(CAC_Facade.getInvoiceLine(
                currency,
                id,
                invoicedQuantity,
                lineExtensionAmount,
                freeOfChargeIndicator,
                item_descriptions,
                item_standardItemIdentification_id_schemeId,
                item_standardItemIdentification_id_schemeName,
                item_standardItemIdentification_id,
                price_priceAmount,
                price_baseQuantity,
                price_baseQuantity_unitCode
        ));

        return this;
    }

    // =========================================================================
    // =========================================================================
    //
    public Invoice build() {
        return this.invoice;
    }

}
