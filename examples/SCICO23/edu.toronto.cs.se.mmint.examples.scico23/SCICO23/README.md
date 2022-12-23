## SciCo 2023 paper

MMINT-A: A Framework for Model-Based Safety Assurance

## Instructions to reproduce the examples

This example runs natively on Linux only.  
Alternatively, a virtual machine image for VirtualBox with all the required dependencies is available at <https://doi.org/TODO> (login password `thisisastrongpassword`), letting you skip to step 2.5.

1. Lean
    1. Download and extract the Lean theorem prover from [here](https://oleanstorage.azureedge.net/releases/bundles/trylean_linux.tar.gz).
    2. `mkdir -p ~/.local/bin; cd ~/.local/bin; ln -s /path_to_lean_folder/lean/bin/lean lean`.
2. MMINT
    1. Install Java and Eclipse following the [requirements](/README.md#requirements), then add `https://adisandro.github.io/mmint/release` to the list of software sites (`Help > Install New Software > Available Software Sites`).
    2. From the top menu select `Help > Install New Software` and install `Examples > MMINT - SCICO23 paper`.
    3. From the top menu select `MMINT > Lean > Change Lean Mathlib Path` and insert `/path_to_lean_folder/mathlib`.
    4. From the top menu select `Window > Show View > Other > General > Properties` (TODO others?).
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
    1. Right-click on the `G0` goal and select `MMINT > Domain Decomposition`.
    2. Insert `FCS,PTS,VSS` as the domain to be decomposed.
    3. Insert `FCS` as the first sub-domain.
    4. Insert `PTS` as the second sub-domain.
    5. Insert `VSS` as the third sub-domain.
    6. The decomposition succeeds and the justification node `J.G0` contains the rationale.
6. Megamodel relationships
    1. Go back to the `warehouse.middiag` megamodel.
    2. From the palette on the right select `New Binary Rel`, click on the yellow box named `fcs : LTS` without releasing the mouse button, release it on the yellow box named `safety : GSN`, select `ModelRel` as model relationship type.
    3. Double-click on the blue arrow named `fcs->safety : ModelRel` to open the relationship editor. From the outline tab on the left expand the two model trees, then drag and drop `State Damaged` and `Domain Goal G0.2` anywhere in the relationship diagram. From the palette on the right select `New Binary Mapping`, click on the yellow box named `State Damaged : ModelElement` without releasing the mouse button, release it on the yellow box named `Domain Goal G0.2 : ModelElement`.
    4. Repeat steps i-ii-iii twice. Create a relationship between `pts : StateMachine` and `safety : GSN` by mapping model elements `Initial State Off` and `Domain Goal G0.3`, then create a relationship between `vss : ClassDiagram` and `safety : GSN` by mapping model elements `Class Security Device` and `Domain Goal G0.4`.
7. Property decomposition
    1. Go back to the `safety` GSN editor.
    2. Right-click on the goal named `G0.2` and select `MMINT > Property Decomposition`.
    3. Select `Absence > $X is not reached` as the property to be decomposed, then select `State Damaged` for variable `$X`.
    4. Insert `2` as the number of sub-properties.
    5. Select `Transitions > Do not begin from $X` as the first sub-property, then select `State Damaged` for variable `$X`.
    6. Select `Transitions > Never transition into $X` as the second sub-property, then select `State Damaged` for variable `$X`.
    7. The decomposition succeeds and the GSN justification node `J.G0.2` points to the results.
8. Querying
    1. Go back to the `warehouse.middiag` megamodel.
    2. Right-click in the diagram background, select `MMINT > Evaluate Query`, select file `/SCICO23/src/scico23/example.vql`, select query `noOutgoingTransitions`, check the result(s), select `Done + Store Results`.
