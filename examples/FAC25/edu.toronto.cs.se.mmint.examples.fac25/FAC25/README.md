## FAC 2025 paper

Assurance Case Development for Evolving Software Product Lines: A Formal Approach

### Instructions to reproduce the examples

1. MMINT
    1. Install Java and Eclipse following the [requirements](/README.md#requirements) and add `https://adisandro.github.io/mmint/release` to the list of software sites (`Help > Install New Software > Available Software Sites`).
    2. From the top menu select `Help > Install New Software` and install `Examples > MMINT - FAC25 paper`.
    3. From the top menu select `File > New > Example > MMINT Examples > FAC25`.
    4. Open `/FAC25/model/examples.middiag`.
    5. Double-click on the yellow box named `ac : ProductLine` to open the PL AC. During any of the following steps, right-click in the diagram background and select `Layout > All` to automatically arrange all nodes.

2. Querying AC template (Sec. 7.2)
    1. Right-click in the diagram background, select `MMINT > Import Template`, select the template `/FAC25/templates/QueryAnalysis.gsn`, select the analysis class `/FAC25/src/FAC25/VQLQueryAnalysis.java`.
    2. Right-click on any of the imported nodes, select `MMINT > Instantiate Template`.
    3. Insert the safety goal text `when the alarm is triggered, the system will not immediately administer a dose`, select the PL model `/FAC25/model/R2.productline`, select the query `/FAC25/src/FAC25/queries.vql`, select `Viatra for Product Lines`. The PL AC is populated with the results of the query analysis.

3. Model Checking AC template (Sec. 7.2)
    1. Right-click in the diagram background, select `MMINT > Import Template`, select the template `/FAC25/templates/ModelCheckingAnalysis.gsn`, select the analysis class `/FAC25/src/FAC25/FTS4VMCAnalysis.java`.
    2. (Ids refer to nodes from this template.) Click on the arrow between goal `G0` and strategy `S0`, press delete on your keyboard to delete it, click on the goal `G0`, press delete on your keyboard to delete it, from the palette on the right select `Create supported-by Link`, click on the goal `G3.1` with query result `Alrm_DoseRateHardLimitsViolationS`, click on the strategy `S0` to connect them.
    3. Right-click on any of the imported nodes from this template, select `MMINT > Instantiate Template`.
    4. (This step works only in Linux, requires Python installed, an internet connection, and takes a while to complete. It downloads and uses the FTS4VMC tool at https://github.com/fts4vmc/FTS4VMC.) Insert the property `AG[Alrm_DoseRateHardLimitsViolationS] AX{not Infusion_NormalOperationS}`. The check succeeds and the PL AC is populated with the results of the model checking analysis.

4. AC Regression Analysis (Sec. 7.2.2)
    1. Using the file view on the left, delete file `/FAC25/model/R2.productline`, copy file `/FAC25/model/R2_add.productline` and paste it as `/FAC25/model/R2.productline`, simulating model evolution. You can later reset the example at any time by restoring the original model file `/FAC25/model/R2_orig.productline`.
    2. Right-click on root goal `G0`, select `MMINT > Change Impact`. The PL AC is populated with the results of the regression analysis.
