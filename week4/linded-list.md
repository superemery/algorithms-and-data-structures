## What determines the linear order of an array? And what determines the linear order of a linked list?
- array
  - array indices
- linked list
  - object pointers

## What do the three key attributes of an object (key, next, prev) in a doubly linked list stand for?
- key
  - The attribute that is used to sort and compare with other objects
- next
  - An object reference pointing to the successor object
- prev
  - An object reference pointing to the predecessor object

## What does head stand for?
- the first element in a list

## What does NIL mean?
- x.prev == NIL
  - x is the head of a list
- x.next == NIL
  - x is the tail of a list

## Under what condition is a linked list empty?
- L.head == NIL

## What is the difference between a singly linked list and doubly linked list?
- An object in a doubly-linked list has two pointers, "next" and "prev," that allow the list to be traversed both forward and backward, whereas an object in a singly-linked list has only a "next" pointer, allowing one-way traversal only.

## What is a circular list?
- L.tail.next == L.head and L.head.prev == L.tail

## What does LIST-SEARCH(L, k) algorithm do and how does it work? Why does it takes Θ(n) in the worst case? What is the best case?
- Find the element with key k in the list L.
- The worst case happens when the list does not contain the element, which takes n+1 comparisons to find out. The second worst case is when the target element is the tail of the list, requiring n comparisons to identify.
- The best case happens when the list is empty or the target element is the head of the list, which requires only one comparison to get the result.

## What does LIST-INSERT(L, x) algorithm do and how does it work? Why does it takes O(1)?
- Insert the object x into the `head` of the list L.
- Steps for inserting an object into a doubly-linked list
  - x.next = L.head
  - L.head.prev = x if L.head != NIL
  - L.head = x
  - x.prev = NIL
- Each of the steps is an O(1) operation
  - The overall insertion time complexity is O(1)

## What does LIST-DELETE(L, x) algorithm do and how does it work? Why does it takes O(1)? What is the time complexity measure if we delete an element with a given key?
- Remove object x from the list L.
- Steps for deleting an object from a doubly-linked list
  - x.prev.next = x.next
  - x.next.prev = x.prev
- Each of the step is an O(1) operation
  - The overall deletion time complexity is O(1)
- Deleting an element with a given key requires searching for the element before deletion, and it is an O(n) operation
  - The overall time complexity is O(n).

## What is a sentinel L.nil? What is the benefit of having a circular double linked list with a sentinel? And what is the side effect?
- A dummy object placed before the head of a linked-list, used to simplified boundary conditions
- Pros
  - Improve code clarity
  - Reduce time complexity by an O(1) scale
- Cons
  - Extra memory cost for storing the sentinel object

## Pseudocode
LIST-SEARCH(L, k)
```
x = L.head
while x != NIL and x.key != k
    x = x.next
return x
```

LIST-INSERT(L, x)
```
x.next = L.head
if L.head != NIL
    L.head.prev = x
L.head = x
x.prev = NIL
```

LIST-DELETE(L, x)
```
if x.prev != NIL
    x.prev.next = x.next
else
    L.head = x.next
if x.next != NIL
    x.next.prev = x.prev
```