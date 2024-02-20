## SafeComp 2024 paper

Assuring Reliability of Machine Learning-based Components

### Instructions to reproduce the examples

1. MMINT
    1. Install Java and Eclipse following the [requirements](/README.md#requirements) and add `https://adisandro.github.io/mmint/release` to the list of software sites (`Help > Install New Software > Available Software Sites`).
    2. From the top menu select `Help > Install New Software` and install `Examples > MMINT - SAFECOMP24 paper`.
    3. From the top menu select `File > New > Example > MMINT Examples > GSNTemplates`.
    4. From the top menu select `File > New > Example > MMINT Examples > SAFECOMP24`.
    5. Open `/SAFECOMP24/model/example.middiag`.
    6. Double-click on the yellow box named `ac : GSN` to open the GSN assurance case.

2. AMLAS-r stages 1-2 + assurance queries
    1. Right-click in the diagram background, select `MMINT > Import Template`, select the template `/GSNTemplates/AMLAS-r/stage1.gsn`.
    2. Right-click on any of the imported nodes from stage 1, select `MMINT > Instantiate Template`.
    3. Insert any text to replace placeholders, select `/SAFECOMP24/files/C1_1.py` when asked to instantiate the file for context `C1.1`.
    4. Right-click in the diagram background, select `MMINT > Import Template`, select the template `/GSNTemplates/AMLAS-r/stage2.gsn`.
    5. Click on the goal `G2.1`, press delete on your keyboard to delete it, from the palette on the right select `Create supported-by Link`, click on the goal `G1.1`, click on the strategy `S2.1` to connect them.
    6. Right-click on any of the imported nodes from stage 2, select `MMINT > Instantiate Template`.
    7. (This step works only in Linux, requires Python installed, and will take a few minutes to complete) Insert 1 as the number of sub-trees for changes, insert 1 as the number of sub-trees for safety requirements, insert any text to replace placeholders, select `/SAFECOMP24/files/{C2_1.py, C2_2.py, C2_3.py, C2_92_fail.py, C2_95.py, C2_98_fail.py}` when asked to instantiate the files for contexts `{C2.1, C2.2, C2.3, C2.92, C2.95, C2.98}`.
    8. The validation of the template fails and the goal `G2.92` is highlighted in red.
    9. Save the GSN diagram, right-click in the diagram background, select `MMINT > Evaluate Query`, select file `/SAFECOMP24/src/safecomp24/queries.vql`, select query `numInvalidElems`, check the result, select `Done`.
    10. Select context `C2.92`, select the Properties tab at the bottom and the Semantic sub-tab, click on the Paths property and change it to the `C2_92_pass.py` file.
    11. Repeat step 10 for context `C2.98`.
    12. (This step works only in Linux and requires Python installed) Right-click on any of the imported nodes from stage 2, select `MMINT > Validate Template`.
    13. The validation of the template succeeds.
    14. Save the GSN diagram, repeat step 9 and check the different result.
