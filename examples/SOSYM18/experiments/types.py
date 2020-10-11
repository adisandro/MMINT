#!/usr/bin/env python3

import sys

if __name__ == '__main__':
    start_num = int(sys.argv[1])
    end_num = int(sys.argv[2])
    for i in range(start_num, end_num):
        print(f"""
   <extension point="org.eclipse.emf.ecore.generated_package">
      <package
            uri="http://se.cs.toronto.edu/modelepedia/PolyModelType{i}"
            class="edu.toronto.cs.se.mmint.mid.MIDPackage"/>
   </extension>

   <extension
         point="edu.toronto.cs.se.mmint.models">
      <modelType>
         <type
               name="PolyModelType{i}"
               uri="http://se.cs.toronto.edu/modelepedia/PolyModelType{i}">
            <superType
                  uri="http://se.cs.toronto.edu/modelepedia/PolyModelType">
            </superType>
         </type>
      </modelType>
   </extension>

   <extension
         point="edu.toronto.cs.se.mmint.editors">
      <editorType
            modelTypeUri="http://se.cs.toronto.edu/modelepedia/PolyModelType{i}"
            id="edu.toronto.cs.se.mmint.mid.presentation.MIDEditorID"
            isDiagram="false"
            wizardId="edu.toronto.cs.se.mmint.mid.presentation.MIDModelWizardID">
         <type
               name="PolyModelType{i} tree"
               uri="http://se.cs.toronto.edu/modelepedia/PolyModelType{i}_Tree">
         </type>
      </editorType>
   </extension>

   <extension
         point="edu.toronto.cs.se.mmint.operators">
      <operatorType>
         <type
               name="Sleep"
               uri="http://se.cs.toronto.edu/modelepedia/Operator_PMT{i}Sleep"
               class="edu.toronto.cs.se.modelepedia.sosym18.operator.Sleep">
            <superType
                  uri="http://se.cs.toronto.edu/modelepedia/Operator_PMTSleep">
            </superType>
         </type>
         <inputs>
            <parameter>
               <type
                     name="poly"
                     uri="http://se.cs.toronto.edu/modelepedia/Operator_PMT{i}Sleep-PT{i}/poly">
                  <superType
                        uri="http://se.cs.toronto.edu/modelepedia/Operator_PMTSleep-PMT/poly">
                  </superType>
               </type>
               <typeEndpoint
                     targetTypeUri="http://se.cs.toronto.edu/modelepedia/PolyModelType{i}">
               </typeEndpoint>
            </parameter>
         </inputs>
         <outputs>
         </outputs>
      </operatorType>
   </extension>

   <extension point="org.eclipse.emf.ecore.generated_package">
      <package
            uri="http://se.cs.toronto.edu/modelepedia/PolyRelType{i}"
            class="edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage"/>
   </extension>

   <extension
         point="edu.toronto.cs.se.mmint.relationships">
      <relationshipType>
         <modelType>
            <type
                  name="PolyRelType{i}"
                  uri="http://se.cs.toronto.edu/modelepedia/PolyRelType{i}">
               <superType
                     uri="http://se.cs.toronto.edu/modelepedia/PolyRelType">
               </superType>
            </type>
         </modelType>
         <modelTypeEndpoint>
            <type
                  name="Endpoint"
                  uri="http://se.cs.toronto.edu/modelepedia/PolyRelType{i}-PolyModelType{i}/Endpoint">
               <superType
                     uri="http://se.cs.toronto.edu/modelepedia/PolyRelType-PolyModelType/Endpoint">
               </superType>
            </type>
            <typeEndpoint
                  lowerBound="1"
                  upperBound="-1"
                  targetTypeUri="http://se.cs.toronto.edu/modelepedia/PolyModelType{i}">
            </typeEndpoint>
         </modelTypeEndpoint>
      </relationshipType>
   </extension>

   <extension
         point="edu.toronto.cs.se.mmint.operators">
      <operatorType>
         <type
               name="Sleep"
               uri="http://se.cs.toronto.edu/modelepedia/Operator_PRT{i}Sleep"
               class="edu.toronto.cs.se.modelepedia.sosym18.operator.Sleep">
            <superType
                  uri="http://se.cs.toronto.edu/modelepedia/Operator_PRTSleep">
            </superType>
         </type>
         <inputs>
            <parameter>
               <type
                     name="poly"
                     uri="http://se.cs.toronto.edu/modelepedia/Operator_PRT{i}Sleep-PRT{i}/poly">
                  <superType
                        uri="http://se.cs.toronto.edu/modelepedia/Operator_PRTSleep-PRT/poly">
                  </superType>
               </type>
               <typeEndpoint
                     targetTypeUri="http://se.cs.toronto.edu/modelepedia/PolyRelType{i}">
               </typeEndpoint>
            </parameter>
         </inputs>
         <outputs>
         </outputs>
      </operatorType>
   </extension>
    """)

