# Exercise 1
*Look at the example diagram below. What is the maximum number of edges in a graph of n vertices? (Assuming no parallel edges as in the picture below).*

(n - 1) + (n - 2) + ... + 1 = n * (n - 1) / 2

# Exercise 2
*Give an adjacency-list representation for a complete binary tree on 7 vertices. Give an equivalent adjacency-matrix representation. Assume that vertices are numbered from 1 to 7 as in a binary heap.*

1 -> 2 -> 3
2 -> 1 -> 4 -> 5
3 -> 1 -> 6 -> 7
4 -> 2
5 -> 2
6 -> 3
7 -> 3

|     | 1   | 2   | 3   | 4   | 5   | 6   | 7   |
| --- | --- | --- | --- | --- | --- | --- | --- |
| 1   | 0   | 1   | 1   | 0   | 0   | 0   | 0   |
| 2   | 1   | 0   | 0   | 1   | 1   | 0   | 0   |
| 3   | 1   | 0   | 0   | 0   | 0   | 1   | 1   |
| 4   | 0   | 1   | 0   | 0   | 0   | 0   | 0   |
| 5   | 0   | 1   | 0   | 0   | 0   | 0   | 0   |
| 6   | 0   | 0   | 1   | 0   | 0   | 0   | 0   |
| 7   | 0   | 0   | 1   | 0   | 0   | 0   | 0   |