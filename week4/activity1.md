## Exercise 1

There are two parts to this exercise:

- Write an algorithm which takes an array of n integers as input and output the maximum element of the list.
- Analyse its time complexity and express it using asymptotic notations.

MAXIMUM(A)
```
max = A[1]
for i = 2 to n
    if A[i] > max
        max = A[i]
return max
```

Time Complexity Analysis
- Line 1: 1
- Line 2: n
- Line 3: n - 1
- Line 4: 0 to n - 1
- Line 5: 1

Asymptotic Notations
- Θ(n)
- O(n)
- Ω(n)
