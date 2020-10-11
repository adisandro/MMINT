package splar.core.fm;

public interface FTTraversalNodeSelector {

	// returns true if node matches the selection criteria, false otherwise
	public boolean select(FeatureTreeNode node);
}
