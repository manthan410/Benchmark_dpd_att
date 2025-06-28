
import java.util.ArrayList;
import org.eclipse.cdt.core.dom.ast.ASTVisitor;
import org.eclipse.cdt.core.dom.ast.IASTDeclaration;
import org.eclipse.cdt.core.dom.ast.IASTFileLocation;
import org.eclipse.cdt.core.dom.ast.IASTName;
class ReferenceVisitor extends ASTVisitor {
	private ArrayList<IASTName> fReferences = new ArrayList<>();
	private int fOffset;
	private int fEndOffset;
	private String fFileName;
	ReferenceVisitor(String fileName, int offset, int length) {
		shouldVisitNames = true;
		shouldVisitDeclarations = true;
		fFileName = fileName;
		fOffset = offset;
		fEndOffset = offset + length;
	}
	public IASTName[] getReferences() {
		return fReferences.toArray(new IASTName[fReferences.size()]);
	}
	@Override
	public int visit(IASTName name) {
		if (name.isReference()) {
			IASTFileLocation loc = name.getFileLocation();
			if (!loc.getFileName().equals(fFileName)) {
				return PROCESS_SKIP;
			}
			int offset = loc.getNodeOffset();
			if (fOffset <= offset && offset + loc.getNodeLength() <= fEndOffset) {
				fReferences.add(name);
			}
		}
		return super.visit(name);
	}
	@Override
	public int visit(IASTDeclaration declaration) {
		IASTFileLocation loc = declaration.getFileLocation();
		if (loc != null) {
			if (!loc.getFileName().equals(fFileName)) {
				return PROCESS_SKIP;
			}
			int offset = loc.getNodeOffset();
			if (offset + loc.getNodeLength() <= fOffset || fEndOffset <= offset) {
				return PROCESS_SKIP;
			}
		}
		return PROCESS_CONTINUE;
	}
}
