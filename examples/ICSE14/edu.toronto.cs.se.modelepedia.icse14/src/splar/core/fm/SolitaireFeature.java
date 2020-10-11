package splar.core.fm;

public class SolitaireFeature extends FeatureTreeNode {

	private boolean isOptional = false;
	
	public SolitaireFeature( boolean isOptional,  String id, String name, IFNodeRenderer nodeRenderer ) {		
		super(id,name,nodeRenderer);
		this.isOptional = isOptional;
	}
	
	public boolean isOptional() {
		return isOptional;
	}

	public String toString() {
		String str = "";
		str = isOptional ? ":o " : ":m ";
		return str + super.toString();
	}
	
}
