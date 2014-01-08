package splar.plugins.configuration.bdd.javabdd.catalog;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import splar.core.fm.FeatureModel;
import splar.core.fm.FeatureTreeNode;
import splar.core.fm.GroupedFeature;


public class ProductCatalog {

	protected FeatureModel featureModel;
	protected Map<String,ProductComponent> concreteComponents;
	protected Map<String,Product> products;
	
	public ProductCatalog(FeatureModel featureModel) {
		this.featureModel = featureModel;
		concreteComponents = new HashMap<String, ProductComponent>();
		products = new LinkedHashMap<String, Product>();
		extractComponentsFromFeatureModel(featureModel.getRoot());
	}
	
	public boolean containsComponent(String componentID) {
		return concreteComponents.containsKey(componentID);
	}
	
	public boolean containsProduct(String productId) {
		return products.containsKey(productId);
	}
	
	public ProductComponent getComponent(String componentID) {
		return concreteComponents.get(componentID);
	}
	
	public Map<String,Product> getProducts() {
		return products;
	}
	
	public Map<String,ProductComponent> getComponents() {
		return concreteComponents;
	}
	
	public List<Product> filterProductsBasedOnFeatureModelSelection() {
		List<Product> filteredProducts = new LinkedList<Product>();
		filteredProducts.addAll(products.values());
		// for each component
		for( ProductComponent component : concreteComponents.values() ) {
			// for each component type
			for( String componentType : component.getTypes() ) {
				FeatureTreeNode featureNode = featureModel.getNodeByID(componentType);
				// if the component type is selected/deselected in the feature model
				if ( featureNode.isInstantiated() ) {
					// for each product 
					for( Iterator<Product> it = filteredProducts.iterator() ; it.hasNext() ; ) {
						Product product = it.next();
						String productComponentType = product.getComponent(component.getID());
						// component type is selected in the feature model but is NOT part of the product - remove product from filter list
						try {
							if ( featureNode.getValue() == 1 && componentType.compareToIgnoreCase(productComponentType) != 0 ) {
								it.remove();
							}
							// or if component type is DEselected in the feature model but IS part of the product - remove product from filter list
							else if ( featureNode.getValue() == 0 && componentType.compareToIgnoreCase(productComponentType) == 0 ) {
								it.remove();
							}						
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		return filteredProducts;
	}
	
	protected void extractComponentsFromFeatureModel(FeatureTreeNode featureNode) {

		if ( featureNode.isLeaf() ) {
			if ( getParentNode(featureNode) != null ) {
				String componentKey = getParentNode(featureNode).getID();
				String componentName = getParentNode(featureNode).getName();
				ProductComponent component = concreteComponents.get(componentKey);
				if ( component == null ) {
					component = new ProductComponent(componentKey, componentName);
					concreteComponents.put(componentKey, component);
				}
				component.addComponentType(featureNode.getID());
			}
		}
		
		for( int i = 0 ; i < featureNode.getChildCount() ; i++ ) {
			extractComponentsFromFeatureModel((FeatureTreeNode)featureNode.getChildAt(i));
		}
		
	}
	
	protected FeatureTreeNode getParentNode(FeatureTreeNode featureNode) {
		if ( featureNode instanceof GroupedFeature ) {
			return (FeatureTreeNode)featureNode.getParent().getParent();
		}
		return (FeatureTreeNode)featureNode.getParent();
	}
	
	public void addProduct(Product product) throws Exception {
//		if 
		products.put(product.getID(), product);
	}
	
	public String toString() {
		String toString = "Product Catalog: " + featureModel.getName() + " [" + concreteComponents.size() + " components, " + products.size() + " products]----------------- \r\n";
		toString += "- Concrete Components \r\n";
		for( ProductComponent component : concreteComponents.values() ) {
			toString += component.toString();
			toString += "\r\n";
		}
		toString += "- Products ------ \r\n";
		for( Product product : products.values() ) {
			toString += product.toString();
			toString += "\r\n";
		}
		return toString;
	}
}
