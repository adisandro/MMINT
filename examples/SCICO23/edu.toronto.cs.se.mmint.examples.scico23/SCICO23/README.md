## SciCo 2023 paper

[MMINT-A: A Framework for Model-Based Safety Assurance](https://doi.org/10.1016/j.scico.2023.103004)

As the complexity of safety-critical systems increases, it becomes more and more challenging to assure that these systems will operate safely and reliably. This has led to the development of industry-specific safety standards that regulate the development of these systems. These standards involve developing model-based safety artifacts to assure the system is safe, such as safety cases and fault trees. Given the significant safety implications of these models, tool assistance is needed to support their creation and management throughout their lifecycle while maintaining traceability to their associated system models.  
To address this need, we have developed *MMINT-A*, a tool-supported framework that facilitates the creation, analysis and evolution of system safety models. In this paper, we report on recent extensions to *MMINT-A* supporting the development of provably correct assurance arguments. We highlight *MMINT-A*'s features, demonstrate them over an example of a fleet of systems for a warehouse facility, and discuss *MMINT-A*'s impact on research in assurance model management.

### Instructions to reproduce the examples

A virtual machine image for VirtualBox with all the required dependencies is available at <https://doi.org/10.5281/zenodo.7478020> (login password `thisisastrongpassword`), letting you skip to step 2.iv.

For more case studies evaluating the property decomposition workflow in step 7, see the [SoSyM 2022](/examples/SOSYM22/edu.toronto.cs.se.mmint.examples.sosym22/SOSYM22/README.md) paper.

1. Lean
    1. Install Lean following the [instructions](/plugins/External/Lean/edu.toronto.cs.se.mmint.lean/README.md).
2. MMINT
    1. Install Java and Eclipse following the [requirements](/README.md#requirements), then add `https://adisandro.github.io/mmint/release` to the list of software sites (`Help > Install New Software > Available Software Sites`).
    2. From the top menu select `Help > Install New Software` and install `Examples > MMINT - SCICO23 paper`.
    3. From the top menu select `MMINT > Lean > Change Lean Mathlib Path` and insert `/path_to_lean_folder/mathlib` (Linux) or `C:\path_to_lean_folder\mathlib` (Windows).
    4. From the top menu select `File > New > Example > MMINT Examples > GSNTemplates`.
    5. From the top menu select `File > New > Example > MMINT Examples > SCICO23`.
    6. Open `/SCICO23/model/example.middiag`.
    7. Double-click on the yellow box named `warehouse : MID` to open the warehouse fleet megamodel.
3. Model management
    1. From the palette on the right select `Import Model`, click anywhere in the diagram background, select file `/SCICO23/model/fcs.lts` to import the Floor Cleaning System model. You can double-click on the new yellow box named `fcs : LTS` to open and view it.
    2. Repeat step i with files `/SCICO23/model/pts.statemachine` and `/SCICO23/model/vss.classdigram` to import the Package Transport System model and the Video Security System model.
4. GSN editor
    1. From the palette on the right select `New Model`, select `GSN > GSN Sirius Diagram`, name it `safety.gsn`, press `Next`, select `Safety Case` as model object, press `Finish`. The GSN editor will open.
    2. From the palette on the right select `Create basic goal`, then click anywhere in the diagram background.
    3. Click to select the newly created goal if not already selected, then from the properties tab on the bottom insert `G0` in the Id field and `All systems in the warehouse fleet operate safely` in the Description field.
5. Domain decomposition
    1. Right-click on the `G0` goal, select `MMINT > Instantiate Template`, then select the template `/GSNTemplates/domain_decomposition.gsn`.
    2. Insert `FCS,PTS,VSS` as the domain to be decomposed.
    3. Insert `FCS` as the first sub-domain.
    4. Insert `PTS` as the second sub-domain.
    5. Insert `VSS` as the third sub-domain.
    6. The decomposition succeeds and the justification node `J.G0` contains the rationale.
    7. Save the GSN model.
6. Megamodel relationships
    1. Go back to the `warehouse.middiag` megamodel.
    2. From the palette on the right select `New Binary Rel`, click on the yellow box named `fcs : LTS` without releasing the mouse button, release it on the yellow box named `safety : GSN`, select `ModelRel` as model relationship type.
    3. Double-click on the blue arrow named `fcs->safety : ModelRel` to open the relationship editor. From the outline tab on the left expand the two model trees, then drag and drop `State Damaged` and `Domain Goal G0.2` anywhere in the relationship diagram. From the palette on the right select `New Binary Mapping`, click on the yellow box named `State Damaged : ModelElement` without releasing the mouse button, release it on the yellow box named `Domain Goal G0.2 : ModelElement`.
    4. Save the model relationship.
    5. Repeat steps i-ii-iii-iv twice. Create a relationship between `pts : StateMachine` and `safety : GSN` by mapping model elements `Initial State Off` and `Domain Goal G0.3`, then create a relationship between `vss : ClassDiagram` and `safety : GSN` by mapping model elements `Class Security Device` and `Domain Goal G0.4`.
7. Property decomposition
    1. Go back to the `safety` GSN editor.
    2. Right-click on the goal named `G0.2`, select `MMINT > Instantiate Template`, then select the template `/GSNTemplates/property_decomposition.gsn`.
    3. Select `Absence > $X is not reached` as the property to be decomposed, then select `State Damaged` for variable `$X`.
    4. Insert `2` as the number of sub-properties.
    5. Select `Transitions > Do not begin from $X` as the first sub-property, then select `State Damaged` for variable `$X`.
    6. Select `Transitions > Never transition into $X` as the second sub-property, then select `State Damaged` for variable `$X`.
    7. The decomposition succeeds and the GSN justification node `J.G0.2` points to the results. Optionally right-click, then `Layout > Arrange All` to auto-arrange all the GSN elements.
    8. Save the GSN model.
8. Querying
    1. Go back to the `warehouse.middiag` megamodel.
    2. Right-click anywhere in the diagram background, select `MMINT > Evaluate Query`, select file `/SCICO23/src/scico23/example.vql`, select query `noOutgoingTransitions`, check the result(s) textually and visually, select `Done + Store Results`.
