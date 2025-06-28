
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.fuzzydb.attrs.Decorator;
import org.fuzzydb.attrs.internal.BaseAttribute;
import org.fuzzydb.attrs.simple.FloatValue;
public class AgeDecorator extends Decorator {
	private static final long serialVersionUID = 3256440291920984112L;
	public AgeDecorator( String attrName ) {
		super( attrName );
	}
	@Override
	public String getValueString(BaseAttribute attr) {
        FloatValue val = (FloatValue)attr;
        GregorianCalendar today = new GregorianCalendar();
        int year = today.get(Calendar.YEAR);
        int month = today.get(Calendar.MONTH);
        int day = today.get(Calendar.DAY_OF_MONTH);
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTimeInMillis((long) val.getValue());
        int age = year - cal.get(Calendar.YEAR);
        if ( ( month < cal.get(Calendar.MONTH) ) || 
             ( month == cal.get(Calendar.MONTH) && day < cal.get(Calendar.DAY_OF_MONTH))) {
            age--;
        }
        return String.valueOf(age);
	}
}
