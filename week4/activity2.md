## Exercise 1
- INITIAL(Q)
    ```
    |  _  |  _  |  _  |  _  |  _  |  _  |
    ^ 
    top=0
    ```   
- PUSH(S, 4)
    ```
    |  4  |  _  |  _  |  _  |  _  |  _  |
       ^ 
      top=1
    ```   
- PUSH(S, 1)
    ```
    |  4  |  1  |  _  |  _  |  _  |  _  |
             ^
            top=2
    ```   
- PUSH(S, 3)
    ```
    |  4  |  1  |  3  |  _  |  _  |  _  |
                   ^
                  top=3
    ```   
- POP(S)
    ```
    |  4  |  1  |  _  |  _  |  _  |  _  |
             ^
            top=2
    ```   
- PUSH(S, 8)
    ```
    |  4  |  1  |  8  |  _  |  _  |  _  |
                   ^
                  top=3
    ```   
- POP(S)
    ```
    |  4  |  1  |  _  |  _  |  _  |  _  |
             ^
            top=2
    ```   

## Exercise 2
- INITIAL(Q)
    ```
    |  _  |  _  |  _  |  _  |  _  |  _  |
       ^
     head=1 tail=1
    ```     
- ENQUEUE(Q, 4)
    ```
    |  4  |  _  |  _  |  _  |  _  |  _  |
       ^     ^
     head=1 tail=2
    ```   
- ENQUEUE(Q, 1)
    ```
    |  4  |  1  |  _  |  _  |  _  |  _  |
       ^           ^
     head=1       tail=3
    ```   
- ENQUEUE(Q, 3)
    ```
    |  4  |  1  |  3  |  _  |  _  |  _  |
       ^                 ^
     head=1             tail=4
    ```   
- DEQUEUE(Q)
    ```
    |  _  |  1  |  3  |  _  |  _  |  _  |
             ^           ^
           head=2       tail=4
    ```   
- ENQUEUE(Q, 8)
    ```
    |  _  |  1  |  3  |  8  |  _  |  _  |
             ^                 ^
           head=2             tail=5
    ```   
- DEQUEUE(Q)
    ```
    |  _  |  _  |  3  |  8  |  _  |  _  |
                   ^           ^
                 head=3       tail=5
    ```

## Exercise 3
FRONT(Q)
```
if Q.head == Q.tail
    error "underflow"
return Q[Q.head]
```

## Exercise 4
ENQUEUE(Q, x)  
```
if Q.tail + 1 == Q.head
    error "overflow"
Q[Q.tail] = x
if Q.tail == Q.length
    Q.tail = 1
else
    Q.tail = Q.tail + 1
```

DEQUEUE(Q)
```
if Q,head == Q.tail
    error "underflow"
x = Q[Q.head]
if Q.head == n
    Q.head = 1
else
    Q.head = Q.head + 1
return x
```