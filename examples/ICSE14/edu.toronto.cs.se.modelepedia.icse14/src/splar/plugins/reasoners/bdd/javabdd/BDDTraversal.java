package splar.plugins.reasoners.bdd.javabdd;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import net.sf.javabdd.BDD;

public class BDDTraversal {

	protected Set<String> path;
	protected byte[] bddPath; 
	
	public static final byte DONTCARE = 2;
	public static final byte TRUE = 1;
	public static final byte FALSE = 0;
	
	public BDDTraversal() {
		path = new LinkedHashSet<String>();
		bddPath = null;
	}
	
	public void dfs(BDD bdd) {
		path.clear();
		bddPath = new byte[bdd.getFactory().varNum()];
		Arrays.fill(bddPath, (byte)DONTCARE);
		dfsTraversal(bdd);
		onTraversalDone();
	}
	
	protected byte[] getSolution() {
		return bddPath;
	}
	
	protected Set<String> getPath() {
		return path;
	}
	
	public boolean searchStopped() {
		return false;
	}
	
	private void dfsTraversal(BDD bdd) {
		if ( !searchStopped() ) {
			if ( bdd.isOne() ) {
				onOneTerminalFound(path, bddPath);
			}
			else if ( bdd.isZero() ) {
				onZeroTerminalFound(path, bddPath);
			}
			else { 
					
				onVisitingNode(bdd, path, bddPath);
				
				BDD firstNode = bdd.low(), secondNode = bdd.high();
				boolean polarity = false;
				if (!visitLowNodeFirst(bdd) ) {
					firstNode = bdd.high();
					secondNode = bdd.low();
					polarity = true; 
				}
				
				// visit child one
				if ( !searchStopped() ) {
					if ( canVisitNode(bdd, polarity) ) {
						String pathEntry = bdd.var() + ":" + polarity;
						path.add(pathEntry);
						bddPath[bdd.var()] = (byte)((polarity)?TRUE:FALSE);
						dfsTraversal(firstNode);
						bddPath[bdd.var()] = DONTCARE;
						path.remove(pathEntry);
					}
					else {
						onSkippedNode(bdd, polarity, path, bddPath);
					}
				}
				
				// visit child two
				if ( !searchStopped() ) {
					if ( canVisitNode(bdd, !polarity) ) {
						String pathEntry = bdd.var() + ":" + !polarity;
						path.add(pathEntry);
						bddPath[bdd.var()] = (byte)((!polarity)?TRUE:FALSE);
						dfsTraversal(secondNode);
						bddPath[bdd.var()] = DONTCARE;
						path.remove(pathEntry);
					}
					else {
						onSkippedNode(bdd, !polarity, path, bddPath);
					}
				}
					
				onVisitedNode(bdd, path, bddPath);
				bdd.free();
			}
		}
	}
	
	public void onVisitingNode(BDD bddNode, Set<String> path, byte solution[]) {
	}
	
	public void onVisitedNode(BDD bddNode, Set<String> path, byte solution[]) {
	}
	
	public void onZeroTerminalFound(Set<String> path, byte solution[]) {		
	}
	
	public void onOneTerminalFound(Set<String> path, byte solution[]) {		
	}
	
	public boolean canVisitNode(BDD bddNode, boolean polarity) {
		return true;
	}
	
	public void onSkippedNode(BDD bdNode, boolean polarity, Set<String> path, byte solution[]) {		
	}
	
	public boolean visitLowNodeFirst(BDD bddNode) {
		return true;
	}
	
	public void onTraversalDone() {
		
	}
	
}
