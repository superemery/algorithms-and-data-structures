# Exercise 1
*Demonstrate the insertion of the keys 5, 28, 19, 15, 20, 33, 12, 17, 10 into a hash table with collisions resolved by chaining. Let the table have 9 slots, and let the hash function be h(k) = k mod 9.*

| key \ slot | 0   | 1          | 2   | 3   | 4   | 5   | 6      | 7   | 8   |
| ---------- | --- | ---------- | --- | --- | --- | --- | ------ | --- | --- |
| 5          |     |            |     |     |     | 5   |        |     |     |
| 28         |     | 28         |     |     |     | 5   |        |     |     |
| 19         |     | 19->28     |     |     |     | 5   |        |     |     |
| 15         |     | 19->28     |     |     |     | 5   | 15     |     |     |
| 20         |     | 19->28     | 20  |     |     | 5   | 15     |     |     |
| 33         |     | 19->28     | 20  |     |     | 5   | 33->15 |     |     |
| 12         |     | 19->28     | 20  | 12  |     | 5   | 33->15 |     |     |
| 17         |     | 19->28     | 20  | 12  |     | 5   | 33->15 |     | 17  |
| 10         |     | 10->19->28 | 20  | 12  |     | 5   | 33->15 |     | 17  |

# Exercise 2
*Consider inserting the keys 10, 22, 31, 4, 15, 28, 17, 88, 59 into a hash table of length m = 11 using open addressing with the primary hash function h(k) = k mod m. Illustrate the result of inserting these keys using linear probing and quadratic probing.*

**Linear Probing**

| key \ slot | 0   | 1   | 2   | 3   | 4   | 5   | 6   | 7   | 8   | 9   | 10  |
| ---------- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| 10         |     |     |     |     |     |     |     |     |     |     | 10  |
| 22         | 22  |     |     |     |     |     |     |     |     |     | 10  |
| 31         | 22  |     |     |     |     |     |     |     |     | 31  | 10  |
| 4          | 22  |     |     |     | 4   |     |     |     |     | 31  | 10  |
| 15         | 22  |     |     |     | 4   | 15  |     |     |     | 31  | 10  |
| 28         | 22  |     |     |     | 4   | 15  | 28  |     |     | 31  | 10  |
| 17         | 22  |     |     |     | 4   | 15  | 28  | 17  |     | 31  | 10  |
| 88         | 22  | 88  |     |     | 4   | 15  | 28  | 17  |     | 31  | 10  |
| 59         | 22  | 88  |     |     | 4   | 15  | 28  | 17  | 59  | 31  | 10  |

**Quadratic Probing**

Set c1 = 0 and c2 = 1 for the quadratic hash hq(k, i) = (h(k) + c1*i + c2*i^2) % m

| key \ slot | 0   | 1   | 2   | 3   | 4   | 5   | 6   | 7   | 8   | 9   | 10  |
| ---------- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| 10         |     |     |     |     |     |     |     |     |     |     | 10  |
| 22         | 22  |     |     |     |     |     |     |     |     |     | 10  |
| 31         | 22  |     |     |     |     |     |     |     |     | 31  | 10  |
| 4          | 22  |     |     |     | 4   |     |     |     |     | 31  | 10  |
| 15         | 22  |     |     |     | 4   | 15  |     |     |     | 31  | 10  |
| 28         | 22  |     |     |     | 4   | 15  | 28  |     |     | 31  | 10  |
| 17         | 22  |     |     |     | 4   | 15  | 28  | 17  |     | 31  | 10  |
| 88         | 22  | 88  |     |     | 4   | 15  | 28  | 17  |     | 31  | 10  |
| 59         | 22  | 88  |     |     | 4   | 15  | 28  | 17  | 59  | 31  | 10  |

# Exercise 3
*Consider a dynamic set S that is represented by a direct-address table T of length m. Write pseudocode for a procedure (say MAX-DAT (T, m)) that finds the maximum element of S.*

MAX-DAT (T, m)
```
max = T[1]
for i = 1 to m
    if max == NIL and T[i] != NIL
        max = T[i]
    elif T[i] != NIL and T[i] > max
        max = T[i]
return max
```

# Exercise 4
*Write pseudocode for HASH-DELETE as outlined in the textbook (p.271 2nd paragraph) and modify HASH-INSERT and HASH-SEARCH to incorporate the special value DELETED.*

HASH-DELETE(T, k)
```
i = 0
repeat
    j = h(k, i)
    if T[j] == k
        T[j] = DELETED
        return
    i = i + 1
until T[j] == NIL or i == m
```

HASH-INSERT(T, j)
```
i = 0
repeat
    j = h(k, i)
    if T[j] == NIL or T[j] == DELETED
        T[j] = k
        return j
    i = i + 1
until i == m
error "hash table overflow"
```

HASH-SEARCH(T, k)
```
i = 0
repeat
    j = h(k, i)
    if T[j] == k
        return j
    i = i + 1
until T[j] == NIL or i == m
return NIL
```