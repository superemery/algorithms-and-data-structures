## What is the principle for a queue?
- first in first out (FIFO)

## How to implement a queue with an array in a circular fashion?
- Q.tail = Q.tail + 1 when Q.enqueue is called
- Q.head = Q.head + 1 when Q.dequeue is called
- Q.tail and Q.head wrap around to 1 they reach n + 1

## What are the major operations for a queue?
- enqueue
- dequeue

## What do Q.head, Q.tail and Q.length stand for?
- Q.head
  - the index of the element that will be remove when Q.dequeue is called
- Q.tail
  - the index where the newly arriving element will be inserted into

## Under what situation is a queue empty?
- Q.head == Q.tail

## Under what situation is a queue full?
- Q.head == Q.tail + 1

## At most how many elements can a queue contain?
- the underlying array's size n - 1

## When will you come cross queue underflow and when will you across queue overflow?
- underflow
  - Q is empty and Q.dequeue is called
- overflow
  - Q is full and Q.enqueue is called

## What are the time complexity measures for the three stack operations in big-oh notation?
- enqueue
  - O(1)
- dequeue
  - O(1)

## Pseudocode
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