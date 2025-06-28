
import com.paypal.sdk.core.nvp.NVPDecoder;
import com.paypal.sdk.core.nvp.NVPEncoder;
import com.paypal.sdk.exceptions.PayPalException;
import com.paypal.sdk.profiles.APIProfile;
import com.paypal.sdk.services.NVPCallerServices;
import com.paypal.soap.api.AbstractRequestType;
import com.paypal.soap.api.AbstractResponseType;
public class PaypalNVPProxy extends AbstractProxy {
    private NVPCallerServices caller;
    private NVPEncoder encoder;
    private NVPDecoder decoder = new NVPDecoder();
    private PaypalNVPProxy(APIProfile profile) throws PayPalException {
        super(profile);
        caller = new NVPCallerServices();
        caller.setAPIProfile(this.profile);
    }
    private PaypalNVPProxy(String apiUsername, String apiPassword) throws PayPalException {
        this(apiUsername, apiPassword, null);
    }
    private PaypalNVPProxy(String apiUsername, String apiPassword, String apiSignature) throws PayPalException {
        super(apiUsername, apiPassword, apiSignature);
        caller = new NVPCallerServices();
        caller.setAPIProfile(profile);
    }
    @Override
    public String call(String operation) throws PayPalException {
        encoder.add("METHOD", operation);
        String NVPRequest = encoder.encode();
        String NVPResponse = (String) caller.call(NVPRequest);
        decoder.decode(NVPResponse);
        return NVPResponse;
    }
    @Override
    public AbstractResponseType call(String operation, AbstractRequestType request){
        return null;    
    }
    public void setEncoder(NVPEncoder encoder) {
        this.encoder = encoder;
        this.encoder.add("VERSION", version);
    }
    public NVPDecoder getDecoder() {
        return decoder;
    }
    public boolean isSuccess() {
        return Boolean.getBoolean(decoder.get("ACK"));
    }
    public static PaypalNVPProxy createPaypalNVPProxy(APIProfile profile)
            throws PayPalException {
        return new PaypalNVPProxy(profile);
    }
    public static PaypalNVPProxy createPaypalNVPProxy(String apiUsername, String apiPassword)
            throws PayPalException {
        return new PaypalNVPProxy(apiUsername, apiPassword);
    }
    public static PaypalNVPProxy createPaypalNVPProxy(String apiUsername,
                                                      String apiPassword, String apiSignature)
            throws PayPalException {
        return new PaypalNVPProxy(apiUsername, apiPassword, apiSignature);
    }
}
