package com.proactivedevs.ublparser.config;

import org.springframework.stereotype.Component;

@Component
public class JaxbObjectFactoryFacade {

    private static final com.proactivedevs.ublparser.model.pojo.ubl.common.cac.ObjectFactory objectFactoryCAC = new com.proactivedevs.ublparser.model.pojo.ubl.common.cac.ObjectFactory();
    private static final com.proactivedevs.ublparser.model.pojo.ubl.common.cbc.ObjectFactory objectFactoryCBC = new com.proactivedevs.ublparser.model.pojo.ubl.common.cbc.ObjectFactory();
    private static final com.proactivedevs.ublparser.model.pojo.ubl.common.cctscct.ObjectFactory objectFactoryCCTSCCT = new com.proactivedevs.ublparser.model.pojo.ubl.common.cctscct.ObjectFactory();
    private static final com.proactivedevs.ublparser.model.pojo.ubl.common.csc.ObjectFactory objectFactoryCSC = new com.proactivedevs.ublparser.model.pojo.ubl.common.csc.ObjectFactory();
    private static final com.proactivedevs.ublparser.model.pojo.ubl.common.ext.ObjectFactory objectFactoryEXT = new com.proactivedevs.ublparser.model.pojo.ubl.common.ext.ObjectFactory();
    private static final com.proactivedevs.ublparser.model.pojo.ubl.common.sac.ObjectFactory objectFactorySAC = new com.proactivedevs.ublparser.model.pojo.ubl.common.sac.ObjectFactory();
    private static final com.proactivedevs.ublparser.model.pojo.ubl.common.sbc.ObjectFactory objectFactorySBC = new com.proactivedevs.ublparser.model.pojo.ubl.common.sbc.ObjectFactory();
    private static final com.proactivedevs.ublparser.model.pojo.ubl.common.udt.ObjectFactory objectFactoryUDT = new com.proactivedevs.ublparser.model.pojo.ubl.common.udt.ObjectFactory();
    private static final com.proactivedevs.ublparser.model.pojo.ubl.common.xadesv132.ObjectFactory objectFactoryXADESV132 = new com.proactivedevs.ublparser.model.pojo.ubl.common.xadesv132.ObjectFactory();
    private static final com.proactivedevs.ublparser.model.pojo.ubl.common.xadesv141.ObjectFactory objectFactoryXADESV141 = new com.proactivedevs.ublparser.model.pojo.ubl.common.xadesv141.ObjectFactory();
    private static final com.proactivedevs.ublparser.model.pojo.ubl.common.xmldsig.ObjectFactory objectFactoryXMLDSIG = new com.proactivedevs.ublparser.model.pojo.ubl.common.xmldsig.ObjectFactory();
    private static final com.proactivedevs.ublparser.model.pojo.ubl.maindoc.applicationresponse.ObjectFactory objectFactoryAPPLICATION_RESPONSE = new com.proactivedevs.ublparser.model.pojo.ubl.maindoc.applicationresponse.ObjectFactory();
    private static final com.proactivedevs.ublparser.model.pojo.ubl.maindoc.attacheddocument.ObjectFactory objectFactoryATTACHED_DOCUMENT = new com.proactivedevs.ublparser.model.pojo.ubl.maindoc.attacheddocument.ObjectFactory();
    private static final com.proactivedevs.ublparser.model.pojo.ubl.maindoc.creditnote.ObjectFactory objectFactoryCREDIT_NOTE = new com.proactivedevs.ublparser.model.pojo.ubl.maindoc.creditnote.ObjectFactory();
    private static final com.proactivedevs.ublparser.model.pojo.ubl.maindoc.debitnote.ObjectFactory objectFactoryDEBIT_NOTE = new com.proactivedevs.ublparser.model.pojo.ubl.maindoc.debitnote.ObjectFactory();
    private static final com.proactivedevs.ublparser.model.pojo.ubl.maindoc.dianublstructures.ObjectFactory objectFactoryDIAN_UBL_STRUCTURES = new com.proactivedevs.ublparser.model.pojo.ubl.maindoc.dianublstructures.ObjectFactory();
    private static final com.proactivedevs.ublparser.model.pojo.ubl.maindoc.invoice.ObjectFactory objectFactoryINVOICE = new com.proactivedevs.ublparser.model.pojo.ubl.maindoc.invoice.ObjectFactory();

    public static com.proactivedevs.ublparser.model.pojo.ubl.common.cac.ObjectFactory getCAC() {
        return objectFactoryCAC;
    }

    public static com.proactivedevs.ublparser.model.pojo.ubl.common.cbc.ObjectFactory getCBC() {
        return objectFactoryCBC;
    }

    public static com.proactivedevs.ublparser.model.pojo.ubl.common.cctscct.ObjectFactory getCCTSCCT() {
        return objectFactoryCCTSCCT;
    }

    public static com.proactivedevs.ublparser.model.pojo.ubl.common.csc.ObjectFactory getCSC() {
        return objectFactoryCSC;
    }

    public static com.proactivedevs.ublparser.model.pojo.ubl.common.ext.ObjectFactory getEXT() {
        return objectFactoryEXT;
    }

    public static com.proactivedevs.ublparser.model.pojo.ubl.common.sac.ObjectFactory getSAC() {
        return objectFactorySAC;
    }

    public static com.proactivedevs.ublparser.model.pojo.ubl.common.sbc.ObjectFactory getSBC() {
        return objectFactorySBC;
    }

    public static com.proactivedevs.ublparser.model.pojo.ubl.common.udt.ObjectFactory getUDT() {
        return objectFactoryUDT;
    }

    public static com.proactivedevs.ublparser.model.pojo.ubl.common.xadesv132.ObjectFactory getXADESV132() {
        return objectFactoryXADESV132;
    }

    public static com.proactivedevs.ublparser.model.pojo.ubl.common.xadesv141.ObjectFactory getXADESV141() {
        return objectFactoryXADESV141;
    }

    public static com.proactivedevs.ublparser.model.pojo.ubl.common.xmldsig.ObjectFactory getXMLDSIG() {
        return objectFactoryXMLDSIG;
    }

    public static com.proactivedevs.ublparser.model.pojo.ubl.maindoc.applicationresponse.ObjectFactory getAPPLICATION_RESPONSE() {
        return objectFactoryAPPLICATION_RESPONSE;
    }

    public static com.proactivedevs.ublparser.model.pojo.ubl.maindoc.attacheddocument.ObjectFactory getATTACHED_DOCUMENT() {
        return objectFactoryATTACHED_DOCUMENT;
    }

    public static com.proactivedevs.ublparser.model.pojo.ubl.maindoc.creditnote.ObjectFactory getCREDIT_NOTE() {
        return objectFactoryCREDIT_NOTE;
    }

    public static com.proactivedevs.ublparser.model.pojo.ubl.maindoc.debitnote.ObjectFactory getDEBIT_NOTE() {
        return objectFactoryDEBIT_NOTE;
    }

    public static com.proactivedevs.ublparser.model.pojo.ubl.maindoc.dianublstructures.ObjectFactory getDIAN_UBL_STRUCTURES() {
        return objectFactoryDIAN_UBL_STRUCTURES;
    }

    public static com.proactivedevs.ublparser.model.pojo.ubl.maindoc.invoice.ObjectFactory getINVOICE() {
        return objectFactoryINVOICE;
    }

}
