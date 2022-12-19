## MODELS 2021 paper

[A Lean Approach to Building Valid Model-Based Safety Arguments](https://doi.org/10.1109/MODELS50736.2021.00028)

In recent decades, cyber-physical systems developed using Model-Driven Engineering (MDE) techniques have become ubiquitous in safety-critical domains. *Safety assurance cases (ACs)* are structured arguments designed to comprehensively show that such systems are safe; however, the reasoning steps, or *strategies*, used in AC arguments are often informal and difficult to rigorously evaluate. Consequently, AC arguments are prone to fallacies, and unsafe systems have been deployed as a result of fallacious ACs. To mitigate this problem, [prior work](https://doi.org/10.1007/978-3-030-54549-9_3) created a set of provably valid AC strategy templates to guide developers in building rigorous ACs. Yet instantiations of these templates remain error-prone and still need to be reviewed manually.

In this paper, we report on using the interactive theorem prover Lean to bridge the gap between safety arguments and rigorous model-based reasoning. We generate formal, model-based machine-checked AC arguments, taking advantage of the traceability between model and safety artifacts, and mitigating errors that could arise from manual argument assessment. The approach is implemented in an extended version of the *MMINT-A* model management [tool](https://doi.org/10.1145/3417990.3422012). Implementation includes a conversion of informal claims into formal Lean properties, decomposition into formal sub-properties and generation of correctness proofs. We demonstrate the applicability of the approach on two safety case studies from the literature.

## Instructions to reproduce the examples

This example runs natively on Linux only.  
Alternatively, a virtual machine image for VirtualBox with all the required dependencies is available at <https://doi.org/10.5281/zenodo.5110436>, letting you skip to step 2.4.

1. Lean
    1. Download and extract the Lean theorem prover from here: <https://oleanstorage.azureedge.net/releases/bundles/trylean_linux.tar.gz>
    2. `mkdir -p ~/.local/bin; cd ~/.local/bin; ln -s /path_to_lean_folder/lean/bin/lean lean`
2. MMINT
    1. Install Java and Eclipse following the [requirements](/README.md#requirements), then add `https://adisandro.github.io/mmint/release` to the list of software sites (`Help > Install New Software > Available Software Sites`).
    2. From the top menu select `Help > Install New Software` and install `Examples > MMINT - MODELS21 paper`.
    3. From the top menu select `MMINT > Lean > Change Lean Mathlib Path` and insert `/path_to_lean_folder/mathlib`.
    4. From the top menu select `File > New > Example > MMINT Examples > MODELS21`.
    5. Open `/MODELS21/examples.middiag`.
    6. Double-click on the yellow box named `sc : GSN` to open the GSN safety case.
3. FCS example (Sec. V-B):
    1. Right-click on the claim named `C1` and select `MMINT > Property Decomposition`.
    2. Select `Absence > $X is not reached` as the property to be decomposed, then select `State Damaged` for variable `$X`.
    3. Insert `2` as the number of sub-properties.
    4. Select `Transitions > Do not begin from $X` as the first sub-property, then select `State Damaged` for variable `$X`.
    5. Select `Transitions > Never transition out of $X` as the second sub-property, then select `State Damaged` for variable `$X`. The decomposition fails, the user is notified about possible corrective actions, and the GSN justification node `J.C1` points to the results.
    6. Repeat FCS steps 1 to 4, then select `Transitions > Never transition into $X` as the second sub-property, then select `State Damaged` for variable `$X`.
    7. The decomposition succeeds and the GSN justification node `J.C1` points to the results.
4. Infusion Pump case study (Sec. VI-A):
    1. Right-click on the claim named `C2` and select `MMINT > Property Decomposition`.
    2. Select `Absence > $X is not reached after $A and until $B` as the property to be decomposed, then select `State BolusRequest` for variable `$X`, `Transition Cond_6_3?` for variable `$A`, `State Infusion_NormalOperation` for variable `$B`.
    3. Insert `3` as the number of sub-properties.
    4. Select `Response > If $X is reached, $Y must follow $X` as the first sub-property, then select `Transition Cond_6_3?` for variable `$X`, `State Alrm_EmptyReservoir` for variable `$Y`.
    5. Select `Absence > $X is not reached between $A and $B` as the second sub-property, then select `State BolusRequest` for variable `$X`, `Transition Cond_6_3?` for variable `$A`, `State Alrm_EmptyReservoir` for variable `$B`.
    6. Select `Absence > $X is not reached after $A and until $B` as the third sub-property, then select `State BolusRequest` for variable `$X`, `State Alrm_EmptyReservoir` for variable `$A`, `State Infusion_NormalOperation` for variable `$B`.
    7. The decomposition succeeds and the GSN justification node `J.C2` points to the results.
    
