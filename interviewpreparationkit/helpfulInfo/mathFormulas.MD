# Math Formulas
## Sum of Numbers
**`(n * n + n) / 2`**
Calculates the sum of n.
1 + 2 + 3 + ... + n
**Helpful For:**
1) <ins>Counting every substring of a string</ins>
   Example: "aaaa" n = the length of the string
   A) Solve by formula: 
   (4*4+4)/2 -> 10
   B) Solve manually:
   ["a", "a", "a", "a"] -> 4
   ["aa", "aa", "aa"] -> 3
   ["aaa", "aaa"] -> 2
   ["aaaa"] -> 1

## Counting Permutations
`n!/(n-r)!`
Permutation relates to the act of arranging all the members of a set into some sequence or order.
**Useful Example:**
1) There are 20 students. We must pick 3. One to be President, one to be Vice President, and one to be Treasurer. In this problem, the order we choose the students matter.
n = 20, r = 3
answer = 20! / (20 - 3)!
answer = 20! / 17!
answer = (18 \*  19 \* 20) / 1
answer = 6840
## Counting Combinations
`n!/(r!(n-r)!)`
*n = total number of objects in the set
r = number of choosing objects from the set*
Combinations is a way of selecting items from a collection, such that the order of selection does not matter. 
**Useful Example:**
1) There are 20 students. We must pick 3 to receive an A. In this problem, the order does not matter.
   n = 20, r = 3
   answer = 20! / (3!(20 - 3)!)
   answer = 20! / (3! \* 17!)
   answer = (18 \* 19 \* 20) / 3!
   answer = 6840 / 6
   answer = 1140