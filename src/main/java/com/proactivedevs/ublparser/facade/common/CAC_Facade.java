package com.proactivedevs.ublparser.facade.common;

import com.proactivedevs.ublparser.facade.ObjectFactoryFacade;
import static com.proactivedevs.ublparser.facade.common.CBC_Facade.getAllowanceTotalAmount;
import static com.proactivedevs.ublparser.facade.common.CBC_Facade.getChargeTotalAmount;
import static com.proactivedevs.ublparser.facade.common.CBC_Facade.getFreeOfChargeIndicator;
import static com.proactivedevs.ublparser.facade.common.CBC_Facade.getID;
import static com.proactivedevs.ublparser.facade.common.CBC_Facade.getLineExtensionAmount;
import static com.proactivedevs.ublparser.facade.common.CBC_Facade.getPayableAmount;
import static com.proactivedevs.ublparser.facade.common.CBC_Facade.getTaxExclusiveAmount;
import static com.proactivedevs.ublparser.facade.common.CBC_Facade.getTaxInclusiveAmount;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cac.ExchangeRateType;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cac.InvoiceLineType;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cac.ItemIdentificationType;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cac.ItemType;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cac.MonetaryTotalType;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cac.OrderReference;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cac.PartyIdentification;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cac.PartyType;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cac.PaymentMeans;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cac.PriceType;
import java.util.Date;
import javax.xml.datatype.DatatypeConfigurationException;

public class CAC_Facade {

    // =========================================================================
    // =========================================================================
    //
    public static InvoiceLineType getInvoiceLine(
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

        InvoiceLineType invoiceLineTypeElement = ObjectFactoryFacade.get_CAC().createInvoiceLineType();

        invoiceLineTypeElement.setID(getID(id));
        invoiceLineTypeElement.setInvoicedQuantity(getPayableAmount(invoicedQuantity));
        invoiceLineTypeElement.setFreeOfChargeIndicator(getFreeOfChargeIndicator(freeOfChargeIndicator));
        invoiceLineTypeElement.setItem(getItemType(
                item_descriptions,
                item_standardItemIdentification_id_schemeId,
                item_standardItemIdentification_id_schemeName,
                item_standardItemIdentification_id)
        );
        invoiceLineTypeElement.setPrice(getPriceType(
                currency,
                price_priceAmount,
                price_baseQuantity,
                price_baseQuantity_unitCode)
        );

        return invoiceLineTypeElement;
    }

    // =========================================================================
    // =========================================================================
    //
    public static MonetaryTotalType getMonetaryTotalType(
            String currency,
            String lineExtensionAmount,
            String taxInclusiveAmount,
            String taxExclusiveAmount,
            String allowanceTotalAmount,
            String chargeTotalAmount,
            String payableAmount
    ) {

        MonetaryTotalType legalMonetaryTotalElement = ObjectFactoryFacade.get_CAC().createMonetaryTotalType();

        legalMonetaryTotalElement.setLineExtensionAmount(getLineExtensionAmount(currency, lineExtensionAmount));
        legalMonetaryTotalElement.setTaxExclusiveAmount(getTaxExclusiveAmount(currency, taxExclusiveAmount));
        legalMonetaryTotalElement.setTaxInclusiveAmount(getTaxInclusiveAmount(currency, taxInclusiveAmount));
        legalMonetaryTotalElement.setAllowanceTotalAmount(getAllowanceTotalAmount(currency, allowanceTotalAmount));
        legalMonetaryTotalElement.setChargeTotalAmount(getChargeTotalAmount(currency, chargeTotalAmount));
        legalMonetaryTotalElement.setPayableAmount(getPayableAmount(currency, payableAmount));

        return legalMonetaryTotalElement;
    }

    // =========================================================================
    // =========================================================================
    //
    public static ItemIdentificationType getItemIdentificationType(
            String schemeId,
            String schemeName,
            String id
    ) {

        ItemIdentificationType itemIdentificationTypeElement = ObjectFactoryFacade.get_CAC().createItemIdentificationType();

        itemIdentificationTypeElement.setID(getID(schemeId, schemeName, id));

        return itemIdentificationTypeElement;
    }

