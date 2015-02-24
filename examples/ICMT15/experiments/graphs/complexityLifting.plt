set term svg dashed
set xtics (200, 400, 800, 1600, 3200)
set ytics auto
set xlabel "Number of model elements (log scale)" offset 0,0.5
set ylabel "Clauses to Variables ratio (log scale)"
set xr [170:4000]
set yr [0.05:6000]
set logscale y
set logscale x
set key at 450,4000
set grid
set style line 1 lt 1 lw 2
set style line 2 lt 2 lw 2
set style line 3 lt 3 lw 2
set style line 4 lt 4 lw 2
set style line 5 lt 5 lw 2 lc rgb 'magenta'
set style line 6 lt 6 lw 2
plot "complexityLifting.dat" using 1:2 title '6 features' with linespoints ls 1, "complexityLifting.dat" using 1:3 title '12 features' with linespoints ls 2, "complexityLifting.dat" using 1:4 title '24 features' with linespoints ls 3, "complexityLifting.dat" using 1:5 title '48 features' with linespoints ls 4, "complexityLifting.dat" using 1:6 title '96 features' with linespoints ls 5, "complexityLifting.dat" using 1:7 title 'input models' with linespoints ls 6
