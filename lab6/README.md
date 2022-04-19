# Useful websites
https://docs.sonarqube.org/latest/requirements/hardware-recommendations/
https://www.elastic.co/guide/en/elasticsearch/guide/current/heap-sizing.html

## 6.2

### f)
Yes, analyzing the overall code, the SonarQube software evaluates the Reliability with D grade (not that good, but there is only 1 bug), Security has A grade since there are no vulnerabilities exploited, Security Review has E grade which is bad (1 security hotspot), Maintainability has A grade, with 23 Code Smells and 2h5min debt.

### g)

| Issue   | Problem description |  How to solve |
|----------|:-------------:|------:|
| Bug | Creating a new Random object each time a random value is needed is inefficient and may produce numbers which are not random depending on the JDK | Save and re-use this "Random" |
| Vulnerability |  --  |  --  |
| Code smell (major) [1]|  Loop counter incremented at the end of the loop  |  Refactor the code in order to not assign to this loop counter from within the loop body  |
| Code smell (major) [2]|  Standard outputs should not be used directly to log anything  |  Replace this use of System.out or System.err by a logger  |


## 6.3

### a)
The technical debt found for this project is 30 minutes. This means that 30 minutes is the estimated time required to fix all Maintainability Issues/Code Smells.

Analysis findings without code coverage (before adding the jacoco plugin):

[![a.png](https://i.postimg.cc/FRP9bBj2/a.png)](https://postimg.cc/MMQ2qt3D)


### b)
Analysis findings after resolving the major code smells (but still before using the jacoco plugin) as we can see, the technical debt significantly dropped):

[![b.png](https://i.postimg.cc/zf0qYhWr/b.png)](https://postimg.cc/mczvQt8X)


### c)
Analysis findings considering code coverage (after adding the jacoco plugin):

[![c.png](https://i.postimg.cc/RVFJwnJY/c.png)](https://postimg.cc/xqwd28RG)


### d)
Code coverage values:

[![d.png](https://i.postimg.cc/W3ThzDPX/d.png)](https://postimg.cc/f3qwgRy9)

As we can see, the project has 63.8% of total code covered.
2 lines missing coverage in Ex2Application.java and 9 lines missing coverage in Car.java.
There are aswell 9 uncovered conditions in Car.java and 1 uncovered condition in CarManagerService.java.


## 6.4

### a)
Since we haven't made tests in IES project, when trying to add that project in sonarqube, the error message "There are test failures" was displayed, so I decided to move on with the last exercise example.

I decided to go along with the metrics on the [DEFAULT] [BUILT-IN] Sonar Way Quality Gate but changing slightly the values:

[![a.png](https://i.postimg.cc/1RJhL87s/a.png)](https://postimg.cc/5jYRz2MR)

Comparing to the Default Quality Gate, there are 3 values that change.
	- Coverage, which should be greater than 80% according to the Default QG and, in my QG I defined that value as 60% which sound reasonable based on my own Coverage percentage (63.8%).

	- Duplicated Blocks, which is not even considered in the Default QG and I found relevant in this case. For the condition to pass, there shouldn't be more than 1 duplicated block.
	
	- Duplicated Lines (%), 3% in Default QG and 2% in my case. I think this condition is really important in order to have a clean and refactored code. In order to achieve that, I restricted the condition to less than 2% of duplicated lines.
	
### b)

Duplicating some code lines in a class file resulted in this Quality Gate Status:

[![bb.png](https://i.postimg.cc/BvdgXfSm/bb.png)](https://postimg.cc/wtQJGPsN)

When analyzing the Issues tab, we can conclude that 2 Major Code Smells appeared:
[![image.png](https://i.postimg.cc/Rh34Gf5S/image.png)](https://postimg.cc/ctNpLvL2)
