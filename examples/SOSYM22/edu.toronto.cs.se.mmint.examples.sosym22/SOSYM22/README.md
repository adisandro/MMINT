## SoSyM Vol. 22-5 2022 paper

[The ForeMoSt Approach to Building Valid Model-Based Safety Arguments](https://doi.org/10.1007/s10270-022-01063-4)

*Safety assurance cases* (ACs) are structured arguments designed to comprehensively show that a system is safe. ACs are often *model-based*, meaning that a model of the system is a primary subject of the argument. ACs use reasoning steps called *strategies* to decompose high-level claims about system safety into refined subclaims that can be directly supported by evidence. Strategies are often informal and difficult to rigorously evaluate in practice, and consequently, AC arguments often contain reasoning errors. This has led to the deployment of unsafe systems, and caused severe real-world consequences. These errors can be mitigated by formalizing and verifying AC strategies using formal methods; however, these techniques are difficult to use without formal methods expertise. To mitigate potential challenges faced by engineers when developing and interpreting formal ACs, we present ForeMoSt, our tool-supported framework for rigorously validating AC strategies using the Lean theorem prover. The goal of the framework is to straddle the level of abstraction used by the theorem prover and by software engineers. We use case studies from the literature to demonstrate that ForeMoSt is able to (i) augment and validate ACs from the research literature, (ii) support AC development for systems with large models, and (iii) support different model types.

### Instructions to reproduce the examples

A virtual machine image for VirtualBox with all the required dependencies is available at <https://doi.org/10.5281/zenodo.6360844> (login password `thisisastrongpassword`), letting you skip to step 2.iv.

We can't share the K9 Mars Rover case study (Sec. 6.2). To illustrate the use of queries, we provide an alternative FCS example.

1. Lean
    1. Install Lean following the [instructions](/plugins/External/Lean/edu.toronto.cs.se.mmint.lean/README.md).
2. MMINT
    1. Install Java and Eclipse following the [requirements](/README.md#requirements) and add `https://adisandro.github.io/mmint/release` to the list of software sites (`Help > Install New Software > Available Software Sites`).
    2. From the top menu select `Help > Install New Software` and install `Examples > MMINT - SOSYM22 paper`.
    3. From the top menu select `MMINT > Lean > Change Lean Mathlib Path` and insert `/path_to_lean_folder/mathlib` (Linux) or `C:\path_to_lean_folder\mathlib` (Windows).
    4. From the top menu select `File > New > Example > MMINT Examples > GSNTemplates`.
    5. From the top menu select `File > New > Example > MMINT Examples > SOSYM22`.
    6. Open `/SOSYM22/model/examples.middiag`.
    7. Double-click on the yellow box named `sc : GSN` to open the GSN safety case.
3. FCS example (Sec. 5):
    1. Right-click in the diagram background, select `MMINT > Import Template`, select the template `/GSNTemplates/FormalStrategies/property_decomposition.gsn`.
    2. Click on the claim named `G1`, press delete on your keyboard to delete it, from the palette on the right select `Create Supported-by Link`, click on the claim named `C1`, click on the strategy named `S1.G1` to connect them.
    3. Right-click on any of the imported nodes, select `MMINT > Instantiate Template`.
    4. Select `Absence > $X is not reached` as the property to be decomposed, select `State Damaged` for variable `$X`.
    5. Insert `2` as the number of sub-properties.
    6. Select `Transitions > Do not begin from $X` as the first sub-property, select `State Damaged` for variable `$X`.
    7. Select `Transitions > Never transition into $X` as the second sub-property, select `State Damaged` for variable `$X`.
    8. The decomposition succeeds and the GSN justification node `J1.C1` points to the results.
4. FCS example (alternative with query):
    1. Right-click in the diagram background, select `MMINT > Import Template`, select the template `/GSNTemplates/FormalStrategies/property_decomposition.gsn`.
    2. Click on the claim named `G1`, press delete on your keyboard to delete it, from the palette on the right select `Create Supported-by Link`, click on the claim named `C1`, click on the strategy named `S1.G1` to connect them.
    3. Right-click on any of the imported nodes, select `MMINT > Instantiate Template`.
    4. Select `Absence > $X is not reached` as the property to be decomposed, select `Run query to select elements`, `/SOSYM22/src/sosym22/query.vql` as query file, `damaged` as query, insert `Selects the state named Damaged` as description.
    5. Insert `2` as the number of sub-properties.
    6. Select `Transitions > Do not begin from $X` as the first sub-property, select `Run query to select elements`, `/SOSYM22/src/sosym22/query.vql` as query file, `damaged` as query.
    7. Select `Transitions > Never transition into $X` as the second sub-property, select `Run query to select elements`, `/SOSYM22/src/sosym22/query.vql` as query file, `damaged` as query.
    8. The decomposition succeeds and the GSN justification node `J1.C1` points to the results.
5. PCA Infusion Pump case study (Sec. 6.1):
    1. Right-click in the diagram background, select `MMINT > Import Template`, select the template `/GSNTemplates/FormalStrategies/property_decomposition.gsn`.
    2. Click on the claim named `G1`, press delete on your keyboard to delete it, from the palette on the right select `Create Supported-by Link`, click on the claim named `C2`, click on the strategy named `S1.G1` to connect them.
    3. Right-click on any of the imported nodes, select `MMINT > Instantiate Template`.
    4. Select `Absence > $X is not reached after $A and until $B` as the property to be decomposed, select `State BolusRequest` for variable `$X`, `Transition Cond_6_3?` for variable `$A`, `State Infusion_NormalOperation` for variable `$B`.
    5. Insert `3` as the number of sub-properties.
    6. Select `Response > If $X is reached, $Y must follow $X` as the first sub-property, select `Transition Cond_6_3?` for variable `$X`, `State Alrm_EmptyReservoir` for variable `$Y`.
    7. Select `Absence > $X is not reached between $A and $B` as the second sub-property, select `State BolusRequest` for variable `$X`, `Transition Cond_6_3?` for variable `$A`, `State Alrm_EmptyReservoir` for variable `$B`.
    8. Select `Absence > $X is not reached after $A and until $B` as the third sub-property, select `State BolusRequest` for variable `$X`, `State Alrm_EmptyReservoir` for variable `$A`, `State Infusion_NormalOperation` for variable `$B`.
    9. The decomposition succeeds and the GSN justification node `J1.C2` points to the results.
6. LACU case study (Sec. 6.3):
    1. Right-click in the diagram background, select `MMINT > Import Template`, select the template `/GSNTemplates/FormalStrategies/property_decomposition.gsn`.
    2. Click on the claim named `G1`, press delete on your keyboard to delete it, from the palette on the right select `Create Supported-by Link`, click on the claim named `C3`, click on the strategy named `S1.G1` to connect them.
    3. Right-click on any of the imported nodes, select `MMINT > Instantiate Template`.
    2. Copy and paste the contents of file `/SOSYM22/model/lacu_properties/parent.property` as the property to be decomposed, insert `The subcontracts induce a correct decomposition of the LACU contract` as description.
    3. Insert `3` as the number of sub-properties.
    4. Copy and paste the contents of file `/SOSYM22/model/lacu_properties/child1.property` as the first sub-property, insert `The armPosition component correctly implements its contract` as description.
    5. Copy and paste the contents of file `/SOSYM22/model/lacu_properties/child2.property` as the second sub-property, insert `The armController component correctly implements its contract` as description.
    6. Copy and paste the contents of file `/SOSYM22/model/lacu_properties/child3.property` as the third sub-property, insert `The LAAP component correctly implements its contract` as description.
    7. The decomposition succeeds and the GSN justification node `J1.C3` points to the results.
