## Exercise 1
SINGLY-LINKED-LIST-INSERT(L, x)
```
x.next = L.head
L.head = x
```
- Time Complexity O(1)

SINGLY-LINKED-LIST-DELETE(L, x)
```
prev = L.nil
while prev.next != NIL and prev.next.key != x.key
    prev = prev.next
prev.next = x.next
```
- Time Complexity O(n)

## Exercise 2
SINGLY-LINKED-LIST-STACK-PUSH(L, x)
```
x.next = L.head
L.head = x
```

SINGLY-LINKED-LIST-STACK-POP(L)
```
if L.head == NIL
    error "underflow"
x = L.head
L.head = L.head.next
return x
```

## Exercise 3
SINGLY-LINKED-LIST-QUEUE-ENQUEUE(L, x)
```
if L.tail != NIL
    L.tail.next = x
L.tail = x
x.next = NIL
```

SINGLY-LINKED-LIST-QUEUE-DEQUEUE(L)
```
if L.head == NIL
    error "underflow"
x = L.head
L.head = L.head.next
return x
```

## Exercise 4
LIST-SEARCH’’(L, k)
```
L.nil.key = k
x = L.head
while x.key != k
    x = x.next
L.nil.key = NIL
if x == L.nil
    return NIL
else
    return x
```