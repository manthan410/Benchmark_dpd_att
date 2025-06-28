
import org.json.JSONException;
import org.json.JSONObject;
import com.teleca.jamendo.api.Review;
public class ReviewBuilder extends JSONBuilder<Review>{
	@Override
	public Review build(JSONObject jsonObject) throws JSONException {
		Review review = new Review();
		review.setId(jsonObject.getInt("id"));
		review.setLang(jsonObject.getString("lang"));
		review.setName(jsonObject.getString("name"));
		try {
			review.setRating(jsonObject.getInt("rating"));
		} catch (JSONException e) {
			review.setRating(0);
		}
		review.setText(jsonObject.getString("text").replace("\r", ""));
		review.setUserImage(jsonObject.getString("user_image"));
		review.setUserName(jsonObject.getString("user_name"));
		return review;
	}
}
