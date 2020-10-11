package splar.core.fm;

public class TreeNodeRendererFactory {
	
	public static IFNodeRenderer createRootRenderer() {
		return new NodeRenderer("../images/", "root.gif","", false);
	}
	
	public static IFNodeRenderer createGroupedRenderer() {
		return new NodeRenderer("../images/", "grouped.gif","", true);
	}
	
	public static IFNodeRenderer createFeatureGroupRenderer() {
		return new NodeRenderer("../images/", "group.gif","", false);
	}
	
	public static IFNodeRenderer createOptionalRenderer() {
		return new NodeRenderer("../images/", "optional.gif","", true);
	}
	
	public static IFNodeRenderer createMandatoryRenderer() {
		return new NodeRenderer("../images/", "mandatory.gif","", true);
	}
}
