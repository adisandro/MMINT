set terminal svg
set xtic auto
set ytic auto
set title "Lifted rules UNSAT count"
set xlabel "# Features"
set ylabel "# UNSAT"
set xr [8:300]
set yr [0:500]
#set logscale x
plot "unsatCountLifting.dat" using 1:2 title 'Rule1' with lines,"unsatCountLifting.dat" using 1:3 title 'Rule2' with lines,"unsatCountLifting.dat" using 1:4 title 'Rule3' with lines,"unsatCountLifting.dat" using 1:5 title 'Rule4' with lines,"unsatCountLifting.dat" using 1:6 title 'Rule5' with lines,"unsatCountLifting.dat" using 1:7 title 'Rule6' with lines,"unsatCountLifting.dat" using 1:8 title 'Rule7' with lines
