package com.proactivedevs.ublparser.config;

import com.sun.xml.bind.marshaller.NamespacePrefixMapper;
import java.util.HashMap;
import java.util.Map;
import javax.xml.XMLConstants;
import javax.xml.bind.Marshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class JaxbMarshallerBeans {

    // =========================================================================
    // =========================================================================
    //
    @Autowired
    @Qualifier("invoiceNamespacePrefixMapper")
    private NamespacePrefixMapper invoiceNamespacePrefixMapper;

    @Bean(name = "invoiceMarshaller")
    public Jaxb2Marshaller invoiceMarshaller() throws Exception {

        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan("com.proactivedevs.ublparser.model.pojo.ubl.maindoc.invoice");

        Map<String, Object> props = new HashMap<>();
        props.put(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        props.put(Marshaller.JAXB_SCHEMA_LOCATION, "urn:oasis:names:specification:ubl:schema:xsd:Invoice-2 http://docs.oasis-open.org/ubl/os-UBL-2.1/xsd/maindoc/UBL-Invoice-2.1.xsd");
        props.put("com.sun.xml.bind.namespacePrefixMapper", invoiceNamespacePrefixMapper);

        marshaller.setMarshallerProperties(props);

        // SCHEMA VALIDATION
        // maindoc
        Resource xsd_dianublstructures = new ClassPathResource("/schemas/maindoc/DIAN_UBL_Structures.xsd");
        Resource xsd_invoice = new ClassPathResource("/schemas/maindoc/UBL-Invoice-2.1.xsd");
        // common
        Resource xsd_cac = new ClassPathResource("/schemas/common/UBL-CommonAggregateComponents-2.1.xsd");
        Resource xsd_cbc = new ClassPathResource("/schemas/common/UBL-CommonBasicComponents-2.1.xsd");
        Resource xsd_ext = new ClassPathResource("/schemas/common/UBL-CommonExtensionComponents-2.1.xsd");
        Resource xsd_xades132 = new ClassPathResource("/schemas/common/UBL-XAdESv132-2.1.xsd");
        Resource xsd_xades141 = new ClassPathResource("/schemas/common/UBL-XAdESv141-2.1.xsd");

        marshaller.setSchemas(
                xsd_dianublstructures,
                xsd_invoice,
                xsd_cac,
                xsd_cbc,
                xsd_ext,
                xsd_xades132,
                xsd_xades141
        );

        marshaller.setSchemaLanguage(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        // marshaller.setValidationEventHandler(new ValidationEventCollector()); // for errors and warnings report        
        // marshaller.afterPropertiesSet();

        return marshaller;
    }

    // =========================================================================
    // =========================================================================
    //
    @Autowired
    @Qualifier("creditNoteNamespacePrefixMapper")
    private NamespacePrefixMapper creditNoteNamespacePrefixMapper;

    @Bean(name = "creditNoteMarshaller")
    public Jaxb2Marshaller creditNoteMarshaller() throws Exception {

        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan("com.proactivedevs.ublparser.model.pojo.ubl.maindoc.creditnote");

        Map<String, Object> props = new HashMap<>();
        props.put(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        props.put(Marshaller.JAXB_SCHEMA_LOCATION, "urn:oasis:names:specification:ubl:schema:xsd:CreditNote-2 http://docs.oasis-open.org/ubl/os-UBL-2.1/xsd/maindoc/UBL-CreditNote-2.1.xsd");
        props.put("com.sun.xml.bind.namespacePrefixMapper", creditNoteNamespacePrefixMapper);

        marshaller.setMarshallerProperties(props);

        // SCHEMA VALIDATION
        // maindoc
        Resource xsd_dianublstructures = new ClassPathResource("/schemas/maindoc/DIAN_UBL_Structures.xsd");
        Resource xsd_creditnote = new ClassPathResource("/schemas/maindoc/UBL-CreditNote-2.1.xsd");
        // common
        Resource xsd_xades132 = new ClassPathResource("/schemas/common/UBL-XAdESv132-2.1.xsd");
        Resource xsd_xades141 = new ClassPathResource("/schemas/common/UBL-XAdESv141-2.1.xsd");
        Resource xsd_cac = new ClassPathResource("/schemas/common/UBL-CommonAggregateComponents-2.1.xsd");
        Resource xsd_cbc = new ClassPathResource("/schemas/common/UBL-CommonBasicComponents-2.1.xsd");
        Resource xsd_ext = new ClassPathResource("/schemas/common/UBL-CommonExtensionComponents-2.1.xsd");

        marshaller.setSchemas(
                xsd_dianublstructures,
                xsd_creditnote,
                xsd_cac,
                xsd_cbc,
                xsd_ext,
                xsd_xades132,
                xsd_xades141
        );

        marshaller.setSchemaLanguage(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        // marshaller.setValidationEventHandler(new ValidationEventCollector()); // for errors and warnings report
        // marshaller.afterPropertiesSet();

        return marshaller;
    }

    // =========================================================================
    // =========================================================================
    //
    @Autowired
    @Qualifier("debitNoteNamespacePrefixMapper")
    private NamespacePrefixMapper debitNoteNamespacePrefixMapper;

    @Bean(name = "debitNoteMarshaller")
    public Jaxb2Marshaller debitNoteMarshaller() throws Exception {

        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan("com.proactivedevs.ublparser.model.pojo.ubl.maindoc.debitnote");

        Map<String, Object> props = new HashMap<>();
        props.put(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        props.put(Marshaller.JAXB_SCHEMA_LOCATION, "urn:oasis:names:specification:ubl:schema:xsd:DebitNote-2 http://docs.oasis-open.org/ubl/os-UBL-2.1/xsd/maindoc/UBL-DebitNote-2.1.xsd");
        props.put("com.sun.xml.bind.namespacePrefixMapper", debitNoteNamespacePrefixMapper);

        marshaller.setMarshallerProperties(props);

        // SCHEMA VALIDATION
        // maindoc
        Resource xsd_dianublstructures = new ClassPathResource("/schemas/maindoc/DIAN_UBL_Structures.xsd");
        Resource xsd_debitnote = new ClassPathResource("/schemas/maindoc/UBL-DebitNote-2.1.xsd");
        // common
        Resource xsd_xades132 = new ClassPathResource("/schemas/common/UBL-XAdESv132-2.1.xsd");
        Resource xsd_xades141 = new ClassPathResource("/schemas/common/UBL-XAdESv141-2.1.xsd");
        Resource xsd_cac = new ClassPathResource("/schemas/common/UBL-CommonAggregateComponents-2.1.xsd");
        Resource xsd_cbc = new ClassPathResource("/schemas/common/UBL-CommonBasicComponents-2.1.xsd");
        Resource xsd_ext = new ClassPathResource("/schemas/common/UBL-CommonExtensionComponents-2.1.xsd");

        marshaller.setSchemas(
                xsd_dianublstructures,
                xsd_debitnote,
                xsd_cac,
                xsd_cbc,
                xsd_ext,
                xsd_xades132,
                xsd_xades141
        );

        marshaller.setSchemaLanguage(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        // marshaller.setValidationEventHandler(new ValidationEventCollector()); // for errors and warnings report
        // marshaller.afterPropertiesSet();

        return marshaller;
    }

    // =========================================================================
    // =========================================================================
    //
    @Autowired
    @Qualifier("attachedDocumentNamespacePrefixMapper")
    private NamespacePrefixMapper attachedDocumentNamespacePrefixMapper;

    @Bean(name = "attachedDocumentMarshaller")
    public Jaxb2Marshaller attachedDocumentMarshaller() throws Exception {

        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan("com.proactivedevs.ublparser.model.pojo.ubl.maindoc.attacheddocument");

        Map<String, Object> props = new HashMap<>();
        props.put(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        props.put(Marshaller.JAXB_SCHEMA_LOCATION, "urn:oasis:names:specification:ubl:schema:xsd:AttachedDocument-2 http://docs.oasis-open.org/ubl/cs1-UBL-2.1/xsd/maindoc/UBL-AttachedDocument-2.1.xsd");
        props.put("com.sun.xml.bind.namespacePrefixMapper", attachedDocumentNamespacePrefixMapper);

        marshaller.setMarshallerProperties(props);

        // SCHEMA VALIDATION
        // maindoc
        // maindoc
        Resource xsd_attacheddocument = new ClassPathResource("/schemas/maindoc/UBL-AttachedDocument-2.1.xsd");
        // common
        Resource xsd_cac = new ClassPathResource("/schemas/common/UBL-CommonAggregateComponents-2.1.xsd");
        Resource xsd_cbc = new ClassPathResource("/schemas/common/UBL-CommonBasicComponents-2.1.xsd");
        Resource xsd_ext = new ClassPathResource("/schemas/common/UBL-CommonExtensionComponents-2.1.xsd");

        marshaller.setSchemas(
                xsd_attacheddocument,
                xsd_cac,
                xsd_cbc,
                xsd_ext
        );

        marshaller.setSchemaLanguage(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        // marshaller.setValidationEventHandler(new ValidationEventCollector()); // for errors and warnings report
        // marshaller.afterPropertiesSet();

        return marshaller;
    }

    // =========================================================================
    // =========================================================================
    //
    @Autowired
    @Qualifier("applicationResponseNamespacePrefixMapper")
    private NamespacePrefixMapper applicationResponseNamespacePrefixMapper;

    @Bean(name = "applicationResponseMarshaller")
    public Jaxb2Marshaller applicationResponseMarshaller() throws Exception {

        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan("com.proactivedevs.ublparser.model.pojo.ubl.maindoc.applicationresponse");

        Map<String, Object> props = new HashMap<>();
        props.put(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        props.put(Marshaller.JAXB_SCHEMA_LOCATION, "urn:oasis:names:specification:ubl:schema:xsd:ApplicationResponse-2 http://docs.oasis-open.org/ubl/cs1-UBL-2.1/xsd/maindoc/UBL-ApplicationResponse-2.1.xsd");
        props.put("com.sun.xml.bind.namespacePrefixMapper", applicationResponseNamespacePrefixMapper);

        marshaller.setMarshallerProperties(props);

        // SCHEMA VALIDATION
        // maindoc
        Resource xsd_dianublstructures = new ClassPathResource("/schemas/maindoc/DIAN_UBL_Structures.xsd");
        Resource xsd_applicationresponse = new ClassPathResource("/schemas/maindoc/UBL-ApplicationResponse-2.1.xsd");
        // common
        Resource xsd_xades132 = new ClassPathResource("/schemas/common/UBL-XAdESv132-2.1.xsd");
        Resource xsd_xades141 = new ClassPathResource("/schemas/common/UBL-XAdESv141-2.1.xsd");
        Resource xsd_cac = new ClassPathResource("/schemas/common/UBL-CommonAggregateComponents-2.1.xsd");
        Resource xsd_cbc = new ClassPathResource("/schemas/common/UBL-CommonBasicComponents-2.1.xsd");
        Resource xsd_ext = new ClassPathResource("/schemas/common/UBL-CommonExtensionComponents-2.1.xsd");

        marshaller.setSchemas(
                xsd_dianublstructures,
                xsd_applicationresponse,
                xsd_cac,
                xsd_cbc,
                xsd_ext,
                xsd_xades132,
                xsd_xades141
        );

        marshaller.setSchemaLanguage(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        // marshaller.setValidationEventHandler(new ValidationEventCollector()); // for errors and warnings report
        // marshaller.afterPropertiesSet();

        return marshaller;
    }

    // =========================================================================
    // =========================================================================
    //
    @Autowired
    @Qualifier("xadesSignatureNamespacePrefixMapper")
    private NamespacePrefixMapper xadesSignatureNamespacePrefixMapper;

    @Bean(name = "xadesSignatureMarshaller")
    public Jaxb2Marshaller xadesSignatureMarshaller() throws Exception {

        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan("com.proactivedevs.ublparser.model.pojo.ubl.common.xadesv132", "com.proactivedevs.ublparser.model.pojo.ubl.common.xadesv141");

        Map<String, Object> props = new HashMap<>();
        props.put(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        // props.put(Marshaller.JAXB_SCHEMA_LOCATION, "urn:oasis:names:specification:ubl:schema:xsd:ApplicationResponse-2 http://docs.oasis-open.org/ubl/cs1-UBL-2.1/xsd/maindoc/UBL-ApplicationResponse-2.1.xsd");
        props.put("com.sun.xml.bind.namespacePrefixMapper", xadesSignatureNamespacePrefixMapper);

        marshaller.setMarshallerProperties(props);

        // SCHEMA VALIDATION
        // common
        Resource xsd_xades132 = new ClassPathResource("/schemas/common/UBL-XAdESv132-2.1.xsd");
        Resource xsd_xades141 = new ClassPathResource("/schemas/common/UBL-XAdESv141-2.1.xsd");
        Resource xsd_xmldsig = new ClassPathResource("/schemas/common/UBL-xmldsig-core-schema-2.1.xsd");

        marshaller.setSchemas(
                xsd_xmldsig,
                xsd_xades132,
                xsd_xades141
        );

        marshaller.setSchemaLanguage(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        // marshaller.setValidationEventHandler(new ValidationEventCollector()); // for errors and warnings report
        // marshaller.afterPropertiesSet();

        return marshaller;
    }

    // =========================================================================
    // =========================================================================
    //
    @Autowired
    @Qualifier("dianExtensionsNamespacePrefixMapper")
    private NamespacePrefixMapper dianExtensionsNamespacePrefixMapper;

    @Bean(name = "dianExtensionsMarshaller")
    public Jaxb2Marshaller dianExtensionsMarshaller() throws Exception {

        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan("com.proactivedevs.ublparser.model.pojo.ubl.maindoc.dianublstructures");

        Map<String, Object> props = new HashMap<>();
        props.put(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        // props.put(Marshaller.JAXB_SCHEMA_LOCATION, "urn:oasis:names:specification:ubl:schema:xsd:ApplicationResponse-2 http://docs.oasis-open.org/ubl/cs1-UBL-2.1/xsd/maindoc/UBL-ApplicationResponse-2.1.xsd");
        props.put("com.sun.xml.bind.namespacePrefixMapper", dianExtensionsNamespacePrefixMapper);

        marshaller.setMarshallerProperties(props);

        // SCHEMA VALIDATION
        // maindoc
        Resource xsd_dianublstructures = new ClassPathResource("/schemas/maindoc/DIAN_UBL_Structures.xsd");
        // common
        Resource xsd_cac = new ClassPathResource("/schemas/common/UBL-CommonAggregateComponents-2.1.xsd");
        Resource xsd_cbc = new ClassPathResource("/schemas/common/UBL-CommonBasicComponents-2.1.xsd");
        Resource xsd_ext = new ClassPathResource("/schemas/common/UBL-CommonExtensionComponents-2.1.xsd");

        marshaller.setSchemas(
                xsd_dianublstructures,
                xsd_cac,
                xsd_cbc,
                xsd_ext
        );

        marshaller.setSchemaLanguage(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        // marshaller.setValidationEventHandler(new ValidationEventCollector()); // for errors and warnings report
        // marshaller.afterPropertiesSet();

        return marshaller;
    }
}
