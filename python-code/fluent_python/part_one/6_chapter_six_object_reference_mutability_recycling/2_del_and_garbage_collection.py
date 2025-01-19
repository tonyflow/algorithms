if __name__ == "__main__":
    """
    del deletes references not objects
    """
    a = [1, 2, 3]
    b = a
    del a
    print(b)

    """
    if we rebind b to a different object, the object [1,2,3] has no remaining references on it and the garbage 
    collector can delete it
    """
    b = [3]

    """
    To demonstrate the end of an object’s life,we use weakref.finalize to register a callback function to be 
    called when an object is destroyed.
    """
    import weakref

    s1 = {1, 2, 3}
    s2 = s1

    def bye():
        print("...like tears in the rain")

    ender = weakref.finalize(s1, bye)
    print(ender.alive)
    del s1
    s2 = "spam"
    """
    You may be wondering why the {1, 2, 3} object was destroyed in after re-referenced s2 as well. After all, the s1 
    reference was passed to the finalize function, which must have held on to it in order to monitor the object and 
    invoke the callback. This works because finalize holds a weak reference to {1, 2, 3}. Weak references to an object
    do not increase its reference count. Therefore, a weak reference does not prevent the target object from being 
    garbage collected. Weak references are useful in caching applications because you don’t want the cached objects 
    to be kept alive just because they are referenced by the cache.
    """
    print(ender.alive)
