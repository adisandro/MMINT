set terminal svg
set xtic auto
set ytic auto
set title "Lifted rules running time"
set xlabel "# Features"
set ylabel "Time (s)"
set xr [8:300]
set yr [0:7]
#set logscale x
plot "timeLifting.dat" using 1:2 title 'Rule1' with lines,"timeLifting.dat" using 1:3 title 'Rule2' with lines,"timeLifting.dat" using 1:4 title 'Rule3' with lines,"timeLifting.dat" using 1:5 title 'Rule4' with lines,"timeLifting.dat" using 1:6 title 'Rule5' with lines,"timeLifting.dat" using 1:7 title 'Rule6' with lines,"timeLifting.dat" using 1:8 title 'Rule7' with lines
