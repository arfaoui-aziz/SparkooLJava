package Utils;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class sendSMS {
    public static final String ACCOUNT_SID = "AC69ee9b52a3da38885e17763a50bfb827";
    public static final String AUTH_TOKEN = "3696b35c14f419e21243814ab77e6026";

    public static void sms(String verifCode,int phoneNumber) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("+216"+phoneNumber), //to
                new com.twilio.type.PhoneNumber("+12057075594"), //from
                "Your SparkooL Verification code to Reset Your Password is : "+verifCode)
                .create();

        System.out.println(message.getSid());
    }
}
