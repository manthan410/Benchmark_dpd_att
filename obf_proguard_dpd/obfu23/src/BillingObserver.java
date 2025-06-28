
import android.app.Activity;
import android.widget.Toast;
import net.robotmedia.billing.BillingRequest;
import net.robotmedia.billing.helper.AbstractBillingObserver;
import net.robotmedia.billing.model.Transaction;
import org.json.JSONException;
import org.json.JSONObject;
public class BillingObserver extends AbstractBillingObserver {
    public BillingObserver(Activity activity) {
        super(activity);
    }
    @Override
    public void onBillingChecked(boolean supported) { }
    @Override
    public void onRequestPurchaseResponse(String itemId, BillingRequest.ResponseCode response) { }
    @Override
    public void onPurchaseStateChanged(String itemId, Transaction.PurchaseState state) {
        if (state == Transaction.PurchaseState.PURCHASED) {
            JSONObject properties = new JSONObject();
            try {
                properties.put("item", itemId);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Toast.makeText(activity, "Thanks a lot for supporting me!", Toast.LENGTH_LONG).show();
        }
    }
}
