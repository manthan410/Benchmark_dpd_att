
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.BadPositionCategoryException;
import org.eclipse.jface.text.DefaultPositionUpdater;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IPositionUpdater;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.ITextViewerExtension;
import org.eclipse.jface.text.ITextViewerExtension5;
import org.eclipse.jface.text.Position;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.custom.StyledTextContent;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSourceAdapter;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.ui.texteditor.ITextEditorExtension;
public class TextViewerDragAdapter extends DragSourceAdapter {
	public final static String DRAG_SELECTION_CATEGORY = "dragSelectionCategory"; 
	private IPositionUpdater fPositionUpdater;
	private Position fSelectionPosition;
	private ITextViewer fViewer;
	private ITextEditorExtension fEditor;
	private boolean fIsEnabled = true;
	public TextViewerDragAdapter(ITextViewer viewer) {
		this(viewer, null);
	}
	public TextViewerDragAdapter(ITextViewer viewer, ITextEditorExtension editor) {
		fViewer = viewer;
		fEditor = editor;
	}
	@Override
	public void dragFinished(DragSourceEvent event) {
		IDocument doc = fViewer.getDocument();
		try {
			doc.removePositionCategory(DRAG_SELECTION_CATEGORY);
			doc.removePositionUpdater(fPositionUpdater);
		} catch (BadPositionCategoryException e1) {
		}
		if (event.doit && event.detail == DND.DROP_MOVE && isDocumentEditable()) {
			try {
				doc.replace(fSelectionPosition.offset, fSelectionPosition.length, null);
			} catch (BadLocationException e) {
			}
		}
		if (fViewer instanceof ITextViewerExtension) {
			((ITextViewerExtension) fViewer).getRewriteTarget().endCompoundChange();
		}
	}
	@Override
	public void dragSetData(DragSourceEvent event) {
		IDocument doc = fViewer.getDocument();
		try {
			event.data = doc.get(fSelectionPosition.offset, fSelectionPosition.length);
		} catch (BadLocationException e) {
			event.detail = DND.DROP_NONE;
			event.doit = false;
		}
	}
	@Override
	public void dragStart(DragSourceEvent event) {
		if (!fIsEnabled) {
			event.doit = false;
			return;
		}
		int offset = getOffsetAtLocation(event.x, event.y, false);
		offset = getDocumentOffset(offset);
		Point selection = fViewer.getSelectedRange();
		if (selection != null && offset >= selection.x && offset < selection.x + selection.y) {
			fSelectionPosition = new Position(selection.x, selection.y);
			if (fViewer instanceof ITextViewerExtension) {
				((ITextViewerExtension) fViewer).getRewriteTarget().beginCompoundChange();
			}
			IDocument doc = fViewer.getDocument();
			try {
				doc.addPositionCategory(DRAG_SELECTION_CATEGORY);
				fPositionUpdater = new DefaultPositionUpdater(DRAG_SELECTION_CATEGORY);
				doc.addPositionUpdater(fPositionUpdater);
				doc.addPosition(DRAG_SELECTION_CATEGORY, fSelectionPosition);
			} catch (BadLocationException e) {
			} catch (BadPositionCategoryException e) {
			}
			event.doit = true;
			event.detail = DND.DROP_COPY;
			if (isDocumentEditable()) {
				event.detail |= DND.DROP_MOVE;
			}
		} else {
			event.doit = false;
			event.detail = DND.DROP_NONE;
		}
	}
	private int getOffsetAtLocation(int x, int y, boolean absolute) {
		StyledText textWidget = fViewer.getTextWidget();
		StyledTextContent content = textWidget.getContent();
		Point location;
		if (absolute) {
			location = textWidget.toControl(x, y);
		} else {
			location = new Point(x, y);
		}
		int line = (textWidget.getTopPixel() + location.y) / textWidget.getLineHeight();
		if (line >= content.getLineCount()) {
			return content.getCharCount();
		}
		int lineOffset = content.getOffsetAtLine(line);
		String lineText = content.getLine(line);
		Point endOfLine = textWidget.getLocationAtOffset(lineOffset + lineText.length());
		if (location.x >= endOfLine.x) {
			return lineOffset + lineText.length();
		}
		try {
			return textWidget.getOffsetAtLocation(location);
		} catch (IllegalArgumentException iae) {
			return -1;
		}
	}
	private int getDocumentOffset(int widgetOffset) {
		if (fViewer instanceof ITextViewerExtension5) {
			ITextViewerExtension5 extension = (ITextViewerExtension5) fViewer;
			return extension.widgetOffset2ModelOffset(widgetOffset);
		}
		IRegion visible = fViewer.getVisibleRegion();
		if (widgetOffset > visible.getLength()) {
			return -1;
		}
		return widgetOffset + visible.getOffset();
	}
	private boolean isDocumentEditable() {
		if (fEditor != null) {
			return !fEditor.isEditorInputReadOnly();
		}
		return fViewer.isEditable();
	}
	public void setEnabled(boolean enabled) {
		fIsEnabled = enabled;
	}
}
