package com.proactivedevs.ublparser.facade.common;

import com.proactivedevs.ublparser.facade.ObjectFactoryFacade;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cbc.AllowanceTotalAmount;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cbc.BaseQuantity;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cbc.CalculationRate;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cbc.ChargeTotalAmount;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cbc.CustomizationID;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cbc.Description;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cbc.DocumentCurrencyCode;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cbc.FreeOfChargeIndicator;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cbc.ID;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cbc.InvoiceTypeCode;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cbc.InvoicedQuantity;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cbc.IssueDate;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cbc.IssueTime;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cbc.LineCountNumeric;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cbc.LineExtensionAmount;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cbc.Note;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cbc.PayableAmount;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cbc.PaymentID;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cbc.PaymentMeansCode;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cbc.PriceAmount;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cbc.ProfileExecutionID;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cbc.ProfileID;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cbc.SourceCurrencyBaseRate;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cbc.SourceCurrencyCode;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cbc.TargetCurrencyBaseRate;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cbc.TargetCurrencyCode;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cbc.TaxExclusiveAmount;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cbc.TaxInclusiveAmount;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cbc.UBLVersionID;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cbc.UUID;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class CBC_Facade {

    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private static final String TIME_FORMAT = "HH:mm:ssXXX";

    // =========================================================================
    // =========================================================================
    //
    public static LineExtensionAmount getLineExtensionAmount(String currency, String value) {

        LineExtensionAmount lineExtensionAmountElement = ObjectFactoryFacade.get_CBC().createLineExtensionAmount();

        lineExtensionAmountElement.setCurrencyID(currency);
        lineExtensionAmountElement.setValue(new BigDecimal(value));

        return lineExtensionAmountElement;
    }

    // =========================================================================
    // =========================================================================
    //
    public static TaxExclusiveAmount getTaxExclusiveAmount(String currency, String value) {

        TaxExclusiveAmount taxExclusiveAmountElement = ObjectFactoryFacade.get_CBC().createTaxExclusiveAmount();

        taxExclusiveAmountElement.setCurrencyID(currency);
        taxExclusiveAmountElement.setValue(new BigDecimal(value));

        return taxExclusiveAmountElement;
    }

    // =========================================================================
    // =========================================================================
    //
    public static TaxInclusiveAmount getTaxInclusiveAmount(String currency, String value) {

        TaxInclusiveAmount taxInclusiveAmountElement = ObjectFactoryFacade.get_CBC().createTaxInclusiveAmount();

        taxInclusiveAmountElement.setCurrencyID(currency);
        taxInclusiveAmountElement.setValue(new BigDecimal(value));

        return taxInclusiveAmountElement;
    }

    // =========================================================================
    // =========================================================================
    //
    public static AllowanceTotalAmount getAllowanceTotalAmount(String currency, String value) {

        AllowanceTotalAmount allowanceTotalAmountElement = ObjectFactoryFacade.get_CBC().createAllowanceTotalAmount();

        allowanceTotalAmountElement.setCurrencyID(currency);
        allowanceTotalAmountElement.setValue(new BigDecimal(value));

        return allowanceTotalAmountElement;
    }

    // =========================================================================
    // =========================================================================
    //
    public static ChargeTotalAmount getChargeTotalAmount(String currency, String value) {

        ChargeTotalAmount chargeTotalAmountElement = ObjectFactoryFacade.get_CBC().createChargeTotalAmount();

        chargeTotalAmountElement.setCurrencyID(currency);
        chargeTotalAmountElement.setValue(new BigDecimal(value));

        return chargeTotalAmountElement;
    }

    // =========================================================================
    // =========================================================================
    //
    public static PayableAmount getPayableAmount(String currency, String value) {

        PayableAmount payableAmountElement = ObjectFactoryFacade.get_CBC().createPayableAmount();

        payableAmountElement.setCurrencyID(currency);
        payableAmountElement.setValue(new BigDecimal(value));

        return payableAmountElement;
    }

    // =========================================================================
    // =========================================================================
    //
    public static InvoicedQuantity getPayableAmount(String value) {

        InvoicedQuantity invoicedQuantityElement = ObjectFactoryFacade.get_CBC().createInvoicedQuantity();

        invoicedQuantityElement.setValue(new BigDecimal(value));

        return invoicedQuantityElement;
    }

    // =========================================================================
    // =========================================================================
    //
    public static FreeOfChargeIndicator getFreeOfChargeIndicator(boolean value) {

        FreeOfChargeIndicator freeOfChargeIndicatorElement = ObjectFactoryFacade.get_CBC().createFreeOfChargeIndicator();

        freeOfChargeIndicatorElement.setValue(value);

        return freeOfChargeIndicatorElement;
    }

    // =========================================================================
    // =========================================================================
    //
    public static Description getDescription(String value) {

        Description descriptionElement = ObjectFactoryFacade.get_CBC().createDescription();

        descriptionElement.setValue(value);

        return descriptionElement;
    }

    // =========================================================================
    // =========================================================================
    //
    public static BaseQuantity getBaseQuantity(String unitCode, String value) {

        BaseQuantity baseQuantityElement = ObjectFactoryFacade.get_CBC().createBaseQuantity();

        baseQuantityElement.setUnitCode(unitCode);
        baseQuantityElement.setValue(new BigDecimal(value));

        return baseQuantityElement;
    }

    // =========================================================================
    // =========================================================================
    //
    public static PriceAmount getPriceAmount(String currency, String value) {

        PriceAmount priceAmountElement = ObjectFactoryFacade.get_CBC().createPriceAmount();

        priceAmountElement.setCurrencyID(currency);
        priceAmountElement.setValue(new BigDecimal(value));

        return priceAmountElement;
    }

    // =========================================================================
    // =========================================================================
    //
    public static UBLVersionID getUBLVersionID(String value) {

        UBLVersionID ublVersionIDElement = ObjectFactoryFacade.get_CBC().createUBLVersionID();

        ublVersionIDElement.setValue(value);

        return ublVersionIDElement;
    }

    // =========================================================================
    // =========================================================================
    //
    public static CustomizationID getCustomizationID(String value) {

        CustomizationID customizationIDElement = ObjectFactoryFacade.get_CBC().createCustomizationID();

        customizationIDElement.setValue(value);

        return customizationIDElement;
    }

    // =========================================================================
    // =========================================================================
    //
    public static ProfileID getProfileID(String value) {

        ProfileID profileIDElement = ObjectFactoryFacade.get_CBC().createProfileID();

        profileIDElement.setValue(value);

        return profileIDElement;
    }

    // =========================================================================
    // =========================================================================
    //
    public static ProfileExecutionID getProfileExecutionID(String value) {

        ProfileExecutionID profileExecutionIDElement = ObjectFactoryFacade.get_CBC().createProfileExecutionID();

        profileExecutionIDElement.setValue(value);

        return profileExecutionIDElement;
    }

    // =========================================================================
    // =========================================================================
    //
    public static InvoiceTypeCode getInvoiceTypeCode(String value) {

        InvoiceTypeCode invoiceTypeCodeElement = ObjectFactoryFacade.get_CBC().createInvoiceTypeCode();

        invoiceTypeCodeElement.setValue(value);

        return invoiceTypeCodeElement;
    }

    // =========================================================================
    // =========================================================================
    //
    public static Note getNote(String value) {

        Note noteElement = ObjectFactoryFacade.get_CBC().createNote();

        noteElement.setValue(value);

        return noteElement;
    }

    // =========================================================================
    // =========================================================================
    //
    public static DocumentCurrencyCode getDocumentCurrencyCode(String value) {

        DocumentCurrencyCode documentCurrencyCodeElement = ObjectFactoryFacade.get_CBC().createDocumentCurrencyCode();

        documentCurrencyCodeElement.setValue(value);

        return documentCurrencyCodeElement;
    }

    // =========================================================================
    // =========================================================================
    //
    public static SourceCurrencyCode getSourceCurrencyCode(String value) {

        SourceCurrencyCode sourceCurrencyCodeElement = ObjectFactoryFacade.get_CBC().createSourceCurrencyCode();

        sourceCurrencyCodeElement.setValue(value);

        return sourceCurrencyCodeElement;
    }

    // =========================================================================
    // =========================================================================
    //
    public static SourceCurrencyBaseRate getSourceCurrencyBaseRate(String value) {

        SourceCurrencyBaseRate sourceCurrencyBaseRateElement = ObjectFactoryFacade.get_CBC().createSourceCurrencyBaseRate();

        sourceCurrencyBaseRateElement.setValue(new BigDecimal(value));

        return sourceCurrencyBaseRateElement;
    }

    // =========================================================================
    // =========================================================================
    //
    public static TargetCurrencyCode getTargetCurrencyCode(String value) {

        TargetCurrencyCode targetCurrencyCodeElement = ObjectFactoryFacade.get_CBC().createTargetCurrencyCode();

        targetCurrencyCodeElement.setValue(value);

        return targetCurrencyCodeElement;
    }

    // =========================================================================
    // =========================================================================
    //
    public static TargetCurrencyBaseRate getTargetCurrencyBaseRate(String value) {

        TargetCurrencyBaseRate targetCurrencyBaseRateElement = ObjectFactoryFacade.get_CBC().createTargetCurrencyBaseRate();

        targetCurrencyBaseRateElement.setValue(new BigDecimal(value));

        return targetCurrencyBaseRateElement;
    }

    // =========================================================================
    // =========================================================================
    //
    public static CalculationRate getCalculationRate(String value) {

        CalculationRate calculationRateElement = ObjectFactoryFacade.get_CBC().createCalculationRate();

        calculationRateElement.setValue(new BigDecimal(value));

        return calculationRateElement;
    }

    // =========================================================================
    // =========================================================================
    //
    public static LineCountNumeric getLineCountNumeric(String value) {

        LineCountNumeric lineCountNumericElement = ObjectFactoryFacade.get_CBC().createLineCountNumeric();

        lineCountNumericElement.setValue(new BigDecimal(value));

        return lineCountNumericElement;
    }

    // =========================================================================
    // =========================================================================
    //
    public static PaymentMeansCode getPaymentMeansCode(String value) {

        PaymentMeansCode paymentMeansCodeElement = ObjectFactoryFacade.get_CBC().createPaymentMeansCode();

        paymentMeansCodeElement.setValue(value);

        return paymentMeansCodeElement;
    }

    // =========================================================================
    // =========================================================================
    //
    public static PaymentID getPaymentID(String value) {

        PaymentID paymentIDElement = ObjectFactoryFacade.get_CBC().createPaymentID();

        paymentIDElement.setValue(value);

        return paymentIDElement;
    }

    // =========================================================================
    // =========================================================================
    //
    public static UUID getUUID(
            String schemeId,
            String schemeName,
            String value
    ) {

        UUID uuidElement = ObjectFactoryFacade.get_CBC().createUUID();

        uuidElement.setSchemeID(schemeId);
        uuidElement.setSchemeName(schemeName);
        uuidElement.setValue(value);

        return uuidElement;
    }

    // =========================================================================
    // =========================================================================
    //
    public static ID getID(String id) {

        ID idElement = ObjectFactoryFacade.get_CBC().createID();

        idElement.setValue(id);

        return idElement;
    }

    // =========================================================================
    // =========================================================================
    //
    public static ID getID(
            String schemeId,
            String schemeName,
            String id
    ) {

        ID idElement = ObjectFactoryFacade.get_CBC().createID();

        idElement.setSchemeID(schemeId);
        idElement.setSchemeName(schemeName);
        idElement.setValue(id);

        return idElement;
    }

    // =========================================================================
    // =========================================================================
    //
    public static ID getID(
            String schemeAgencyId,
            String schemeAgencyName,
            String schemeId,
            String schemeName,
            String id
    ) {

        ID idElement = ObjectFactoryFacade.get_CBC().createID();

        idElement.setSchemeAgencyID(schemeAgencyId);
        idElement.setSchemeAgencyName(schemeAgencyName);
        idElement.setSchemeID(schemeId);
        idElement.setSchemeName(schemeName);
        idElement.setValue(id);

        return idElement;
    }

    // =========================================================================
    // =========================================================================
    //
    public static IssueDate getIssueDate(Date date) throws DatatypeConfigurationException {

        DateFormat format = new SimpleDateFormat(DATE_FORMAT);
        XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(format.format(date));

        IssueDate issueDate = ObjectFactoryFacade.get_CBC().createIssueDate();
        issueDate.setValue(xmlGregorianCalendar);

        return issueDate;
    }

    // =========================================================================
    // =========================================================================
    //
    public static com.proactivedevs.ublparser.model.pojo.ubl.common.cbc.Date getDate(Date date) throws DatatypeConfigurationException {

        DateFormat format = new SimpleDateFormat(DATE_FORMAT);
        XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(format.format(date));

        com.proactivedevs.ublparser.model.pojo.ubl.common.cbc.Date dateCbc = ObjectFactoryFacade.get_CBC().createDate();
        dateCbc.setValue(xmlGregorianCalendar);

        return dateCbc;
    }

    // =========================================================================
    // =========================================================================
    //
    public static IssueTime getIssueTime(Date date) throws DatatypeConfigurationException {

        DateFormat format = new SimpleDateFormat(TIME_FORMAT);
        format.setTimeZone(TimeZone.getTimeZone("America/Bogota")); // this should be dynamic
        XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(format.format(date));

        IssueTime issueTime = ObjectFactoryFacade.get_CBC().createIssueTime();
        issueTime.setValue(xmlGregorianCalendar);

        return issueTime;
    }

}
