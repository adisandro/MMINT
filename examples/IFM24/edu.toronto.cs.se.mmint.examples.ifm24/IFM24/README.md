## Integrated Formal Methods 2024 paper

PLACIDUS: Engineering Product Lines of Rigorous Assurance Cases

### Instructions to reproduce the examples

1. MMINT
    1. Install Java and Eclipse following the [requirements](/README.md#requirements) and add `https://adisandro.github.io/mmint/develop` to the list of software sites (`Help > Install New Software > Available Software Sites`).
    2. From the top menu select `Help > Install New Software` and install `Examples > MMINT - IFM24 paper`.
    3. From the top menu select `File > New > Example > MMINT Examples > IFM24`.
    4. Open `/IFM24/model/examples.middiag`.
    5. Double-click on the yellow box named `ac : ProductLine` to open the PL AC. During any of the following steps, right-click in the diagram background and select `Layout > All` to automatically arrange all nodes.

2. Querying AC template (Sec. 5.2)
    1. Right-click in the diagram background, select `MMINT > Import Template`, select the template `/IFM24/templates/QueryAnalysis.gsn`, select the analysis class `/IFM24/src/ifm24/VQLQueryAnalysis.java`.
    2. Right-click on any of the imported nodes, select `MMINT > Instantiate Template`.
    3. Insert the safety goal text `the system does not administer a dose`, select the PL model `/IFM24/model/R1.productline`, select the query `/IFM24/src/ifm24/queries.vql`, select `Viatra for Product Lines`. The PL AC is populated with the results of the query analysis.

3. Model Checking AC template (Sec. 5.2)
    1. Right-click in the diagram background, select `MMINT > Import Template`, select the template `/IFM24/templates/ModelCheckingAnalysis.gsn`, select the analysis class `/IFM24/src/ifm24/FTS4VMCAnalysis.java`.
    2. (Ids refer to nodes from this template.) Click on the arrow between goal `G0` and strategy `S0`, press delete on your keyboard to delete it, click on the goal `G0`, press delete on your keyboard to delete it, from the palette on the right select `Create supported-by Link`, click on the goal with query result `Alrm_DoseRateHardLimitsViolationS`, click on the strategy `S0` to connect them.
    3. Right-click on any of the imported nodes from this template, select `MMINT > Instantiate Template`.
    4. (This step works only in Linux, requires Python installed, an internet connection, and takes a while to complete. It downloads and uses the FTS4VMC tool at https://github.com/fts4vmc/FTS4VMC.) Insert the property `AG(Alrm_DoseRateHardLimitsViolationS => A[not(Infusion_NormalOperationS) U (E_ClearAlarmS)])`. The check succeeds and the PL AC is populated with the results of the model checking analysis.
