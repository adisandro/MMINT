## Lean integration with MMINT

Lean is a theorem prover (available at [https://leanprover.github.io](https://leanprover.github.io)) that can be used within MMINT for various reasoning tasks.

### Installation instructions

1. Download and extract the Lean theorem prover for [Linux](https://oleanstorage.azureedge.net/releases/bundles/trylean_linux.tar.gz) or [Windows](https://oleanstorage.azureedge.net/releases/bundles/trylean_windows.zip).
2. Run `mkdir -p ~/.local/bin; cd ~/.local/bin; ln -s /path_to_lean_folder/lean/bin/lean lean` in your shell (Linux), or add `C:\path_to_lean_folder` to the environment variable `Path` found in `Control Panel > System and Security > System > About > Advanced system settings > Advanced > Environment Variables` (Windows).
