## SOSYM 2022 paper

A Lean Approach to Building Valid Model-Based Safety Arguments

## Instructions to reproduce the examples

This example runs natively on Linux only.

Alternatively, a virtual machine image for VirtualBox with all the required dependencies is available at <https://doi.org/10.5281/zenodo.5110436>, letting you skip to step 2.4.

1. Lean
    1. Download and extract the Lean theorem prover from here: <https://oleanstorage.azureedge.net/releases/bundles/trylean_linux.tar.gz>
    2. `mkdir -p ~/.local/bin; cd ~/.local/bin; ln -s /path_to_lean_folder/lean/bin/lean lean`
2. MMINT
    1. Add `https://adisandro.github.io/mmint/release` to the list of software sites in Eclipse (`Help > Install New Software > Available Software Sites`) unless MMINT is already installed.
    2. From the top menu select `Help > Install New Software` and install `Examples > MMINT - SOSYM22 paper`.
    3. From the top menu select `MMINT > Lean > Change Lean Mathlib Path` and insert `/path_to_lean_folder/mathlib`.
    4. From the top menu select `File > New > Example > MMINT Examples > SOSYM22`.
    5. Open `/SOSYM22/examples.middiag`.
    6. Double-click on the yellow box named `sc : GSN` to open the GSN safety case.
3. FCS example (Sec. 5):
    1. Right-click on the claim named `C1` and select `MMINT > Property Decomposition`.
    2. Select `Absence > $X is not reached` as the property to be decomposed, then select `State Damaged` for variable `$X`.
    3. Insert `2` as the number of sub-properties.
    4. Select `Transitions > Do not begin from $X` as the first sub-property, then select `State Damaged` for variable `$X`.
    5. Select `Transitions > Never transition out of $X` as the second sub-property, then select `State Damaged` for variable `$X`. The decomposition fails, the user is notified about possible corrective actions, and the GSN justification node `J.C1` points to the results.
    6. Repeat FCS steps 1 to 4, then select `Transitions > Never transition into $X` as the second sub-property, then select `State Damaged` for variable `$X`. The decomposition succeeds and the GSN justification node `J.C1` points to the results.
4. PCA Infusion Pump case study (Sec. 6.1):
    1. Right-click on the claim named `C2` and select `MMINT > Property Decomposition`.
    2. Select `Absence > $X is not reached after $A and until $B` as the property to be decomposed, then select `State BolusRequest` for variable `$X`, `Transition Cond_6_3?` for variable `$A`, `State Infusion_NormalOperation` for variable `$B`.
    3. Insert `3` as the number of sub-properties.
    4. Select `Response > If $X is reached, $Y must follow $X` as the first sub-property, then select `Transition Cond_6_3?` for variable `$X`, `State Alrm_EmptyReservoir` for variable `$Y`.
    5. Select `Absence > $X is not reached between $A and $B` as the second sub-property, then select `State BolusRequest` for variable `$X`, `Transition Cond_6_3?` for variable `$A`, `State Alrm_EmptyReservoir` for variable `$B`.
    6. Select `Absence > $X is not reached after $A and until $B` as the third sub-property, then select `State BolusRequest` for variable `$X`, `State Alrm_EmptyReservoir` for variable `$A`, `State Infusion_NormalOperation` for variable `$B`. The decomposition succeeds and the GSN justification node `J.C2` points to the results.
5. LACU case study (Sec. 6.3):
    1. Right-click on the claim named `C3` and select `MMINT > Property Decomposition`.
