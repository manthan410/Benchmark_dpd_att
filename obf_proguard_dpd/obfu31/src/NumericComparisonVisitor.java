
import java.math.BigDecimal;
import java.math.BigInteger;
import org.mindswap.pellet.exceptions.InternalReasonerException;
public class NumericComparisonVisitor implements NumericVisitor {
	private int result;
	private void argCheck(Number[] args) {
		if ( args.length != 2 )
			throw new InternalReasonerException( "Wrong number of arguments to comparison visitor." );
	}
	public int getComparison() { return result; }
	public void visit(BigDecimal[] args) {
		argCheck( args );
		result = args[0].compareTo( args[1] );
	}
	public void visit(BigInteger[] args) {
		argCheck( args );
		result = args[0].compareTo( args[1] );
	}
	public void visit(Double[] args) {
		argCheck( args );
		result = args[0].compareTo( args[1] );
	}
	public void visit(Float[] args) {
		argCheck( args );
		result = args[0].compareTo( args[1] );
	}
}
