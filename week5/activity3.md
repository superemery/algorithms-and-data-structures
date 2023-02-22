# Exercise 1
Using the model below, illustrate the operation of: MAX-HEAPIFY (A, 3) on the array A = {27, 17, 3, 16, 13, 10, 1, 5, 7, 12, 4, 8, 9, 0} 

```
              27          
           /      \       
      17             [3]   
     /  \            / \  
  16      13      10     1
 /  \    /  \    /  \   / 
5    7  12   4  8    9 0  
```

```
              27          
           /      \       
      17             10   
     /  \           /  \  
  16      13     [3]     1
 /  \    /  \    / \    / 
5    7  12   4  8   9  0  
```

```
              27          
           /      \       
      17             10   
     /  \           /  \  
  16      13      9      1
 /  \    /  \    / \    / 
5    7  12   4  8  [3] 0  
```

# Exercise 2
Starting with the procedure MAX-HEAPIFY, write the pseudo-code for the procedure MIN-HEAPIFY(A, i), which performs the corresponding manipulation on a min-heap. What is the running time for the MIN-HEAPIFY procedure?

MIN-HEAPIFY(A, i)
```
l = 2 * i
r = 2 * i + 1
smallest = i
if l <= A.length and A[l] < A[i]
    smallest = l
if r <= A.length and A[r] < A[i]
    smallest = r
if smallest != i
    SWAP(A[i], A[smallest])
    MIN-HEAPIFY(A, smallest)
``` 

The running time of MIN-HEAPIFY is proportional to the height of the tree. Since the height of a binary tree with n nodes is floor(log2(n)), the upper bound of MIN-HEAPIFY is O(logn).

# Exercise 3
Using the model below, illustrate the operation of BUILD-MAX-HEAP on the array: A =  {5, 3, 17, 10, 84, 19, 6, 22, 9}

```
          5       
         / \      
      3       17  
     / \     /  \ 
 [10]   84 19    6
 /  \             
22   9
```
```
          5       
         / \      
      3      [17]  
     / \     /  \ 
  22    84 19    6
 /  \             
10   9   
```
```
          5       
         / \      
     [3]      19  
     / \     /  \ 
  22    84 17    6
 /  \             
10   9            
```
```
         [5]       
         / \      
      84      19  
     /  \    /  \ 
  22     3 17    6
 /  \             
10   9            
```
```
          84       
         /  \      
      22       19  
     /  \     /  \ 
  10     3  17    6
 /  \              
5    9                
```

# Exercise 4
To perform the HEAPSORT on the array A = {5, 13, 2, 25, 7, 17, 20, 8, 4}. In line 3 of HEAPSORT algorithm, there is for loop with a variable i, using the model below illustrate the array A and heap [A] immediately after the completion of the execution of the loops when i=9, 7, 3, 2 in turn.


i = 9
```
        20      
       /  \     
    13      17  
   /  \    /  \ 
  8    7  4    2
 /              
5               

[25]
```
i = 7
```
     13   
    /  \  
  8      5
 / \    / 
2   7  4  

[17, 20, 25]
```
i = 3
```
 4
/ 
2 

[5, 7, 8, 13, 17, 20, 25]
```
i = 2
```
2

[4, 5, 7, 8, 13, 17, 20, 25]
```