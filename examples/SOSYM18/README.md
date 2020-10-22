Instructions to run experiments:

1. Add `https://adisandro.github.io/mmint/release` to the list of software sites in Eclipse.
2. Install `Examples > SoSyM18`.
3. Import [this project](https://github.com/adisandro/MMINT/tree/develop/examples/SOSYM18) in your workspace from git (here's an Eclipse tutorial: https://wiki.eclipse.org/EGit/User_Guide#Starting_from_existing_Git_Repositories).
4. Navigate to the scenario you want to run, e.g. `experiments > filter > model` (from now on, let us assume this is the scenario to run).
5. From the menus at the top, select `MMINT > Open Type MID`.
6. On the right, click on `New Operator Type > SOSYM18 > experiments > setup.mid`, give it a name and save.
7. On the right, click on `New Operator Type > SOSYM18 > experiments > filter > model > samples_filter_model.mid`, give it a name and save.
8. Modify `SOSYM18/experiments/filter/model/ExperimentIn.properties` to run the scenarios you want.
9. Open `SOSYM18/experiments/filter/model/filter_model.middiag`, right click anywhere in the canvas, then `MMINT > Run Operator > Experiment<SETUP, SAMPLES> > name from 6 > name from 7`.
