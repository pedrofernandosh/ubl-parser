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
import com.proactivedevs.ublparser.model.pojo.ubl.common.cac.AddressLine;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cac.AddressType;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cac.ContactType;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cac.CorporateRegistrationScheme;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cac.CountryType;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cac.CustomerPartyType;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cac.ExchangeRateType;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cac.InvoiceLineType;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cac.ItemIdentificationType;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cac.ItemType;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cac.LocationType;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cac.MonetaryTotalType;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cac.OrderReference;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cac.PartyIdentification;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cac.PartyLegalEntity;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cac.PartyName;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cac.PartyTaxScheme;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cac.PartyType;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cac.PaymentMeans;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cac.PriceType;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cac.SupplierPartyType;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cac.TaxScheme;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cbc.AdditionalAccountID;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cbc.CompanyID;
import com.proactivedevs.ublparser.model.pojo.ubl.common.cbc.TaxLevelCode;
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
        invoiceLineTypeElement.setLineExtensionAmount(getLineExtensionAmount(currency, lineExtensionAmount));
        invoiceLineTypeElement.setFreeOfChargeIndicator(getFreeOfChargeIndicator(freeOfChargeIndicator));
        invoiceLineTypeElement.setItem(getItem(
                item_descriptions,
                item_standardItemIdentification_id_schemeId,
                item_standardItemIdentification_id_schemeName,
                item_standardItemIdentification_id)
        );
        invoiceLineTypeElement.setPrice(getPrice(
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
    public static ItemIdentificationType getStandardItemIdentification(
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
    public static ExchangeRateType getPaymentExchangeRate(
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
    public static PriceType getPrice(
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
    public static ItemType getItem(
            String[] descriptions,
            String standardItemIdentification_id_schemeId,
            String standardItemIdentification_id_schemeName,
            String standardItemIdentification_id
    ) {

        ItemType itemTypeElement = ObjectFactoryFacade.get_CAC().createItemType();

        for (String d : descriptions) {
            itemTypeElement.getDescriptions().add(CBC_Facade.getDescription(d));
        }

        itemTypeElement.setStandardItemIdentification(getStandardItemIdentification(
                standardItemIdentification_id_schemeId,
                standardItemIdentification_id_schemeName,
                standardItemIdentification_id)
        );

        return itemTypeElement;
    }

    // =========================================================================
    // =========================================================================
    //
    public static ContactType getConact(
            String name,
            String telephone,
            String email
    ) {

        ContactType contactTypeElement = ObjectFactoryFacade.get_CAC().createContactType();

        contactTypeElement.setName(CBC_Facade.getName(name));
        contactTypeElement.setTelephone(CBC_Facade.getTelephone(telephone));
        contactTypeElement.setElectronicMail(CBC_Facade.getElectronicMail(email));

        return contactTypeElement;
    }

    // =========================================================================
    // =========================================================================
    //
    public static TaxScheme getTaxScheme(
            String id,
            String name
    ) {

        TaxScheme taxSchemeElement = ObjectFactoryFacade.get_CAC().createTaxScheme();

        taxSchemeElement.setID(CBC_Facade.getID(id));
        taxSchemeElement.setName(CBC_Facade.getName(name));

        return taxSchemeElement;
    }

    // =========================================================================
    // =========================================================================
    //
    public static AddressLine getAddressLine(String line) {

        AddressLine addressLineElement = ObjectFactoryFacade.get_CAC().createAddressLine();

        addressLineElement.setLine(CBC_Facade.getLine(line));

        return addressLineElement;
    }

    // =========================================================================
    // =========================================================================
    //
    public static CountryType getCountry(
            String name,
            String languageID,
            String identificationCode,
            String identificationCode_listAgencyId,
            String identificationCode_listAgencyName,
            String identificationCode_listSchemeURI
    ) {

        CountryType countryTypeElement = ObjectFactoryFacade.get_CAC().createCountryType();

        countryTypeElement.setIdentificationCode(CBC_Facade.getIdentificationCode(
                identificationCode_listAgencyId,
                identificationCode_listAgencyName,
                identificationCode_listSchemeURI,
                identificationCode
        ));
        countryTypeElement.setName(CBC_Facade.getName(name, languageID));

        return countryTypeElement;
    }

    // =========================================================================
    // =========================================================================
    //
    public static AddressType getRegistrationAddress(
            String id,
            String cityName,
            String countrySubentity,
            String countrySubentityCode,
            AddressLine[] addressLines,
            CountryType country
    ) {

        AddressType addressTypeElement = ObjectFactoryFacade.get_CAC().createAddressType();

        addressTypeElement.setID(CBC_Facade.getID(id));
        addressTypeElement.setCityName(CBC_Facade.getCityName(cityName));
        addressTypeElement.setCountrySubentity(CBC_Facade.getCountrySubentity(countrySubentity));
        addressTypeElement.setCountrySubentityCode(CBC_Facade.getCountrySubentityCode(countrySubentityCode));

        for (AddressLine a : addressLines) {
            addressTypeElement.getAddressLines().add(a);
        }

        addressTypeElement.setCountry(country);

        return addressTypeElement;
    }

    // =========================================================================
    // =========================================================================
    //
    public static CorporateRegistrationScheme getCorporateRegistrationScheme(
            String id,
            String name
    ) {

        CorporateRegistrationScheme corporateRegistrationSchemeElement = ObjectFactoryFacade.get_CAC().createCorporateRegistrationScheme();

        corporateRegistrationSchemeElement.setID(CBC_Facade.getID(id));
        corporateRegistrationSchemeElement.setName(CBC_Facade.getName(name));

        return corporateRegistrationSchemeElement;
    }

    // =========================================================================
    // =========================================================================
    //
    public static PartyTaxScheme getPartyTaxScheme(
            String registrationName,
            CompanyID companyId,
            TaxLevelCode taxLevelCode,
            AddressType registrationAddress,
            TaxScheme taxScheme
    ) {

        PartyTaxScheme partyTaxSchemeElement = ObjectFactoryFacade.get_CAC().createPartyTaxScheme();

        partyTaxSchemeElement.setRegistrationName(CBC_Facade.getRegistrationName(registrationName));
        partyTaxSchemeElement.setCompanyID(companyId);
        partyTaxSchemeElement.setTaxLevelCode(taxLevelCode);
        partyTaxSchemeElement.setRegistrationAddress(registrationAddress);
        partyTaxSchemeElement.setTaxScheme(taxScheme);

        return partyTaxSchemeElement;
    }

    // =========================================================================
    // =========================================================================
    //
    public static PartyName getPartyName(String name) {

        PartyName partyNameElement = ObjectFactoryFacade.get_CAC().createPartyName();

        partyNameElement.setName(CBC_Facade.getName(name));

        return partyNameElement;
    }

    // =========================================================================
    // =========================================================================
    //
    public static LocationType getPhysicalLocation(AddressType address) {

        LocationType locationTypeElement = ObjectFactoryFacade.get_CAC().createLocationType();

        locationTypeElement.setAddress(address);

        return locationTypeElement;
    }

    // =========================================================================
    // =========================================================================
    //
    public static PartyLegalEntity getPartyLegalEntity(
            String registrationName,
            CompanyID companyID,
            CorporateRegistrationScheme corporateRegistrationScheme
    ) {

        PartyLegalEntity partyLegalEntityElement = ObjectFactoryFacade.get_CAC().createPartyLegalEntity();

        partyLegalEntityElement.setRegistrationName(CBC_Facade.getRegistrationName(registrationName));
        partyLegalEntityElement.setCompanyID(companyID);
        partyLegalEntityElement.setCorporateRegistrationScheme(corporateRegistrationScheme);

        return partyLegalEntityElement;
    }

    // =========================================================================
    // =========================================================================
    //
    public static PartyLegalEntity getPartyLegalEntity(
            String registrationName,
            CompanyID companyID
    ) {

        PartyLegalEntity partyLegalEntityElement = ObjectFactoryFacade.get_CAC().createPartyLegalEntity();

        partyLegalEntityElement.setRegistrationName(CBC_Facade.getRegistrationName(registrationName));
        partyLegalEntityElement.setCompanyID(companyID);

        return partyLegalEntityElement;
    }

    // =========================================================================
    // =========================================================================
    //
    public static PartyType getParty(
            String[] names,
            LocationType physicalLocation,
            PartyTaxScheme[] partyTaxSchemes,
            PartyLegalEntity[] partyLegalEntities,
            ContactType contact
    ) {

        PartyType partyTypeElement = ObjectFactoryFacade.get_CAC().createPartyType();

        for (String n : names) {
            partyTypeElement.getPartyNames().add(getPartyName(n));
        }

        partyTypeElement.setPhysicalLocation(physicalLocation);

        for (PartyTaxScheme p : partyTaxSchemes) {
            partyTypeElement.getPartyTaxSchemes().add(p);
        }

        for (PartyLegalEntity p : partyLegalEntities) {
            partyTypeElement.getPartyLegalEntities().add(p);
        }

        partyTypeElement.setContact(contact);

        return partyTypeElement;
    }

    // =========================================================================
    // =========================================================================
    //
    public static SupplierPartyType getAccountingSupplierParty(
            AdditionalAccountID[] additionalAccountIDs,
            PartyType party
    ) {

        SupplierPartyType supplierPartyTypeElement = ObjectFactoryFacade.get_CAC().createSupplierPartyType();

        for (AdditionalAccountID id : additionalAccountIDs) {
            supplierPartyTypeElement.getAdditionalAccountIDs().add(id);
        }

        supplierPartyTypeElement.setParty(party);

        return supplierPartyTypeElement;
    }

    // =========================================================================
    // =========================================================================
    //
    public static CustomerPartyType getAccountingCustomerParty(
            AdditionalAccountID[] additionalAccountIDs,
            PartyType party
    ) {

        CustomerPartyType customerPartyTypeElement = ObjectFactoryFacade.get_CAC().createCustomerPartyType();

        for (AdditionalAccountID id : additionalAccountIDs) {
            customerPartyTypeElement.getAdditionalAccountIDs().add(id);
        }

        customerPartyTypeElement.setParty(party);

        return customerPartyTypeElement;
    }

}
