package com.proactivedevs.ublparser.config;

import com.sun.xml.bind.marshaller.NamespacePrefixMapper;
import java.util.HashMap;
import java.util.Map;
import javax.xml.crypto.dsig.XMLSignature;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JaxbNamespacePrefixMapperBeans {

    // =========================================================================
    // =========================================================================
    //
    @Bean(name = "invoiceNamespacePrefixMapper")
    public NamespacePrefixMapper invoiceNamespacePrefixMapper() {
        return new NamespacePrefixMapper() {

            private final Map<String, String> MAP = new HashMap<>();

            @Override
            public String getPreferredPrefix(String namespaceUri, String suggestion, boolean requirePrefix) {

                // Default
                MAP.put("http://www.w3.org/2001/XMLSchema-instance", "xsi");
                MAP.put(XMLSignature.XMLNS, "ds");
                // maindoc
                MAP.put("urn:oasis:names:specification:ubl:schema:xsd:Invoice-2", "");
                MAP.put("dian:gov:co:facturaelectronica:Structures-2-1", "sts");
                // common
                MAP.put("urn:oasis:names:specification:ubl:schema:xsd:CommonExtensionComponents-2", "ext");
                MAP.put("urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", "cbc");
                MAP.put("urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2", "cac");
                MAP.put("urn:oasis:names:specification:ubl:schema:xsd:SignatureBasicComponents-2", "sbc");
                MAP.put("http://uri.etsi.org/01903/v1.3.2#", "xades");
                MAP.put("http://uri.etsi.org/01903/v1.4.1#", "xades141");

                return MAP.getOrDefault(namespaceUri, suggestion);
            }
        };
    }

    // =========================================================================
    // =========================================================================
    //
    @Bean(name = "creditNoteNamespacePrefixMapper")
    public NamespacePrefixMapper creditNoteNamespacePrefixMapper() {
        return new NamespacePrefixMapper() {

            private final Map<String, String> MAP = new HashMap<>();

            @Override
            public String getPreferredPrefix(String namespaceUri, String suggestion, boolean requirePrefix) {

                // Default
                MAP.put("http://www.w3.org/2001/XMLSchema-instance", "xsi");
                MAP.put(XMLSignature.XMLNS, "ds");
                // maindoc
                MAP.put("urn:oasis:names:specification:ubl:schema:xsd:CreditNote-2", "");
                MAP.put("dian:gov:co:facturaelectronica:Structures-2-1", "sts");
                // common
                MAP.put("urn:oasis:names:specification:ubl:schema:xsd:CommonExtensionComponents-2", "ext");
                MAP.put("urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", "cbc");
                MAP.put("urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2", "cac");
                MAP.put("urn:oasis:names:specification:ubl:schema:xsd:SignatureBasicComponents-2", "sbc");
                MAP.put("http://uri.etsi.org/01903/v1.3.2#", "xades");
                MAP.put("http://uri.etsi.org/01903/v1.4.1#", "xades141");

                return MAP.getOrDefault(namespaceUri, suggestion);
            }
        };
    }

}
