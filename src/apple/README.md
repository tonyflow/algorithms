### Analysis of the problem
The end condition of the shuffling algorithm is when the deck at hand is of the same order as the original deck's order.
In order to check this condition we will always keep the original state in an order-of-insertion preserving data structure - a queue. `Shuffler`'s
`original` member variable will be used for that state.

Now the shuffling algorithm describes a process where we remove cards from the top of the deck-at-hand and we place them
on a stack of cards - one over the other - on the table. This suggests that the `table` structure should be a stack.

Moving on, on the second step of the shuffling algorithm we should

> Take the next card off the top and put it on the bottom of the deck in your hand.

This describes a queue like structure where we dequeue elements from the start of the queue and add elements at the end of it. Thus,
the `deck` member variable of the `Shuffler` is a `Queue` which is implemented by a `LinkedList`.


At the end of every iteration - when we have no more cards at hand - the table stack should become our next deck-at-hand state. 
When this happens, the top card of the table should be the first to be removed. Nevertheless, since adding elements to the bottom
of the stack (Take the next card off the top and put it on the bottom of the deck in your hand) defies the purpose of using a stack, 
we will convert the table stack back to a deck queue.