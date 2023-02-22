# Exercise 1
*Draw binary search trees of height 2, 3, 4, 5, and 6 on the set of keys {1, 4, 5, 10, 16, 17, 21}.*

**Height 2**
[10,4,17,1,5,16,21]
```
     10      
    /  \     
  4      17  
 / \    /  \ 
1   5  16  21
```

**Height 3**
[5,4,16,1,null,10,17,null,null,null,null,null,21]
```
    5          
   / \         
  4     16     
 /     /  \    
1    10    17  
             \ 
             21
```

**Height 4**
[4,1,5,null,null,null,16,10,17,null,null,null,21]
```
  4            
 / \           
1   5          
     \         
        16     
       /  \    
     10    17  
             \ 
             21
```

**Height 5**
[1,null,4,null,5,null,10,null,17,16,21]
```
1             
 \            
  4           
   \          
    5         
     \        
      10      
        \     
          17  
         /  \ 
        16  21
```

**Height 6**
[1,null,4,null,5,null,10,null,16,null,17,null,21]
```
1               
 \              
  4             
   \            
    5           
     \          
      10        
        \       
         16     
           \    
            17  
              \ 
              21
```

# Exercise 2
*Given the following binary search tree, modify the tree after inserting an item with key 13 and 27.*

**Original Tree**
[12,5,18,2,9,15,19,null,null,null,null,null,17]
```
     12         
    /  \        
  5        18   
 / \      /  \  
2   9  15     19
         \      
         17     
```

**Insert 13**
[12,5,18,2,9,15,19,null,null,null,null,13,17]
```
     12           
    /    \        
  5          18   
 / \        /  \  
2   9    15     19
        /  \      
       13  17      
```

**Insert 27**
[12,5,18,2,9,15,19,null,null,null,null,13,17,null,27]
```
     12             
    /    \          
  5          18     
 / \        /  \    
2   9    15     19  
        /  \      \ 
       13  17     27
```

# Exercise 3
*Given the following binary search tree, modify the tree after deleting item with key 18 (or 15, or 9), explain the deleting process.*

**Original Tree**
[12,5,18,2,9,15,19,null,null,null,null,null,17]
```
     12         
    /  \        
  5        18   
 / \      /  \  
2   9  15     19
         \      
         17     
```

**Delete 18**
Since node 18 has two children and its successor is its right child, replace it with its right subtree.
[12,5,19,2,9,15,null,null,null,null,null,null,17]
```
     12      
    /  \     
  5        19
 / \      /  
2   9  15    
         \   
         17     
```

**Delete 15**
Since node 15 has only one child, replace it with its child (17).
[12,5,18,2,9,17,19]
```
     12      
    /  \     
  5      18  
 / \    /  \ 
2   9  17  19
```

**Delete 9**
Since node 9 has no child, set its parent's left child to node.
[12,5,18,2,null,15,19,null,null,null,null,null,17]
```
    12          
   /  \         
  5      18     
 /      /  \    
2     15    19  
              \ 
              17
```

# Exercise 4
*Show the result of inserting 3, 1, 4, 6, 9, 2, 5 and 7 in an initially empty binary search tree, then show the result of deleting the root.*

**Original Tree**
[3,1,4,null,2,null,6,null,null,5,9,null,null,7]
```
   3       
  / \      
1    4     
 \    \    
  2     6  
       / \ 
      5   9
         / 
         7 
```

**Delete Root**
[4,1,6,null,2,5,9,null,null,null,null,7]
```
   4     
  / \    
1     6  
 \   / \ 
  2 5   9
       / 
       7 
```

# Exercise 5
*Write a recursive version of the TREE-MINIMUM and TREE-MAXIMUM procedures.*

**TREE-MINIMUM(x)**
```
if x.left != NIL
    return TREE-MINIMUM(x.left)
else return x
```

**TREE-MAXIMUM(x)**
```
if x.right != NIL
    return TREE-MAXIMUM(x.right)
else return x
```