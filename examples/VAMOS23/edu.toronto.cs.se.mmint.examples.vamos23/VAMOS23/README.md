## VaMoS 2023 paper

Adding Product-Line Capabilities to Your Favourite Modeling Language

Evaluation results are [here](model).

## Instructions to reproduce the examples

The evaluation requires Python >= 3.10.

1. MMINT-PL
    1. Install Java and Eclipse following the [requirements](/README.md#requirements), then add `https://adisandro.github.io/mmint/release` to the list of software sites (`Help > Install New Software > Available Software Sites`).
    2. From the top menu select `Help > Install New Software` and install `Examples > MMINT - VAMOS23 paper`.
    3. From the top menu select `File > New > Example > MMINT Examples > VAMOS23`.
2. Washing Machine example (Sec. 4):
    1. Open `/VAMOS23/model/WashingMachine/WashingMachine.middiag`.
    2. Run a Product Line query:
        1. Right-click in the diagram background, select `MMINT > Evaluate Query`, select file `/VAMOS23/src/vamos23/example.vql`, select reasoner `Viatra for Product Lines`, select query `twoOutgoingTransitions`, check the result(s), select `Done` to finish.
        2. Repeat step a with query `numOutgoingTransitions`.
    3. Run a Product query:
        1. Right-click on the yellow box named `WashingMachine : ProductLine`, select `MMINT > Run Operator > ToProduct(ProductLine productLine=WashingMachine)`, answer `Yes` when asked to manually assign features, answer `Yes` to the features you want to enable.
        2. Repeat step a if the product instantiation fails because of the feature model constraints, or double-click on the yellow box named `WashingMachine_prod : StateMachine` to view the state machine product.
        3. Right-click in the diagram background, select `MMINT > Evaluate Query`, select file `/VAMOS23/src/vamos23/example.vql`, select reasoner `Viatra`, select query `twoOutgoingTransitions`, check the result(s), select `Done` to finish.
        4. To repeat steps a-b-c with a different product, right-click on the yellow box named `WashingMachine_prod : StateMachine` and select `Delete from Model`.
        2. Repeat steps a-b-c-d with query `numOutgoingTransitions`.
3. Evaluation (Sec. 5):
    1. From the top menu select `MMINT > Open Type MID`.
    2. Click on `New Operator Type` in the palette, click in the diagram background, select `VAMOS23 > model > setup_evaluation.mid`, choose a name.
    3. Repeat step ii using `VAMOS23 > model > samples_evaluation.mid`.
    4. Open `/VAMOS23/model/X/X.middiag`, where `X` is one of `Automata`, `bCMS-SPL-PC`, `crom_l1`, `GPL`.
    5. Right-click on the yellow box named `X : ProductLine`, select `MMINT > Run Operator > Experiment<SETUP,SAMPLES>(Model inputs=X)`, choose the name you entered in step ii, then choose the name you entered in step iii and the experiment will take some time to collect samples for statistical significance.
    6. Open a command line at `/VAMOS23/model` and run `python3 collect.py X PL`.
    7. Repeat the next steps viii-ix, where `Y` is one of `0`, `1`, `2`, `3`, `4`.
    8. Right-click on the yellow box named `X_prodY : ClassDiagram`, select `MMINT > Run Operator > Experiment<SETUP,SAMPLES>(Model inputs=X)`, choose the name you entered in step ii, then choose the name you entered in step iii and the experiment will take some time to collect samples for statistical significance.
    9. Open a command line at `/VAMOS23/model` and run `python3 collect.py X PY`.
    10. Open a command line at `/VAMOS23/model`, run `python3 average.py X` and check the results.
