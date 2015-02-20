set term svg dashed
set xtics ("XS" 200, "S" 400, "M" 800, "L" 1600, "XL" 3200)
set ytics auto
set xlabel "Number of model elements" offset 0,0.5
set ylabel "Clauses to Features ratio"
set xr [0:3300]
set yr [0:30]
set key at 1000,30
set grid
set style line 1 lt 1 lw 2
set style line 2 lt 2 lw 2
set style line 3 lt 3 lw 2
set style line 4 lt 4 lw 2
set style line 5 lt 5 lw 2 lc rgb 'magenta'
plot "timeLifting.dat" using 1:2 title '6 features' w l ls 1, "timeLifting.dat" using 1:3 title '12 features' w l ls 2, "timeLifting.dat" using 1:4 title '24 features' w l ls 3, "timeLifting.dat" using 1:5 title '48 features' w l ls 4, "timeLifting.dat" using 1:6 title '96 features' w l ls 5
