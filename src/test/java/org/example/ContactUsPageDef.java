package org.example;

public class ContactUsPageDef {
    private static  String FIRSTNAME="//*[@id=\"et_pb_contact_first_0\"]";
    private static String LASTNAME="//*[@id=\"et_pb_contact_last_0\"]";
    private static String EMAIL="//*[@id=\"et_pb_contact_email_0\"]";
    private static String SEND_MESSAGE="//*[@id=\"et_pb_contact_message_0\"]";

    private static String MESSAGE_bUTTON="//*[@id=\"et_pb_contact_form_0\"]/div[2]/form/div/button";

    private static String ERROE_MESSAGE="et-pb-contact-message";

    public ContactUsPageDef() {
    }

    public static String getFIRSTNAME() {
        return FIRSTNAME;
    }

    public static void setFIRSTNAME(String FIRSTNAME) {
        ContactUsPageDef.FIRSTNAME = FIRSTNAME;
    }

    public static String getLASTNAME() {
        return LASTNAME;
    }

    public static void setLASTNAME(String LASTNAME) {
        ContactUsPageDef.LASTNAME = LASTNAME;
    }

    public static String getEMAIL() {
        return EMAIL;
    }

    public static void setEMAIL(String EMAIL) {
        ContactUsPageDef.EMAIL = EMAIL;
    }

    public static String getSendMessage() {
        return SEND_MESSAGE;
    }

    public static void setSendMessage(String sendMessage) {
        SEND_MESSAGE = sendMessage;
    }

    public static String getMessagebutton() {
        return MESSAGE_bUTTON;
    }

    public static void setMessagebutton(String messagebutton) {
        MESSAGE_bUTTON = messagebutton;
    }

    public static String getErroeMessage() {
        return ERROE_MESSAGE;
    }

    public static void setErroeMessage(String erroeMessage) {
        ERROE_MESSAGE = erroeMessage;
    }
}
