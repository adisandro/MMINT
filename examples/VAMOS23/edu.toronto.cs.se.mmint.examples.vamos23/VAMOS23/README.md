## VAMOS 2023 paper

Adding Product-Line Capabilities to Your Favourite Modeling Language

## Instructions to reproduce the examples

1. MMINT
    1. Add `https://adisandro.github.io/mmint/release` to the list of software sites in Eclipse (`Help > Install New Software > Available Software Sites`) unless MMINT is already installed.
    2. From the top menu select `Help > Install New Software` and install `Examples > MMINT - VAMOS23 paper`.
    3. From the top menu select `File > New > Example > MMINT Examples > VAMOS23`.
2. Washing Machine example (Sec. 4):
    1. Open `/VAMOS23/model/WashingMachine/WashingMachine.middiag`.
    2. Run a Product Line query:
        1. Right-click in the background, select `MMINT > Evaluate Query`, select file `/VAMOS23/src/vamos23/example.vql`, select reasoner `Viatra for Product Lines`, select query `twoOutgoingTransitions`, check the result(s), answer `No` when asked to store the results.
        2. Repeat step 1 with query `numOutgoingTransitions`.
    3. Run a Product query:
        1. Right-click on the yellow box named `WashingMachine : ProductLine`, select `MMINT > Run Operator > ToProduct(ProductLine productLine=WashingMachine)`, answer `Yes` when asked to manually assign features, answer `Yes` to the features you want to enable.
        2. Repeat step 1 if the product instantiation fails because of the feature model constraints, or double-click on the yellow box named `WashingMachine_prod : StateMachine` to view the state machine product.
        3. Right-click in the background, select `MMINT > Evaluate Query`, select file `/VAMOS23/src/vamos23/example.vql`, select reasoner `Viatra`, select query `twoOutgoingTransitions`, check the result(s), answer `No` when asked to store the results.
        4. To repeat steps 1-2-3 with a different product, right-click on the yellow box named `WashingMachine_prod : StateMachine` and select `Delete from Model`.
        2. Repeat steps 1-2-3-4 with query `numOutgoingTransitions`.
3. Evaluation (Sec. 5):
