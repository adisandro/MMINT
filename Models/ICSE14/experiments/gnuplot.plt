set terminal svg
set xtic auto
set ytic auto
set title "Experiment 2"
set xlabel "# features"
set ylabel "time"
set xr [0:300]
set yr [0:10]
plot "gnuplot.dat" using 1:2 title 'Rule1' with lines,"gnuplot.dat" using 1:3 title 'Rule2' with lines,"gnuplot.dat" using 1:4 title 'Rule3' with lines,"gnuplot.dat" using 1:5 title 'Rule4' with lines,"gnuplot.dat" using 1:6 title 'Rule5' with lines,"gnuplot.dat" using 1:7 title 'Rule6' with lines,"gnuplot.dat" using 1:8 title 'Rule7' with lines
