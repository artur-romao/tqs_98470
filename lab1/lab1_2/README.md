# alinea e) - Code coverage

## Euromillions
Package "euromillions" has 81% coverage in Instructions and 79% coverage in Branches.
That package is composed by 3 classes:
	- CuponEuromillions;
	- Dip;
	- EuromillionsDraw.
	

### CuponEuromillions
CuponEuromillions has only 40% of coverage in Instructions but that shouldn't worry us since only format() method is not being covered, all other methods are 100% covered in their Instructions (that can be checked by analyzing the class' methods)

### Dip
Dip is being widely covered with 89% for Instructions and 77% for Branches.
hashCode() method is not being covered aswell as 25% of equals(), but there is no need for that since they're generated methods and, at first, won't give us problems.
Dip(int[], int[]) constructor has 13% missed branches and generatedRandomDip() method has 25% missed branches, which correspond to if statements.

### EuromillionsDraw
EuromillionsDraw has 90% coverage for Instructions and 100% for Branches.
Those 10% are 2 returns from methods generateRandomDraw() and getDrawResults().

## Sets
Sets package has only SetOfNaturals class which tests cover all relevant methods (only hashCode() and equals() are not widely covered)
