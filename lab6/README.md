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