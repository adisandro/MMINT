set term svg dashed
set xtic auto
set ytic auto
set xlabel "Number of features (logarithmic scale)" offset 0,0.5
set ylabel "Time (seconds)"
set xr [8:300]
set yr [0:7]
set logscale x
set key at 75,6.8
set grid
set style line 1 lt 1 lw 2
set style line 2 lt 2 lw 2
set style line 3 lt 3 lw 2
set style line 4 lt 4 lw 2
set style line 5 lt 5 lw 2 lc rgb 'magenta'
set style line 6 lt 6 lw 2
set style line 7 lt 7 lw 2
plot "timeLifting.dat" using 1:2 title '1 - Relations:StationwMale' w l ls 1,"timeLifting.dat" using 1:3 title '2 - UML Activity to Petri Net transition' w l ls 2,"timeLifting.dat" using 1:4 title '3 - while' w l ls 3,"timeLifting.dat" using 1:5 title '4 - Encapsulate Variable' w l ls 4,"timeLifting.dat" using 1:6 title '5 - Fold incoming transitions' w l ls 5,"timeLifting.dat" using 1:7 title '6 - attr2fkeyR' w l ls 6,"timeLifting.dat" using 1:8 title '7 - assoc2fkeyR' w l ls 7
