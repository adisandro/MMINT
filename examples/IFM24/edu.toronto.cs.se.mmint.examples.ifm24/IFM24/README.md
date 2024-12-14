## iFM 2024 paper

[PLACIDUS: Engineering Product Lines of Rigorous Assurance Cases](https://doi.org/10.1007/978-3-031-76554-4_6)

In critical software engineering, structured assurance cases (ACs) are used to demonstrate how key properties (e.g., safety, security) are supported by evidence artifacts (e.g., test results, proofs). ACs can also be studied as formal objects in themselves, such that formal methods can be used to establish their correctness. Creating rigorous ACs is particularly challenging in the context of software product lines (SPLs), wherein a family of related software products is engineered simultaneously. Since creating individual ACs for each product is infeasible, AC development methodology must be lifted to the level of product lines. In this work, we propose PLACIDUS, a methodology for integrating formal methods and software product line engineering to develop provably correct ACs for SPLs. To provide rigorous foundations for PLACIDUS, we define a variability-aware AC language and formalize its semantics using the proof assistant Lean. We provide tool support for PLACIDUS as part of an Eclipse-based model management framework. Finally, we demonstrate the feasibility of PLACIDUS by developing an AC for a product line of medical devices.

### Instructions to reproduce the examples

1. MMINT
    1. Install Java and Eclipse following the [requirements](/README.md#requirements) and add `https://adisandro.github.io/mmint/release` to the list of software sites (`Help > Install New Software > Available Software Sites`).
    2. From the top menu select `Help > Install New Software` and install `Examples > MMINT - IFM24 paper`.
    3. From the top menu select `File > New > Example > MMINT Examples > IFM24`.
    4. Open `/IFM24/model/examples.middiag`.
    5. Double-click on the yellow box named `ac : ProductLine` to open the PL AC. During any of the following steps, right-click in the diagram background and select `Layout > All` to automatically arrange all nodes.

2. Querying AC template (Sec. 5.2)
    1. Right-click in the diagram background, select `MMINT > Import Template`, select the template `/IFM24/templates/QueryAnalysis.gsn`, select the analysis class `/IFM24/src/ifm24/VQLQueryAnalysis.java`.
    2. Right-click on any of the imported nodes, select `MMINT > Instantiate Template`.
    3. Insert the safety goal text `the system does not administer a dose until the alarm is disabled`, select the PL model `/IFM24/model/R1.productline`, select the query `/IFM24/src/ifm24/queries.vql`, select `Viatra for Product Lines`. The PL AC is populated with the results of the query analysis.

3. Model Checking AC template (Sec. 5.2)
    1. Right-click in the diagram background, select `MMINT > Import Template`, select the template `/IFM24/templates/ModelCheckingAnalysis.gsn`, select the analysis class `/IFM24/src/ifm24/FTS4VMCAnalysis.java`.
    2. (Ids refer to nodes from this template.) Click on the arrow between goal `G0` and strategy `S0`, press delete on your keyboard to delete it, click on the goal `G0`, press delete on your keyboard to delete it, from the palette on the right select `Create supported-by Link`, click on the goal with query result `Alrm_DoseRateHardLimitsViolationS`, click on the strategy `S0` to connect them.
    3. Right-click on any of the imported nodes from this template, select `MMINT > Instantiate Template`.
    4. (This step works only in Linux, requires Python installed, an internet connection, and takes a while to complete. It downloads and uses the FTS4VMC tool at https://github.com/fts4vmc/FTS4VMC.) Insert the property `AG(Alrm_DoseRateHardLimitsViolationS => A[not(Infusion_NormalOperationS) U (E_ClearAlarmS)])`. The check succeeds and the PL AC is populated with the results of the model checking analysis.
