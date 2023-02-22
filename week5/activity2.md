# Exercise 1
*Using the model below, illustrate the operation of merge sort on the array A = <3, 41, 52, 26, 38, 57, 9, 49>. Label each of the merges in their execution order, e.g. merge 1, merge 2.*

```
[3]---
      |
    M1=[3, 41]---
      |          |
[41]--           |
        M5=[3, 26, 41, 52]--
[52]--           |          |
      |          |          |
    M2=[26, 52]--           |
      |                     |
[26]--                      |
            M7=[3, 9, 26, 38, 41, 49, 52, 57]
[38]--                      |
      |                     |
    M3=[38, 57]--           |
      |          |          |
[57]--           |          |
        M6=[9, 38, 49, 57]--
[9]---           |
      |          |
    M4=[9, 49]---
      |
[49]--
```

# Exercise 2
*Rewrite the merge procedure so that it does not use sentinels, instead, stopping once either array L or R has all its elements copied back to A and then copying the remainder of the other array back into A. Then, contrast the code for the one with and without sentinels, which one is simpler?*

**MERGE(A, p, q, r)**
```
n1 = q - p + 1
n2 = r - q
let L[1..n1] and R[1..n2] be new arrays
for i = 1 to n1
    L[i] = A[p + i - 1]
for j = 1 to n2
    R[j] = A[q + j]
i = 1
j = 1
k = p
while i <= n1 and j <= n2
    if L[i] <= R[j]
        A[k] = L[i]
        i = i + 1
    else A[k] = R[j]
        j = j + 1
    k = k + 1
while i <= n1
    A[k] = L[i]
    i = i + 1
    k = k + 1
while j <= n2
    A[k] = R[j]
    j = j + 1
    k = k + 1
```

# Exercise 3
*Referring back to the searching problem, observe that if the array A is sorted, we can check the midpoint of the array against x and eliminate half of the sequence from further consideration. Binary search is an algorithm that repeats this procedure, halving the size of the remaining portion of the sequence each time. Write pseudocode, recursively, for binary search. Argue that the worst-case running time of binary search is (lgn).*

Assume that the array `A` contains the search target `t`, the worst case happens when the `t` is at the first index `s` or the last index `e` of the array. In these cases, the search procedure has to go down to the deepest level of the recursion tree, taking running time complexity of `θ(lgn)`.

**BINARY-SEARCH(A, t, s, e)**
```
if s > e
    return 0
m = (s + e) / 2
if A[m] == t
    return m
if A[m] <= t
    return BINARY-SEARCH(A, t, s, m - 1)
else return BINARY-SEARCH(A, t, m + 1, e)
```

