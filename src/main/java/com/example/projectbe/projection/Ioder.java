package com.example.projectbe.projection;

public interface Ioder {
    String getID();
    String getIDORDERS();
    String getORDERS_DATE();
    String getIDCUSTOMER();
    String getTOTAL_MONEY();
    String getOrder_notes();
    String getNAME_RECIVER();
    String getADDRESS();
    String getPHONE();
    String getPaymentmethodname();
    String getPaymentmethodnotes();
    String getOrderspaymenttotal();
    String getTransportmethodname();
    String getTransportmethodnotes();
    Double getOrderstransporttotal();
    String getProduct_name();
    String getProduct_image();
    String getProduct_price();
    String getOrderDetailsId();
}
