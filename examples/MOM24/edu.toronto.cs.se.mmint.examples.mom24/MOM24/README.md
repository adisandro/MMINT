## MoM@MODELS 2024 paper

From Products to Product Lines: a Model-based Methodology

To effectively manage collections of system and software products, industries are increasingly relying on model-based solutions and product lines (PLs). PLs enable developing, analyzing, and maintaining multiple related products. However, adopting PLs requires tool developers and users to extend existing model management (MoM) frameworks so that they are able to support the lifecycle management of PL models. In this paper, we describe a methodology for doing so. Our methodology identifies four key model management components required to define, transform, and evolve PL models, and relates them to each other and to traditional MoM components. To support rigorous reasoning about MoM of PLs, we combine existing techniques for PL modelling, PL modelling operators, and relations between product and PL models into a unified formal framework. We present an exemplar application of our methodology which extends a product-level modelling tool to support MoM for a product line of medical devices.

### Instructions to reproduce the examples

1. MMINT
    1. Install Java and Eclipse following the [requirements](/README.md#requirements) and add `https://adisandro.github.io/mmint/release` to the list of software sites (`Help > Install New Software > Available Software Sites`).
    2. From the top menu select `Help > Install New Software` and install `Examples > MMINT - MOM24 paper`.
    3. From the top menu select `File > New > Example > MMINT Examples > MOM24`.
    4. Open `/MOM24/model/example.middiag`. During any of the following steps, double-click on any of the yellow boxes to open and view the corresponding model.

2. Washing Machine example (Sec. 4)
    1. The yellow box named `WashingMachine : ProductLine` is the washing machine product line in figure 3c, the yellow box named `Heat : StateMachine` is the washing machine product in figure 3d, the yellow box named `Heat : ProductLine` is the washing machine product in figure 3d annotated with presence conditions for the merge operation.
    2. Right-click on the yellow box named `WashingMachine : ProductLine`, select `MMINT > Run Operator > Derive(ProductLine productLine=WashingMachine)`, select `Yes` to manually assign features, select `Yes` to enable features `Wash` and `Delay`. The resulting yellow box named `WashingMachine_prod : StateMachine` is the washing machine product in figure 3b.
    3. Right-click on the blue/grey box named `match : Overlap`, select `MMINT > Run Operator > Merge(PLModelRel overlap=match)`. The resulting yellow box named `WashingMachine_Heat : ProductLine` is the washing machine product line in figure 3e.
    4. Double-click on the yellow box named `WashingMachine_Heat : ProductLine`, right-click in the diagram background, select `MMINT > Evaluate Query`, select file `/MOM24/src/mom24/example.vql`, select `Viatra for Product Lines`, check that there are no results, select `OK` to finish.
    6. Go back to the `example.middiag` megamodel.
    7. Right-click on the yellow box named `WashingMachine_Heat : ProductLine`, select `MMINT > Run Operator > RemoveFeature(ProductLine pl=WashingMachine_Heat)`, insert `Heat` as the feature to remove. The resulting yellow box named `WashingMachine_Heat_removed : ProductLine` is again the washing machine product line in figure 3c.

