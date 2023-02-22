# Exercise 1
*Draw the resulting binary heap after the operation of HEAP-EXTRACT-MIN on the heap A=<18, 25, 20, 35, 45, 60, 30, 50>*

A=<20, 25, 30, 35, 45, 60, 50>

# Exercise 2
*Draw the resulting binary heap after the operation MIN-HEAP-INSERT (A, 17) on the heap A=<18, 25, 20, 35, 45, 60, 30, 50>*

A=<17, 18, 20, 25, 45, 60, 30, 50, 35>

# Exercise 3
*Draw the resulting binary heap after the operation of HEAP-EXTRACT-MAX on the heap A=<15, 13, 9, 5, 12, 8, 7, 4, 0, 6, 2, 1>*

A=<13, 12, 9, 5, 6, 8, 7, 4, 0, 1, 2>

# Exercise 4
*Draw the resulting binary heap after the operation MAX-HEAP-INSERT (A, 10) on the heap A=<15, 13, 9, 5, 12, 8, 7, 4, 0, 6, 2, 1>*

A=<15, 13, 10, 5, 12, 8, 7, 4, 0, 6, 2, 1, 8>

# Exercise 5
*Build a Huffman code for the following symbols with frequency:*
*A:10%   B:15%   C:20%   D:30%   E:5%   F:20%*
    *(1) Draw the Huffman tree, following the HUFFMAN algorithm defined in the "Introduction to algorithms" book.*
    *(2) List the code.*
```
E(5%) A(10%) B(15%) C(20%) F(20%) D(30%)
```
```
  (15%) B(15%) C(20%) F(20%) D(30%)
  /   \
E(5%) A(10%) 
```
```
C(20%) F(20%) (30%) D(30%)
              /   \
           (15%) B(15%)
           /   \
        E(5%) A(10%) 
```
```
      (30%) D(30%)  (40%)
      /   \         /   \
   (15%) B(15%) C(20%) F(20%)
   /   \
E(5%) A(10%) 
```
```
  (40%)           (60%)
  /   \           /   \
C(20%) F(20%)  (30%) D(30%)
               /   \
            (15%) B(15%)
            /   \
         E(5%) A(10%) 
```
```
          (100%)
      /           \
  (40%)           (60%)
  /   \           /   \
C(20%) F(20%)  (30%) D(30%)
               /   \
            (15%) B(15%)
            /   \
         E(5%) A(10%) 
```

A: 1001
B: 101
C: 00
D: 11
E: 1000
F: 01

# Exercise 6
*Huffman tree is built up in a bottom up manner, this ensures every internal node has 2 children, this kind of tree is called full binary tree. A full binary tree with n leaves has n-1 internal nodes. What is the difference between a full binary tree and a complete binary tree?*

According to the definition from "Introduction to Algorithms," each node in a full binary tree has two children except for the leave nodes, whereas a complete binary tree is full at every level except for the last one.