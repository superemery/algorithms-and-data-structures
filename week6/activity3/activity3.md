# Exercise 1
*Draw the complete binary search tree of height 3 on the keys {1, 2, . . . , 15}. Add the NIL leaves and colour the nodes in three different ways such that the black-heights of the resulting red-black trees are 2, 3, and 4.*

Labelling red nodes with negative number 

**Black Height 2**
```
                                    8                                          
                           /                  \                                
                 -4                                     -12                    
            /          \                           /           \               
        2                  6                 10                     14         
      /   \              /   \             /    \                 /    \       
   -1       -3        -5       -7       -9        -11         -13        -15   
 /    \   /    \    /    \   /    \   /    \    /     \     /     \    /     \ 
NIL  NIL NIL  NIL  NIL  NIL NIL  NIL NIL  NIL  NIL   NIL   NIL   NIL  NIL   NIL
```

**Black Height 3**
```
                                8                                      
                        /                \                             
               -4                                 -12                  
           /        \                        /           \             
       2                6               10                   14        
     /   \            /   \           /    \               /    \      
   1       3        5       7       9        11         13        15   
 /   \   /   \    /   \   /   \   /   \    /    \     /    \    /    \ 
NIL NIL NIL NIL  NIL NIL NIL NIL NIL NIL  NIL  NIL   NIL  NIL  NIL  NIL
```

**Black Height 4**
```
                               8                                     
                       /                \                            
               4                                 12                  
           /       \                        /          \             
       2               6               10                  14        
     /   \           /   \           /    \              /    \      
   1       3       5       7       9        11        13        15   
 /   \   /   \   /   \   /   \   /   \    /    \    /    \    /    \ 
NIL NIL NIL NIL NIL NIL NIL NIL NIL NIL  NIL  NIL  NIL  NIL  NIL  NIL     
```

# Exercise 2
*Using the following tree, draw the resulting tree by performing the right rotation on the node with key 18 twice, then left rotation on the node with key 5, finally, right rotation on nodes with key 12, 9, 5 and 2.*

**Original Tree**
```
     12         
    /  \        
  5        18   
 / \      /  \  
2   9  15     19
         \      
         17     
```

**Right Rotate 18**
```
     12         
    /  \        
  5     15      
 / \      \     
2   9       18  
           /  \ 
          17  19
```

**Right Rotate 18 Again**
```
     12           
    /  \          
  5     15        
 / \      \       
2   9      17     
             \    
              18  
                \ 
                19
```

**Left Rotate 5**
```
      12           
     /  \          
    9    15        
   /       \       
  5         17     
 /            \    
2              18  
                 \ 
                 19
```

**Right Rotate 12, 9, 5, 2**
```
1                  
 \                 
  5                
   \               
    9              
     \             
      12           
        \          
         15        
           \       
            17     
              \    
               18  
                 \ 
                 19
```



# Exercise 3
*Show the red-black trees that result after successively inserting the keys 45, 49, 19, 12, 31, 38, 41 sequentially into an initially empty red-black tree.*

**Insert 45**
```
45
```

**Insert 49**
```
45   
   \ 
  -49
```

**Insert 19**
```
   45   
 /    \ 
-19  -49
```

**Insert 12**
```
      45   
     /  \  
   19    49
 /         
-12        
```

**Insert 31**
```
        45   
      /   \  
   19      49
 /    \      
-12  -31     
```

**Insert 38**
```
            45   
       /      \  
   -19         49
  /   \          
12     31        
          \      
         -38     
```

**Insert 41**
```
              45   
         /      \  
   -19           49
  /    \           
12       38        
       /    \      
      -31  -41     
```

# Exercise 4
*Now show the red-black trees that result from the successive deletion of the keys in the order 8, 12, 19, 31, 38, 41 from the following tree.*

**Original Tree**
```
           38   
         /   \  
     -19      41
    /   \       
  12     31     
 /              
-8              
```

**Delete 8**
```
       38   
     /   \  
  -19     41
 /   \      
12   31     
```

**Delete 12**
```
     38   
   /   \  
19      41
   \      
  -31    
```

**Delete 19**
```
  38  
 /  \ 
31  41
```

**Delete 31**
```
38   
   \ 
  -41
```

**Delete 38**
```
41
```

**Delete 41**
```
```

# Exercise 5
*In line 16 of RB-INSERT, we set the colour of the newly inserted node x to red. Notice that if we had chosen to set x's colour to black, then property 4 of a red-black tree would not be violated. Why didn't we choose to set x's colour to black?*

Setting x's color to black will violate property 5, saying that all paths from a node to descendant leaves must have an equal number of black nodes.

# Exercise 6
*Write pseudocode for RIGHT-ROTATE.*

**RIGHT-ROTATE(T, y)**
```
x = y.left
y.lef = x.right
if x.right != T.nil
    x.right.p = y
x.p = y.p
if y.p == T.nil
    T.root = x
elseif y = y.p.left
    y.p.left = x
else y.p.right = x
x.right = y
y.p = x
```