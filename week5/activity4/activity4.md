# Exercise 1
*How would you modify QUICKSORT to sort in decreasing order?*

PARTITION(A, p, r)
```
x = A[r]
i = p - 1
for j = p to r - 1
    if A[p] >= x
        i = i + 1
        SWAP(A[i], A[j])
i = i + 1
SWAP(A[i], A[r])
return i
```

QUICKSORT(A, p, r)
```
if p < r
    q = PARTITION(A, p, r)
    QUICKSORT(A, p, q - 1)
    QUICKSORT(A, q + 1, r)
```

# Exercise 2
*Using the substitution method to prove that the recurrence T(n)=T(n-1) + θ(n) has the solution T(n)= θ(n2).*

T(n)   = T(n-1) + θ(n)
T(n-1) = T(n-2) + θ(n-1)
T(n-2) = T(n-3) + θ(n-2)
T(n-3) = T(n-2) + θ(n-3)
...
T(1)   = T(0) + θ(0)

=> T(n) = θ(n) + θ(n-1) + θ(n-2) + ... + θ(0) [Arithmetic Series!!]
=> 0.5 * n * (n + 1)
=> θ(n2)


# Exercise 3
*Show that the running time of QUICKSORT is Ө(n2) when the array A is sorted in decreasing order.*

When array A is sorted, the two recursive calls in QUICKSORT create two subarrays with sizes n-1 and 0, respectively. We know that PARTITION's running time is linear, as it loops over A from p to r-1. Assume that the running time of each QUICKSORT call is T(n); it can be further broken down into the running time sum of lines 2, 3, and 4, as Ө(n), T(0), and T(n-1).

> T(n) = T(n-1) + T(0) + θ(n)

Since the running time to solve subproblems of size 0 is a constant, the term T(0)=Ө(1) can be omitted, deriving

> T(n) = T(n-1) + θ(n)

The above equation has been proved to have a running time of Ө(n2) in Exercise 2.

# Exercise 4
*During the running of the procedure RANDOMIZED-QUICKSORT, how many calls are made to the random-number generator RANDOM in the worst case? How does the answer change in the best case?*

The number of calls for RANDOM equals to of RANDOMIZED-PARTITION, n-1

# Exercise 5
*Why do we expect the average-case performance of a randomised algorithm and not its worst-case performance?*

With the help of randomization, the pivot element is evenly selected within the range r - p + 1. We can therefore expect the input array to be split in a well-balanced manner, reasonably avoiding the worst-case conditions.