    // =========================================================================
    // =========================================================================
    //
    public static ExchangeRateType getExchangeRateType(
            String sourceCurrencyCode,
            String sourceCurrencyBaseRate,
            String targetCurrencyCode,
            String targetCurrencyBaseRate,
            String calculationRate,
            Date date
    ) throws DatatypeConfigurationException {

        ExchangeRateType exchangeRateTypeElement = ObjectFactoryFacade.get_CAC().createExchangeRateType();

        exchangeRateTypeElement.setSourceCurrencyCode(CBC_Facade.getSourceCurrencyCode(sourceCurrencyCode));
        exchangeRateTypeElement.setSourceCurrencyBaseRate(CBC_Facade.getSourceCurrencyBaseRate(sourceCurrencyBaseRate));
        exchangeRateTypeElement.setTargetCurrencyCode(CBC_Facade.getTargetCurrencyCode(targetCurrencyCode));
        exchangeRateTypeElement.setTargetCurrencyBaseRate(CBC_Facade.getTargetCurrencyBaseRate(targetCurrencyBaseRate));
        exchangeRateTypeElement.setCalculationRate(CBC_Facade.getCalculationRate(calculationRate));
        exchangeRateTypeElement.setDate(CBC_Facade.getDate(date));

        return exchangeRateTypeElement;
    }

    // =========================================================================
    // =========================================================================
    //
    public static OrderReference getOrderReference(
            String id,
            Date issueDate
    ) throws DatatypeConfigurationException {

        OrderReference orderReferenceElement = ObjectFactoryFacade.get_CAC().createOrderReference();

        orderReferenceElement.setID(CBC_Facade.getID(id));
        orderReferenceElement.setIssueDate(CBC_Facade.getIssueDate(issueDate));

        return orderReferenceElement;
    }

    // =========================================================================
    // =========================================================================
    //
    public static PartyIdentification getPartyIdentification(
            String schemeAgencyId,
            String schemeAgencyName,
            String schemeId,
            String schemeName,
            String id
    ) {

        PartyIdentification partyIdentificationElement = ObjectFactoryFacade.get_CAC().createPartyIdentification();

        partyIdentificationElement.setID(CBC_Facade.getID(
                schemeAgencyId,
                schemeAgencyName,
                schemeId,
                schemeName,
                id
        ));

        return partyIdentificationElement;
    }

    // =========================================================================
    // =========================================================================
    //
    public static PartyType getTaxRepresentativeParty(
            PartyIdentification[] partyIdentifications
    ) {

        PartyType partyTypeElement = ObjectFactoryFacade.get_CAC().createPartyType();

        for (PartyIdentification p : partyIdentifications) {
            partyTypeElement.getPartyIdentifications().add(p);
        }

        return partyTypeElement;
    }

    // =========================================================================
    // =========================================================================
    //
    public static PaymentMeans getPaymentMeans(
            String id,
            String paymentMeansCode,
            String[] paymentIDs
    ) {

        PaymentMeans paymentMeansElement = ObjectFactoryFacade.get_CAC().createPaymentMeans();

        paymentMeansElement.setID(CBC_Facade.getID(id));
        paymentMeansElement.setPaymentMeansCode(CBC_Facade.getPaymentMeansCode(paymentMeansCode));

        for (String p : paymentIDs) {
            paymentMeansElement.getPaymentIDs().add(CBC_Facade.getPaymentID(p));
        }

        return paymentMeansElement;
    }

    // =========================================================================
    // =========================================================================
    //
    public static PriceType getPriceType(
            String currency,
            String priceAmount,
            String baseQuantity,
            String baseQuantity_unitCode
    ) {

        PriceType priceTypeElement = ObjectFactoryFacade.get_CAC().createPriceType();

        priceTypeElement.setPriceAmount(CBC_Facade.getPriceAmount(currency, priceAmount));
        priceTypeElement.setBaseQuantity(CBC_Facade.getBaseQuantity(baseQuantity_unitCode, baseQuantity));

        return priceTypeElement;
    }

    // =========================================================================
    // =========================================================================
    //
    public static ItemType getItemType(
            String[] descriptions,
            String standardItemIdentification_id_schemeId,
            String standardItemIdentification_id_schemeName,
            String standardItemIdentification_id
    ) {

        ItemType itemTypeElement = ObjectFactoryFacade.get_CAC().createItemType();

        for (String d : descriptions) {
            itemTypeElement.getDescriptions().add(CBC_Facade.getDescription(d));
        }

        itemTypeElement.setStandardItemIdentification(getItemIdentificationType(
                standardItemIdentification_id_schemeId,
                standardItemIdentification_id_schemeName,
                standardItemIdentification_id)
        );

        return itemTypeElement;
    }

}
