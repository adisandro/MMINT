package splar.plugins.reasoners.sat.sat4j;

import java.util.Map;
import java.util.Random;

import org.sat4j.core.LiteralsUtils;
import org.sat4j.minisat.core.ILits2;
import org.sat4j.minisat.orders.VarOrder;

public class StaticVariableOrderSAT extends VarOrder<ILits2> {

    private static final long serialVersionUID = 1L;

    private String[] varOrder; 
    private Map<String,Integer> varName2IndexMap;
    private String[] varIndex2NameMap;
    private Boolean phase = false;  // false: negative first, true: positive first, null: random
    private int valueOrder[] = null;
    
    public StaticVariableOrderSAT(String varOrder[], Boolean phase, Map<String,Integer> varName2IndexMap, String[] varIndex2NameMap) {
    	this.varOrder = varOrder;
    	this.varName2IndexMap = varName2IndexMap;
    	this.varIndex2NameMap = varIndex2NameMap;
    	this.phase = phase;
    	this.valueOrder = null;
    }
    
    public void setPhase(boolean phase) {
    	this.phase = phase;
    }
    
    public void setValueOrder(int valueOrder[]) {
    	if ( this.valueOrder == null ) {
    		this.valueOrder = new int[valueOrder.length];
    	}
    	System.arraycopy(valueOrder, 0, this.valueOrder, 0, valueOrder.length);
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.sat4j.minisat.IHeuristics#init()
     */
    @Override
    public void init() {
        super.init();
        
        if ( valueOrder == null ) {
        	Random random = new Random();
	        for( int i = 0 ; i < varOrder.length ; i++ ) {
	        	int varIndex = varName2IndexMap.get(varOrder[i]);
	        	// random
	        	if ( phase == null ) {
	        		order[i+1] = ( random.nextBoolean() ) ?  LiteralsUtils.posLit(varIndex) : LiteralsUtils.negLit(varIndex);
	        	}
	        	// positive first
	        	else if (phase.booleanValue()) {
	        		order[i+1] = LiteralsUtils.posLit(varIndex);
	        	}
	        	// negative first
	        	else {
	        		order[i+1] = LiteralsUtils.negLit(varIndex);
	        	}
//        		System.out.print(varOrder[i] + ": " + ((order[i+1]%2==1) ? "false" : "true") + ", ");
	            varpos[varIndex] = i+1;
	        }
        }
        else {
        	for( int i = 0 ; i < valueOrder.length ; i++ ) {
	        	int varIndex = varName2IndexMap.get(varOrder[i]);
        		order[i+1] = (valueOrder[i] == 1) ? LiteralsUtils.posLit(varIndex) : LiteralsUtils.negLit(varIndex);
	            varpos[varIndex] = i+1;
        	}
        }
        lastVar = 1;
    }

    @Override
    public String toString() {
        return "Init VSIDS order with binary clause occurrences."; //$NON-NLS-1$
    }
}




