# parallel-testing
Just experimenting with different ways to perform operations on large sets of numbers fast. 

# Observations: Small Testing Set:
Seeded the random number generator to 100000000. And had the following output:
Test for Single Core:
-913097096
Duration: 0.457224958

Time for Dual Cores:
Total sum: -913097096
Duration: 0.103221167

Time for Four Cores:
Total sum: -913097096
Duration: 0.035104583

Time for Eight Cores:
Total sum: -913097096
Duration: 0.036106208

Time for Twelve Cores:
Total sum: -913097096
Duration: 0.042955917

From the above results, we can see that when we added:
    - Dual Cores: we got a drastic performance increase from single cores. 
    - Four Cores: Another great performance increase from dual cores.
    - Eight Cores: The duration starts to increase, maybe there is to many cores tackling a "small" task now? 
    - Twelve Cores: Okay!! There is way too many cores in here! It has increased to worse performance than Four Cores. 



# Observations: Larger Testing Set:
Seeded the random number generator to 1000000000. And had the following output:
This time we wont be using the single core, because I don't want my laptop to calve.

Test for Single Core:

Time for Dual Cores:
Total sum: 1036203818
Duration: 0.368991541

Time for Four Cores:
Total sum: 1036203818
Duration: 0.128223209

Time for Eight Cores:
Total sum: 1036203818
Duration: 0.128754375

Time for Twelve Cores:
Total sum: 1036203818
Duration: 0.1271695

Here we can see another similar pattern, when we get past 4 cores, there seems to be a fall off in the processing speed. 
It doesnt decrease as much as it did prior. We see that on 8 cores, we are slower than four cores, and 12 cores is faster than 8 cores which is pretty unusual. 

I will investigate this more. 
