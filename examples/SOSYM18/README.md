## SoSyM Vol. 19-1 2020 paper

[Heterogeneous Megamodel Management using Collection Operators](https://doi.org/10.1007/s10270-019-00738-9)

Model management techniques help tame the complexity caused by the many models used in large-scale software development; however, these techniques have focused on operators to manipulate individual models rather than entire collections of them. In this work, we begin to address this gap by adapting the widely used map, reduce and filter collection operators for collections of models represented by megamodels. Key parts of this adaptation include the special handling of relationships between models and the use of polymorphism to support heterogeneous model collections. We evaluate the complexity of our operators analytically and demonstrate their applicability on six diverse megamodel management scenarios. We describe our tool support for the approach and evaluate its scalability experimentally as well as its applicability on a practical application from the automotive domain.

### Experiments instructions

1. Install Java and Eclipse following the [requirements](/README.md#requirements), then add `https://adisandro.github.io/mmint/release` to the list of software sites (`Help > Install New Software > Available Software Sites`).
2. Install `Examples > SoSyM18`.
3. Import [this project](https://github.com/adisandro/MMINT/tree/develop/examples/SOSYM18) in your workspace from git (here's an Eclipse tutorial: https://wiki.eclipse.org/EGit/User_Guide#Starting_from_existing_Git_Repositories).
4. Navigate to the scenario you want to run, e.g. `experiments > filter > model` (from now on, let us assume this is the scenario to run).
5. From the menus at the top, select `MMINT > Open Type MID`.
6. On the right, click on `New Operator Type > SOSYM18 > experiments > setup.mid`, give it a name and save.
7. On the right, click on `New Operator Type > SOSYM18 > experiments > filter > model > samples_filter_model.mid`, give it a name and save.
8. Modify `SOSYM18/experiments/filter/model/ExperimentIn.properties` to run the scenarios you want.
9. Open `SOSYM18/experiments/filter/model/filter_model.middiag`, right click anywhere in the canvas, then `MMINT > Run Operator > Experiment<SETUP, SAMPLES> > name from 6 > name from 7`.

